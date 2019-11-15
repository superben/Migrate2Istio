package com.yofc.vote.service;

import com.github.pagehelper.PageInfo;
import com.yofc.dal.vote.entity.VoteSubject;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import java.util.List;
import java.util.Map;

public interface VoteSubjectService {
    @Cacheable(value = "cache.votesubject.list.view", key = " #queryParam['voteId']+ '_' + #pageNum")
    PageInfo<Map<String, Object>> list(Map<String, Object> queryParam, Integer pageNum, Integer pageSize);

    @Cacheable(value = "cache.votesubject.bean", key = "#id")
    VoteSubject findByKeys(Integer id);


    List<VoteSubject> findByParentKey(Integer voteId);

    @Caching(
            evict = {
                    @CacheEvict(value = "cache.votesubject.list.view"),
            }
    )
    void save(VoteSubject bean);

    @Caching(
            evict = {
                    @CacheEvict(value = "cache.votesubject.list.view"),
                    @CacheEvict(value = "cache.votesubject.bean", key = "#bean.voteSubjectId"),
            }
    )
    void delete(VoteSubject bean);

    void saveOrUpdate(VoteSubject voteSubject);

    void saveOrUpdateSubject(List<Map<String, Object>> voteSubjects, Integer voteId);
}
