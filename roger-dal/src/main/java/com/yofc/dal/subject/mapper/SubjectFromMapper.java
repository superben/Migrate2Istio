package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.SubjectFrom;
import com.yofc.dal.subject.entity.SubjectFromExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectFromMapper {
    long countByExample(SubjectFromExample example);

    int deleteByExample(SubjectFromExample example);

    int deleteByPrimaryKey(Integer realId);

    int insert(SubjectFrom record);

    int insertSelective(SubjectFrom record);

    List<SubjectFrom> selectByExample(SubjectFromExample example);

    SubjectFrom selectByPrimaryKey(Integer realId);

    int updateByExampleSelective(@Param("record") SubjectFrom record, @Param("example") SubjectFromExample example);

    int updateByExample(@Param("record") SubjectFrom record, @Param("example") SubjectFromExample example);

    int updateByPrimaryKeySelective(SubjectFrom record);

    int updateByPrimaryKey(SubjectFrom record);
}