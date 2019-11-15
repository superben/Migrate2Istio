package com.yofc.vote.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yofc.common.bean.ValidationException;
import com.yofc.common.enums.PublicEnum;
import com.yofc.common.enums.VoteStatus;
import com.yofc.common.util.BeanMapUtil;
import com.yofc.dal.vote.entity.Vote;
import com.yofc.dal.vote.entity.VoteExample;
import com.yofc.dal.vote.entity.VoteRecord;
import com.yofc.dal.vote.entity.VoteSubject;
import com.yofc.dal.vote.mapper.VoteMapperExt;
import com.yofc.dal.vote.mapper.VoteRecordMapperExt;
import com.yofc.vote.remote.SubjectFromRemoteService;
import com.yofc.vote.service.*;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteMapperExt voteMapperExt;

    @Autowired
    private VoteSubjectService voteSubjectService;

    @Autowired
    private VoteRecordService VoteRecordService;

    @Autowired
    private VoteRecordMapperExt voteRecordMapperExt;

    @Autowired
    private SubjectFromRemoteService subjectFromRemoteService;

    @Autowired
    private RedisVoteService redisVoteService;

    @Override
    @Cacheable(value = "cache.vote.list.view", key = "#pageNum")
    public PageInfo<Map<String, Object>> list(Map<String, Object> queryParam, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = voteMapperExt.findAll(queryParam);
        PageInfo result = new PageInfo(list);
        return result;
    }



    @Override
    public void save(Vote bean) {
        voteMapperExt.insertSelective(bean);
    }

    @Override
    public void update(Vote bean) {
        voteMapperExt.updateByPrimaryKeySelective(bean);
    }

    @Override
    public void delete(Vote bean) {
        bean.setRemoveFlag(PublicEnum.Y.name());
        voteMapperExt.updateByPrimaryKeySelective(bean);
    }

    @Override
    @Transactional
    @Caching(
            evict = {
                    @CacheEvict(value = "cache.vote.list.view", allEntries = true),
            }
    )
    public void delteVoteAndSubject(Integer voteId) throws ValidationException {
        Vote vote = new Vote();
        vote.setVoteId(voteId);
        delete(vote);

        subjectFromRemoteService.deleteSubjectByVoteId(voteId);
    }

    @Override
    public Map<String, Object> queryDetail(Integer voteId, Map<String, Object> param) {
        String userId = MapUtils.getString(param, "userId");
        Map<String, Object> result = new HashMap();
        //加载vote
        Vote vote = redisVoteService.findByKeys(voteId);
        //加载 投票状态
        List<VoteRecord> records = VoteRecordService.queryVoteRecordDetail(voteId, userId);
        result.put("hadVote", !records.isEmpty());
        //统计投票
        result.put("summary", voteRecordMapperExt.countSummary(voteId));

        //加载投票结果
        result.put("exampleResult", countVoteSubject4Summary(voteId));

        //加载历史投票记录
        result.put("history", VoteRecordService.selectHistory(voteId, 1, 5));

        result.put("vote", vote);
        return result;
    }

    @Override
    public Vote findByKeys(Integer keyId) {
        return redisVoteService.findByKeys(keyId);
    }

    @Override
    public List<Map<String, Object>> countVoteSubject4Summary(Integer voteId){
        List<VoteSubject> voteSubjects = voteSubjectService.findByParentKey(voteId);
        if (!voteSubjects.isEmpty()) {
            Integer voteSubjectId = voteSubjects.get(0).getVoteSubjectId();
            Map qParam = new HashMap();
            qParam.put("voteSubjectId", voteSubjectId);
            return voteRecordMapperExt.countVoteSubject4Summary(qParam);
        }
        return null;
    }

    @Override
    @Transactional
    public void save(Map<String, Object> param) {
        Map<String, Object> vote = (Map<String, Object>) param.get("vote");
        List<Map<String, Object>> voteSubjects = (List<Map<String, Object>>) param.get("voteSubjects");

        Vote voteBean = new Vote();
        vote.put("startDate", transferDate((String) vote.get("startDate")));
        vote.put("endDate", transferDate((String) vote.get("endDate")));
        BeanMapUtil.map2Bean(vote, voteBean);
        redisVoteService.saveOrUpdate(voteBean);
        voteSubjectService.saveOrUpdateSubject(voteSubjects, voteBean.getVoteId());

        //todo create Subject
        subjectFromRemoteService.saveCbSubject(voteBean);
    }

    @Transactional
    @Override
    public void updateVoteStatus(){
        System.out.println("vote tasks starting");
        VoteExample example = new VoteExample();
        Date now = new Date();
        example.createCriteria().andStatusEqualTo(VoteStatus.wait.name()).andStartDateLessThan(now).andEndDateGreaterThanOrEqualTo(now);
        List<Vote> votes = voteMapperExt.selectByExample(example);
        for(Vote temp: votes){
            temp.setStatus(VoteStatus.doing.name());
            redisVoteService.update(temp);
        }
        example.clear();
        example.createCriteria().andStatusEqualTo(VoteStatus.doing.name()).andEndDateLessThan(now);
        List<Vote> votes1 = voteMapperExt.selectByExample(example);
        for(Vote temp: votes1){
            temp.setStatus(VoteStatus.dead.name());
            redisVoteService.update(temp);
        }
        System.out.println("vote tasks end");
    }

    protected Date transferDate(String str) {
        try {
            return DateUtils.parseDate(str, "yyyy-MM-dd HH:mm");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
