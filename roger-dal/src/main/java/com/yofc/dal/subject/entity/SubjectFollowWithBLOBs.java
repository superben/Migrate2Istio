package com.yofc.dal.subject.entity;

import java.io.Serializable;

public class SubjectFollowWithBLOBs extends SubjectFollow implements Serializable {
    private String followText;

    private String imgSrc;

    public String getFollowText() {
        return followText;
    }

    public void setFollowText(String followText) {
        this.followText = followText == null ? null : followText.trim();
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc == null ? null : imgSrc.trim();
    }
}