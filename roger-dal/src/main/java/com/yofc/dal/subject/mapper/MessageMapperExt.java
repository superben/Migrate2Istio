package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.Message;

import javax.annotation.Resource;

@Resource
public interface MessageMapperExt extends MessageMapper {

    int insertSelectiveExt(Message message);

}