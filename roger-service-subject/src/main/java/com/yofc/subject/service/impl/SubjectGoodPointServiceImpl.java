package com.yofc.subject.service.impl;

import com.yofc.common.bean.BusinessException;
import com.yofc.common.util.BeanMapUtil;
import com.yofc.common.util.CommonMapUtils;
import com.yofc.dal.subject.entity.*;
import com.yofc.common.enums.ColleagueTextTypeEnum;
import com.yofc.dal.subject.mapper.*;
import com.yofc.subject.service.*;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SubjectGoodPointServiceImpl implements SubjectGoodPointService {
    protected static final Logger logger = LoggerFactory.getLogger(SubjectGoodPointServiceImpl.class);

    @Autowired
    private SubjectGoodPointMapperExt subjectGoodPointMapperExt;

    @Autowired
    private SubjectFollowMapperExt subjectFollowMapperExt;

    @Autowired
    private SubjectFollowReplyMapperExt subjectFollowReplyMapperExt;

    @Autowired
    private SubjectCollectionMapperExt subjectCollectionMapperExt;

    @Autowired
    private SubjectMapperExt subjectMapperExt;

    @Autowired
    private SendMessageService sendMessageService;

    @Autowired
    private RedisSubjectGoodPointService redisSubjectGoodPointService;

    @Autowired
    private RedisSubjectCollectionService redisSubjectCollectionService;

    @Autowired
    private RedisSubjectService redisSubjectService;

    @Autowired
    private RedisSubjectFollowService redisSubjectFollowService;

    @Autowired
    private RedisSubjectReplyService redisSubjectReplyService;

    @Override
    public Integer setGoodPoint(Integer id, String type, Map<String, Object> params) throws BusinessException {
        return setGoodPointNew(id, type, null, params);
    }

    @Override
    public List<Map<String, Object>> setGoodPointList(Map<String, Object> params) {
        List<Map<String, Object>> list = (List<Map<String, Object>>) params.get("dataList");
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String, Object> item : list) {
            Integer id = MapUtils.getInteger(item, "keyId");
            String pointType = MapUtils.getString(item, "pointType");
            Integer goodPoint = MapUtils.getInteger(item, "goodPoint");
            try {
                setGoodPointNew(id, pointType, goodPoint, params);
                result.add(item);
            } catch (Exception ex) {
                ex.printStackTrace();
                logger.error("Set GoodPoint error. id:" + id + " pointType:" + pointType);
            }
        }
        return result;
    }

    public Integer setGoodPointNew(Integer id, String type, Integer goodPoint, Map<String, Object> params) throws BusinessException {
        SubjectGoodPoint subjectGoodPoint;
        String title = null;
        String receiver = null;
        Integer trargetId = id;
        String userId = MapUtils.getString(params, "pointUserId");
        if (StringUtils.isEmpty(userId)) {
            throw new BusinessException("pointUserId is Required");
        }
        if (CommonMapUtils.isBlankByKey(params, "pointUserName")) {
            throw new BusinessException("pointUserName is Required");
        }
        SubjectGoodPointExample example = new SubjectGoodPointExample();
        SubjectGoodPointExample.Criteria cc = example.createCriteria();

        if (ColleagueTextTypeEnum.subject.toString().equals(type)) {
            params.put("subjectId", id);
            cc.andSubjectIdEqualTo(id);
            //发送站内消息
            Subject subject = this.redisSubjectService.findByKeys(id);
            if(subject == null){
                return 0;
            }
            title = subject.getSubject();
            receiver = subject.getOwnerId();
            cc.andPointTypeEqualTo(type).andPointUserIdEqualTo(userId);
        } else if (ColleagueTextTypeEnum.follow.toString().equals(type)) {
            Integer followId = id;
            SubjectFollowWithBLOBs follow = redisSubjectFollowService.findByKeys(followId);
            if(follow == null){
                return 0;
            }
            params.put("followId", id);
            params.put("subjectId", follow.getFollowId());
            cc.andFollowIdEqualTo(id);
            title = follow.getFollowText();
            receiver = follow.getFollowUserId();
            cc.andPointTypeEqualTo(type).andPointUserIdEqualTo(userId);
        } else if (ColleagueTextTypeEnum.reply.toString().equals(type)) {
            Integer replyId = id;

            SubjectFollowReply reply = redisSubjectReplyService.findByKeys(replyId);
            if(reply == null){
                return 0;
            }
            //重新设置 pointType
            params.put("pointType", ColleagueTextTypeEnum.follow.name());
            //params.put("replyId", id);
            params.put("followId", reply.getImageFollowId());
            params.put("subjectId", reply.getSubjectId());
            cc.andFollowIdEqualTo(reply.getImageFollowId());
            title = reply.getReplyText();
            receiver = reply.getReplyUserId();
            trargetId = reply.getFollowId();
            cc.andPointTypeEqualTo(ColleagueTextTypeEnum.follow.name()).andPointUserIdEqualTo(userId);
        } else if (ColleagueTextTypeEnum.collection.toString().equals(type)) {
            return setCollectionFlag(id, userId, MapUtils.getString(params, "pointUserName"), params);
        }
        List<SubjectGoodPoint> subjectGoodPoints = subjectGoodPointMapperExt.selectByExample(example);
        if (subjectGoodPoints != null && !subjectGoodPoints.isEmpty()) {
            subjectGoodPoint = subjectGoodPoints.get(0);
            if (goodPoint != null) {
                subjectGoodPoint.setGoodPoint(goodPoint);
            } else {
                subjectGoodPoint.setGoodPoint(goodPoint == null ? (subjectGoodPoints.get(0).getGoodPoint() == 0 ? 1 : 0) : goodPoint);
            }
            redisSubjectGoodPointService.update(subjectGoodPoint);
        } else {
            subjectGoodPoint = new SubjectGoodPoint();
            BeanMapUtil.map2Bean(params, subjectGoodPoint);
            subjectGoodPoint.setGoodPoint(goodPoint == null ? 1 : goodPoint);
            subjectGoodPoint.setPointDate(new Date());
            if(MapUtils.getString(params, "pointType") == null){
                subjectGoodPoint.setPointType(type);
            }
            redisSubjectGoodPointService.save(subjectGoodPoint);
            //发送站内消息
            sendMessageService.sendMessage(trargetId, subjectGoodPoint.getPointUserName(), receiver, title, type);
        }
        return subjectGoodPoint.getGoodPoint();
    }

    protected Integer setCollectionFlag(Integer subjectId, String collectionUserId, String collectionUserName, Map<String, Object> param) {
        SubjectCollection subjectCollection;
        SubjectCollectionExample example = new SubjectCollectionExample();
        example.createCriteria().andSubjectIdEqualTo(subjectId).andCollectionUserIdEqualTo(collectionUserId);
        List<SubjectCollection> subjectCollections = subjectCollectionMapperExt.selectByExample(example);
        if (subjectCollections != null && !subjectCollections.isEmpty()) {
            subjectCollection = subjectCollections.get(0);
            subjectCollection.setCollectionFlag(subjectCollections.get(0).getCollectionFlag() == 0 ? 1 : 0);
            subjectCollection.setUpdateDate(new Date());
            subjectCollection.setUpdateUser(collectionUserId);
            redisSubjectCollectionService.update(subjectCollection);
        } else {
            subjectCollection = new SubjectCollection();
            subjectCollection.setGoodPoint(0);
            subjectCollection.setCollectionFlag(1);
            subjectCollection.setSubjectId(subjectId);
            subjectCollection.setCollectionUserId(collectionUserId);
            subjectCollection.setCollectionUserName(collectionUserName);
            subjectCollection.setCreateUser(collectionUserId);
            subjectCollection.setUpdateUser(collectionUserName);
            subjectCollection.setCreateDate(new Date());
            subjectCollection.setUpdateDate(new Date());
            BeanMapUtil.map2Bean(param, subjectCollection);
            redisSubjectCollectionService.save(subjectCollection);
            //发送站内消息
            Subject subject = redisSubjectService.findByKeys(subjectId);
            sendMessageService.sendMessage(subjectId, collectionUserName, subject.getOwnerId(), subject.getSubject(), ColleagueTextTypeEnum.collection.name());
        }
        return subjectCollection.getCollectionFlag();
    }
}
