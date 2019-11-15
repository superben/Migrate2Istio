package com.yofc.dal.vote.entity;

public class VoteSubject implements java.io.Serializable{
    private Integer voteSubjectId;

    private String subject;

    private String multipleable;

    private Integer voteId;

    private String hasOther;

    private Integer maxSelectCount;

    public Integer getVoteSubjectId() {
        return voteSubjectId;
    }

    public void setVoteSubjectId(Integer voteSubjectId) {
        this.voteSubjectId = voteSubjectId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getMultipleable() {
        return multipleable;
    }

    public void setMultipleable(String multipleable) {
        this.multipleable = multipleable == null ? null : multipleable.trim();
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public String getHasOther() {
        return hasOther;
    }

    public void setHasOther(String hasOther) {
        this.hasOther = hasOther == null ? null : hasOther.trim();
    }

    public Integer getMaxSelectCount() {
        return maxSelectCount;
    }

    public void setMaxSelectCount(Integer maxSelectCount) {
        this.maxSelectCount = maxSelectCount;
    }
}