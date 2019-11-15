package com.yofc.subject.redis.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
@Data
public class GoodPointAmount {

    @Id
    private String id;

    private Integer objectId;

    private String goodPointType;

    private Long amount;

}
