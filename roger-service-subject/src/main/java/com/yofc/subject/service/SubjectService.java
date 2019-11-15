package com.yofc.subject.service;

import com.yofc.common.bean.BusinessException;
import com.yofc.common.bean.ValidationException;
import com.yofc.dal.subject.entity.Subject;
import com.yofc.dal.subject.entity.SubjectParagraph;

import java.util.List;
import java.util.Map;

public interface SubjectService {
    int insertExt(Subject record);

    int insertSelectiveExt(Map<String, Object> record) throws BusinessException;

    void deleteSubjectSoft(Subject bean) throws ValidationException;

    List<Map<String, Object>> list(Map<String, Object> queryParam, Integer pageSize, boolean fixable) throws Exception;

    void loadReadAmount(List<Map<String, Object>> list);

    Map<String, Object> queryByParam(Integer subjectId, Map<String, Object> params) throws BusinessException;

    void deleteSubject(Integer subjectId) throws BusinessException;

    void insertTask(Subject subject, List<SubjectParagraph> paragraphs);

    Integer saveOrUpdateSelectiveExt(Integer subjectId, Map<String, Object> bean) throws BusinessException;

    Subject queryById(Integer subjectId);

    Map<String, Object> queryMyAttention(Map<String, Object> queryParam);
}
