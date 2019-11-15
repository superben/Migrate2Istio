package com.yofc.dal.subject.entity;

import java.io.Serializable;
import java.util.Date;

public class SubjectClassify implements Serializable {
    private String subjectClassifyCode;

    private String subjectClassifyName;

    private String remark;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    public String getSubjectClassifyCode() {
        return subjectClassifyCode;
    }

    public void setSubjectClassifyCode(String subjectClassifyCode) {
        this.subjectClassifyCode = subjectClassifyCode == null ? null : subjectClassifyCode.trim();
    }

    public String getSubjectClassifyName() {
        return subjectClassifyName;
    }

    public void setSubjectClassifyName(String subjectClassifyName) {
        this.subjectClassifyName = subjectClassifyName == null ? null : subjectClassifyName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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