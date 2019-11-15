package com.yofc.subject.service.impl;

import com.yofc.dal.subject.entity.Subject;
import com.yofc.dal.subject.entity.SubjectExample;
import com.yofc.common.enums.PublicEnum;
import com.yofc.dal.subject.mapper.SubjectMapperExt;
import com.yofc.subject.service.RedisSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisSubjectServiceImpl implements RedisSubjectService {

    @Autowired
    private SubjectMapperExt subjectMapperExt;

    /***
     * TODO
     * @param id
     * @return
     */
    @Cacheable(value = "cache.subject.bean", key = "#id")
    @Override
    public Subject findByKeys(Integer id){

        SubjectExample example = new SubjectExample();
        example.createCriteria().andSubjectIdEqualTo(id).andRemoveFlagEqualTo(PublicEnum.N.name());
        List<Subject> list = subjectMapperExt.selectByExampleWithBLOBs(example);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    /***
     * 插入前subjectId自增持序列为null,
     * @param bean bean
     */
    @Override
    public void save(Subject bean){
        subjectMapperExt.insertSelectiveExt(bean);
    }

    @Caching(
            evict = {
                    @CacheEvict(value = "cache.subject.bean", key = "#bean.subjectId")
            }
    )
    @Override
    public void update(Subject bean){
        subjectMapperExt.updateByPrimaryKeySelective(bean);
    }

    @Caching(
            evict = {
                    @CacheEvict(value = "cache.subject.bean", key = "#bean.subjectId")
            }
    )
    @Override
    public void delete(Subject bean){
        subjectMapperExt.updateByPrimaryKeySelective(bean);
    }
}
