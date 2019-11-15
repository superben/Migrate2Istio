package com.yofc.subject.service;

import com.github.pagehelper.PageInfo;
import com.yofc.common.bean.BusinessException;
import com.yofc.dal.subject.entity.SubjectFollowReply;

import java.util.Map;

public interface SubjectReplyService {

    void insertSelectiveExt(SubjectFollowReply bean) throws BusinessException;

    void deleteByFollowId(Integer FollowId);

    void deleteBySubject(Integer subjectId);

    void updateReply(SubjectFollowReply bean) throws BusinessException;

    void deleteByReplyId(Integer replyId);

    PageInfo<Map<String, Object>> list(Map<String, Object> queryParam, Integer pageNum, Integer pageSize) throws Exception;
}
