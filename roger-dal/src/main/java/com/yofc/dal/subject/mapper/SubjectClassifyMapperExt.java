package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.SubjectClassify;

import java.util.List;
import java.util.Map;

public interface SubjectClassifyMapperExt extends SubjectClassifyMapper{

    List<SubjectClassify> list(Map<String, Object> userId);
}
