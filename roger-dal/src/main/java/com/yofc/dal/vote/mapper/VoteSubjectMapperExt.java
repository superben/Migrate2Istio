package com.yofc.dal.vote.mapper;

import com.yofc.dal.vote.entity.VoteSubject;

import javax.annotation.Resource;

@Resource
public interface VoteSubjectMapperExt extends VoteSubjectMapper {
    int insertSelectiveExt(VoteSubject record);
}