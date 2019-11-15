package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.SubjectClassify;
import com.yofc.dal.subject.entity.SubjectClassifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectClassifyMapper {
    long countByExample(SubjectClassifyExample example);

    int deleteByExample(SubjectClassifyExample example);

    int deleteByPrimaryKey(String subjectClassifyCode);

    int insert(SubjectClassify record);

    int insertSelective(SubjectClassify record);

    List<SubjectClassify> selectByExample(SubjectClassifyExample example);

    SubjectClassify selectByPrimaryKey(String subjectClassifyCode);

    int updateByExampleSelective(@Param("record") SubjectClassify record, @Param("example") SubjectClassifyExample example);

    int updateByExample(@Param("record") SubjectClassify record, @Param("example") SubjectClassifyExample example);

    int updateByPrimaryKeySelective(SubjectClassify record);

    int updateByPrimaryKey(SubjectClassify record);
}