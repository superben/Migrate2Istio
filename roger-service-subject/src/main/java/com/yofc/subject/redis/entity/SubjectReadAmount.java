package com.yofc.subject.redis.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
@Data
public class SubjectReadAmount {

    @Id
    private String id;

    private Integer objectId;

    private Long readAmount;

    private Long goodPointAmount;

    private Long followAmount;

    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
