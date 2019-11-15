package com.yofc.dal.vote.mapper;

import com.yofc.dal.vote.entity.VoteSubject;
import com.yofc.dal.vote.entity.VoteSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoteSubjectMapper {
    long countByExample(VoteSubjectExample example);

    int deleteByExample(VoteSubjectExample example);

    int deleteByPrimaryKey(Integer voteSubjectId);

    int insert(VoteSubject record);

    int insertSelective(VoteSubject record);

    List<VoteSubject> selectByExample(VoteSubjectExample example);

    VoteSubject selectByPrimaryKey(Integer voteSubjectId);

    int updateByExampleSelective(@Param("record") VoteSubject record, @Param("example") VoteSubjectExample example);

    int updateByExample(@Param("record") VoteSubject record, @Param("example") VoteSubjectExample example);

    int updateByPrimaryKeySelective(VoteSubject record);

    int updateByPrimaryKey(VoteSubject record);
}