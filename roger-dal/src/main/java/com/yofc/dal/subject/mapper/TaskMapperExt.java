package com.yofc.dal.subject.mapper;

import com.yofc.dal.subject.entity.Task;

import javax.annotation.Resource;

@Resource
public interface TaskMapperExt extends TaskMapper {
    int insertSelectiveExt(Task record);
}