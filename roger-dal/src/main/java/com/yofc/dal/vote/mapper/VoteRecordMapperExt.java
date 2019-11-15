package com.yofc.dal.vote.mapper;

import com.yofc.dal.vote.entity.VoteRecord;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface VoteRecordMapperExt extends VoteRecordMapper {
    int insertSelectiveExt(VoteRecord record);

    List<Map<String, Object>> countVoteSubject4Summary(Map<String, Object> param);

    List<Map<String, Object>> queryVoteRecordByPerson(Integer voteId);

    Map<String, Object> countSummary(Integer voteId);

}