package com.yofc.subject.service.impl;

import com.yofc.dal.subject.entity.SubjectFollowExample;
import com.yofc.dal.subject.entity.SubjectFollowWithBLOBs;
import com.yofc.dal.subject.mapper.SubjectFollowMapperExt;
import com.yofc.subject.service.RedisSubjectFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class RedisSubjectFollowServiceImpl implements RedisSubjectFollowService {

    @Autowired
    private SubjectFollowMapperExt subjectFollowMapperExt;

    @Cacheable(value = "cache.follow.bean", key = "#id")
    @Override
    public SubjectFollowWithBLOBs findByKeys(Integer id){
        return subjectFollowMapperExt.selectByPrimaryKey(id);
    }

    /***
     * 统计跟帖数
     * @param subjectId
     * @return
     */
    @Cacheable(value = "cache.follow.amount", key = "#subjectId")
    @Override
    public long countFollows(Integer subjectId) {
        SubjectFollowExample example = new SubjectFollowExample();
        example.createCriteria().andSubjectIdEqualTo(subjectId);
        return subjectFollowMapperExt.countByExample(example);
    }

    /***
     * 暂时用不到
     *
     * @param bean
     */
    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = "cache.follow.amount", key = "#bean.subjectId")
            }
    )
    public void save(SubjectFollowWithBLOBs bean){
        subjectFollowMapperExt.insertSelectiveExt(bean);
    }

    /***
     * 暂时用不到
     * @param bean
     */
    @Caching(
            evict = {
                    @CacheEvict(value = "cache.follow.bean", key = "#bean.followId"),
                    @CacheEvict(value = "cache.follow.amount", key = "#bean.subjectId")
            }
    )
    @Override
    public void delete(SubjectFollowWithBLOBs bean){
        subjectFollowMapperExt.deleteByPrimaryKey(bean.getFollowId());
    }

}
