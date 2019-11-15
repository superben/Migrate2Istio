package com.yofc.subject.service;

import com.yofc.dal.subject.entity.SubjectGoodPoint;

public interface RedisSubjectGoodPointService {

    SubjectGoodPoint findByKeys(Integer id, String user, String type);

    SubjectGoodPoint update(SubjectGoodPoint bean);

    Integer save(SubjectGoodPoint bean);

    Long count(Integer id, String type);

}
