package com.yofc.subject.service;

import com.yofc.dal.subject.entity.SubjectCollection;

public interface RedisSubjectCollectionService {
    SubjectCollection findByKeys(Integer id, String user);

    long countCollection(Integer id);

    SubjectCollection update(SubjectCollection bean);

    SubjectCollection save(SubjectCollection bean);
}
