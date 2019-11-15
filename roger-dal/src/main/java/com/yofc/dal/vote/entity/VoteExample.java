package com.yofc.dal.vote.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VoteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public VoteExample() {
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

        public Criteria andVoteTitleIsNull() {
            addCriterion("vote_title is null");
            return (Criteria) this;
        }

        public Criteria andVoteTitleIsNotNull() {
            addCriterion("vote_title is not null");
            return (Criteria) this;
        }

        public Criteria andVoteTitleEqualTo(String value) {
            addCriterion("vote_title =", value, "voteTitle");
            return (Criteria) this;
        }

        public Criteria andVoteTitleNotEqualTo(String value) {
            addCriterion("vote_title <>", value, "voteTitle");
            return (Criteria) this;
        }

        public Criteria andVoteTitleGreaterThan(String value) {
            addCriterion("vote_title >", value, "voteTitle");
            return (Criteria) this;
        }

        public Criteria andVoteTitleGreaterThanOrEqualTo(String value) {
            addCriterion("vote_title >=", value, "voteTitle");
            return (Criteria) this;
        }

        public Criteria andVoteTitleLessThan(String value) {
            addCriterion("vote_title <", value, "voteTitle");
            return (Criteria) this;
        }

        public Criteria andVoteTitleLessThanOrEqualTo(String value) {
            addCriterion("vote_title <=", value, "voteTitle");
            return (Criteria) this;
        }

        public Criteria andVoteTitleLike(String value) {
            addCriterion("vote_title like", value, "voteTitle");
            return (Criteria) this;
        }

        public Criteria andVoteTitleNotLike(String value) {
            addCriterion("vote_title not like", value, "voteTitle");
            return (Criteria) this;
        }

        public Criteria andVoteTitleIn(List<String> values) {
            addCriterion("vote_title in", values, "voteTitle");
            return (Criteria) this;
        }

        public Criteria andVoteTitleNotIn(List<String> values) {
            addCriterion("vote_title not in", values, "voteTitle");
            return (Criteria) this;
        }

        public Criteria andVoteTitleBetween(String value1, String value2) {
            addCriterion("vote_title between", value1, value2, "voteTitle");
            return (Criteria) this;
        }

        public Criteria andVoteTitleNotBetween(String value1, String value2) {
            addCriterion("vote_title not between", value1, value2, "voteTitle");
            return (Criteria) this;
        }

        public Criteria andVoteDescIsNull() {
            addCriterion("vote_desc is null");
            return (Criteria) this;
        }

        public Criteria andVoteDescIsNotNull() {
            addCriterion("vote_desc is not null");
            return (Criteria) this;
        }

        public Criteria andVoteDescEqualTo(String value) {
            addCriterion("vote_desc =", value, "voteDesc");
            return (Criteria) this;
        }

        public Criteria andVoteDescNotEqualTo(String value) {
            addCriterion("vote_desc <>", value, "voteDesc");
            return (Criteria) this;
        }

        public Criteria andVoteDescGreaterThan(String value) {
            addCriterion("vote_desc >", value, "voteDesc");
            return (Criteria) this;
        }

        public Criteria andVoteDescGreaterThanOrEqualTo(String value) {
            addCriterion("vote_desc >=", value, "voteDesc");
            return (Criteria) this;
        }

        public Criteria andVoteDescLessThan(String value) {
            addCriterion("vote_desc <", value, "voteDesc");
            return (Criteria) this;
        }

        public Criteria andVoteDescLessThanOrEqualTo(String value) {
            addCriterion("vote_desc <=", value, "voteDesc");
            return (Criteria) this;
        }

        public Criteria andVoteDescLike(String value) {
            addCriterion("vote_desc like", value, "voteDesc");
            return (Criteria) this;
        }

        public Criteria andVoteDescNotLike(String value) {
            addCriterion("vote_desc not like", value, "voteDesc");
            return (Criteria) this;
        }

        public Criteria andVoteDescIn(List<String> values) {
            addCriterion("vote_desc in", values, "voteDesc");
            return (Criteria) this;
        }

        public Criteria andVoteDescNotIn(List<String> values) {
            addCriterion("vote_desc not in", values, "voteDesc");
            return (Criteria) this;
        }

        public Criteria andVoteDescBetween(String value1, String value2) {
            addCriterion("vote_desc between", value1, value2, "voteDesc");
            return (Criteria) this;
        }

        public Criteria andVoteDescNotBetween(String value1, String value2) {
            addCriterion("vote_desc not between", value1, value2, "voteDesc");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andPublicStateIsNull() {
            addCriterion("public_state is null");
            return (Criteria) this;
        }

        public Criteria andPublicStateIsNotNull() {
            addCriterion("public_state is not null");
            return (Criteria) this;
        }

        public Criteria andPublicStateEqualTo(String value) {
            addCriterion("public_state =", value, "publicState");
            return (Criteria) this;
        }

        public Criteria andPublicStateNotEqualTo(String value) {
            addCriterion("public_state <>", value, "publicState");
            return (Criteria) this;
        }

        public Criteria andPublicStateGreaterThan(String value) {
            addCriterion("public_state >", value, "publicState");
            return (Criteria) this;
        }

        public Criteria andPublicStateGreaterThanOrEqualTo(String value) {
            addCriterion("public_state >=", value, "publicState");
            return (Criteria) this;
        }

        public Criteria andPublicStateLessThan(String value) {
            addCriterion("public_state <", value, "publicState");
            return (Criteria) this;
        }

        public Criteria andPublicStateLessThanOrEqualTo(String value) {
            addCriterion("public_state <=", value, "publicState");
            return (Criteria) this;
        }

        public Criteria andPublicStateLike(String value) {
            addCriterion("public_state like", value, "publicState");
            return (Criteria) this;
        }

        public Criteria andPublicStateNotLike(String value) {
            addCriterion("public_state not like", value, "publicState");
            return (Criteria) this;
        }

        public Criteria andPublicStateIn(List<String> values) {
            addCriterion("public_state in", values, "publicState");
            return (Criteria) this;
        }

        public Criteria andPublicStateNotIn(List<String> values) {
            addCriterion("public_state not in", values, "publicState");
            return (Criteria) this;
        }

        public Criteria andPublicStateBetween(String value1, String value2) {
            addCriterion("public_state between", value1, value2, "publicState");
            return (Criteria) this;
        }

        public Criteria andPublicStateNotBetween(String value1, String value2) {
            addCriterion("public_state not between", value1, value2, "publicState");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andReminderStateIsNull() {
            addCriterion("reminder_state is null");
            return (Criteria) this;
        }

        public Criteria andReminderStateIsNotNull() {
            addCriterion("reminder_state is not null");
            return (Criteria) this;
        }

        public Criteria andReminderStateEqualTo(String value) {
            addCriterion("reminder_state =", value, "reminderState");
            return (Criteria) this;
        }

        public Criteria andReminderStateNotEqualTo(String value) {
            addCriterion("reminder_state <>", value, "reminderState");
            return (Criteria) this;
        }

        public Criteria andReminderStateGreaterThan(String value) {
            addCriterion("reminder_state >", value, "reminderState");
            return (Criteria) this;
        }

        public Criteria andReminderStateGreaterThanOrEqualTo(String value) {
            addCriterion("reminder_state >=", value, "reminderState");
            return (Criteria) this;
        }

        public Criteria andReminderStateLessThan(String value) {
            addCriterion("reminder_state <", value, "reminderState");
            return (Criteria) this;
        }

        public Criteria andReminderStateLessThanOrEqualTo(String value) {
            addCriterion("reminder_state <=", value, "reminderState");
            return (Criteria) this;
        }

        public Criteria andReminderStateLike(String value) {
            addCriterion("reminder_state like", value, "reminderState");
            return (Criteria) this;
        }

        public Criteria andReminderStateNotLike(String value) {
            addCriterion("reminder_state not like", value, "reminderState");
            return (Criteria) this;
        }

        public Criteria andReminderStateIn(List<String> values) {
            addCriterion("reminder_state in", values, "reminderState");
            return (Criteria) this;
        }

        public Criteria andReminderStateNotIn(List<String> values) {
            addCriterion("reminder_state not in", values, "reminderState");
            return (Criteria) this;
        }

        public Criteria andReminderStateBetween(String value1, String value2) {
            addCriterion("reminder_state between", value1, value2, "reminderState");
            return (Criteria) this;
        }

        public Criteria andReminderStateNotBetween(String value1, String value2) {
            addCriterion("reminder_state not between", value1, value2, "reminderState");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdIsNull() {
            addCriterion("originator_id is null");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdIsNotNull() {
            addCriterion("originator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdEqualTo(String value) {
            addCriterion("originator_id =", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdNotEqualTo(String value) {
            addCriterion("originator_id <>", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdGreaterThan(String value) {
            addCriterion("originator_id >", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("originator_id >=", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdLessThan(String value) {
            addCriterion("originator_id <", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdLessThanOrEqualTo(String value) {
            addCriterion("originator_id <=", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdLike(String value) {
            addCriterion("originator_id like", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdNotLike(String value) {
            addCriterion("originator_id not like", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdIn(List<String> values) {
            addCriterion("originator_id in", values, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdNotIn(List<String> values) {
            addCriterion("originator_id not in", values, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdBetween(String value1, String value2) {
            addCriterion("originator_id between", value1, value2, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdNotBetween(String value1, String value2) {
            addCriterion("originator_id not between", value1, value2, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorNameIsNull() {
            addCriterion("Originator_name is null");
            return (Criteria) this;
        }

        public Criteria andOriginatorNameIsNotNull() {
            addCriterion("Originator_name is not null");
            return (Criteria) this;
        }

        public Criteria andOriginatorNameEqualTo(String value) {
            addCriterion("Originator_name =", value, "originatorName");
            return (Criteria) this;
        }

        public Criteria andOriginatorNameNotEqualTo(String value) {
            addCriterion("Originator_name <>", value, "originatorName");
            return (Criteria) this;
        }

        public Criteria andOriginatorNameGreaterThan(String value) {
            addCriterion("Originator_name >", value, "originatorName");
            return (Criteria) this;
        }

        public Criteria andOriginatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("Originator_name >=", value, "originatorName");
            return (Criteria) this;
        }

        public Criteria andOriginatorNameLessThan(String value) {
            addCriterion("Originator_name <", value, "originatorName");
            return (Criteria) this;
        }

        public Criteria andOriginatorNameLessThanOrEqualTo(String value) {
            addCriterion("Originator_name <=", value, "originatorName");
            return (Criteria) this;
        }

        public Criteria andOriginatorNameLike(String value) {
            addCriterion("Originator_name like", value, "originatorName");
            return (Criteria) this;
        }

        public Criteria andOriginatorNameNotLike(String value) {
            addCriterion("Originator_name not like", value, "originatorName");
            return (Criteria) this;
        }

        public Criteria andOriginatorNameIn(List<String> values) {
            addCriterion("Originator_name in", values, "originatorName");
            return (Criteria) this;
        }

        public Criteria andOriginatorNameNotIn(List<String> values) {
            addCriterion("Originator_name not in", values, "originatorName");
            return (Criteria) this;
        }

        public Criteria andOriginatorNameBetween(String value1, String value2) {
            addCriterion("Originator_name between", value1, value2, "originatorName");
            return (Criteria) this;
        }

        public Criteria andOriginatorNameNotBetween(String value1, String value2) {
            addCriterion("Originator_name not between", value1, value2, "originatorName");
            return (Criteria) this;
        }

        public Criteria andRemoveFlagIsNull() {
            addCriterion("remove_flag is null");
            return (Criteria) this;
        }

        public Criteria andRemoveFlagIsNotNull() {
            addCriterion("remove_flag is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveFlagEqualTo(String value) {
            addCriterion("remove_flag =", value, "removeFlag");
            return (Criteria) this;
        }

        public Criteria andRemoveFlagNotEqualTo(String value) {
            addCriterion("remove_flag <>", value, "removeFlag");
            return (Criteria) this;
        }

        public Criteria andRemoveFlagGreaterThan(String value) {
            addCriterion("remove_flag >", value, "removeFlag");
            return (Criteria) this;
        }

        public Criteria andRemoveFlagGreaterThanOrEqualTo(String value) {
            addCriterion("remove_flag >=", value, "removeFlag");
            return (Criteria) this;
        }

        public Criteria andRemoveFlagLessThan(String value) {
            addCriterion("remove_flag <", value, "removeFlag");
            return (Criteria) this;
        }

        public Criteria andRemoveFlagLessThanOrEqualTo(String value) {
            addCriterion("remove_flag <=", value, "removeFlag");
            return (Criteria) this;
        }

        public Criteria andRemoveFlagLike(String value) {
            addCriterion("remove_flag like", value, "removeFlag");
            return (Criteria) this;
        }

        public Criteria andRemoveFlagNotLike(String value) {
            addCriterion("remove_flag not like", value, "removeFlag");
            return (Criteria) this;
        }

        public Criteria andRemoveFlagIn(List<String> values) {
            addCriterion("remove_flag in", values, "removeFlag");
            return (Criteria) this;
        }

        public Criteria andRemoveFlagNotIn(List<String> values) {
            addCriterion("remove_flag not in", values, "removeFlag");
            return (Criteria) this;
        }

        public Criteria andRemoveFlagBetween(String value1, String value2) {
            addCriterion("remove_flag between", value1, value2, "removeFlag");
            return (Criteria) this;
        }

        public Criteria andRemoveFlagNotBetween(String value1, String value2) {
            addCriterion("remove_flag not between", value1, value2, "removeFlag");
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