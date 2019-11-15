package com.yofc.dal.vote.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VoteRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public VoteRecordExample() {
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

        public Criteria andVoteRecordIdIsNull() {
            addCriterion("vote_record_id is null");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdIsNotNull() {
            addCriterion("vote_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdEqualTo(Integer value) {
            addCriterion("vote_record_id =", value, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdNotEqualTo(Integer value) {
            addCriterion("vote_record_id <>", value, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdGreaterThan(Integer value) {
            addCriterion("vote_record_id >", value, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_record_id >=", value, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdLessThan(Integer value) {
            addCriterion("vote_record_id <", value, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("vote_record_id <=", value, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdIn(List<Integer> values) {
            addCriterion("vote_record_id in", values, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdNotIn(List<Integer> values) {
            addCriterion("vote_record_id not in", values, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("vote_record_id between", value1, value2, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_record_id not between", value1, value2, "voteRecordId");
            return (Criteria) this;
        }

        public Criteria andVoteIdIsNull() {
            addCriterion("vote_id is null");
            return (Criteria) this;
        }

        public Criteria andVoteIdIsNotNull() {
            addCriterion("vote_id is not null");
            return (Criteria) this;
        }

        public Criteria andVoteIdEqualTo(Integer value) {
            addCriterion("vote_id =", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotEqualTo(Integer value) {
            addCriterion("vote_id <>", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdGreaterThan(Integer value) {
            addCriterion("vote_id >", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_id >=", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdLessThan(Integer value) {
            addCriterion("vote_id <", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdLessThanOrEqualTo(Integer value) {
            addCriterion("vote_id <=", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdIn(List<Integer> values) {
            addCriterion("vote_id in", values, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotIn(List<Integer> values) {
            addCriterion("vote_id not in", values, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdBetween(Integer value1, Integer value2) {
            addCriterion("vote_id between", value1, value2, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_id not between", value1, value2, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteUserIdIsNull() {
            addCriterion("vote_user_id is null");
            return (Criteria) this;
        }

        public Criteria andVoteUserIdIsNotNull() {
            addCriterion("vote_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andVoteUserIdEqualTo(String value) {
            addCriterion("vote_user_id =", value, "voteUserId");
            return (Criteria) this;
        }

        public Criteria andVoteUserIdNotEqualTo(String value) {
            addCriterion("vote_user_id <>", value, "voteUserId");
            return (Criteria) this;
        }

        public Criteria andVoteUserIdGreaterThan(String value) {
            addCriterion("vote_user_id >", value, "voteUserId");
            return (Criteria) this;
        }

        public Criteria andVoteUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("vote_user_id >=", value, "voteUserId");
            return (Criteria) this;
        }

        public Criteria andVoteUserIdLessThan(String value) {
            addCriterion("vote_user_id <", value, "voteUserId");
            return (Criteria) this;
        }

        public Criteria andVoteUserIdLessThanOrEqualTo(String value) {
            addCriterion("vote_user_id <=", value, "voteUserId");
            return (Criteria) this;
        }

        public Criteria andVoteUserIdLike(String value) {
            addCriterion("vote_user_id like", value, "voteUserId");
            return (Criteria) this;
        }

        public Criteria andVoteUserIdNotLike(String value) {
            addCriterion("vote_user_id not like", value, "voteUserId");
            return (Criteria) this;
        }

        public Criteria andVoteUserIdIn(List<String> values) {
            addCriterion("vote_user_id in", values, "voteUserId");
            return (Criteria) this;
        }

        public Criteria andVoteUserIdNotIn(List<String> values) {
            addCriterion("vote_user_id not in", values, "voteUserId");
            return (Criteria) this;
        }

        public Criteria andVoteUserIdBetween(String value1, String value2) {
            addCriterion("vote_user_id between", value1, value2, "voteUserId");
            return (Criteria) this;
        }

        public Criteria andVoteUserIdNotBetween(String value1, String value2) {
            addCriterion("vote_user_id not between", value1, value2, "voteUserId");
            return (Criteria) this;
        }

        public Criteria andVoteDateIsNull() {
            addCriterion("vote_date is null");
            return (Criteria) this;
        }

        public Criteria andVoteDateIsNotNull() {
            addCriterion("vote_date is not null");
            return (Criteria) this;
        }

        public Criteria andVoteDateEqualTo(Date value) {
            addCriterion("vote_date =", value, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateNotEqualTo(Date value) {
            addCriterion("vote_date <>", value, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateGreaterThan(Date value) {
            addCriterion("vote_date >", value, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateGreaterThanOrEqualTo(Date value) {
            addCriterion("vote_date >=", value, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateLessThan(Date value) {
            addCriterion("vote_date <", value, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateLessThanOrEqualTo(Date value) {
            addCriterion("vote_date <=", value, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateIn(List<Date> values) {
            addCriterion("vote_date in", values, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateNotIn(List<Date> values) {
            addCriterion("vote_date not in", values, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateBetween(Date value1, Date value2) {
            addCriterion("vote_date between", value1, value2, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteDateNotBetween(Date value1, Date value2) {
            addCriterion("vote_date not between", value1, value2, "voteDate");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectIdIsNull() {
            addCriterion("vote_subject_id is null");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectIdIsNotNull() {
            addCriterion("vote_subject_id is not null");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectIdEqualTo(Integer value) {
            addCriterion("vote_subject_id =", value, "voteSubjectId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectIdNotEqualTo(Integer value) {
            addCriterion("vote_subject_id <>", value, "voteSubjectId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectIdGreaterThan(Integer value) {
            addCriterion("vote_subject_id >", value, "voteSubjectId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_subject_id >=", value, "voteSubjectId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectIdLessThan(Integer value) {
            addCriterion("vote_subject_id <", value, "voteSubjectId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("vote_subject_id <=", value, "voteSubjectId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectIdIn(List<Integer> values) {
            addCriterion("vote_subject_id in", values, "voteSubjectId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectIdNotIn(List<Integer> values) {
            addCriterion("vote_subject_id not in", values, "voteSubjectId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectIdBetween(Integer value1, Integer value2) {
            addCriterion("vote_subject_id between", value1, value2, "voteSubjectId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_subject_id not between", value1, value2, "voteSubjectId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemIdIsNull() {
            addCriterion("vote_subject_item_id is null");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemIdIsNotNull() {
            addCriterion("vote_subject_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemIdEqualTo(Integer value) {
            addCriterion("vote_subject_item_id =", value, "voteSubjectItemId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemIdNotEqualTo(Integer value) {
            addCriterion("vote_subject_item_id <>", value, "voteSubjectItemId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemIdGreaterThan(Integer value) {
            addCriterion("vote_subject_item_id >", value, "voteSubjectItemId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_subject_item_id >=", value, "voteSubjectItemId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemIdLessThan(Integer value) {
            addCriterion("vote_subject_item_id <", value, "voteSubjectItemId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("vote_subject_item_id <=", value, "voteSubjectItemId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemIdIn(List<Integer> values) {
            addCriterion("vote_subject_item_id in", values, "voteSubjectItemId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemIdNotIn(List<Integer> values) {
            addCriterion("vote_subject_item_id not in", values, "voteSubjectItemId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemIdBetween(Integer value1, Integer value2) {
            addCriterion("vote_subject_item_id between", value1, value2, "voteSubjectItemId");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_subject_item_id not between", value1, value2, "voteSubjectItemId");
            return (Criteria) this;
        }

        public Criteria andVoteUserNameIsNull() {
            addCriterion("vote_user_name is null");
            return (Criteria) this;
        }

        public Criteria andVoteUserNameIsNotNull() {
            addCriterion("vote_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andVoteUserNameEqualTo(String value) {
            addCriterion("vote_user_name =", value, "voteUserName");
            return (Criteria) this;
        }

        public Criteria andVoteUserNameNotEqualTo(String value) {
            addCriterion("vote_user_name <>", value, "voteUserName");
            return (Criteria) this;
        }

        public Criteria andVoteUserNameGreaterThan(String value) {
            addCriterion("vote_user_name >", value, "voteUserName");
            return (Criteria) this;
        }

        public Criteria andVoteUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("vote_user_name >=", value, "voteUserName");
            return (Criteria) this;
        }

        public Criteria andVoteUserNameLessThan(String value) {
            addCriterion("vote_user_name <", value, "voteUserName");
            return (Criteria) this;
        }

        public Criteria andVoteUserNameLessThanOrEqualTo(String value) {
            addCriterion("vote_user_name <=", value, "voteUserName");
            return (Criteria) this;
        }

        public Criteria andVoteUserNameLike(String value) {
            addCriterion("vote_user_name like", value, "voteUserName");
            return (Criteria) this;
        }

        public Criteria andVoteUserNameNotLike(String value) {
            addCriterion("vote_user_name not like", value, "voteUserName");
            return (Criteria) this;
        }

        public Criteria andVoteUserNameIn(List<String> values) {
            addCriterion("vote_user_name in", values, "voteUserName");
            return (Criteria) this;
        }

        public Criteria andVoteUserNameNotIn(List<String> values) {
            addCriterion("vote_user_name not in", values, "voteUserName");
            return (Criteria) this;
        }

        public Criteria andVoteUserNameBetween(String value1, String value2) {
            addCriterion("vote_user_name between", value1, value2, "voteUserName");
            return (Criteria) this;
        }

        public Criteria andVoteUserNameNotBetween(String value1, String value2) {
            addCriterion("vote_user_name not between", value1, value2, "voteUserName");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemOtherIsNull() {
            addCriterion("vote_subject_item_other is null");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemOtherIsNotNull() {
            addCriterion("vote_subject_item_other is not null");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemOtherEqualTo(String value) {
            addCriterion("vote_subject_item_other =", value, "voteSubjectItemOther");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemOtherNotEqualTo(String value) {
            addCriterion("vote_subject_item_other <>", value, "voteSubjectItemOther");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemOtherGreaterThan(String value) {
            addCriterion("vote_subject_item_other >", value, "voteSubjectItemOther");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemOtherGreaterThanOrEqualTo(String value) {
            addCriterion("vote_subject_item_other >=", value, "voteSubjectItemOther");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemOtherLessThan(String value) {
            addCriterion("vote_subject_item_other <", value, "voteSubjectItemOther");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemOtherLessThanOrEqualTo(String value) {
            addCriterion("vote_subject_item_other <=", value, "voteSubjectItemOther");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemOtherLike(String value) {
            addCriterion("vote_subject_item_other like", value, "voteSubjectItemOther");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemOtherNotLike(String value) {
            addCriterion("vote_subject_item_other not like", value, "voteSubjectItemOther");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemOtherIn(List<String> values) {
            addCriterion("vote_subject_item_other in", values, "voteSubjectItemOther");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemOtherNotIn(List<String> values) {
            addCriterion("vote_subject_item_other not in", values, "voteSubjectItemOther");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemOtherBetween(String value1, String value2) {
            addCriterion("vote_subject_item_other between", value1, value2, "voteSubjectItemOther");
            return (Criteria) this;
        }

        public Criteria andVoteSubjectItemOtherNotBetween(String value1, String value2) {
            addCriterion("vote_subject_item_other not between", value1, value2, "voteSubjectItemOther");
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