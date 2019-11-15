package com.yofc.vote.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yofc.dal.vote.entity.VoteRecord;
import com.yofc.dal.vote.entity.VoteRecordExample;
import com.yofc.dal.vote.mapper.VoteRecordMapperExt;
import com.yofc.vote.service.VoteRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VoteRecordServiceImpl implements VoteRecordService {

    @Autowired
    private VoteRecordMapperExt voteRecordMapperExt;

    @Override
    public PageInfo<Map<String, Object>> list(Map<String, Object> queryParam, Integer pageNum, Integer pageSize){
        VoteRecordExample example = new VoteRecordExample();
        PageHelper.startPage(pageNum, pageSize);
        List<VoteRecord> list = voteRecordMapperExt.selectByExample(example);
        PageInfo result = new PageInfo(list);
        return result;
    }

    @Override
    public VoteRecord findByKeys(Integer id){
        return voteRecordMapperExt.selectByPrimaryKey(id);
    }

    @Override
    public void save(VoteRecord bean){
        voteRecordMapperExt.insertSelective(bean);
    }

    @Override
    public void delete(VoteRecord bean){
        voteRecordMapperExt.deleteByPrimaryKey(bean.getVoteId());
    }

    /**
     * 用来判断是否投票
     * 用来加载投票信息
     * */
    @Override
    public List<VoteRecord> queryVoteRecordDetail(Integer voteId, String userId) {
        VoteRecordExample example = new VoteRecordExample();
        example.createCriteria().andVoteIdEqualTo(voteId).andVoteUserIdEqualTo(userId);
        List<VoteRecord> rs = voteRecordMapperExt.selectByExample(example);
        return rs;
    }

    @Override
    public PageInfo<Map<String, Object>> selectHistory(Integer voteId, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = voteRecordMapperExt.queryVoteRecordByPerson(voteId);
        PageInfo result = new PageInfo(list);
        return result;
    }

    @Override
    public PageInfo<VoteRecord> selectOthers(Integer voteId, Integer voteSubjectId, Integer pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        VoteRecordExample example = new VoteRecordExample();
        example.createCriteria().andVoteIdEqualTo(voteId).andVoteSubjectIdEqualTo(voteSubjectId).andVoteSubjectItemOtherIsNotNull();
        List<VoteRecord> list = voteRecordMapperExt.selectByExample(example);
        PageInfo result = new PageInfo(list);
        return result;
    }

}
