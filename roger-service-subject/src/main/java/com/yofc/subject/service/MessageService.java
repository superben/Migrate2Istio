package com.yofc.subject.service;

import com.github.pagehelper.PageInfo;
import com.yofc.dal.subject.entity.Message;

import java.util.Map;

public interface MessageService {

    Integer insertSelectiveExt(Message message);

    PageInfo<Map<String, Object>> list(Map<String, Object> queryParam, Integer pageNum, Integer pageSize);

    void updateReadable(Integer msgId);

    Long countMessage(String userId);
}
