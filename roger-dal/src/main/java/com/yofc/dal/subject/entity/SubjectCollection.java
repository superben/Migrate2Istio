package com.yofc.dal.subject.entity;

import java.io.Serializable;
import java.util.Date;

public class SubjectCollection implements Serializable {
    private Integer collectionId;

    private Integer subjectId;

    private Integer collectionFlag;

    private Integer goodPoint;

    private String collectionUserId;

    private String collectionUserName;

    private String goodPointUserId;

    private String goodPointUserName;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getCollectionFlag() {
        return collectionFlag;
    }

    public void setCollectionFlag(Integer collectionFlag) {
        this.collectionFlag = collectionFlag;
    }

    public Integer getGoodPoint() {
        return goodPoint;
    }

    public void setGoodPoint(Integer goodPoint) {
        this.goodPoint = goodPoint;
    }

    public String getCollectionUserId() {
        return collectionUserId;
    }

    public void setCollectionUserId(String collectionUserId) {
        this.collectionUserId = collectionUserId == null ? null : collectionUserId.trim();
    }

    public String getCollectionUserName() {
        return collectionUserName;
    }

    public void setCollectionUserName(String collectionUserName) {
        this.collectionUserName = collectionUserName == null ? null : collectionUserName.trim();
    }

    public String getGoodPointUserId() {
        return goodPointUserId;
    }

    public void setGoodPointUserId(String goodPointUserId) {
        this.goodPointUserId = goodPointUserId == null ? null : goodPointUserId.trim();
    }

    public String getGoodPointUserName() {
        return goodPointUserName;
    }

    public void setGoodPointUserName(String goodPointUserName) {
        this.goodPointUserName = goodPointUserName == null ? null : goodPointUserName.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}