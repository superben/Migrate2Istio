package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.SubjectFollowReply;
import com.yofc.dal.subject.entity.SubjectFollowReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectFollowReplyMapper {
    long countByExample(SubjectFollowReplyExample example);

    int deleteByExample(SubjectFollowReplyExample example);

    int deleteByPrimaryKey(Integer replyId);

    int insert(SubjectFollowReply record);

    int insertSelective(SubjectFollowReply record);

    List<SubjectFollowReply> selectByExampleWithBLOBs(SubjectFollowReplyExample example);

    List<SubjectFollowReply> selectByExample(SubjectFollowReplyExample example);

    SubjectFollowReply selectByPrimaryKey(Integer replyId);

    int updateByExampleSelective(@Param("record") SubjectFollowReply record, @Param("example") SubjectFollowReplyExample example);

    int updateByExampleWithBLOBs(@Param("record") SubjectFollowReply record, @Param("example") SubjectFollowReplyExample example);

    int updateByExample(@Param("record") SubjectFollowReply record, @Param("example") SubjectFollowReplyExample example);

    int updateByPrimaryKeySelective(SubjectFollowReply record);

    int updateByPrimaryKeyWithBLOBs(SubjectFollowReply record);

    int updateByPrimaryKey(SubjectFollowReply record);
}