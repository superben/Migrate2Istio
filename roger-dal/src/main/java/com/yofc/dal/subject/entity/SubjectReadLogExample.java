package com.yofc.dal.subject.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectReadLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SubjectReadLogExample() {
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

        public Criteria andReadIdIsNull() {
            addCriterion("read_id is null");
            return (Criteria) this;
        }

        public Criteria andReadIdIsNotNull() {
            addCriterion("read_id is not null");
            return (Criteria) this;
        }

        public Criteria andReadIdEqualTo(Integer value) {
            addCriterion("read_id =", value, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdNotEqualTo(Integer value) {
            addCriterion("read_id <>", value, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdGreaterThan(Integer value) {
            addCriterion("read_id >", value, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_id >=", value, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdLessThan(Integer value) {
            addCriterion("read_id <", value, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdLessThanOrEqualTo(Integer value) {
            addCriterion("read_id <=", value, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdIn(List<Integer> values) {
            addCriterion("read_id in", values, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdNotIn(List<Integer> values) {
            addCriterion("read_id not in", values, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdBetween(Integer value1, Integer value2) {
            addCriterion("read_id between", value1, value2, "readId");
            return (Criteria) this;
        }

        public Criteria andReadIdNotBetween(Integer value1, Integer value2) {
            addCriterion("read_id not between", value1, value2, "readId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNull() {
            addCriterion("object_id is null");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNotNull() {
            addCriterion("object_id is not null");
            return (Criteria) this;
        }

        public Criteria andObjectIdEqualTo(Integer value) {
            addCriterion("object_id =", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotEqualTo(Integer value) {
            addCriterion("object_id <>", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThan(Integer value) {
            addCriterion("object_id >", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("object_id >=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThan(Integer value) {
            addCriterion("object_id <", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("object_id <=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdIn(List<Integer> values) {
            addCriterion("object_id in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotIn(List<Integer> values) {
            addCriterion("object_id not in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdBetween(Integer value1, Integer value2) {
            addCriterion("object_id between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("object_id not between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andEnterDateIsNull() {
            addCriterion("enter_date is null");
            return (Criteria) this;
        }

        public Criteria andEnterDateIsNotNull() {
            addCriterion("enter_date is not null");
            return (Criteria) this;
        }

        public Criteria andEnterDateEqualTo(Date value) {
            addCriterion("enter_date =", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateNotEqualTo(Date value) {
            addCriterion("enter_date <>", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateGreaterThan(Date value) {
            addCriterion("enter_date >", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateGreaterThanOrEqualTo(Date value) {
            addCriterion("enter_date >=", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateLessThan(Date value) {
            addCriterion("enter_date <", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateLessThanOrEqualTo(Date value) {
            addCriterion("enter_date <=", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateIn(List<Date> values) {
            addCriterion("enter_date in", values, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateNotIn(List<Date> values) {
            addCriterion("enter_date not in", values, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateBetween(Date value1, Date value2) {
            addCriterion("enter_date between", value1, value2, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateNotBetween(Date value1, Date value2) {
            addCriterion("enter_date not between", value1, value2, "enterDate");
            return (Criteria) this;
        }

        public Criteria andOutDateIsNull() {
            addCriterion("out_date is null");
            return (Criteria) this;
        }

        public Criteria andOutDateIsNotNull() {
            addCriterion("out_date is not null");
            return (Criteria) this;
        }

        public Criteria andOutDateEqualTo(Date value) {
            addCriterion("out_date =", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotEqualTo(Date value) {
            addCriterion("out_date <>", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateGreaterThan(Date value) {
            addCriterion("out_date >", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateGreaterThanOrEqualTo(Date value) {
            addCriterion("out_date >=", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateLessThan(Date value) {
            addCriterion("out_date <", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateLessThanOrEqualTo(Date value) {
            addCriterion("out_date <=", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateIn(List<Date> values) {
            addCriterion("out_date in", values, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotIn(List<Date> values) {
            addCriterion("out_date not in", values, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateBetween(Date value1, Date value2) {
            addCriterion("out_date between", value1, value2, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotBetween(Date value1, Date value2) {
            addCriterion("out_date not between", value1, value2, "outDate");
            return (Criteria) this;
        }

        public Criteria andBodyIsNull() {
            addCriterion("body is null");
            return (Criteria) this;
        }

        public Criteria andBodyIsNotNull() {
            addCriterion("body is not null");
            return (Criteria) this;
        }

        public Criteria andBodyEqualTo(String value) {
            addCriterion("body =", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotEqualTo(String value) {
            addCriterion("body <>", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThan(String value) {
            addCriterion("body >", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThanOrEqualTo(String value) {
            addCriterion("body >=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThan(String value) {
            addCriterion("body <", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThanOrEqualTo(String value) {
            addCriterion("body <=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLike(String value) {
            addCriterion("body like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotLike(String value) {
            addCriterion("body not like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyIn(List<String> values) {
            addCriterion("body in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotIn(List<String> values) {
            addCriterion("body not in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyBetween(String value1, String value2) {
            addCriterion("body between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotBetween(String value1, String value2) {
            addCriterion("body not between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andKeyColIsNull() {
            addCriterion("key_col is null");
            return (Criteria) this;
        }

        public Criteria andKeyColIsNotNull() {
            addCriterion("key_col is not null");
            return (Criteria) this;
        }

        public Criteria andKeyColEqualTo(Integer value) {
            addCriterion("key_col =", value, "keyCol");
            return (Criteria) this;
        }

        public Criteria andKeyColNotEqualTo(Integer value) {
            addCriterion("key_col <>", value, "keyCol");
            return (Criteria) this;
        }

        public Criteria andKeyColGreaterThan(Integer value) {
            addCriterion("key_col >", value, "keyCol");
            return (Criteria) this;
        }

        public Criteria andKeyColGreaterThanOrEqualTo(Integer value) {
            addCriterion("key_col >=", value, "keyCol");
            return (Criteria) this;
        }

        public Criteria andKeyColLessThan(Integer value) {
            addCriterion("key_col <", value, "keyCol");
            return (Criteria) this;
        }

        public Criteria andKeyColLessThanOrEqualTo(Integer value) {
            addCriterion("key_col <=", value, "keyCol");
            return (Criteria) this;
        }

        public Criteria andKeyColIn(List<Integer> values) {
            addCriterion("key_col in", values, "keyCol");
            return (Criteria) this;
        }

        public Criteria andKeyColNotIn(List<Integer> values) {
            addCriterion("key_col not in", values, "keyCol");
            return (Criteria) this;
        }

        public Criteria andKeyColBetween(Integer value1, Integer value2) {
            addCriterion("key_col between", value1, value2, "keyCol");
            return (Criteria) this;
        }

        public Criteria andKeyColNotBetween(Integer value1, Integer value2) {
            addCriterion("key_col not between", value1, value2, "keyCol");
            return (Criteria) this;
        }

        public Criteria andExtStr1IsNull() {
            addCriterion("ext_str1 is null");
            return (Criteria) this;
        }

        public Criteria andExtStr1IsNotNull() {
            addCriterion("ext_str1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtStr1EqualTo(String value) {
            addCriterion("ext_str1 =", value, "extStr1");
            return (Criteria) this;
        }

        public Criteria andExtStr1NotEqualTo(String value) {
            addCriterion("ext_str1 <>", value, "extStr1");
            return (Criteria) this;
        }

        public Criteria andExtStr1GreaterThan(String value) {
            addCriterion("ext_str1 >", value, "extStr1");
            return (Criteria) this;
        }

        public Criteria andExtStr1GreaterThanOrEqualTo(String value) {
            addCriterion("ext_str1 >=", value, "extStr1");
            return (Criteria) this;
        }

        public Criteria andExtStr1LessThan(String value) {
            addCriterion("ext_str1 <", value, "extStr1");
            return (Criteria) this;
        }

        public Criteria andExtStr1LessThanOrEqualTo(String value) {
            addCriterion("ext_str1 <=", value, "extStr1");
            return (Criteria) this;
        }

        public Criteria andExtStr1Like(String value) {
            addCriterion("ext_str1 like", value, "extStr1");
            return (Criteria) this;
        }

        public Criteria andExtStr1NotLike(String value) {
            addCriterion("ext_str1 not like", value, "extStr1");
            return (Criteria) this;
        }

        public Criteria andExtStr1In(List<String> values) {
            addCriterion("ext_str1 in", values, "extStr1");
            return (Criteria) this;
        }

        public Criteria andExtStr1NotIn(List<String> values) {
            addCriterion("ext_str1 not in", values, "extStr1");
            return (Criteria) this;
        }

        public Criteria andExtStr1Between(String value1, String value2) {
            addCriterion("ext_str1 between", value1, value2, "extStr1");
            return (Criteria) this;
        }

        public Criteria andExtStr1NotBetween(String value1, String value2) {
            addCriterion("ext_str1 not between", value1, value2, "extStr1");
            return (Criteria) this;
        }

        public Criteria andExtStr2IsNull() {
            addCriterion("ext_str2 is null");
            return (Criteria) this;
        }

        public Criteria andExtStr2IsNotNull() {
            addCriterion("ext_str2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtStr2EqualTo(String value) {
            addCriterion("ext_str2 =", value, "extStr2");
            return (Criteria) this;
        }

        public Criteria andExtStr2NotEqualTo(String value) {
            addCriterion("ext_str2 <>", value, "extStr2");
            return (Criteria) this;
        }

        public Criteria andExtStr2GreaterThan(String value) {
            addCriterion("ext_str2 >", value, "extStr2");
            return (Criteria) this;
        }

        public Criteria andExtStr2GreaterThanOrEqualTo(String value) {
            addCriterion("ext_str2 >=", value, "extStr2");
            return (Criteria) this;
        }

        public Criteria andExtStr2LessThan(String value) {
            addCriterion("ext_str2 <", value, "extStr2");
            return (Criteria) this;
        }

        public Criteria andExtStr2LessThanOrEqualTo(String value) {
            addCriterion("ext_str2 <=", value, "extStr2");
            return (Criteria) this;
        }

        public Criteria andExtStr2Like(String value) {
            addCriterion("ext_str2 like", value, "extStr2");
            return (Criteria) this;
        }

        public Criteria andExtStr2NotLike(String value) {
            addCriterion("ext_str2 not like", value, "extStr2");
            return (Criteria) this;
        }

        public Criteria andExtStr2In(List<String> values) {
            addCriterion("ext_str2 in", values, "extStr2");
            return (Criteria) this;
        }

        public Criteria andExtStr2NotIn(List<String> values) {
            addCriterion("ext_str2 not in", values, "extStr2");
            return (Criteria) this;
        }

        public Criteria andExtStr2Between(String value1, String value2) {
            addCriterion("ext_str2 between", value1, value2, "extStr2");
            return (Criteria) this;
        }

        public Criteria andExtStr2NotBetween(String value1, String value2) {
            addCriterion("ext_str2 not between", value1, value2, "extStr2");
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