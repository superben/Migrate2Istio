package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.SubjectFollow;
import com.yofc.dal.subject.entity.SubjectFollowExample;
import com.yofc.dal.subject.entity.SubjectFollowWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectFollowMapper {
    long countByExample(SubjectFollowExample example);

    int deleteByExample(SubjectFollowExample example);

    int deleteByPrimaryKey(Integer followId);

    int insert(SubjectFollowWithBLOBs record);

    int insertSelective(SubjectFollowWithBLOBs record);

    List<SubjectFollowWithBLOBs> selectByExampleWithBLOBs(SubjectFollowExample example);

    List<SubjectFollow> selectByExample(SubjectFollowExample example);

    SubjectFollowWithBLOBs selectByPrimaryKey(Integer followId);

    int updateByExampleSelective(@Param("record") SubjectFollowWithBLOBs record, @Param("example") SubjectFollowExample example);

    int updateByExampleWithBLOBs(@Param("record") SubjectFollowWithBLOBs record, @Param("example") SubjectFollowExample example);

    int updateByExample(@Param("record") SubjectFollow record, @Param("example") SubjectFollowExample example);

    int updateByPrimaryKeySelective(SubjectFollowWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SubjectFollowWithBLOBs record);

    int updateByPrimaryKey(SubjectFollow record);
}