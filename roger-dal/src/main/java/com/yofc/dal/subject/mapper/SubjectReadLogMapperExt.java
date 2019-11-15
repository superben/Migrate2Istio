package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.SubjectReadLog;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface SubjectReadLogMapperExt extends SubjectReadLogMapper {

    int insertSelectiveExt(SubjectReadLog record);

    List<Map<String, Object>> summary(Map<String, Object> param);
}