package com.yofc.dal.subject.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;
@RedisHash
@Data
public class SubjectReadLog {

    @Id
    private Integer id;

    private Integer readId;

    private Integer userId;

    private String userName;

    private Integer objectId;

    private Date enterDate;

    private Date outDate;

    private String body;

    private Integer keyCol;

    private String extStr1;

    private String extStr2;
}