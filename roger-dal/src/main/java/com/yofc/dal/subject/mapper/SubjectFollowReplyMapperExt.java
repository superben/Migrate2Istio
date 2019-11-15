package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.SubjectFollowReply;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface SubjectFollowReplyMapperExt extends SubjectFollowReplyMapper {

    void insertSelectiveExt(SubjectFollowReply bean);

    List<Map<String, Object>> queryDetailId(Map<String, Object> queryParam);
}