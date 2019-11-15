package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.SubjectGoodPoint;
import com.yofc.dal.subject.entity.SubjectGoodPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectGoodPointMapper {
    long countByExample(SubjectGoodPointExample example);

    int deleteByExample(SubjectGoodPointExample example);

    int deleteByPrimaryKey(Integer goodPointId);

    int insert(SubjectGoodPoint record);

    int insertSelective(SubjectGoodPoint record);

    List<SubjectGoodPoint> selectByExample(SubjectGoodPointExample example);

    SubjectGoodPoint selectByPrimaryKey(Integer goodPointId);

    int updateByExampleSelective(@Param("record") SubjectGoodPoint record, @Param("example") SubjectGoodPointExample example);

    int updateByExample(@Param("record") SubjectGoodPoint record, @Param("example") SubjectGoodPointExample example);

    int updateByPrimaryKeySelective(SubjectGoodPoint record);

    int updateByPrimaryKey(SubjectGoodPoint record);
}