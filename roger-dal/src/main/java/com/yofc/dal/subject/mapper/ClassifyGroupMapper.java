package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.ClassifyGroup;
import com.yofc.dal.subject.entity.ClassifyGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassifyGroupMapper {
    long countByExample(ClassifyGroupExample example);

    int deleteByExample(ClassifyGroupExample example);

    int deleteByPrimaryKey(Integer mapId);

    int insert(ClassifyGroup record);

    int insertSelective(ClassifyGroup record);

    List<ClassifyGroup> selectByExample(ClassifyGroupExample example);

    ClassifyGroup selectByPrimaryKey(Integer mapId);

    int updateByExampleSelective(@Param("record") ClassifyGroup record, @Param("example") ClassifyGroupExample example);

    int updateByExample(@Param("record") ClassifyGroup record, @Param("example") ClassifyGroupExample example);

    int updateByPrimaryKeySelective(ClassifyGroup record);

    int updateByPrimaryKey(ClassifyGroup record);
}