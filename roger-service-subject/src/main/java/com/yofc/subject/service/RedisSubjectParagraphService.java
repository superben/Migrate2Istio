package com.yofc.subject.service;

import com.yofc.dal.subject.entity.SubjectParagraph;

import java.util.List;

public interface RedisSubjectParagraphService {
    List<SubjectParagraph> findAllByParentId(Integer id);
}
