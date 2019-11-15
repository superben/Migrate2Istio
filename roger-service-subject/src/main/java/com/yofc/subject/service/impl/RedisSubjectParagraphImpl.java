package com.yofc.subject.service.impl;

import com.yofc.dal.subject.entity.SubjectParagraph;
import com.yofc.dal.subject.entity.SubjectParagraphExample;
import com.yofc.dal.subject.mapper.SubjectParagraphMapperExt;
import com.yofc.subject.service.RedisSubjectParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisSubjectParagraphImpl implements RedisSubjectParagraphService {

    @Autowired
    private SubjectParagraphMapperExt subjectParagraphMapperExt;

    @Override
    @Cacheable(value = "cache.paragraph.bypid.list", key = "#id")
    public List<SubjectParagraph> findAllByParentId(Integer id){
        SubjectParagraphExample example = new SubjectParagraphExample();
        example.createCriteria().andSubjectIdEqualTo(id);
        return subjectParagraphMapperExt.selectByExampleWithBLOBs(example);
    }

}
