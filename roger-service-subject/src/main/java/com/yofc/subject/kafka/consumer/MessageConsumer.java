package com.yofc.subject.kafka.consumer;

import com.alibaba.fastjson.JSONObject;
import com.yofc.common.bean.ValidationException;
import com.yofc.dal.subject.entity.Message;
import com.yofc.dal.subject.mapper.MessageMapperExt;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MessageConsumer {

    protected static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @Autowired
    private MessageMapperExt messageMapperExt;

    //暂时关闭kafka监听
    //@KafkaListener(topics = "${cbJms.messageTopic}")
    public void listen(ConsumerRecord<?, String> record) {
        logger.debug(record.toString());
        String value = record.value();
        try{
            Message message = JSONObject.parseObject(record.value(), Message.class);
            validation(message);
            messageMapperExt.insertSelectiveExt(message);
        }catch (ClassCastException ex){
            logger.error("消息格式不正确",ex);
        }catch (ValidationException ex){
            logger.error("消息格式不正确,缺少参数",ex);
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
        }
    }

    protected void validation(Message message) throws ValidationException {
        String msg = null;
        if(StringUtils.isEmpty(message.getReceiverUserId())){
            msg = "receiverUserId is required";
        }else if(StringUtils.isEmpty(message.getTitle())){
            msg = "title is required";
        }else if(StringUtils.isEmpty(message.getMsgType())){
            msg = "msgType is required";
        }else if(StringUtils.isEmpty(message.getMsgBody())){
            msg = "msgBody is required";
        }
        if(!StringUtils.isEmpty(msg)){
            throw new ValidationException(msg);
        }
    }
}
