package com.yofc.vote.service.impl;

import com.yofc.dal.vote.entity.VoteSubjectItem;
import com.yofc.dal.vote.entity.VoteSubjectItemExample;
import com.yofc.dal.vote.mapper.VoteSubjectItemMapperExt;
import com.yofc.vote.service.VoteSubjectItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteSubjectItemServiceImpl implements VoteSubjectItemService {

    @Autowired
    private VoteSubjectItemMapperExt voteSubjectItemMapperExt;

    @Override
    public void saveOrUpdate(VoteSubjectItem voteSubjectItem) {
        voteSubjectItemMapperExt.insertSelectiveExt(voteSubjectItem);
    }

    @Override
    public List<VoteSubjectItem> findByParentKeys(Integer pid) {
        VoteSubjectItemExample example = new VoteSubjectItemExample();
        example.createCriteria().andVoteSubjectIdEqualTo(pid);
        return voteSubjectItemMapperExt.selectByExample(example);
    }

    @Override
    public void deleteOthers(Integer subjectId){
        if(subjectId != null){
            VoteSubjectItemExample example = new VoteSubjectItemExample();
            example.createCriteria().andVoteSubjectIdEqualTo(subjectId);
            voteSubjectItemMapperExt.deleteByExample(example);
        }
    }
}
