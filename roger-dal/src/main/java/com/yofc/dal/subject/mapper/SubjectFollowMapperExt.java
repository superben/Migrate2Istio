package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.SubjectFollowWithBLOBs;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface SubjectFollowMapperExt extends SubjectFollowMapper {
    void insertSelectiveExt(SubjectFollowWithBLOBs bean);

    List<Map<String, Object>> queryDetailId(Map<String, Object> params);

    List<Map<String, Object>> queryByParam(Map<String, Object> queryParam);

}