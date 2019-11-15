package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.SubjectParagraph;
import com.yofc.dal.subject.entity.SubjectParagraphExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectParagraphMapper {
    long countByExample(SubjectParagraphExample example);

    int deleteByExample(SubjectParagraphExample example);

    int deleteByPrimaryKey(Integer paragraphId);

    int insert(SubjectParagraph record);

    int insertSelective(SubjectParagraph record);

    List<SubjectParagraph> selectByExampleWithBLOBs(SubjectParagraphExample example);

    List<SubjectParagraph> selectByExample(SubjectParagraphExample example);

    SubjectParagraph selectByPrimaryKey(Integer paragraphId);

    int updateByExampleSelective(@Param("record") SubjectParagraph record, @Param("example") SubjectParagraphExample example);

    int updateByExampleWithBLOBs(@Param("record") SubjectParagraph record, @Param("example") SubjectParagraphExample example);

    int updateByExample(@Param("record") SubjectParagraph record, @Param("example") SubjectParagraphExample example);

    int updateByPrimaryKeySelective(SubjectParagraph record);

    int updateByPrimaryKeyWithBLOBs(SubjectParagraph record);

    int updateByPrimaryKey(SubjectParagraph record);
}