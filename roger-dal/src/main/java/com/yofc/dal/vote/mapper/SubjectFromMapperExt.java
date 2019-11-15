package com.yofc.dal.vote.mapper;

import com.yofc.dal.subject.entity.SubjectFrom;

import javax.annotation.Resource;

@Resource
public interface SubjectFromMapperExt extends SubjectFromMapper {

    void insertSelectiveExt(SubjectFrom subjectGoodPoint);

}