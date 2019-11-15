package com.yofc.dal.subject.entity;

public class ClassifyGroup {
    private Integer mapId;

    private String subjectClassifyCode;

    private String groupCode;

    private String ancestors;

    private String userIds;

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public String getSubjectClassifyCode() {
        return subjectClassifyCode;
    }

    public void setSubjectClassifyCode(String subjectClassifyCode) {
        this.subjectClassifyCode = subjectClassifyCode == null ? null : subjectClassifyCode.trim();
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors == null ? null : ancestors.trim();
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds == null ? null : userIds.trim();
    }
}