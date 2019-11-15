package com.yofc.dal.subject.entity;

import java.io.Serializable;
import java.util.Date;

public class SubjectGoodPoint implements Serializable {
    private Integer goodPointId;

    private Integer subjectId;

    private Integer followId;

    private Integer replyId;

    private Integer goodPoint;

    private String pointType;

    private String pointUserId;

    private String pointUserName;

    private Date pointDate;

    public Integer getGoodPointId() {
        return goodPointId;
    }

    public void setGoodPointId(Integer goodPointId) {
        this.goodPointId = goodPointId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getGoodPoint() {
        return goodPoint;
    }

    public void setGoodPoint(Integer goodPoint) {
        this.goodPoint = goodPoint;
    }

    public String getPointType() {
        return pointType;
    }

    public void setPointType(String pointType) {
        this.pointType = pointType == null ? null : pointType.trim();
    }

    public String getPointUserId() {
        return pointUserId;
    }

    public void setPointUserId(String pointUserId) {
        this.pointUserId = pointUserId == null ? null : pointUserId.trim();
    }

    public String getPointUserName() {
        return pointUserName;
    }

    public void setPointUserName(String pointUserName) {
        this.pointUserName = pointUserName == null ? null : pointUserName.trim();
    }

    public Date getPointDate() {
        return pointDate;
    }

    public void setPointDate(Date pointDate) {
        this.pointDate = pointDate;
    }
}