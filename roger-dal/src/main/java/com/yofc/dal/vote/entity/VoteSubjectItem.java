package com.yofc.dal.vote.entity;

public class VoteSubjectItem implements java.io.Serializable{
    private Integer voteItemId;

    private String item;

    private String hasOther;

    private Integer voteSubjectId;

    private Integer seq;

    public Integer getVoteItemId() {
        return voteItemId;
    }

    public void setVoteItemId(Integer voteItemId) {
        this.voteItemId = voteItemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public String getHasOther() {
        return hasOther;
    }

    public void setHasOther(String hasOther) {
        this.hasOther = hasOther == null ? null : hasOther.trim();
    }

    public Integer getVoteSubjectId() {
        return voteSubjectId;
    }

    public void setVoteSubjectId(Integer voteSubjectId) {
        this.voteSubjectId = voteSubjectId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}