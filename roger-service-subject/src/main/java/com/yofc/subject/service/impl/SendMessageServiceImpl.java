package com.yofc.subject.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yofc.common.util.WebStringUtils;
import com.yofc.subject.config.JmsConfig;
import com.yofc.dal.subject.entity.Message;
import com.yofc.common.enums.ColleagueBarConstants;
import com.yofc.common.enums.ColleagueTextTypeEnum;
import com.yofc.common.enums.MessageReadableEnum;
import com.yofc.subject.kafka.producer.MessageProducer;
import com.yofc.dal.subject.mapper.MessageMapperExt;
import com.yofc.subject.service.SendMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SendMessageServiceImpl implements SendMessageService {
    protected static final Logger logger = LoggerFactory.getLogger(SendMessageService.class);

    @Autowired
    private MessageMapperExt messageMapperExt;

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private JmsConfig jmsConfig;

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value="cache.message.count", key = "#receiver")
            }
    )
    public void sendMessage(Integer id, String optName, String receiver, String title, String type) {
        try{
            Message bean = new Message();
            Map<String, String> titleMap = new HashMap();
            titleMap.put("encode", "base64");
            if (type.equals(ColleagueTextTypeEnum.newFollow.name())) {
                bean.setUrl("/follow?subjectId=" + id);
                bean.setMsgBody(optName + "  发起了跟帖");
            }else if (type.equals(ColleagueTextTypeEnum.newReply.name())) {
                bean.setTitle(WebStringUtils.formatTextDecode(title));
                bean.setUrl("/reply?followId=" + id);
                bean.setMsgBody(optName + "  回复了您");
            }else if (type.equals(ColleagueTextTypeEnum.follow.name())
                    || type.equals(ColleagueTextTypeEnum.reply.name())) {
                bean.setTitle(WebStringUtils.formatTextDecode(title));
                bean.setUrl("/reply?followId=" + id);
                bean.setMsgBody(optName + "  点赞了您");
            } else {
                titleMap.put("encode", "string");
                bean.setUrl("/follow?subjectId=" + id);
                bean.setMsgBody(optName + (type.equals(ColleagueTextTypeEnum.collection.name()) ? "  关注了你的帖子" : "  点赞了您"));
            }
            titleMap.put("tValue", title);
            bean.setTitle(JSONObject.toJSONString(titleMap));

            bean.setReadable(MessageReadableEnum.unread.name());
            bean.setReceiverUserId(receiver);
            bean.setMsgType(type);
            bean.setCreateTime(new Date());
            bean.setCreateUser(ColleagueBarConstants.systemUser);
            if (jmsConfig.isEnable()) {
                messageProducer.sendMessage(jmsConfig.getMessageTopic(), JSON.toJSONString(bean));
            } else {
                messageMapperExt.insertSelectiveExt(bean);
            }
        }catch (Exception ex){
            logger.error("发送消息失败",ex);
        }
    }

}
