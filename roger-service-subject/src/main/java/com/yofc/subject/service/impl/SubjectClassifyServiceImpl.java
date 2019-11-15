package com.yofc.subject.service.impl;

import com.yofc.dal.subject.entity.SubjectClassify;
import com.yofc.dal.subject.mapper.SubjectClassifyMapperExt;
import com.yofc.subject.service.SubjectClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubjectClassifyServiceImpl implements SubjectClassifyService {

    @Autowired
    private SubjectClassifyMapperExt subjectClassifyMapper;

    @Override
    public int addSubjectClassify(SubjectClassify subjectClassify) {
        return 0;
    }

    @Override
    @Cacheable(value = "cache.subjectclasify.list")
    public List<SubjectClassify> list(String userId) {
        Map<String, Object> param = new HashMap();
        param.put("userId", userId);
        return subjectClassifyMapper.list(param);
    }

    @Override
    @Cacheable(value = "cache.subjectclasify.bean.name")
    public String getClassifyName(String code){
        return subjectClassifyMapper.selectByPrimaryKey(code).getSubjectClassifyName();
    }

}
