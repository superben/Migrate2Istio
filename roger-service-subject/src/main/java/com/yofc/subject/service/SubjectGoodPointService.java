package com.yofc.subject.service;

import com.yofc.common.bean.BusinessException;

import java.util.List;
import java.util.Map;

public interface SubjectGoodPointService {
    Integer setGoodPoint(Integer followId, String type, Map<String, Object> params) throws BusinessException;
    List<Map<String, Object>> setGoodPointList(Map<String, Object> params) throws BusinessException;
}
