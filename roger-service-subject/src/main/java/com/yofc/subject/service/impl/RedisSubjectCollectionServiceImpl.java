package com.yofc.subject.service.impl;

import com.yofc.dal.subject.entity.SubjectCollection;
import com.yofc.dal.subject.entity.SubjectCollectionExample;
import com.yofc.dal.subject.mapper.SubjectCollectionMapperExt;
import com.yofc.subject.service.RedisSubjectCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisSubjectCollectionServiceImpl implements RedisSubjectCollectionService {

    @Autowired
    private SubjectCollectionMapperExt subjectCollectionMapperExt;

    @Cacheable(value = "cache.collection.bean", key="#id + '_' + #user")
    @Override
    public SubjectCollection findByKeys(Integer id, String user){
        SubjectCollectionExample example = new SubjectCollectionExample();
        example.createCriteria().andSubjectIdEqualTo(id).andCollectionUserIdEqualTo(user);
        List<SubjectCollection> rs = subjectCollectionMapperExt.selectByExample(example);
        if(!rs.isEmpty()){
            return rs.get(0);
        }
        return null;
    }

    @Cacheable(value = "cache.collection.amount", key = "#id")
    @Override
    public long countCollection(Integer id){
        SubjectCollectionExample example = new SubjectCollectionExample();
        example.createCriteria().andSubjectIdEqualTo(id);
        return subjectCollectionMapperExt.countByExample(example);
    }

    @Caching(
            put = {
                    @CachePut(value = "cache.collection.bean", key="#bean.subjectId + '_' + #bean.collectionUserId")
            },
            evict = {
                    @CacheEvict(value = "cache.collection.amount", key = "#bean.subjectId"),
                    @CacheEvict(value = "cache.subject.list.view", allEntries = true)
            }
    )
    @Override
    public SubjectCollection update(SubjectCollection bean){
        subjectCollectionMapperExt.updateByPrimaryKeySelective(bean);
        return bean;
    }

    @Caching(
            put = {
                    @CachePut(value = "cache.collection.bean", key="#bean.subjectId + '_' + #bean.collectionUserId")
            },
            evict = {
                    @CacheEvict(value = "cache.collection.amount", key = "#bean.subjectId"),
                    @CacheEvict(value = "cache.subject.list.view", allEntries = true)
            }
    )
    @Override
    public SubjectCollection save(SubjectCollection bean){
        subjectCollectionMapperExt.insertSelectiveExt(bean);
        return bean;
    }
}
