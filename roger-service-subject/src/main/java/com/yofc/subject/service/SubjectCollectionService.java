package com.yofc.subject.service;

import com.yofc.common.bean.BusinessException;

import java.util.Map;

public interface SubjectCollectionService {
    Integer setGoodPoint(Integer subjectId, Map<String, Object> param) throws BusinessException;

    Integer setCollectionFlag(Integer subjectId, Map<String, Object> param) throws BusinessException;
}
