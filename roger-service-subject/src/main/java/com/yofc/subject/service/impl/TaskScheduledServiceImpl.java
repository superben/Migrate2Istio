package com.yofc.subject.service.impl;

import com.yofc.dal.subject.entity.Task;
import com.yofc.dal.subject.entity.TaskExample;
import com.yofc.common.enums.TaskScheduledStatusEnum;
import com.yofc.dal.subject.mapper.TaskMapperExt;
import com.yofc.subject.service.AbstractTaskService;
import com.yofc.subject.service.TaskScheduledService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskScheduledServiceImpl implements TaskScheduledService {

    @Autowired
    private TaskMapperExt taskMapperExt;

    @Override
    public void doTask(AbstractTaskService taskService) {
        List<Task> taskList = new ArrayList<>();
        taskList = beforeDoTaskDelegate();
        taskList = taskService.doTaskDelegate(taskList);
        afterDoTaskDelegate(taskList);
    }

    protected List<Task> beforeDoTaskDelegate() {
        TaskExample example = new TaskExample();
        example.createCriteria().andStatusEqualTo(TaskScheduledStatusEnum.waiting.name()).andCreateTimeGreaterThan(DateUtils.addDays(new Date(), -1));
        List<Task>  taskList = taskMapperExt.selectByExample(example);
        for (Task task : taskList){
            blockTask(task);
        }
        return taskList;
    }

    protected void afterDoTaskDelegate(List<Task> taskList) {
        for (Task task : taskList){
            taskMapperExt.updateByPrimaryKeySelective(task);
        }
    }

    protected void blockTask(Task task){
        task.setStatus(TaskScheduledStatusEnum.starting.name());
        taskMapperExt.updateByPrimaryKeySelective(task);
    }

}
