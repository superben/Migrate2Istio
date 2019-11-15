package com.yofc.dal.subject.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectGoodPointExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SubjectGoodPointExample() {
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

        public Criteria andGoodPointIdIsNull() {
            addCriterion("good_point_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodPointIdIsNotNull() {
            addCriterion("good_point_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodPointIdEqualTo(Integer value) {
            addCriterion("good_point_id =", value, "goodPointId");
            return (Criteria) this;
        }

        public Criteria andGoodPointIdNotEqualTo(Integer value) {
            addCriterion("good_point_id <>", value, "goodPointId");
            return (Criteria) this;
        }

        public Criteria andGoodPointIdGreaterThan(Integer value) {
            addCriterion("good_point_id >", value, "goodPointId");
            return (Criteria) this;
        }

        public Criteria andGoodPointIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("good_point_id >=", value, "goodPointId");
            return (Criteria) this;
        }

        public Criteria andGoodPointIdLessThan(Integer value) {
            addCriterion("good_point_id <", value, "goodPointId");
            return (Criteria) this;
        }

        public Criteria andGoodPointIdLessThanOrEqualTo(Integer value) {
            addCriterion("good_point_id <=", value, "goodPointId");
            return (Criteria) this;
        }

        public Criteria andGoodPointIdIn(List<Integer> values) {
            addCriterion("good_point_id in", values, "goodPointId");
            return (Criteria) this;
        }

        public Criteria andGoodPointIdNotIn(List<Integer> values) {
            addCriterion("good_point_id not in", values, "goodPointId");
            return (Criteria) this;
        }

        public Criteria andGoodPointIdBetween(Integer value1, Integer value2) {
            addCriterion("good_point_id between", value1, value2, "goodPointId");
            return (Criteria) this;
        }

        public Criteria andGoodPointIdNotBetween(Integer value1, Integer value2) {
            addCriterion("good_point_id not between", value1, value2, "goodPointId");
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

        public Criteria andFollowIdIsNull() {
            addCriterion("follow_id is null");
            return (Criteria) this;
        }

        public Criteria andFollowIdIsNotNull() {
            addCriterion("follow_id is not null");
            return (Criteria) this;
        }

        public Criteria andFollowIdEqualTo(Integer value) {
            addCriterion("follow_id =", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdNotEqualTo(Integer value) {
            addCriterion("follow_id <>", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdGreaterThan(Integer value) {
            addCriterion("follow_id >", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("follow_id >=", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdLessThan(Integer value) {
            addCriterion("follow_id <", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdLessThanOrEqualTo(Integer value) {
            addCriterion("follow_id <=", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdIn(List<Integer> values) {
            addCriterion("follow_id in", values, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdNotIn(List<Integer> values) {
            addCriterion("follow_id not in", values, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdBetween(Integer value1, Integer value2) {
            addCriterion("follow_id between", value1, value2, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdNotBetween(Integer value1, Integer value2) {
            addCriterion("follow_id not between", value1, value2, "followId");
            return (Criteria) this;
        }

        public Criteria andReplyIdIsNull() {
            addCriterion("reply_id is null");
            return (Criteria) this;
        }

        public Criteria andReplyIdIsNotNull() {
            addCriterion("reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplyIdEqualTo(Integer value) {
            addCriterion("reply_id =", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotEqualTo(Integer value) {
            addCriterion("reply_id <>", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThan(Integer value) {
            addCriterion("reply_id >", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_id >=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThan(Integer value) {
            addCriterion("reply_id <", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("reply_id <=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdIn(List<Integer> values) {
            addCriterion("reply_id in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotIn(List<Integer> values) {
            addCriterion("reply_id not in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdBetween(Integer value1, Integer value2) {
            addCriterion("reply_id between", value1, value2, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_id not between", value1, value2, "replyId");
            return (Criteria) this;
        }

        public Criteria andGoodPointIsNull() {
            addCriterion("good_point is null");
            return (Criteria) this;
        }

        public Criteria andGoodPointIsNotNull() {
            addCriterion("good_point is not null");
            return (Criteria) this;
        }

        public Criteria andGoodPointEqualTo(Integer value) {
            addCriterion("good_point =", value, "goodPoint");
            return (Criteria) this;
        }

        public Criteria andGoodPointNotEqualTo(Integer value) {
            addCriterion("good_point <>", value, "goodPoint");
            return (Criteria) this;
        }

        public Criteria andGoodPointGreaterThan(Integer value) {
            addCriterion("good_point >", value, "goodPoint");
            return (Criteria) this;
        }

        public Criteria andGoodPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("good_point >=", value, "goodPoint");
            return (Criteria) this;
        }

        public Criteria andGoodPointLessThan(Integer value) {
            addCriterion("good_point <", value, "goodPoint");
            return (Criteria) this;
        }

        public Criteria andGoodPointLessThanOrEqualTo(Integer value) {
            addCriterion("good_point <=", value, "goodPoint");
            return (Criteria) this;
        }

        public Criteria andGoodPointIn(List<Integer> values) {
            addCriterion("good_point in", values, "goodPoint");
            return (Criteria) this;
        }

        public Criteria andGoodPointNotIn(List<Integer> values) {
            addCriterion("good_point not in", values, "goodPoint");
            return (Criteria) this;
        }

        public Criteria andGoodPointBetween(Integer value1, Integer value2) {
            addCriterion("good_point between", value1, value2, "goodPoint");
            return (Criteria) this;
        }

        public Criteria andGoodPointNotBetween(Integer value1, Integer value2) {
            addCriterion("good_point not between", value1, value2, "goodPoint");
            return (Criteria) this;
        }

        public Criteria andPointTypeIsNull() {
            addCriterion("point_type is null");
            return (Criteria) this;
        }

        public Criteria andPointTypeIsNotNull() {
            addCriterion("point_type is not null");
            return (Criteria) this;
        }

        public Criteria andPointTypeEqualTo(String value) {
            addCriterion("point_type =", value, "pointType");
            return (Criteria) this;
        }

        public Criteria andPointTypeNotEqualTo(String value) {
            addCriterion("point_type <>", value, "pointType");
            return (Criteria) this;
        }

        public Criteria andPointTypeGreaterThan(String value) {
            addCriterion("point_type >", value, "pointType");
            return (Criteria) this;
        }

        public Criteria andPointTypeGreaterThanOrEqualTo(String value) {
            addCriterion("point_type >=", value, "pointType");
            return (Criteria) this;
        }

        public Criteria andPointTypeLessThan(String value) {
            addCriterion("point_type <", value, "pointType");
            return (Criteria) this;
        }

        public Criteria andPointTypeLessThanOrEqualTo(String value) {
            addCriterion("point_type <=", value, "pointType");
            return (Criteria) this;
        }

        public Criteria andPointTypeLike(String value) {
            addCriterion("point_type like", value, "pointType");
            return (Criteria) this;
        }

        public Criteria andPointTypeNotLike(String value) {
            addCriterion("point_type not like", value, "pointType");
            return (Criteria) this;
        }

        public Criteria andPointTypeIn(List<String> values) {
            addCriterion("point_type in", values, "pointType");
            return (Criteria) this;
        }

        public Criteria andPointTypeNotIn(List<String> values) {
            addCriterion("point_type not in", values, "pointType");
            return (Criteria) this;
        }

        public Criteria andPointTypeBetween(String value1, String value2) {
            addCriterion("point_type between", value1, value2, "pointType");
            return (Criteria) this;
        }

        public Criteria andPointTypeNotBetween(String value1, String value2) {
            addCriterion("point_type not between", value1, value2, "pointType");
            return (Criteria) this;
        }

        public Criteria andPointUserIdIsNull() {
            addCriterion("point_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPointUserIdIsNotNull() {
            addCriterion("point_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPointUserIdEqualTo(String value) {
            addCriterion("point_user_id =", value, "pointUserId");
            return (Criteria) this;
        }

        public Criteria andPointUserIdNotEqualTo(String value) {
            addCriterion("point_user_id <>", value, "pointUserId");
            return (Criteria) this;
        }

        public Criteria andPointUserIdGreaterThan(String value) {
            addCriterion("point_user_id >", value, "pointUserId");
            return (Criteria) this;
        }

        public Criteria andPointUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("point_user_id >=", value, "pointUserId");
            return (Criteria) this;
        }

        public Criteria andPointUserIdLessThan(String value) {
            addCriterion("point_user_id <", value, "pointUserId");
            return (Criteria) this;
        }

        public Criteria andPointUserIdLessThanOrEqualTo(String value) {
            addCriterion("point_user_id <=", value, "pointUserId");
            return (Criteria) this;
        }

        public Criteria andPointUserIdLike(String value) {
            addCriterion("point_user_id like", value, "pointUserId");
            return (Criteria) this;
        }

        public Criteria andPointUserIdNotLike(String value) {
            addCriterion("point_user_id not like", value, "pointUserId");
            return (Criteria) this;
        }

        public Criteria andPointUserIdIn(List<String> values) {
            addCriterion("point_user_id in", values, "pointUserId");
            return (Criteria) this;
        }

        public Criteria andPointUserIdNotIn(List<String> values) {
            addCriterion("point_user_id not in", values, "pointUserId");
            return (Criteria) this;
        }

        public Criteria andPointUserIdBetween(String value1, String value2) {
            addCriterion("point_user_id between", value1, value2, "pointUserId");
            return (Criteria) this;
        }

        public Criteria andPointUserIdNotBetween(String value1, String value2) {
            addCriterion("point_user_id not between", value1, value2, "pointUserId");
            return (Criteria) this;
        }

        public Criteria andPointUserNameIsNull() {
            addCriterion("point_user_name is null");
            return (Criteria) this;
        }

        public Criteria andPointUserNameIsNotNull() {
            addCriterion("point_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andPointUserNameEqualTo(String value) {
            addCriterion("point_user_name =", value, "pointUserName");
            return (Criteria) this;
        }

        public Criteria andPointUserNameNotEqualTo(String value) {
            addCriterion("point_user_name <>", value, "pointUserName");
            return (Criteria) this;
        }

        public Criteria andPointUserNameGreaterThan(String value) {
            addCriterion("point_user_name >", value, "pointUserName");
            return (Criteria) this;
        }

        public Criteria andPointUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("point_user_name >=", value, "pointUserName");
            return (Criteria) this;
        }

        public Criteria andPointUserNameLessThan(String value) {
            addCriterion("point_user_name <", value, "pointUserName");
            return (Criteria) this;
        }

        public Criteria andPointUserNameLessThanOrEqualTo(String value) {
            addCriterion("point_user_name <=", value, "pointUserName");
            return (Criteria) this;
        }

        public Criteria andPointUserNameLike(String value) {
            addCriterion("point_user_name like", value, "pointUserName");
            return (Criteria) this;
        }

        public Criteria andPointUserNameNotLike(String value) {
            addCriterion("point_user_name not like", value, "pointUserName");
            return (Criteria) this;
        }

        public Criteria andPointUserNameIn(List<String> values) {
            addCriterion("point_user_name in", values, "pointUserName");
            return (Criteria) this;
        }

        public Criteria andPointUserNameNotIn(List<String> values) {
            addCriterion("point_user_name not in", values, "pointUserName");
            return (Criteria) this;
        }

        public Criteria andPointUserNameBetween(String value1, String value2) {
            addCriterion("point_user_name between", value1, value2, "pointUserName");
            return (Criteria) this;
        }

        public Criteria andPointUserNameNotBetween(String value1, String value2) {
            addCriterion("point_user_name not between", value1, value2, "pointUserName");
            return (Criteria) this;
        }

        public Criteria andPointDateIsNull() {
            addCriterion("point_date is null");
            return (Criteria) this;
        }

        public Criteria andPointDateIsNotNull() {
            addCriterion("point_date is not null");
            return (Criteria) this;
        }

        public Criteria andPointDateEqualTo(Date value) {
            addCriterion("point_date =", value, "pointDate");
            return (Criteria) this;
        }

        public Criteria andPointDateNotEqualTo(Date value) {
            addCriterion("point_date <>", value, "pointDate");
            return (Criteria) this;
        }

        public Criteria andPointDateGreaterThan(Date value) {
            addCriterion("point_date >", value, "pointDate");
            return (Criteria) this;
        }

        public Criteria andPointDateGreaterThanOrEqualTo(Date value) {
            addCriterion("point_date >=", value, "pointDate");
            return (Criteria) this;
        }

        public Criteria andPointDateLessThan(Date value) {
            addCriterion("point_date <", value, "pointDate");
            return (Criteria) this;
        }

        public Criteria andPointDateLessThanOrEqualTo(Date value) {
            addCriterion("point_date <=", value, "pointDate");
            return (Criteria) this;
        }

        public Criteria andPointDateIn(List<Date> values) {
            addCriterion("point_date in", values, "pointDate");
            return (Criteria) this;
        }

        public Criteria andPointDateNotIn(List<Date> values) {
            addCriterion("point_date not in", values, "pointDate");
            return (Criteria) this;
        }

        public Criteria andPointDateBetween(Date value1, Date value2) {
            addCriterion("point_date between", value1, value2, "pointDate");
            return (Criteria) this;
        }

        public Criteria andPointDateNotBetween(Date value1, Date value2) {
            addCriterion("point_date not between", value1, value2, "pointDate");
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