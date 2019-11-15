package com.yofc.vote.service.impl;

import com.yofc.common.enums.PublicEnum;
import com.yofc.common.enums.VoteStatus;
import com.yofc.common.util.BeanMapUtil;
import com.yofc.dal.vote.mapper.VoteMapperExt;
import com.yofc.dal.vote.mapper.VoteSubjectItemMapperExt;
import com.yofc.dal.vote.mapper.VoteSubjectMapperExt;
import com.yofc.dal.vote.entity.*;
import com.yofc.vote.service.RedisVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RedisVoteServiceImpl implements RedisVoteService {

    @Autowired
    private VoteMapperExt voteMapperExt;

    @Autowired
    private VoteSubjectMapperExt voteSubjectMapperExt;

    @Autowired
    private VoteSubjectItemMapperExt voteSubjectItemMapperExt;

    @Override
    @Cacheable(value = "cache.vote.bean", key = "#id")
    public Vote findByKeys(Integer id) {
        return voteMapperExt.selectByPrimaryKey(id);
    }

    @Override
    @Cacheable(value = "cache.emptyVote.bean", key = "#voteId")
    public Map<String, Object> queryEmptyVote(Integer voteId) {
        Map<String, Object> result = new HashMap<>();
        Vote vote = voteMapperExt.selectByPrimaryKey(voteId);
        VoteSubjectExample example = new VoteSubjectExample();
        example.createCriteria().andVoteIdEqualTo(voteId);
        List<VoteSubject> voteSubjects = voteSubjectMapperExt.selectByExample(example);
        List<Map<String, Object>> voteSubjectsView = new ArrayList<>();
        for (VoteSubject item : voteSubjects) {
            Map<String, Object> voteSubjectMap = BeanMapUtil.bean2Map(item);
            VoteSubjectItemExample example1 = new VoteSubjectItemExample();
            example1.createCriteria().andVoteSubjectIdEqualTo(item.getVoteSubjectId());
            example1.setOrderByClause("seq ");
            List<VoteSubjectItem> voteSubjectItems = voteSubjectItemMapperExt.selectByExample(example1);
            List<Map<String, Object>> voteSubjectsItemView = new ArrayList<>();
            for (VoteSubjectItem two : voteSubjectItems) {
                Map<String, Object> voteSubjectItemMap = BeanMapUtil.bean2Map(two);
                voteSubjectsItemView.add(voteSubjectItemMap);
            }
            voteSubjectMap.put("subjectItem", voteSubjectsItemView);
            voteSubjectsView.add(voteSubjectMap);
        }
        result.put("vote", vote);
        result.put("voteSubjects", voteSubjectsView);
        return result;
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = "cache.vote.list.view", allEntries = true),
                    @CacheEvict(value = "cache.vote.bean", key = "#bean.voteId", condition = "#bean.voteId != null"),
                    @CacheEvict(value = "cache.emptyVote.bean", key = "#bean.voteId", condition = "#bean.voteId !=null ")
            }
    )
    public void saveOrUpdate(Vote bean) {
        if (bean.getVoteId() == null) {
            bean.setRemoveFlag(PublicEnum.N.name());
            bean.setStatus(VoteStatus.wait.name());
            voteMapperExt.insertSelectiveExt(bean);
        } else {
            voteMapperExt.updateByPrimaryKeySelective(bean);
        }
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = "cache.vote.list.view", allEntries = true),
                    @CacheEvict(value = "cache.vote.bean", key = "#bean.voteId", condition = "#bean.voteId != null"),
                    @CacheEvict(value = "cache.emptyVote.bean", key = "#bean.voteId", condition = "#bean.voteId !=null ")
            }
    )
    public void update(Vote bean){
        voteMapperExt.updateByPrimaryKeySelective(bean);
    }
}
