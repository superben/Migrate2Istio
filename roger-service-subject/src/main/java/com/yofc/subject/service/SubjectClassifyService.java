package com.yofc.subject.service;

import com.yofc.dal.subject.entity.SubjectClassify;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface SubjectClassifyService {

    int addSubjectClassify(SubjectClassify subjectClassify);

    List<SubjectClassify> list(String userId);

    @Cacheable
    String getClassifyName(String code);
}
