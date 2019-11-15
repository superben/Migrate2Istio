package com.yofc.dal.vote.entity;

import java.util.Date;

public class Vote implements java.io.Serializable{
    private Integer voteId;

    private String voteTitle;

    private String voteDesc;

    private Date startDate;

    private Date endDate;

    private String publicState;

    private String status;

    private String reminderState;

    private String originatorId;

    private String originatorName;

    private String removeFlag;

    private String imgSrc;

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public String getVoteTitle() {
        return voteTitle;
    }

    public void setVoteTitle(String voteTitle) {
        this.voteTitle = voteTitle == null ? null : voteTitle.trim();
    }

    public String getVoteDesc() {
        return voteDesc;
    }

    public void setVoteDesc(String voteDesc) {
        this.voteDesc = voteDesc == null ? null : voteDesc.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPublicState() {
        return publicState;
    }

    public void setPublicState(String publicState) {
        this.publicState = publicState == null ? null : publicState.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getReminderState() {
        return reminderState;
    }

    public void setReminderState(String reminderState) {
        this.reminderState = reminderState == null ? null : reminderState.trim();
    }

    public String getOriginatorId() {
        return originatorId;
    }

    public void setOriginatorId(String originatorId) {
        this.originatorId = originatorId == null ? null : originatorId.trim();
    }

    public String getOriginatorName() {
        return originatorName;
    }

    public void setOriginatorName(String originatorName) {
        this.originatorName = originatorName == null ? null : originatorName.trim();
    }

    public String getRemoveFlag() {
        return removeFlag;
    }

    public void setRemoveFlag(String removeFlag) {
        this.removeFlag = removeFlag == null ? null : removeFlag.trim();
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc == null ? null : imgSrc.trim();
    }
}