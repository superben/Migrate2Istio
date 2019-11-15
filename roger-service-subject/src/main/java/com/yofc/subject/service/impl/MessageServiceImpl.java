package com.yofc.subject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yofc.dal.subject.entity.Message;
import com.yofc.dal.subject.entity.MessageExample;
import com.yofc.common.enums.ColleagueBarConstants;
import com.yofc.common.enums.MessageReadableEnum;
import com.yofc.dal.subject.mapper.MessageMapperExt;
import com.yofc.subject.service.MessageService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapperExt messageMapperExt;

    @Override
    public Integer insertSelectiveExt(Message message) {
        message.setReadable(MessageReadableEnum.unread.name());
        message.setCreateTime(new Date());
        message.setCreateUser(ColleagueBarConstants.systemUser);
        return messageMapperExt.insertSelectiveExt(message);
    }

    @Override
    public PageInfo<Map<String, Object>> list(Map<String, Object> queryParam, Integer pageNum, Integer pageSize) {
        MessageExample example = new MessageExample();
        String receiverUserId = MapUtils.getString(queryParam, "receiverUserId");
        example.createCriteria().andReceiverUserIdEqualTo(receiverUserId);
        example.setOrderByClause(" create_time desc ");
        PageHelper.startPage(pageNum, pageSize);
        List<Message> list = messageMapperExt.selectByExample(example);
        PageInfo result = new PageInfo(list);
        return result;
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = "cache.message.count", key = "#userId")
            }
    )
    public void updateReadable(Integer msgId) {
        Message message = new Message();
        message.setMsgId(msgId);
        message.setReadable(MessageReadableEnum.read.name());
        messageMapperExt.updateByPrimaryKeySelective(message);
    }

    @Override
    @Cacheable(value = "cache.message.count", key = "#userId")
    public Long countMessage(String userId) {
        MessageExample example = new MessageExample();
        example.createCriteria().andReadableEqualTo(MessageReadableEnum.unread.name()).andReceiverUserIdEqualTo(userId);
        return messageMapperExt.countByExample(example);
    }

}
