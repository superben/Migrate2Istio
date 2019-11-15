package com.yofc.dal.subject.entity;

import java.io.Serializable;
import java.util.Date;

public class SubjectFollow implements Serializable {
    private Integer followId;

    private Integer subjectId;

    private String followUserId;

    private String followUserName;

    private Integer followParentId;

    private String followParentUserId;

    private String followParentUserName;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(String followUserId) {
        this.followUserId = followUserId == null ? null : followUserId.trim();
    }

    public String getFollowUserName() {
        return followUserName;
    }

    public void setFollowUserName(String followUserName) {
        this.followUserName = followUserName == null ? null : followUserName.trim();
    }

    public Integer getFollowParentId() {
        return followParentId;
    }

    public void setFollowParentId(Integer followParentId) {
        this.followParentId = followParentId;
    }

    public String getFollowParentUserId() {
        return followParentUserId;
    }

    public void setFollowParentUserId(String followParentUserId) {
        this.followParentUserId = followParentUserId == null ? null : followParentUserId.trim();
    }

    public String getFollowParentUserName() {
        return followParentUserName;
    }

    public void setFollowParentUserName(String followParentUserName) {
        this.followParentUserName = followParentUserName == null ? null : followParentUserName.trim();
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