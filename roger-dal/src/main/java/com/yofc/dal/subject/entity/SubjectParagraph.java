package com.yofc.dal.subject.entity;

import java.io.Serializable;

public class SubjectParagraph implements Serializable{
    private Integer paragraphId;

    private Integer subjectId;

    private String imgSrc;

    private Integer mainTag;

    private String paragraph;

    public Integer getParagraphId() {
        return paragraphId;
    }

    public void setParagraphId(Integer paragraphId) {
        this.paragraphId = paragraphId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc == null ? null : imgSrc.trim();
    }

    public Integer getMainTag() {
        return mainTag;
    }

    public void setMainTag(Integer mainTag) {
        this.mainTag = mainTag;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph == null ? null : paragraph.trim();
    }
}