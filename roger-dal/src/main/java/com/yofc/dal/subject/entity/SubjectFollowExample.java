package com.yofc.dal.subject.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectFollowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SubjectFollowExample() {
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

        public Criteria andFollowUserIdIsNull() {
            addCriterion("follow_user_id is null");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdIsNotNull() {
            addCriterion("follow_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdEqualTo(String value) {
            addCriterion("follow_user_id =", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdNotEqualTo(String value) {
            addCriterion("follow_user_id <>", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdGreaterThan(String value) {
            addCriterion("follow_user_id >", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("follow_user_id >=", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdLessThan(String value) {
            addCriterion("follow_user_id <", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdLessThanOrEqualTo(String value) {
            addCriterion("follow_user_id <=", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdLike(String value) {
            addCriterion("follow_user_id like", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdNotLike(String value) {
            addCriterion("follow_user_id not like", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdIn(List<String> values) {
            addCriterion("follow_user_id in", values, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdNotIn(List<String> values) {
            addCriterion("follow_user_id not in", values, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdBetween(String value1, String value2) {
            addCriterion("follow_user_id between", value1, value2, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdNotBetween(String value1, String value2) {
            addCriterion("follow_user_id not between", value1, value2, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserNameIsNull() {
            addCriterion("follow_user_name is null");
            return (Criteria) this;
        }

        public Criteria andFollowUserNameIsNotNull() {
            addCriterion("follow_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andFollowUserNameEqualTo(String value) {
            addCriterion("follow_user_name =", value, "followUserName");
            return (Criteria) this;
        }

        public Criteria andFollowUserNameNotEqualTo(String value) {
            addCriterion("follow_user_name <>", value, "followUserName");
            return (Criteria) this;
        }

        public Criteria andFollowUserNameGreaterThan(String value) {
            addCriterion("follow_user_name >", value, "followUserName");
            return (Criteria) this;
        }

        public Criteria andFollowUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("follow_user_name >=", value, "followUserName");
            return (Criteria) this;
        }

        public Criteria andFollowUserNameLessThan(String value) {
            addCriterion("follow_user_name <", value, "followUserName");
            return (Criteria) this;
        }

        public Criteria andFollowUserNameLessThanOrEqualTo(String value) {
            addCriterion("follow_user_name <=", value, "followUserName");
            return (Criteria) this;
        }

        public Criteria andFollowUserNameLike(String value) {
            addCriterion("follow_user_name like", value, "followUserName");
            return (Criteria) this;
        }

        public Criteria andFollowUserNameNotLike(String value) {
            addCriterion("follow_user_name not like", value, "followUserName");
            return (Criteria) this;
        }

        public Criteria andFollowUserNameIn(List<String> values) {
            addCriterion("follow_user_name in", values, "followUserName");
            return (Criteria) this;
        }

        public Criteria andFollowUserNameNotIn(List<String> values) {
            addCriterion("follow_user_name not in", values, "followUserName");
            return (Criteria) this;
        }

        public Criteria andFollowUserNameBetween(String value1, String value2) {
            addCriterion("follow_user_name between", value1, value2, "followUserName");
            return (Criteria) this;
        }

        public Criteria andFollowUserNameNotBetween(String value1, String value2) {
            addCriterion("follow_user_name not between", value1, value2, "followUserName");
            return (Criteria) this;
        }

        public Criteria andFollowParentIdIsNull() {
            addCriterion("follow_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andFollowParentIdIsNotNull() {
            addCriterion("follow_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andFollowParentIdEqualTo(Integer value) {
            addCriterion("follow_parent_id =", value, "followParentId");
            return (Criteria) this;
        }

        public Criteria andFollowParentIdNotEqualTo(Integer value) {
            addCriterion("follow_parent_id <>", value, "followParentId");
            return (Criteria) this;
        }

        public Criteria andFollowParentIdGreaterThan(Integer value) {
            addCriterion("follow_parent_id >", value, "followParentId");
            return (Criteria) this;
        }

        public Criteria andFollowParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("follow_parent_id >=", value, "followParentId");
            return (Criteria) this;
        }

        public Criteria andFollowParentIdLessThan(Integer value) {
            addCriterion("follow_parent_id <", value, "followParentId");
            return (Criteria) this;
        }

        public Criteria andFollowParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("follow_parent_id <=", value, "followParentId");
            return (Criteria) this;
        }

        public Criteria andFollowParentIdIn(List<Integer> values) {
            addCriterion("follow_parent_id in", values, "followParentId");
            return (Criteria) this;
        }

        public Criteria andFollowParentIdNotIn(List<Integer> values) {
            addCriterion("follow_parent_id not in", values, "followParentId");
            return (Criteria) this;
        }

        public Criteria andFollowParentIdBetween(Integer value1, Integer value2) {
            addCriterion("follow_parent_id between", value1, value2, "followParentId");
            return (Criteria) this;
        }

        public Criteria andFollowParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("follow_parent_id not between", value1, value2, "followParentId");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserIdIsNull() {
            addCriterion("follow_parent_user_id is null");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserIdIsNotNull() {
            addCriterion("follow_parent_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserIdEqualTo(String value) {
            addCriterion("follow_parent_user_id =", value, "followParentUserId");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserIdNotEqualTo(String value) {
            addCriterion("follow_parent_user_id <>", value, "followParentUserId");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserIdGreaterThan(String value) {
            addCriterion("follow_parent_user_id >", value, "followParentUserId");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("follow_parent_user_id >=", value, "followParentUserId");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserIdLessThan(String value) {
            addCriterion("follow_parent_user_id <", value, "followParentUserId");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserIdLessThanOrEqualTo(String value) {
            addCriterion("follow_parent_user_id <=", value, "followParentUserId");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserIdLike(String value) {
            addCriterion("follow_parent_user_id like", value, "followParentUserId");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserIdNotLike(String value) {
            addCriterion("follow_parent_user_id not like", value, "followParentUserId");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserIdIn(List<String> values) {
            addCriterion("follow_parent_user_id in", values, "followParentUserId");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserIdNotIn(List<String> values) {
            addCriterion("follow_parent_user_id not in", values, "followParentUserId");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserIdBetween(String value1, String value2) {
            addCriterion("follow_parent_user_id between", value1, value2, "followParentUserId");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserIdNotBetween(String value1, String value2) {
            addCriterion("follow_parent_user_id not between", value1, value2, "followParentUserId");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserNameIsNull() {
            addCriterion("follow_parent_user_name is null");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserNameIsNotNull() {
            addCriterion("follow_parent_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserNameEqualTo(String value) {
            addCriterion("follow_parent_user_name =", value, "followParentUserName");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserNameNotEqualTo(String value) {
            addCriterion("follow_parent_user_name <>", value, "followParentUserName");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserNameGreaterThan(String value) {
            addCriterion("follow_parent_user_name >", value, "followParentUserName");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("follow_parent_user_name >=", value, "followParentUserName");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserNameLessThan(String value) {
            addCriterion("follow_parent_user_name <", value, "followParentUserName");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserNameLessThanOrEqualTo(String value) {
            addCriterion("follow_parent_user_name <=", value, "followParentUserName");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserNameLike(String value) {
            addCriterion("follow_parent_user_name like", value, "followParentUserName");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserNameNotLike(String value) {
            addCriterion("follow_parent_user_name not like", value, "followParentUserName");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserNameIn(List<String> values) {
            addCriterion("follow_parent_user_name in", values, "followParentUserName");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserNameNotIn(List<String> values) {
            addCriterion("follow_parent_user_name not in", values, "followParentUserName");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserNameBetween(String value1, String value2) {
            addCriterion("follow_parent_user_name between", value1, value2, "followParentUserName");
            return (Criteria) this;
        }

        public Criteria andFollowParentUserNameNotBetween(String value1, String value2) {
            addCriterion("follow_parent_user_name not between", value1, value2, "followParentUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
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