package com.yofc.subject.service;

import com.yofc.dal.subject.entity.SubjectFollowWithBLOBs;

public interface RedisSubjectFollowService {
    SubjectFollowWithBLOBs findByKeys(Integer id);

    long countFollows(Integer subjectId);

    void save(SubjectFollowWithBLOBs bean);

    void delete(SubjectFollowWithBLOBs bean);
}
