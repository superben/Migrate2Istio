package com.yofc.dal.vote.entity;

import java.util.ArrayList;
import java.util.List;

public class VoteSubjectItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public VoteSubjectItemExample() {
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

        public Criteria andVoteItemIdIsNull() {
            addCriterion("vote_item_id is null");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdIsNotNull() {
            addCriterion("vote_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdEqualTo(Integer value) {
            addCriterion("vote_item_id =", value, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdNotEqualTo(Integer value) {
            addCriterion("vote_item_id <>", value, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdGreaterThan(Integer value) {
            addCriterion("vote_item_id >", value, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_item_id >=", value, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdLessThan(Integer value) {
            addCriterion("vote_item_id <", value, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("vote_item_id <=", value, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdIn(List<Integer> values) {
            addCriterion("vote_item_id in", values, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdNotIn(List<Integer> values) {
            addCriterion("vote_item_id not in", values, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdBetween(Integer value1, Integer value2) {
            addCriterion("vote_item_id between", value1, value2, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_item_id not between", value1, value2, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andItemIsNull() {
            addCriterion("item is null");
            return (Criteria) this;
        }

        public Criteria andItemIsNotNull() {
            addCriterion("item is not null");
            return (Criteria) this;
        }

        public Criteria andItemEqualTo(String value) {
            addCriterion("item =", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotEqualTo(String value) {
            addCriterion("item <>", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemGreaterThan(String value) {
            addCriterion("item >", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemGreaterThanOrEqualTo(String value) {
            addCriterion("item >=", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLessThan(String value) {
            addCriterion("item <", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLessThanOrEqualTo(String value) {
            addCriterion("item <=", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLike(String value) {
            addCriterion("item like", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotLike(String value) {
            addCriterion("item not like", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemIn(List<String> values) {
            addCriterion("item in", values, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotIn(List<String> values) {
            addCriterion("item not in", values, "item");
            return (Criteria) this;
        }

        public Criteria andItemBetween(String value1, String value2) {
            addCriterion("item between", value1, value2, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotBetween(String value1, String value2) {
            addCriterion("item not between", value1, value2, "item");
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

        public Criteria andSeqIsNull() {
            addCriterion("seq is null");
            return (Criteria) this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("seq is not null");
            return (Criteria) this;
        }

        public Criteria andSeqEqualTo(Integer value) {
            addCriterion("seq =", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotEqualTo(Integer value) {
            addCriterion("seq <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThan(Integer value) {
            addCriterion("seq >", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("seq >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThan(Integer value) {
            addCriterion("seq <", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThanOrEqualTo(Integer value) {
            addCriterion("seq <=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqIn(List<Integer> values) {
            addCriterion("seq in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotIn(List<Integer> values) {
            addCriterion("seq not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqBetween(Integer value1, Integer value2) {
            addCriterion("seq between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("seq not between", value1, value2, "seq");
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