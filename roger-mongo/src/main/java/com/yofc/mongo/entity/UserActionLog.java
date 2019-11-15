package com.yofc.mongo.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class UserActionLog {
    @Id
    private ObjectId id;

    private Date enterDate;

    private Date outDate;

    private String userId;

    private String userName;

    private String body;

    private Integer keyCol;

}
