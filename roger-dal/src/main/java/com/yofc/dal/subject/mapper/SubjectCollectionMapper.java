package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.SubjectCollection;
import com.yofc.dal.subject.entity.SubjectCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectCollectionMapper {
    long countByExample(SubjectCollectionExample example);

    int deleteByExample(SubjectCollectionExample example);

    int deleteByPrimaryKey(Integer collectionId);

    int insert(SubjectCollection record);

    int insertSelective(SubjectCollection record);

    List<SubjectCollection> selectByExample(SubjectCollectionExample example);

    SubjectCollection selectByPrimaryKey(Integer collectionId);

    int updateByExampleSelective(@Param("record") SubjectCollection record, @Param("example") SubjectCollectionExample example);

    int updateByExample(@Param("record") SubjectCollection record, @Param("example") SubjectCollectionExample example);

    int updateByPrimaryKeySelective(SubjectCollection record);

    int updateByPrimaryKey(SubjectCollection record);
}