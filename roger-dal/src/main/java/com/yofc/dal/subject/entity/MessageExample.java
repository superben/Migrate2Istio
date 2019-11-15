package com.yofc.dal.subject.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public MessageExample() {
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

        public Criteria andMsgIdIsNull() {
            addCriterion("msg_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgIdIsNotNull() {
            addCriterion("msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIdEqualTo(Integer value) {
            addCriterion("msg_id =", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotEqualTo(Integer value) {
            addCriterion("msg_id <>", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThan(Integer value) {
            addCriterion("msg_id >", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_id >=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThan(Integer value) {
            addCriterion("msg_id <", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThanOrEqualTo(Integer value) {
            addCriterion("msg_id <=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdIn(List<Integer> values) {
            addCriterion("msg_id in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotIn(List<Integer> values) {
            addCriterion("msg_id not in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdBetween(Integer value1, Integer value2) {
            addCriterion("msg_id between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_id not between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andReceiverUserIdIsNull() {
            addCriterion("receiver_user_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiverUserIdIsNotNull() {
            addCriterion("receiver_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverUserIdEqualTo(String value) {
            addCriterion("receiver_user_id =", value, "receiverUserId");
            return (Criteria) this;
        }

        public Criteria andReceiverUserIdNotEqualTo(String value) {
            addCriterion("receiver_user_id <>", value, "receiverUserId");
            return (Criteria) this;
        }

        public Criteria andReceiverUserIdGreaterThan(String value) {
            addCriterion("receiver_user_id >", value, "receiverUserId");
            return (Criteria) this;
        }

        public Criteria andReceiverUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_user_id >=", value, "receiverUserId");
            return (Criteria) this;
        }

        public Criteria andReceiverUserIdLessThan(String value) {
            addCriterion("receiver_user_id <", value, "receiverUserId");
            return (Criteria) this;
        }

        public Criteria andReceiverUserIdLessThanOrEqualTo(String value) {
            addCriterion("receiver_user_id <=", value, "receiverUserId");
            return (Criteria) this;
        }

        public Criteria andReceiverUserIdLike(String value) {
            addCriterion("receiver_user_id like", value, "receiverUserId");
            return (Criteria) this;
        }

        public Criteria andReceiverUserIdNotLike(String value) {
            addCriterion("receiver_user_id not like", value, "receiverUserId");
            return (Criteria) this;
        }

        public Criteria andReceiverUserIdIn(List<String> values) {
            addCriterion("receiver_user_id in", values, "receiverUserId");
            return (Criteria) this;
        }

        public Criteria andReceiverUserIdNotIn(List<String> values) {
            addCriterion("receiver_user_id not in", values, "receiverUserId");
            return (Criteria) this;
        }

        public Criteria andReceiverUserIdBetween(String value1, String value2) {
            addCriterion("receiver_user_id between", value1, value2, "receiverUserId");
            return (Criteria) this;
        }

        public Criteria andReceiverUserIdNotBetween(String value1, String value2) {
            addCriterion("receiver_user_id not between", value1, value2, "receiverUserId");
            return (Criteria) this;
        }

        public Criteria andSrcIsNull() {
            addCriterion("src is null");
            return (Criteria) this;
        }

        public Criteria andSrcIsNotNull() {
            addCriterion("src is not null");
            return (Criteria) this;
        }

        public Criteria andSrcEqualTo(String value) {
            addCriterion("src =", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcNotEqualTo(String value) {
            addCriterion("src <>", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcGreaterThan(String value) {
            addCriterion("src >", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcGreaterThanOrEqualTo(String value) {
            addCriterion("src >=", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcLessThan(String value) {
            addCriterion("src <", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcLessThanOrEqualTo(String value) {
            addCriterion("src <=", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcLike(String value) {
            addCriterion("src like", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcNotLike(String value) {
            addCriterion("src not like", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcIn(List<String> values) {
            addCriterion("src in", values, "src");
            return (Criteria) this;
        }

        public Criteria andSrcNotIn(List<String> values) {
            addCriterion("src not in", values, "src");
            return (Criteria) this;
        }

        public Criteria andSrcBetween(String value1, String value2) {
            addCriterion("src between", value1, value2, "src");
            return (Criteria) this;
        }

        public Criteria andSrcNotBetween(String value1, String value2) {
            addCriterion("src not between", value1, value2, "src");
            return (Criteria) this;
        }

        public Criteria andFallbackSrcIsNull() {
            addCriterion("fallback_src is null");
            return (Criteria) this;
        }

        public Criteria andFallbackSrcIsNotNull() {
            addCriterion("fallback_src is not null");
            return (Criteria) this;
        }

        public Criteria andFallbackSrcEqualTo(String value) {
            addCriterion("fallback_src =", value, "fallbackSrc");
            return (Criteria) this;
        }

        public Criteria andFallbackSrcNotEqualTo(String value) {
            addCriterion("fallback_src <>", value, "fallbackSrc");
            return (Criteria) this;
        }

        public Criteria andFallbackSrcGreaterThan(String value) {
            addCriterion("fallback_src >", value, "fallbackSrc");
            return (Criteria) this;
        }

        public Criteria andFallbackSrcGreaterThanOrEqualTo(String value) {
            addCriterion("fallback_src >=", value, "fallbackSrc");
            return (Criteria) this;
        }

        public Criteria andFallbackSrcLessThan(String value) {
            addCriterion("fallback_src <", value, "fallbackSrc");
            return (Criteria) this;
        }

        public Criteria andFallbackSrcLessThanOrEqualTo(String value) {
            addCriterion("fallback_src <=", value, "fallbackSrc");
            return (Criteria) this;
        }

        public Criteria andFallbackSrcLike(String value) {
            addCriterion("fallback_src like", value, "fallbackSrc");
            return (Criteria) this;
        }

        public Criteria andFallbackSrcNotLike(String value) {
            addCriterion("fallback_src not like", value, "fallbackSrc");
            return (Criteria) this;
        }

        public Criteria andFallbackSrcIn(List<String> values) {
            addCriterion("fallback_src in", values, "fallbackSrc");
            return (Criteria) this;
        }

        public Criteria andFallbackSrcNotIn(List<String> values) {
            addCriterion("fallback_src not in", values, "fallbackSrc");
            return (Criteria) this;
        }

        public Criteria andFallbackSrcBetween(String value1, String value2) {
            addCriterion("fallback_src between", value1, value2, "fallbackSrc");
            return (Criteria) this;
        }

        public Criteria andFallbackSrcNotBetween(String value1, String value2) {
            addCriterion("fallback_src not between", value1, value2, "fallbackSrc");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andMsgBodyIsNull() {
            addCriterion("msg_body is null");
            return (Criteria) this;
        }

        public Criteria andMsgBodyIsNotNull() {
            addCriterion("msg_body is not null");
            return (Criteria) this;
        }

        public Criteria andMsgBodyEqualTo(String value) {
            addCriterion("msg_body =", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyNotEqualTo(String value) {
            addCriterion("msg_body <>", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyGreaterThan(String value) {
            addCriterion("msg_body >", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyGreaterThanOrEqualTo(String value) {
            addCriterion("msg_body >=", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyLessThan(String value) {
            addCriterion("msg_body <", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyLessThanOrEqualTo(String value) {
            addCriterion("msg_body <=", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyLike(String value) {
            addCriterion("msg_body like", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyNotLike(String value) {
            addCriterion("msg_body not like", value, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyIn(List<String> values) {
            addCriterion("msg_body in", values, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyNotIn(List<String> values) {
            addCriterion("msg_body not in", values, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyBetween(String value1, String value2) {
            addCriterion("msg_body between", value1, value2, "msgBody");
            return (Criteria) this;
        }

        public Criteria andMsgBodyNotBetween(String value1, String value2) {
            addCriterion("msg_body not between", value1, value2, "msgBody");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIsNull() {
            addCriterion("msg_type is null");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIsNotNull() {
            addCriterion("msg_type is not null");
            return (Criteria) this;
        }

        public Criteria andMsgTypeEqualTo(String value) {
            addCriterion("msg_type =", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotEqualTo(String value) {
            addCriterion("msg_type <>", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeGreaterThan(String value) {
            addCriterion("msg_type >", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("msg_type >=", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLessThan(String value) {
            addCriterion("msg_type <", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLessThanOrEqualTo(String value) {
            addCriterion("msg_type <=", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLike(String value) {
            addCriterion("msg_type like", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotLike(String value) {
            addCriterion("msg_type not like", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIn(List<String> values) {
            addCriterion("msg_type in", values, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotIn(List<String> values) {
            addCriterion("msg_type not in", values, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeBetween(String value1, String value2) {
            addCriterion("msg_type between", value1, value2, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotBetween(String value1, String value2) {
            addCriterion("msg_type not between", value1, value2, "msgType");
            return (Criteria) this;
        }

        public Criteria andReadableIsNull() {
            addCriterion("readable is null");
            return (Criteria) this;
        }

        public Criteria andReadableIsNotNull() {
            addCriterion("readable is not null");
            return (Criteria) this;
        }

        public Criteria andReadableEqualTo(String value) {
            addCriterion("readable =", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableNotEqualTo(String value) {
            addCriterion("readable <>", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableGreaterThan(String value) {
            addCriterion("readable >", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableGreaterThanOrEqualTo(String value) {
            addCriterion("readable >=", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableLessThan(String value) {
            addCriterion("readable <", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableLessThanOrEqualTo(String value) {
            addCriterion("readable <=", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableLike(String value) {
            addCriterion("readable like", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableNotLike(String value) {
            addCriterion("readable not like", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableIn(List<String> values) {
            addCriterion("readable in", values, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableNotIn(List<String> values) {
            addCriterion("readable not in", values, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableBetween(String value1, String value2) {
            addCriterion("readable between", value1, value2, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableNotBetween(String value1, String value2) {
            addCriterion("readable not between", value1, value2, "readable");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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