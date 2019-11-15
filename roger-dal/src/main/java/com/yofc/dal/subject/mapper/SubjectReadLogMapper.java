package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.SubjectReadLog;
import com.yofc.dal.subject.entity.SubjectReadLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectReadLogMapper {
    long countByExample(SubjectReadLogExample example);

    int deleteByExample(SubjectReadLogExample example);

    int deleteByPrimaryKey(Integer readId);

    int insert(SubjectReadLog record);

    int insertSelective(SubjectReadLog record);

    List<SubjectReadLog> selectByExample(SubjectReadLogExample example);

    SubjectReadLog selectByPrimaryKey(Integer readId);

    int updateByExampleSelective(@Param("record") SubjectReadLog record, @Param("example") SubjectReadLogExample example);

    int updateByExample(@Param("record") SubjectReadLog record, @Param("example") SubjectReadLogExample example);

    int updateByPrimaryKeySelective(SubjectReadLog record);

    int updateByPrimaryKey(SubjectReadLog record);
}