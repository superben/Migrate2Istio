package com.yofc.dal.subject.entity;

public class SubjectFrom implements java.io.Serializable{
    private Integer realId;

    private Integer subjectId;

    private Integer keyId;

    private String type;

    public Integer getRealId() {
        return realId;
    }

    public void setRealId(Integer realId) {
        this.realId = realId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}