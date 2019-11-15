package com.yofc.subject.spring;

import com.yofc.subject.redis.service.ISubjectReadRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Roger
 * redis 初始化系统参数
 * */
@Component
@Order(11)
public class RedisInitCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(RedisInitCommandLineRunner.class);

    @Autowired
    private ISubjectReadRedisService subjectReadRedisService;

    @Override
    public void run(String... args) throws Exception {
        log.info("init redis variables begin");
        init();
        log.info("init redis variables end");
    }

    private void init(){
        log.info("init redis variables[subject read amount] begin");
        subjectReadRedisService.initSubjectReadAmount();
    }

}
