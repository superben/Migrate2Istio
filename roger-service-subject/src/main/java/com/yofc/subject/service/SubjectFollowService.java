package com.yofc.subject.service;

import com.github.pagehelper.PageInfo;
import com.yofc.common.bean.BusinessException;
import com.yofc.dal.subject.entity.SubjectFollowWithBLOBs;
import com.yofc.dal.subject.entity.vo.SubjectFollowVO;

import java.util.Map;

public interface SubjectFollowService {
    PageInfo<Map<String, Object>> list(Map<String, Object> queryParam, Integer pageNum, Integer pageSize) throws Exception;

    void insertSelectiveExt(SubjectFollowWithBLOBs bean) throws BusinessException;

    void deleteFollowId(Integer subjectId, Integer followId);

    void updateFollow(SubjectFollowWithBLOBs bean) throws BusinessException;


    SubjectFollowVO queryByParam(Integer followId, Map<String, Object> queryParam) throws BusinessException;
}
