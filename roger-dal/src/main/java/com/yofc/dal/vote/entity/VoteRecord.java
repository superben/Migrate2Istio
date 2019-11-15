package com.yofc.dal.vote.entity;

import java.util.Date;

public class VoteRecord implements java.io.Serializable{
    private Integer voteRecordId;

    private Integer voteId;

    private String voteUserId;

    private Date voteDate;

    private Integer voteSubjectId;

    private Integer voteSubjectItemId;

    private String voteUserName;

    private String voteSubjectItemOther;

    public Integer getVoteRecordId() {
        return voteRecordId;
    }

    public void setVoteRecordId(Integer voteRecordId) {
        this.voteRecordId = voteRecordId;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public String getVoteUserId() {
        return voteUserId;
    }

    public void setVoteUserId(String voteUserId) {
        this.voteUserId = voteUserId == null ? null : voteUserId.trim();
    }

    public Date getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(Date voteDate) {
        this.voteDate = voteDate;
    }

    public Integer getVoteSubjectId() {
        return voteSubjectId;
    }

    public void setVoteSubjectId(Integer voteSubjectId) {
        this.voteSubjectId = voteSubjectId;
    }

    public Integer getVoteSubjectItemId() {
        return voteSubjectItemId;
    }

    public void setVoteSubjectItemId(Integer voteSubjectItemId) {
        this.voteSubjectItemId = voteSubjectItemId;
    }

    public String getVoteUserName() {
        return voteUserName;
    }

    public void setVoteUserName(String voteUserName) {
        this.voteUserName = voteUserName == null ? null : voteUserName.trim();
    }

    public String getVoteSubjectItemOther() {
        return voteSubjectItemOther;
    }

    public void setVoteSubjectItemOther(String voteSubjectItemOther) {
        this.voteSubjectItemOther = voteSubjectItemOther == null ? null : voteSubjectItemOther.trim();
    }
}