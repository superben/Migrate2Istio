package com.yofc.vote.service;

import com.yofc.dal.vote.entity.Vote;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import java.util.Map;

public interface RedisVoteService {
    Vote findByKeys(Integer id);

    Map<String, Object> queryEmptyVote(Integer voteId);

    void saveOrUpdate(Vote bean);

    @Caching(
            evict = {
                    @CacheEvict(value = "cache.vote.list.view", allEntries = true),
                    @CacheEvict(value = "cache.vote.bean", key = "#bean.voteId", condition = "#bean.voteId != null"),
                    @CacheEvict(value = "cache.emptyVote.bean", key = "#bean.voteId", condition = "#bean.voteId !=null ")
            }
    )
    void update(Vote bean);
}
