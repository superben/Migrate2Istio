package com.yofc.vote.service;

import java.util.List;
import java.util.Map;

public interface VoteDetailService {
    Map<String, Object> queryEmptyVote(Integer voteId);

    Map<String, Object> queryFilledVote(Integer voteId, String userId);

    void saveVoteRecord(Integer voteId, Map<String, Object> param);

    List<Map<String, Object>> countVoteSubject4Summary(Integer voteId);
}
