package com.yofc.dal.vote.mapper;

import com.yofc.dal.vote.entity.Vote;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface VoteMapperExt extends VoteMapper {
    int insertSelectiveExt(Vote record);

    List<Map<String, Object>> findAll(Map<String, Object> queryParam);
}