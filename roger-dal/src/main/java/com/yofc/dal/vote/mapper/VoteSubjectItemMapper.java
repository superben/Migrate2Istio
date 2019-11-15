package com.yofc.dal.vote.mapper;

import com.yofc.dal.vote.entity.VoteSubjectItem;
import com.yofc.dal.vote.entity.VoteSubjectItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoteSubjectItemMapper {
    long countByExample(VoteSubjectItemExample example);

    int deleteByExample(VoteSubjectItemExample example);

    int deleteByPrimaryKey(Integer voteItemId);

    int insert(VoteSubjectItem record);

    int insertSelective(VoteSubjectItem record);

    List<VoteSubjectItem> selectByExample(VoteSubjectItemExample example);

    VoteSubjectItem selectByPrimaryKey(Integer voteItemId);

    int updateByExampleSelective(@Param("record") VoteSubjectItem record, @Param("example") VoteSubjectItemExample example);

    int updateByExample(@Param("record") VoteSubjectItem record, @Param("example") VoteSubjectItemExample example);

    int updateByPrimaryKeySelective(VoteSubjectItem record);

    int updateByPrimaryKey(VoteSubjectItem record);
}