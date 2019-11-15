package com.yofc.subject.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yofc.common.bean.BusinessException;
import com.yofc.common.bean.MessageJson;
import com.yofc.common.enums.ColleagueTextTypeEnum;
import com.yofc.common.util.CommonMapUtils;
import com.yofc.dal.subject.entity.Subject;
import com.yofc.dal.subject.entity.SubjectFollowWithBLOBs;
import com.yofc.dal.subject.entity.SubjectGoodPoint;
import com.yofc.dal.subject.entity.SubjectGoodPointExample;
import com.yofc.dal.subject.entity.vo.SubjectFollowVO;
import com.yofc.dal.subject.mapper.SubjectFollowMapperExt;
import com.yofc.dal.subject.mapper.SubjectGoodPointMapperExt;
import com.yofc.subject.remote.UserRemoteService;
import com.yofc.subject.service.*;
import org.apache.commons.collections4.MapUtils;
import org.apache.ibatis.reflection.property.PropertyCopier;
import org.apache.xerces.impl.dv.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SubjectFollowServiceImpl implements SubjectFollowService {

    private static final Logger log = LoggerFactory.getLogger(SubjectFollowServiceImpl.class);
    @Autowired
    private SubjectFollowMapperExt subjectFollowMapperExt;

    @Autowired
    private SubjectReplyService subjectReplyService;

    @Autowired
    private SubjectGoodPointMapperExt subjectGoodPointMapperExt;

    @Autowired
    private SendMessageService sendMessageService;

    @Autowired
    private RedisSubjectGoodPointService redisSubjectGoodPointService;

    @Autowired
    private RedisSubjectReplyService redisSubjectReplyService;

    @Autowired
    private RedisSubjectFollowService redisSubjectFollowService;

    @Autowired
    private RedisSubjectService redisSubjectService;

    @Autowired
    private UserRemoteService userRemoteService;

    @Autowired
    private SubjectFollowService subjectFollowService;

    @Override
    @Cacheable(value = "cache.follow.list.view", key = "#queryParam['subjectId'] + '_' + #queryParam['userId'] + '_' +#pageNum")
    public PageInfo<Map<String, Object>> list(Map<String, Object> queryParam, Integer pageNum, Integer pageSize) throws Exception {
        if (CommonMapUtils.isBlankByKey(queryParam, "subjectId")) {
            throw new Exception("subjectId is required");
        }
        if (CommonMapUtils.isBlankByKey(queryParam, "userId")) {
            throw new Exception("userId is required");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = subjectFollowMapperExt.queryDetailId(queryParam);
        for (Map<String, Object> item : list) {
            String imgSrc = MapUtils.getString(item, "imgSrc");
            if (!StringUtils.isEmpty(imgSrc)) {
                List<Map<String, Object>> imgs = (List<Map<String, Object>>) JSONObject.parse(imgSrc);
                item.put("images", imgs);
            }
        }
        PageInfo result = new PageInfo(list);
        return result;
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = "cache.subject.list.view", allEntries = true),
                    @CacheEvict(value = "cache.follow.list.view", allEntries = true),
                    @CacheEvict(value = "cache.follow.amount", key = "#bean.subjectId")
            }
    )
    public void insertSelectiveExt(SubjectFollowWithBLOBs bean) throws BusinessException {
        if (StringUtils.isEmpty(bean.getSubjectId())) {
            throw new BusinessException("subjectId is required");
        }
        if (StringUtils.isEmpty(bean.getFollowUserId())) {
            throw new BusinessException("followUserId is required");
        }
        if (StringUtils.isEmpty(bean.getFollowUserName())) {
            throw new BusinessException("followUserName is required");
        }
        if (StringUtils.isEmpty(bean.getFollowText())) {
            throw new BusinessException("followText is required");
        }
        Subject subject = redisSubjectService.findByKeys(bean.getSubjectId());
        bean.setCreateDate(new Date());
        bean.setUpdateDate(new Date());
        bean.setCreateUser(bean.getFollowUserId());
        bean.setUpdateUser(bean.getFollowUserId());
        bean.setFollowText(Base64.encode(bean.getFollowText().getBytes()));
        subjectFollowMapperExt.insertSelectiveExt(bean);
        sendMessageService.sendMessage(bean.getSubjectId(), bean.getFollowUserName(), subject.getOwnerId(), bean.getFollowText(), ColleagueTextTypeEnum.newFollow.name());
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = "cache.subject.list.view", allEntries = true),
                    @CacheEvict(value = "cache.follow.list.view", allEntries = true),
                    @CacheEvict(value = "cache.follow.amount", key = "#subjectId"),
                    @CacheEvict(value = "cache.subject.goodpoint.amont", key = "#followId + '_follow'")
            }
    )
    public void deleteFollowId(Integer subjectId, Integer followId) {
        //删除点赞
        SubjectGoodPointExample example = new SubjectGoodPointExample();
        example.createCriteria().andFollowIdEqualTo(followId);
        subjectGoodPointMapperExt.deleteByExample(example);
        //删除跟帖回复
        subjectReplyService.deleteByFollowId(followId);
        //删除跟帖
        subjectFollowMapperExt.deleteByPrimaryKey(followId);
    }

    @Override
    public void updateFollow(SubjectFollowWithBLOBs bean) throws BusinessException {
        if (StringUtils.isEmpty(bean.getFollowText())) {
            throw new BusinessException("followText is required");
        }
        if (StringUtils.isEmpty(bean.getUpdateUser())) {
            throw new BusinessException("updateUser is required");
        }
        bean.setUpdateDate(new Date());
        subjectFollowMapperExt.updateByPrimaryKeySelective(bean);
    }

    @Override
    public SubjectFollowVO queryByParam(Integer followId, Map<String, Object> queryParam) throws BusinessException {
        String userId = MapUtils.getString(queryParam, "userId");
        //加载当前用户点赞信息
        SubjectFollowVO result = queryFollowByParam(followId, queryParam);
        //加载点赞信息
        SubjectGoodPoint subjectGoodPoint = redisSubjectGoodPointService.findByKeys(followId, userId, ColleagueTextTypeEnum.follow.name());
        Integer cGoodPoint = (subjectGoodPoint != null ? subjectGoodPoint.getGoodPoint() : 0);
        result.setGoodPoint(cGoodPoint);
        //加载跟帖回复数
        result.setFollowCount(redisSubjectReplyService.countReply(followId));
        //加载跟帖点赞数
        result.setGoodPointCount(redisSubjectGoodPointService.count(followId, ColleagueTextTypeEnum.follow.name()));
        //加载用户信息
        log.info("[roger debug]====================" + result.getFollowUserId());
        MessageJson res = userRemoteService.getUser(result.getFollowUserId());
        log.info("[roger debug]====================res：" + res);
        log.info("[roger debug]====================res.getData()：" + res.getData());
        Map<String, Object> user =  (Map<String, Object>)res.getData();
        log.info("[roger debug]====================(Map<String, Object>)res.getData()：" + user);
        result.setAvatar((String) user.get("avatar"));
        return result;
    }

    @Cacheable(value = "cache.follow.vo", key = "#followId")
    public SubjectFollowVO queryFollowByParam(Integer followId, Map<String, Object> queryParam) throws BusinessException {
        // 查询当前用户关注状态
        SubjectFollowVO subjectFollowVO = new SubjectFollowVO();
        queryParam.put("followId", followId);
        SubjectFollowWithBLOBs follow = redisSubjectFollowService.findByKeys(followId);
        PropertyCopier.copyBeanProperties(SubjectFollowWithBLOBs.class, follow, subjectFollowVO);
        if (follow == null ) {
            throw new BusinessException("未查询到主题帖跟帖");
        }
        String imgSrc = follow.getImgSrc();
        if (!StringUtils.isEmpty(imgSrc)) {
            List<Map<String, Object>> imgs = (List<Map<String, Object>>) JSONObject.parse(imgSrc);
            subjectFollowVO.setImages(imgs);

        }
        return subjectFollowVO;
    }
}
