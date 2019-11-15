package com.yofc.subject.redis.api;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MyRedisCacheManager {
    @Autowired
    private RedisTemplate redisTemplate;

    /***
     *  插入数据或者更新数据
     *  */
    public void insert(String key, Object value, long timeout, TimeUnit timeUnit) {

        if (StringUtils.isBlank(key) || !ObjectUtils.anyNotNull(value)) {
            return;
        }
        if (timeout == 0) {
            redisTemplate.opsForValue().set(key, value);
        } else {
            redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
        }
    }

    /***
     *  插入数据或者更新数据
     *  */
    public void insert(String key, Object value) {
        if (StringUtils.isBlank(key) || !ObjectUtils.anyNotNull(value)) {
            return;
        }
        redisTemplate.opsForValue().set(key, value);
    }

    public void delete(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
    }
}
