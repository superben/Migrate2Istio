package com.yofc.dal.subject.entity;

import java.util.ArrayList;
import java.util.List;

public class SubjectParagraphExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SubjectParagraphExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andParagraphIdIsNull() {
            addCriterion("paragraph_id is null");
            return (Criteria) this;
        }

        public Criteria andParagraphIdIsNotNull() {
            addCriterion("paragraph_id is not null");
            return (Criteria) this;
        }

        public Criteria andParagraphIdEqualTo(Integer value) {
            addCriterion("paragraph_id =", value, "paragraphId");
            return (Criteria) this;
        }

        public Criteria andParagraphIdNotEqualTo(Integer value) {
            addCriterion("paragraph_id <>", value, "paragraphId");
            return (Criteria) this;
        }

        public Criteria andParagraphIdGreaterThan(Integer value) {
            addCriterion("paragraph_id >", value, "paragraphId");
            return (Criteria) this;
        }

        public Criteria andParagraphIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("paragraph_id >=", value, "paragraphId");
            return (Criteria) this;
        }

        public Criteria andParagraphIdLessThan(Integer value) {
            addCriterion("paragraph_id <", value, "paragraphId");
            return (Criteria) this;
        }

        public Criteria andParagraphIdLessThanOrEqualTo(Integer value) {
            addCriterion("paragraph_id <=", value, "paragraphId");
            return (Criteria) this;
        }

        public Criteria andParagraphIdIn(List<Integer> values) {
            addCriterion("paragraph_id in", values, "paragraphId");
            return (Criteria) this;
        }

        public Criteria andParagraphIdNotIn(List<Integer> values) {
            addCriterion("paragraph_id not in", values, "paragraphId");
            return (Criteria) this;
        }

        public Criteria andParagraphIdBetween(Integer value1, Integer value2) {
            addCriterion("paragraph_id between", value1, value2, "paragraphId");
            return (Criteria) this;
        }

        public Criteria andParagraphIdNotBetween(Integer value1, Integer value2) {
            addCriterion("paragraph_id not between", value1, value2, "paragraphId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNull() {
            addCriterion("subject_id is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNotNull() {
            addCriterion("subject_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdEqualTo(Integer value) {
            addCriterion("subject_id =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(Integer value) {
            addCriterion("subject_id <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(Integer value) {
            addCriterion("subject_id >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_id >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(Integer value) {
            addCriterion("subject_id <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("subject_id <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<Integer> values) {
            addCriterion("subject_id in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<Integer> values) {
            addCriterion("subject_id not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(Integer value1, Integer value2) {
            addCriterion("subject_id between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_id not between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andImgSrcIsNull() {
            addCriterion("img_src is null");
            return (Criteria) this;
        }

        public Criteria andImgSrcIsNotNull() {
            addCriterion("img_src is not null");
            return (Criteria) this;
        }

        public Criteria andImgSrcEqualTo(String value) {
            addCriterion("img_src =", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcNotEqualTo(String value) {
            addCriterion("img_src <>", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcGreaterThan(String value) {
            addCriterion("img_src >", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcGreaterThanOrEqualTo(String value) {
            addCriterion("img_src >=", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcLessThan(String value) {
            addCriterion("img_src <", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcLessThanOrEqualTo(String value) {
            addCriterion("img_src <=", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcLike(String value) {
            addCriterion("img_src like", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcNotLike(String value) {
            addCriterion("img_src not like", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcIn(List<String> values) {
            addCriterion("img_src in", values, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcNotIn(List<String> values) {
            addCriterion("img_src not in", values, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcBetween(String value1, String value2) {
            addCriterion("img_src between", value1, value2, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcNotBetween(String value1, String value2) {
            addCriterion("img_src not between", value1, value2, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andMainTagIsNull() {
            addCriterion("main_tag is null");
            return (Criteria) this;
        }

        public Criteria andMainTagIsNotNull() {
            addCriterion("main_tag is not null");
            return (Criteria) this;
        }

        public Criteria andMainTagEqualTo(Integer value) {
            addCriterion("main_tag =", value, "mainTag");
            return (Criteria) this;
        }

        public Criteria andMainTagNotEqualTo(Integer value) {
            addCriterion("main_tag <>", value, "mainTag");
            return (Criteria) this;
        }

        public Criteria andMainTagGreaterThan(Integer value) {
            addCriterion("main_tag >", value, "mainTag");
            return (Criteria) this;
        }

        public Criteria andMainTagGreaterThanOrEqualTo(Integer value) {
            addCriterion("main_tag >=", value, "mainTag");
            return (Criteria) this;
        }

        public Criteria andMainTagLessThan(Integer value) {
            addCriterion("main_tag <", value, "mainTag");
            return (Criteria) this;
        }

        public Criteria andMainTagLessThanOrEqualTo(Integer value) {
            addCriterion("main_tag <=", value, "mainTag");
            return (Criteria) this;
        }

        public Criteria andMainTagIn(List<Integer> values) {
            addCriterion("main_tag in", values, "mainTag");
            return (Criteria) this;
        }

        public Criteria andMainTagNotIn(List<Integer> values) {
            addCriterion("main_tag not in", values, "mainTag");
            return (Criteria) this;
        }

        public Criteria andMainTagBetween(Integer value1, Integer value2) {
            addCriterion("main_tag between", value1, value2, "mainTag");
            return (Criteria) this;
        }

        public Criteria andMainTagNotBetween(Integer value1, Integer value2) {
            addCriterion("main_tag not between", value1, value2, "mainTag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}