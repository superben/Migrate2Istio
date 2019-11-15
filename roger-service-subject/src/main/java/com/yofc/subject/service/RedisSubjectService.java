package com.yofc.subject.service;

import com.yofc.dal.subject.entity.Subject;

public interface RedisSubjectService {
    Subject findByKeys(Integer id);

    void save(Subject bean);

    void update(Subject bean);

    void delete(Subject bean);
}
