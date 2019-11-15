package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.SubjectGoodPoint;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface SubjectGoodPointMapperExt extends SubjectGoodPointMapper {
    void insertSelectiveExt(SubjectGoodPoint subjectGoodPoint);

    List<Map<String, Object>> summary();
}