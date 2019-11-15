package com.yofc.subject.service;

import com.yofc.dal.subject.entity.SubjectFollow;
import com.yofc.dal.subject.entity.SubjectFollowReply;

public interface RedisSubjectReplyService {
    SubjectFollowReply findByKeys(Integer id);

    long countReply(Integer followId);

    void save(SubjectFollowReply bean);

    void delete(SubjectFollowReply bean);

    void insert(SubjectFollowReply bean, SubjectFollow follow);
}
