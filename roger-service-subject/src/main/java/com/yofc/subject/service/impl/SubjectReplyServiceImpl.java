package com.yofc.subject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yofc.common.bean.BusinessException;
import com.yofc.common.util.CommonMapUtils;
import com.yofc.dal.subject.entity.*;
import com.yofc.common.enums.ColleagueTextTypeEnum;
import com.yofc.dal.subject.mapper.SubjectFollowReplyMapperExt;
import com.yofc.dal.subject.mapper.SubjectGoodPointMapperExt;
import com.yofc.subject.service.RedisSubjectFollowService;
import com.yofc.subject.service.RedisSubjectReplyService;
import com.yofc.subject.service.SendMessageService;
import com.yofc.subject.service.SubjectReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SubjectReplyServiceImpl implements SubjectReplyService {

    @Autowired
    private SubjectFollowReplyMapperExt subjectFollowReplyMapperExt;

    @Autowired
    private SubjectGoodPointMapperExt subjectGoodPointMapperExt;

    @Autowired
    private SendMessageService sendMessageService;

    @Autowired
    private RedisSubjectFollowService redisSubjectFollowService;

    @Autowired
    private RedisSubjectReplyService redisSubjectReplyService;

    @Override
    public void insertSelectiveExt(SubjectFollowReply bean) throws BusinessException {
        if(StringUtils.isEmpty(bean.getFollowId())){
            throw new BusinessException("followId is required");
        }
        if(StringUtils.isEmpty(bean.getReplyUserId())){
            throw new BusinessException("replyUserId is required");
        }
        if(StringUtils.isEmpty(bean.getReplyUserName())){
            throw new BusinessException("replyUserName is required");
        }
        if(StringUtils.isEmpty(bean.getReplyText())){
            throw new BusinessException("replyText is required");
        }


        SubjectFollow follow = redisSubjectFollowService.findByKeys(bean.getFollowId());
        redisSubjectReplyService.insert(bean, follow);
        sendMessageService.sendMessage(bean.getFollowId(), bean.getReplyUserName(), follow.getFollowUserId(), bean.getReplyText(), ColleagueTextTypeEnum.newReply.name());
    }

    @Override
    public void deleteByReplyId(Integer replyId) {
        SubjectFollowReply reply = redisSubjectReplyService.findByKeys(replyId);
        redisSubjectReplyService.delete(reply);
    }

    @Override
    @Cacheable(value = "cache.reply.list.view", key = "#queryParam['followId'] +'_'+#queryParam['userId'] +'_'+#pageNum")
    public PageInfo<Map<String, Object>> list(Map<String, Object> queryParam, Integer pageNum, Integer pageSize) throws Exception {
        if(CommonMapUtils.isBlankByKey(queryParam,"followId")){
            throw new Exception("followId is required");
        }
        if(CommonMapUtils.isBlankByKey(queryParam,"userId")){
            throw new Exception("userId is required");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = subjectFollowReplyMapperExt.queryDetailId(queryParam);
        PageInfo result = new PageInfo(list);
        return result;
    }

    @Override
    public void deleteByFollowId(Integer followId) {
        //删除跟帖点赞记录
        SubjectGoodPointExample example = new SubjectGoodPointExample();
        example.createCriteria().andFollowIdEqualTo(followId);
        subjectGoodPointMapperExt.deleteByExample(example);
        //删除回复记录
        SubjectFollowReplyExample example1 = new SubjectFollowReplyExample();
        example1.createCriteria().andFollowIdEqualTo(followId);
        subjectFollowReplyMapperExt.deleteByExample(example1);
    }

    @Override
    public void deleteBySubject(Integer subjectId) {
        //删除点赞记录
        SubjectGoodPointExample example = new SubjectGoodPointExample();
        example.createCriteria().andSubjectIdEqualTo(subjectId);
        subjectGoodPointMapperExt.deleteByExample(example);
        //删除跟帖记录
        SubjectFollowReplyExample example1 = new SubjectFollowReplyExample();
        example1.createCriteria().andSubjectIdEqualTo(subjectId);
        subjectFollowReplyMapperExt.deleteByExample(example1);
    }

    @Override
    public void updateReply(SubjectFollowReply bean) throws BusinessException {
        if(StringUtils.isEmpty(bean.getReplyText())){
            throw new BusinessException("replyText is required");
        }
        if(StringUtils.isEmpty(bean.getUpdateUser())){
            throw new BusinessException("updateUser is required");
        }
        bean.setUpdateDate(new Date());
        subjectFollowReplyMapperExt.updateByPrimaryKeySelective(bean);
    }
}
