package com.yofc.vote.service;

import com.github.pagehelper.PageInfo;
import com.yofc.dal.vote.entity.VoteRecord;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import java.util.List;
import java.util.Map;

public interface VoteRecordService {

    @Cacheable(value = "cache.voterecord.list.view", key = "#pageNum")
    PageInfo<Map<String, Object>> list(Map<String, Object> queryParam, Integer pageNum, Integer pageSize);

    @Cacheable(value = "cache.voterecord.bean", key = "#id")
    VoteRecord findByKeys(Integer id);

    void save(VoteRecord bean);

    @Caching(
            evict = {
                    @CacheEvict(value = "cache.voterecord.bean", key = "#bean.voteRecordId"),
            }
    )
    void delete(VoteRecord bean);

    List<VoteRecord> queryVoteRecordDetail(Integer voteId, String userId);

    PageInfo<Map<String, Object>> selectHistory(Integer voteId, Integer pageNum, Integer pageSize);

    PageInfo<VoteRecord> selectOthers(Integer voteId, Integer voteSubjectId, Integer pageNum, int pageSize);
}
