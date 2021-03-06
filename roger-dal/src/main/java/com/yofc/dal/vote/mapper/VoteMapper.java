package com.yofc.dal.vote.mapper;

import com.yofc.dal.vote.entity.Vote;
import com.yofc.dal.vote.entity.VoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoteMapper {
    long countByExample(VoteExample example);

    int deleteByExample(VoteExample example);

    int deleteByPrimaryKey(Integer voteId);

    int insert(Vote record);

    int insertSelective(Vote record);

    List<Vote> selectByExample(VoteExample example);

    Vote selectByPrimaryKey(Integer voteId);

    int updateByExampleSelective(@Param("record") Vote record, @Param("example") VoteExample example);

    int updateByExample(@Param("record") Vote record, @Param("example") VoteExample example);

    int updateByPrimaryKeySelective(Vote record);

    int updateByPrimaryKey(Vote record);
}