package com.yofc.dal.subject.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectCollectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SubjectCollectionExample() {
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

        public Criteria andCollectionIdIsNull() {
            addCriterion("collection_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionIdIsNotNull() {
            addCriterion("collection_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionIdEqualTo(Integer value) {
            addCriterion("collection_id =", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotEqualTo(Integer value) {
            addCriterion("collection_id <>", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdGreaterThan(Integer value) {
            addCriterion("collection_id >", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_id >=", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdLessThan(Integer value) {
            addCriterion("collection_id <", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdLessThanOrEqualTo(Integer value) {
            addCriterion("collection_id <=", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdIn(List<Integer> values) {
            addCriterion("collection_id in", values, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotIn(List<Integer> values) {
            addCriterion("collection_id not in", values, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdBetween(Integer value1, Integer value2) {
            addCriterion("collection_id between", value1, value2, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_id not between", value1, value2, "collectionId");
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

        public Criteria andCollectionFlagIsNull() {
            addCriterion("collection_flag is null");
            return (Criteria) this;
        }

        public Criteria andCollectionFlagIsNotNull() {
            addCriterion("collection_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionFlagEqualTo(Integer value) {
            addCriterion("collection_flag =", value, "collectionFlag");
            return (Criteria) this;
        }

        public Criteria andCollectionFlagNotEqualTo(Integer value) {
            addCriterion("collection_flag <>", value, "collectionFlag");
            return (Criteria) this;
        }

        public Criteria andCollectionFlagGreaterThan(Integer value) {
            addCriterion("collection_flag >", value, "collectionFlag");
            return (Criteria) this;
        }

        public Criteria andCollectionFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_flag >=", value, "collectionFlag");
            return (Criteria) this;
        }

        public Criteria andCollectionFlagLessThan(Integer value) {
            addCriterion("collection_flag <", value, "collectionFlag");
            return (Criteria) this;
        }

        public Criteria andCollectionFlagLessThanOrEqualTo(Integer value) {
            addCriterion("collection_flag <=", value, "collectionFlag");
            return (Criteria) this;
        }

        public Criteria andCollectionFlagIn(List<Integer> values) {
            addCriterion("collection_flag in", values, "collectionFlag");
            return (Criteria) this;
        }

        public Criteria andCollectionFlagNotIn(List<Integer> values) {
            addCriterion("collection_flag not in", values, "collectionFlag");
            return (Criteria) this;
        }

        public Criteria andCollectionFlagBetween(Integer value1, Integer value2) {
            addCriterion("collection_flag between", value1, value2, "collectionFlag");
            return (Criteria) this;
        }

        public Criteria andCollectionFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_flag not between", value1, value2, "collectionFlag");
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

        public Criteria andCollectionUserIdIsNull() {
            addCriterion("collection_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdIsNotNull() {
            addCriterion("collection_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdEqualTo(String value) {
            addCriterion("collection_user_id =", value, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdNotEqualTo(String value) {
            addCriterion("collection_user_id <>", value, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdGreaterThan(String value) {
            addCriterion("collection_user_id >", value, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("collection_user_id >=", value, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdLessThan(String value) {
            addCriterion("collection_user_id <", value, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdLessThanOrEqualTo(String value) {
            addCriterion("collection_user_id <=", value, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdLike(String value) {
            addCriterion("collection_user_id like", value, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdNotLike(String value) {
            addCriterion("collection_user_id not like", value, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdIn(List<String> values) {
            addCriterion("collection_user_id in", values, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdNotIn(List<String> values) {
            addCriterion("collection_user_id not in", values, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdBetween(String value1, String value2) {
            addCriterion("collection_user_id between", value1, value2, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdNotBetween(String value1, String value2) {
            addCriterion("collection_user_id not between", value1, value2, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNameIsNull() {
            addCriterion("collection_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNameIsNotNull() {
            addCriterion("collection_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNameEqualTo(String value) {
            addCriterion("collection_user_name =", value, "collectionUserName");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNameNotEqualTo(String value) {
            addCriterion("collection_user_name <>", value, "collectionUserName");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNameGreaterThan(String value) {
            addCriterion("collection_user_name >", value, "collectionUserName");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("collection_user_name >=", value, "collectionUserName");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNameLessThan(String value) {
            addCriterion("collection_user_name <", value, "collectionUserName");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNameLessThanOrEqualTo(String value) {
            addCriterion("collection_user_name <=", value, "collectionUserName");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNameLike(String value) {
            addCriterion("collection_user_name like", value, "collectionUserName");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNameNotLike(String value) {
            addCriterion("collection_user_name not like", value, "collectionUserName");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNameIn(List<String> values) {
            addCriterion("collection_user_name in", values, "collectionUserName");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNameNotIn(List<String> values) {
            addCriterion("collection_user_name not in", values, "collectionUserName");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNameBetween(String value1, String value2) {
            addCriterion("collection_user_name between", value1, value2, "collectionUserName");
            return (Criteria) this;
        }

        public Criteria andCollectionUserNameNotBetween(String value1, String value2) {
            addCriterion("collection_user_name not between", value1, value2, "collectionUserName");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserIdIsNull() {
            addCriterion("good_point_user_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserIdIsNotNull() {
            addCriterion("good_point_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserIdEqualTo(String value) {
            addCriterion("good_point_user_id =", value, "goodPointUserId");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserIdNotEqualTo(String value) {
            addCriterion("good_point_user_id <>", value, "goodPointUserId");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserIdGreaterThan(String value) {
            addCriterion("good_point_user_id >", value, "goodPointUserId");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("good_point_user_id >=", value, "goodPointUserId");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserIdLessThan(String value) {
            addCriterion("good_point_user_id <", value, "goodPointUserId");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserIdLessThanOrEqualTo(String value) {
            addCriterion("good_point_user_id <=", value, "goodPointUserId");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserIdLike(String value) {
            addCriterion("good_point_user_id like", value, "goodPointUserId");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserIdNotLike(String value) {
            addCriterion("good_point_user_id not like", value, "goodPointUserId");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserIdIn(List<String> values) {
            addCriterion("good_point_user_id in", values, "goodPointUserId");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserIdNotIn(List<String> values) {
            addCriterion("good_point_user_id not in", values, "goodPointUserId");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserIdBetween(String value1, String value2) {
            addCriterion("good_point_user_id between", value1, value2, "goodPointUserId");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserIdNotBetween(String value1, String value2) {
            addCriterion("good_point_user_id not between", value1, value2, "goodPointUserId");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserNameIsNull() {
            addCriterion("good_point_user_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserNameIsNotNull() {
            addCriterion("good_point_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserNameEqualTo(String value) {
            addCriterion("good_point_user_name =", value, "goodPointUserName");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserNameNotEqualTo(String value) {
            addCriterion("good_point_user_name <>", value, "goodPointUserName");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserNameGreaterThan(String value) {
            addCriterion("good_point_user_name >", value, "goodPointUserName");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("good_point_user_name >=", value, "goodPointUserName");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserNameLessThan(String value) {
            addCriterion("good_point_user_name <", value, "goodPointUserName");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserNameLessThanOrEqualTo(String value) {
            addCriterion("good_point_user_name <=", value, "goodPointUserName");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserNameLike(String value) {
            addCriterion("good_point_user_name like", value, "goodPointUserName");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserNameNotLike(String value) {
            addCriterion("good_point_user_name not like", value, "goodPointUserName");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserNameIn(List<String> values) {
            addCriterion("good_point_user_name in", values, "goodPointUserName");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserNameNotIn(List<String> values) {
            addCriterion("good_point_user_name not in", values, "goodPointUserName");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserNameBetween(String value1, String value2) {
            addCriterion("good_point_user_name between", value1, value2, "goodPointUserName");
            return (Criteria) this;
        }

        public Criteria andGoodPointUserNameNotBetween(String value1, String value2) {
            addCriterion("good_point_user_name not between", value1, value2, "goodPointUserName");
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