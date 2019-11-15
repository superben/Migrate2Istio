package com.yofc.dal.vote.entity;

import java.util.ArrayList;
import java.util.List;

public class VoteSubjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public VoteSubjectExample() {
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

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andMultipleableIsNull() {
            addCriterion("multipleable is null");
            return (Criteria) this;
        }

        public Criteria andMultipleableIsNotNull() {
            addCriterion("multipleable is not null");
            return (Criteria) this;
        }

        public Criteria andMultipleableEqualTo(String value) {
            addCriterion("multipleable =", value, "multipleable");
            return (Criteria) this;
        }

        public Criteria andMultipleableNotEqualTo(String value) {
            addCriterion("multipleable <>", value, "multipleable");
            return (Criteria) this;
        }

        public Criteria andMultipleableGreaterThan(String value) {
            addCriterion("multipleable >", value, "multipleable");
            return (Criteria) this;
        }

        public Criteria andMultipleableGreaterThanOrEqualTo(String value) {
            addCriterion("multipleable >=", value, "multipleable");
            return (Criteria) this;
        }

        public Criteria andMultipleableLessThan(String value) {
            addCriterion("multipleable <", value, "multipleable");
            return (Criteria) this;
        }

        public Criteria andMultipleableLessThanOrEqualTo(String value) {
            addCriterion("multipleable <=", value, "multipleable");
            return (Criteria) this;
        }

        public Criteria andMultipleableLike(String value) {
            addCriterion("multipleable like", value, "multipleable");
            return (Criteria) this;
        }

        public Criteria andMultipleableNotLike(String value) {
            addCriterion("multipleable not like", value, "multipleable");
            return (Criteria) this;
        }

        public Criteria andMultipleableIn(List<String> values) {
            addCriterion("multipleable in", values, "multipleable");
            return (Criteria) this;
        }

        public Criteria andMultipleableNotIn(List<String> values) {
            addCriterion("multipleable not in", values, "multipleable");
            return (Criteria) this;
        }

        public Criteria andMultipleableBetween(String value1, String value2) {
            addCriterion("multipleable between", value1, value2, "multipleable");
            return (Criteria) this;
        }

        public Criteria andMultipleableNotBetween(String value1, String value2) {
            addCriterion("multipleable not between", value1, value2, "multipleable");
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

        public Criteria andHasOtherIsNull() {
            addCriterion("has_other is null");
            return (Criteria) this;
        }

        public Criteria andHasOtherIsNotNull() {
            addCriterion("has_other is not null");
            return (Criteria) this;
        }

        public Criteria andHasOtherEqualTo(String value) {
            addCriterion("has_other =", value, "hasOther");
            return (Criteria) this;
        }

        public Criteria andHasOtherNotEqualTo(String value) {
            addCriterion("has_other <>", value, "hasOther");
            return (Criteria) this;
        }

        public Criteria andHasOtherGreaterThan(String value) {
            addCriterion("has_other >", value, "hasOther");
            return (Criteria) this;
        }

        public Criteria andHasOtherGreaterThanOrEqualTo(String value) {
            addCriterion("has_other >=", value, "hasOther");
            return (Criteria) this;
        }

        public Criteria andHasOtherLessThan(String value) {
            addCriterion("has_other <", value, "hasOther");
            return (Criteria) this;
        }

        public Criteria andHasOtherLessThanOrEqualTo(String value) {
            addCriterion("has_other <=", value, "hasOther");
            return (Criteria) this;
        }

        public Criteria andHasOtherLike(String value) {
            addCriterion("has_other like", value, "hasOther");
            return (Criteria) this;
        }

        public Criteria andHasOtherNotLike(String value) {
            addCriterion("has_other not like", value, "hasOther");
            return (Criteria) this;
        }

        public Criteria andHasOtherIn(List<String> values) {
            addCriterion("has_other in", values, "hasOther");
            return (Criteria) this;
        }

        public Criteria andHasOtherNotIn(List<String> values) {
            addCriterion("has_other not in", values, "hasOther");
            return (Criteria) this;
        }

        public Criteria andHasOtherBetween(String value1, String value2) {
            addCriterion("has_other between", value1, value2, "hasOther");
            return (Criteria) this;
        }

        public Criteria andHasOtherNotBetween(String value1, String value2) {
            addCriterion("has_other not between", value1, value2, "hasOther");
            return (Criteria) this;
        }

        public Criteria andMaxSelectCountIsNull() {
            addCriterion("max_select_count is null");
            return (Criteria) this;
        }

        public Criteria andMaxSelectCountIsNotNull() {
            addCriterion("max_select_count is not null");
            return (Criteria) this;
        }

        public Criteria andMaxSelectCountEqualTo(Integer value) {
            addCriterion("max_select_count =", value, "maxSelectCount");
            return (Criteria) this;
        }

        public Criteria andMaxSelectCountNotEqualTo(Integer value) {
            addCriterion("max_select_count <>", value, "maxSelectCount");
            return (Criteria) this;
        }

        public Criteria andMaxSelectCountGreaterThan(Integer value) {
            addCriterion("max_select_count >", value, "maxSelectCount");
            return (Criteria) this;
        }

        public Criteria andMaxSelectCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_select_count >=", value, "maxSelectCount");
            return (Criteria) this;
        }

        public Criteria andMaxSelectCountLessThan(Integer value) {
            addCriterion("max_select_count <", value, "maxSelectCount");
            return (Criteria) this;
        }

        public Criteria andMaxSelectCountLessThanOrEqualTo(Integer value) {
            addCriterion("max_select_count <=", value, "maxSelectCount");
            return (Criteria) this;
        }

        public Criteria andMaxSelectCountIn(List<Integer> values) {
            addCriterion("max_select_count in", values, "maxSelectCount");
            return (Criteria) this;
        }

        public Criteria andMaxSelectCountNotIn(List<Integer> values) {
            addCriterion("max_select_count not in", values, "maxSelectCount");
            return (Criteria) this;
        }

        public Criteria andMaxSelectCountBetween(Integer value1, Integer value2) {
            addCriterion("max_select_count between", value1, value2, "maxSelectCount");
            return (Criteria) this;
        }

        public Criteria andMaxSelectCountNotBetween(Integer value1, Integer value2) {
            addCriterion("max_select_count not between", value1, value2, "maxSelectCount");
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