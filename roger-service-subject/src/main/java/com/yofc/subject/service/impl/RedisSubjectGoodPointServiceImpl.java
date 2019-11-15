package com.yofc.subject.service.impl;

import com.yofc.dal.subject.entity.SubjectGoodPoint;
import com.yofc.dal.subject.entity.SubjectGoodPointExample;
import com.yofc.common.enums.ColleagueTextTypeEnum;
import com.yofc.dal.subject.mapper.SubjectGoodPointMapperExt;
import com.yofc.subject.service.RedisSubjectGoodPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisSubjectGoodPointServiceImpl implements RedisSubjectGoodPointService {

    @Autowired
    private SubjectGoodPointMapperExt subjectGoodPointMapperExt;

    /***
     * 查询点赞信息
     * @param id
     * @param user
     * @param type
     * @return
     */
    @Cacheable(value = "cache.goodpoint.bean", key="#id + '_' + #user + '_' + #type")
    @Override
    public SubjectGoodPoint findByKeys(Integer id, String user, String type){
        SubjectGoodPointExample example = new SubjectGoodPointExample();
        buildExample(example, id, type).andPointUserIdEqualTo(user);
        List<SubjectGoodPoint> rs = subjectGoodPointMapperExt.selectByExample(example);
        if(!rs.isEmpty()){
            return rs.get(0);
        }
        return null;
    }

    /***
     * 统计点赞数
     * @param id
     * @param type
     * @return
     */
    @Cacheable(value = "cache.subject.goodpoint.amont", key = "#id + '_' + #type")
    @Override
    public Long count(Integer id, String type){
        SubjectGoodPointExample example = new SubjectGoodPointExample();
        buildExample(example, id, type).andGoodPointEqualTo(1);
        return subjectGoodPointMapperExt.countByExample(example);
    }


    protected SubjectGoodPointExample.Criteria buildExample(SubjectGoodPointExample example, Integer id, String type){
        SubjectGoodPointExample.Criteria c = example.createCriteria().andPointTypeEqualTo(type);
        if(ColleagueTextTypeEnum.subject.name().equals(type)){
            c.andSubjectIdEqualTo(id);
        }else if(ColleagueTextTypeEnum.follow.name().equals(type)){
            c.andFollowIdEqualTo(id);
        }else if(ColleagueTextTypeEnum.reply.name().equals(type)){
            c.andReplyIdEqualTo(id);
        }
        return c;
    }

    /***
     * 更新点赞
     * @param bean
     * @return
     */
    @Caching(
            put = {
                    @CachePut(value = "cache.goodpoint.bean", key="#bean.subjectId + '_' + #bean.pointUserId + '_' + #bean.pointType", condition = "#bean.pointType eq 'subject'"),
                    @CachePut(value = "cache.goodpoint.bean", key="#bean.subjectId + '_' + #bean.pointUserId + '_' + #bean.pointType", condition = "#bean.pointType eq 'follow'"),
                    @CachePut(value = "cache.goodpoint.bean", key="#bean.subjectId + '_' + #bean.pointUserId + '_' + #bean.pointType", condition = "#bean.pointType eq 'reply'"),
                    @CachePut(value = "cache.goodpoint.bean", key="#bean.subjectId + '_' + #bean.pointUserId + '_' + #bean.pointType", condition = "#bean.pointType eq 'collection'")
            },
            evict = {
                    @CacheEvict(value = "cache.subject.goodpoint.amont", key = "#bean.subjectId + '_' + #bean.pointType", condition = "#bean.pointType eq 'subject'"),
                    @CacheEvict(value = "cache.subject.goodpoint.amont", key = "#bean.followId + '_' + #bean.pointType", condition = "#bean.pointType eq 'follow'"),
                    @CacheEvict(value = "cache.subject.goodpoint.amont", key = "#bean.replyId + '_' + #bean.pointType", condition = "#bean.pointType eq 'reply'"),
                    @CacheEvict(value = "cache.subject.list.view", allEntries = true, condition = "#bean.pointType eq 'subject' or #bean.pointType eq 'collection'"),
                    @CacheEvict(value = "cache.follow.list.view", allEntries = true, condition = "#bean.pointType=='follow'"),
                    @CacheEvict(value = "cache.reply.list.view", allEntries = true, condition = "#bean.pointType=='reply' || #bean.pointType=='follow'")
            }
    )
    @Override
    public SubjectGoodPoint update(SubjectGoodPoint bean){
        subjectGoodPointMapperExt.updateByPrimaryKeySelective(bean);
        return bean;
    }

    /***
     * 新增点赞信息
     * @param bean
     * @return
     */
    @Caching(
            evict = {
                    @CacheEvict(value = "cache.subject.goodpoint.amont", key = "#bean.subjectId + '_' + #bean.pointType", condition = "#bean.pointType eq 'subject'"),
                    @CacheEvict(value = "cache.subject.goodpoint.amont", key = "#bean.followId + '_' + #bean.pointType", condition = "#bean.pointType eq 'follow'"),
                    @CacheEvict(value = "cache.subject.goodpoint.amont", key = "#bean.replyId + '_' + #bean.pointType", condition = "#bean.pointType eq 'reply'"),
                    @CacheEvict(value = "cache.subject.list.view", allEntries = true, condition = "#bean.pointType eq 'subject' or #bean.pointType eq 'collection'"),
                    @CacheEvict(value = "cache.follow.list.view", allEntries = true, condition = "#bean.pointType=='follow'"),
                    @CacheEvict(value = "cache.reply.list.view", allEntries = true, condition = "#bean.pointType=='reply'")
            }
    )
    @Override
    public Integer save(SubjectGoodPoint bean){
        subjectGoodPointMapperExt.insertSelectiveExt(bean);
        return bean.getGoodPoint();
    }

}
