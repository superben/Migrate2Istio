package com.yofc.admin.service;

import com.yofc.dal.subject.entity.Task;

import java.util.List;

public abstract class AbstractTaskService {
    public abstract List<Task> doTaskDelegate(List<Task> taskList);
}
