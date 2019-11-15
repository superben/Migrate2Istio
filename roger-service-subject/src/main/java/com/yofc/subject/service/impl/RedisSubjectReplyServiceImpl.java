package com.yofc.subject.service.impl;

import com.yofc.dal.subject.entity.*;
import com.yofc.dal.subject.mapper.SubjectFollowMapperExt;
import com.yofc.dal.subject.mapper.SubjectFollowReplyMapperExt;
import com.yofc.dal.subject.mapper.SubjectGoodPointMapperExt;
import com.yofc.subject.service.RedisSubjectReplyService;
import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RedisSubjectReplyServiceImpl implements RedisSubjectReplyService {

    @Autowired
    private SubjectFollowReplyMapperExt subjectFollowReplyMapperExt;

    @Autowired
    private SubjectGoodPointMapperExt subjectGoodPointMapperExt;

    @Autowired
    private SubjectFollowMapperExt subjectFollowMapperExt;

    /***
     * 暂时用不到缓存
     * @param id
     * @return
     */
    @Cacheable(value = "cache.reply.bean", key = "#id")
    @Override
    public SubjectFollowReply findByKeys(Integer id){
        return subjectFollowReplyMapperExt.selectByPrimaryKey(id);
    }

    /***
     * 统计回复数
     * @param followId
     * @return
     */
    @Cacheable(value = "cache.reply.amount", key = "#followId")
    @Override
    public long countReply(Integer followId) {
        SubjectFollowReplyExample example = new SubjectFollowReplyExample();
        example.createCriteria().andFollowIdEqualTo(followId);
        return subjectFollowReplyMapperExt.countByExample(example);
    }

    /***
     * 暂时用不到缓存
     *
     * @param bean
     */
    @Caching(
            evict = {
                    @CacheEvict(value = "cache.reply.amount", key = "#bean.followId")
            }
    )
    @Override
    public void save(SubjectFollowReply bean){
        subjectFollowReplyMapperExt.insertSelectiveExt(bean);
    }

    /***
     * 暂时用不到缓存
     *
     * @param reply SubjectFollowReply
     */
    @Caching(
            evict = {
                    @CacheEvict(value = "cache.reply.bean", key = "#reply.replyId"),
                    @CacheEvict(value = "cache.subject.list.view", allEntries = true),
                    @CacheEvict(value = "cache.follow.list.view", allEntries = true),
                    @CacheEvict(value = "cache.reply.list.view", allEntries = true),
                    @CacheEvict(value = "cache.follow.amount", key = "#reply.subjectId"),
                    @CacheEvict(value = "cache.reply.amount", key = "#reply.followId"),
                    @CacheEvict(value = "cache.reply.amount", key = "#reply.imageFollowId", condition = "#reply.imageFollowId != null"),
                    @CacheEvict(value = "cache.subject.goodpoint.amont", key = "#reply.replyId + '_reply'")
            }
    )
    @Override
    public void delete(SubjectFollowReply reply){
        //删除回复镜像点赞信息
        SubjectGoodPointExample example1 = new SubjectGoodPointExample();
        example1.createCriteria().andFollowIdEqualTo(reply.getImageFollowId());
        subjectGoodPointMapperExt.deleteByExample(example1);

        //删除回复镜像
        subjectFollowMapperExt.deleteByPrimaryKey(reply.getImageFollowId());

        //删除跟帖点赞记录
        SubjectGoodPointExample example = new SubjectGoodPointExample();
        example.createCriteria().andReplyIdEqualTo(reply.getReplyId());
        subjectGoodPointMapperExt.deleteByExample(example);

        //删除回复记录
        subjectFollowReplyMapperExt.deleteByPrimaryKey(reply.getReplyId());
    }

    @Caching(
            evict = {
                    @CacheEvict(value = "cache.subject.list.view", allEntries = true),
                    @CacheEvict(value = "cache.follow.list.view", allEntries = true),
                    @CacheEvict(value = "cache.reply.list.view", allEntries = true),
                    @CacheEvict(value = "cache.follow.amount", key = "#follow.subjectId"),
                    @CacheEvict(value = "cache.reply.amount", key = "#follow.followId")
            }
    )
    @Override
    public void insert(SubjectFollowReply bean, SubjectFollow follow){
        String replyText = Base64.encode(bean.getReplyText().getBytes());
        Date now = new Date();
        //new changes
        SubjectFollowWithBLOBs newFollow = new SubjectFollowWithBLOBs();
        newFollow.setFollowText(replyText);
        newFollow.setSubjectId(follow.getSubjectId());
        newFollow.setFollowUserId(bean.getReplyUserId());
        newFollow.setFollowUserName(bean.getReplyUserName());
        newFollow.setImgSrc("[]");
        newFollow.setFollowParentId(bean.getFollowId());
        newFollow.setFollowParentUserId(follow.getFollowUserId());
        newFollow.setFollowParentUserName(follow.getFollowUserName());
        newFollow.setCreateDate(now);
        newFollow.setUpdateDate(now);
        newFollow.setCreateUser(bean.getReplyUserId());
        newFollow.setUpdateUser(bean.getReplyUserId());
        subjectFollowMapperExt.insertSelectiveExt(newFollow);

        bean.setSubjectId(follow.getSubjectId());
        bean.setReplyText(replyText);
        bean.setReplyDate(now);
        bean.setImageFollowId(newFollow.getFollowId());
        bean.setCreateDate(now);
        bean.setUpdateDate(now);
        bean.setCreateUser(bean.getReplyUserId());
        bean.setUpdateUser(bean.getReplyUserId());
        subjectFollowReplyMapperExt.insertSelectiveExt(bean);
    }
}
