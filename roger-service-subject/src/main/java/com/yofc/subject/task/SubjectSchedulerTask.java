package com.yofc.subject.task;

import com.yofc.subject.redis.service.ISubjectReadRedisService;
import com.yofc.subject.service.AbstractTaskService;
import com.yofc.subject.service.PushSubjectTaskService;
import com.yofc.subject.service.TaskScheduledService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SubjectSchedulerTask {

    private static final Logger log = LoggerFactory.getLogger(SubjectSchedulerTask.class);
    @Autowired
    private TaskScheduledService taskScheduledService;

    @Autowired
    private PushSubjectTaskService pushSubjectTaskService;

    @Autowired
    private ISubjectReadRedisService subjectReadService;

    //@Scheduled(cron = "0 0/3 * * * ? ")
    private void task() {
        taskScheduledService.doTask((AbstractTaskService) pushSubjectTaskService);
    }

    @Scheduled(cron = "0 0/3 * * * ? ")
    public void flushSubjectReadToDB() {
        subjectReadService.saveSubjectReadLogFromRedis();
    }

}
