package com.yofc.dal.subject.entity;

import java.io.Serializable;
import java.util.Date;

public class Subject implements Serializable {

    private Integer subjectId;

    private String subjectClassifyCode;

    private String subject;

    private String ownerId;

    private String ownerName;

    private String topStick;

    private String removeFlag;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private String linkLabel;

    private String linkUrl;

    private String subjectText;

    private String subjectClassifyName;

    private Integer goodPoint;

    private Integer collectionFlag;

    private Long goodPointCount;

    private Long followCount;

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectClassifyCode() {
        return subjectClassifyCode;
    }

    public void setSubjectClassifyCode(String subjectClassifyCode) {
        this.subjectClassifyCode = subjectClassifyCode == null ? null : subjectClassifyCode.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getTopStick() {
        return topStick;
    }

    public void setTopStick(String topStick) {
        this.topStick = topStick == null ? null : topStick.trim();
    }

    public String getRemoveFlag() {
        return removeFlag;
    }

    public void setRemoveFlag(String removeFlag) {
        this.removeFlag = removeFlag == null ? null : removeFlag.trim();
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

    public String getLinkLabel() {
        return linkLabel;
    }

    public void setLinkLabel(String linkLabel) {
        this.linkLabel = linkLabel == null ? null : linkLabel.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public String getSubjectText() {
        return subjectText;
    }

    public void setSubjectText(String subjectText) {
        this.subjectText = subjectText == null ? null : subjectText.trim();
    }

    public String getSubjectClassifyName() {
        return subjectClassifyName;
    }

    public void setSubjectClassifyName(String subjectClassifyName) {
        this.subjectClassifyName = subjectClassifyName;
    }

    public Integer getGoodPoint() {
        return goodPoint;
    }

    public void setGoodPoint(Integer goodPoint) {
        this.goodPoint = goodPoint;
    }

    public Integer getCollectionFlag() {
        return collectionFlag;
    }

    public void setCollectionFlag(Integer collectionFlag) {
        this.collectionFlag = collectionFlag;
    }

    public Long getGoodPointCount() {
        return goodPointCount;
    }

    public void setGoodPointCount(Long goodPointCount) {
        this.goodPointCount = goodPointCount;
    }

    public Long getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Long followCount) {
        this.followCount = followCount;
    }
}