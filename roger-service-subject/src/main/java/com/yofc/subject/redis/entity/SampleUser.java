package com.yofc.subject.redis.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
@Data
public class SampleUser {

    @Id
    private String id;

    private String userName;

    private Integer age;

}
