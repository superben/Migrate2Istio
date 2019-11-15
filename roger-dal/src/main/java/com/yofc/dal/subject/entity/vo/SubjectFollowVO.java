package com.yofc.dal.subject.entity.vo;

import com.yofc.dal.subject.entity.SubjectFollowWithBLOBs;

import java.util.List;
import java.util.Map;

public class SubjectFollowVO extends SubjectFollowWithBLOBs implements java.io.Serializable{

    private Integer goodPoint;

    private Long followCount;

    private Long goodPointCount;

    private String avatar;

    private List<Map<String, Object>> images;

    public Integer getGoodPoint() {
        return goodPoint;
    }

    public void setGoodPoint(Integer goodPoint) {
        this.goodPoint = goodPoint;
    }

    public Long getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Long followCount) {
        this.followCount = followCount;
    }

    public Long getGoodPointCount() {
        return goodPointCount;
    }

    public void setGoodPointCount(Long goodPointCount) {
        this.goodPointCount = goodPointCount;
    }

    public List<Map<String, Object>> getImages() {
        return images;
    }

    public void setImages(List<Map<String, Object>> images) {
        this.images = images;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
