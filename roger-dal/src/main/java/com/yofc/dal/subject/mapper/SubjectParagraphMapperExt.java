package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.SubjectParagraph;

import javax.annotation.Resource;

@Resource
public interface SubjectParagraphMapperExt extends SubjectParagraphMapper {

    int insertSelectiveExt(SubjectParagraph paragraph);

}