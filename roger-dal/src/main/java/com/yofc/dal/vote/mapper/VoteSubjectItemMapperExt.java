package com.yofc.dal.vote.mapper;

import com.yofc.dal.vote.entity.VoteSubjectItem;

import javax.annotation.Resource;

@Resource
public interface VoteSubjectItemMapperExt extends VoteSubjectItemMapper {
    int insertSelectiveExt(VoteSubjectItem record);
}