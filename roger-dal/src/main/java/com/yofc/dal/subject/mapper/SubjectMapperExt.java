package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.Subject;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface SubjectMapperExt extends SubjectMapper {
    int insertExt(Subject record);

    int insertSelectiveExt(Subject record);

    List<Map<String, Object>> queryListByParam(Map<String, Object> queryParam);

    List<Map<String, Object>> queryByParam(Map<String, Object> queryParam);

    Map<String, Object> queryMyAttention(Map<String, Object> queryParam);
}