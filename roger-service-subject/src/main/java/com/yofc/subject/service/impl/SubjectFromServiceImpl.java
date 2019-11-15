package com.yofc.subject.service.impl;

import com.yofc.common.bean.ValidationException;
import com.yofc.dal.subject.entity.*;
import com.yofc.common.enums.ActionsType;
import com.yofc.common.enums.PublicEnum;
import com.yofc.common.enums.TopStickEnum;
import com.yofc.dal.subject.mapper.SubjectFromMapperExt;
import com.yofc.dal.subject.mapper.SubjectParagraphMapperExt;
import com.yofc.dal.vote.entity.Vote;
import com.yofc.subject.service.RedisSubjectService;
import com.yofc.subject.service.SubjectFromService;
import com.yofc.subject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SubjectFromServiceImpl implements SubjectFromService {

    @Autowired
    private SubjectFromMapperExt subjectFromMapperExt;

    @Autowired
    private RedisSubjectService redisSubjectService;

    @Autowired
    private SubjectParagraphMapperExt subjectParagraphMapperExt;
    
    @Autowired
    private SubjectService subjectService;

    @Override
    @Cacheable(value = "cache.voteFrom.subject.bean", key = "#id")
    public SubjectFrom findBySubjectId(Integer id) {
        SubjectFromExample example = new SubjectFromExample();
        example.createCriteria().andSubjectIdEqualTo(id);
        List<SubjectFrom> list = subjectFromMapperExt.selectByExample(example);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override
    @Cacheable(value = "cache.voteFrom.vote.bean", key = "#id")
    public SubjectFrom findVoteId(Integer id) {
        SubjectFromExample example = new SubjectFromExample();
        example.createCriteria().andKeyIdEqualTo(id);
        List<SubjectFrom> list = subjectFromMapperExt.selectByExample(example);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = "cache.subject.list.view", allEntries = true),
            }
    )
    public void saveCbSubject(Vote vote, ActionsType type) {
        SubjectFromExample example = new SubjectFromExample();
        example.createCriteria().andKeyIdEqualTo(vote.getVoteId()).andTypeEqualTo(type.name());
        List<SubjectFrom> froms = subjectFromMapperExt.selectByExample(example);
        if(froms.isEmpty()){
            //1. new subject
            Subject subject = new Subject();
            conventPo(vote, subject, false);
            redisSubjectService.save(subject);
            //2. new paragraph
            SubjectParagraph p = new SubjectParagraph();
            conventPO(vote, p, false);
            p.setSubjectId(subject.getSubjectId());
            subjectParagraphMapperExt.insertSelectiveExt(p);
            //3. new form
            SubjectFrom from = new SubjectFrom();
            from.setKeyId(vote.getVoteId());
            from.setType(type.name());
            from.setSubjectId(subject.getSubjectId());
            subjectFromMapperExt.insertSelective(from);

            //send message
            List<SubjectParagraph> ps = new ArrayList<>();
            ps.add(p);
            subjectService.insertTask(subject, ps);
        }else{
            Integer keyId = froms.get(0).getSubjectId();
            //update subject
            Subject subject = redisSubjectService.findByKeys(keyId);
            conventPo(vote, subject, true);
            redisSubjectService.update(subject);
            //update main paragraph
            SubjectParagraphExample example1 = new SubjectParagraphExample();
            example1.createCriteria().andSubjectIdEqualTo(keyId).andMainTagEqualTo(1);
            List<SubjectParagraph> ps = subjectParagraphMapperExt.selectByExampleWithBLOBs(example1);
            if(!ps.isEmpty()){
                SubjectParagraph p = ps.get(0);
                conventPO(vote, p, true);
                subjectParagraphMapperExt.updateByPrimaryKeySelective(p);
            }

        }
    }

    @Override
    /**
     *  cache 作用在vote/subject,此处不需要
     * */
    public void deleteSubjectByVoteId(Integer voteId) throws ValidationException {
        SubjectFrom from = findVoteId(voteId);
        if(from != null){
            Integer subjectId = from.getSubjectId();
            Subject  bean= new Subject();
            bean.setSubjectId(subjectId);
            bean.setUpdateUser("sys");
            subjectService.deleteSubjectSoft(bean);
        }
    }

    protected void conventPo(Vote vote, Subject subject, Boolean update){
        subject.setSubject(vote.getVoteTitle());
        subject.setOwnerId(vote.getOriginatorId());
        subject.setOwnerName(vote.getOriginatorName());
        subject.setUpdateDate(new Date());
        subject.setUpdateUser(vote.getOriginatorId());
        if(!update){
            subject.setSubjectClassifyCode(ActionsType.vote.name());
            subject.setTopStick(TopStickEnum.normal.name());
            subject.setRemoveFlag(PublicEnum.N.name());
            subject.setCreateDate(new Date());
            subject.setCreateUser(vote.getOriginatorId());
        }
    }

    protected void conventPO(Vote vote, SubjectParagraph p, Boolean update){
        p.setParagraph(vote.getVoteDesc());
        p.setImgSrc(vote.getImgSrc());
        if(!update){
            p.setMainTag(1);
        }
    }
}
