package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.SubjectCollection;

import javax.annotation.Resource;

@Resource
public interface SubjectCollectionMapperExt extends SubjectCollectionMapper {
    void insertSelectiveExt(SubjectCollection subjectCollection);
}