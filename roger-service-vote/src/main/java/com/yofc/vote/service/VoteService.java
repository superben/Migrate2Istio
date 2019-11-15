package com.yofc.vote.service;

import com.github.pagehelper.PageInfo;
import com.yofc.common.bean.ValidationException;
import com.yofc.dal.vote.entity.Vote;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public interface VoteService {

    PageInfo<Map<String, Object>> list(Map<String, Object> queryParam, Integer pageNum, Integer pageSize);

    void save(Vote bean);

    void update(Vote bean);

    void delete(Vote bean);

    List<Map<String, Object>> countVoteSubject4Summary(Integer voteId);

    void save(Map<String, Object> param);

    void delteVoteAndSubject(Integer voteId) throws ValidationException;

    Map<String, Object> queryDetail(Integer voteId, Map<String, Object> param);

    Vote findByKeys(Integer keyId);

    @Transactional
    void updateVoteStatus();
}
