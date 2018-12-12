package com.core.model.checkmis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GzxsJcqkbMxExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
    public GzxsJcqkbMxExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andJcqkbIdIsNull() {
            addCriterion("JCQKB_ID is null");
            return (Criteria) this;
        }

        public Criteria andJcqkbIdIsNotNull() {
            addCriterion("JCQKB_ID is not null");
            return (Criteria) this;
        }

        public Criteria andJcqkbIdEqualTo(Long value) {
            addCriterion("JCQKB_ID =", value, "jcqkbId");
            return (Criteria) this;
        }

        public Criteria andJcqkbIdNotEqualTo(Long value) {
            addCriterion("JCQKB_ID <>", value, "jcqkbId");
            return (Criteria) this;
        }

        public Criteria andJcqkbIdGreaterThan(Long value) {
            addCriterion("JCQKB_ID >", value, "jcqkbId");
            return (Criteria) this;
        }

        public Criteria andJcqkbIdGreaterThanOrEqualTo(Long value) {
            addCriterion("JCQKB_ID >=", value, "jcqkbId");
            return (Criteria) this;
        }

        public Criteria andJcqkbIdLessThan(Long value) {
            addCriterion("JCQKB_ID <", value, "jcqkbId");
            return (Criteria) this;
        }

        public Criteria andJcqkbIdLessThanOrEqualTo(Long value) {
            addCriterion("JCQKB_ID <=", value, "jcqkbId");
            return (Criteria) this;
        }

        public Criteria andJcqkbIdIn(List<Long> values) {
            addCriterion("JCQKB_ID in", values, "jcqkbId");
            return (Criteria) this;
        }

        public Criteria andJcqkbIdNotIn(List<Long> values) {
            addCriterion("JCQKB_ID not in", values, "jcqkbId");
            return (Criteria) this;
        }

        public Criteria andJcqkbIdBetween(Long value1, Long value2) {
            addCriterion("JCQKB_ID between", value1, value2, "jcqkbId");
            return (Criteria) this;
        }

        public Criteria andJcqkbIdNotBetween(Long value1, Long value2) {
            addCriterion("JCQKB_ID not between", value1, value2, "jcqkbId");
            return (Criteria) this;
        }

        public Criteria andJcxdsxIdIsNull() {
            addCriterion("JCXDSX_ID is null");
            return (Criteria) this;
        }

        public Criteria andJcxdsxIdIsNotNull() {
            addCriterion("JCXDSX_ID is not null");
            return (Criteria) this;
        }

        public Criteria andJcxdsxIdEqualTo(Long value) {
            addCriterion("JCXDSX_ID =", value, "jcxdsxId");
            return (Criteria) this;
        }

        public Criteria andJcxdsxIdNotEqualTo(Long value) {
            addCriterion("JCXDSX_ID <>", value, "jcxdsxId");
            return (Criteria) this;
        }

        public Criteria andJcxdsxIdGreaterThan(Long value) {
            addCriterion("JCXDSX_ID >", value, "jcxdsxId");
            return (Criteria) this;
        }

        public Criteria andJcxdsxIdGreaterThanOrEqualTo(Long value) {
            addCriterion("JCXDSX_ID >=", value, "jcxdsxId");
            return (Criteria) this;
        }

        public Criteria andJcxdsxIdLessThan(Long value) {
            addCriterion("JCXDSX_ID <", value, "jcxdsxId");
            return (Criteria) this;
        }

        public Criteria andJcxdsxIdLessThanOrEqualTo(Long value) {
            addCriterion("JCXDSX_ID <=", value, "jcxdsxId");
            return (Criteria) this;
        }

        public Criteria andJcxdsxIdIn(List<Long> values) {
            addCriterion("JCXDSX_ID in", values, "jcxdsxId");
            return (Criteria) this;
        }

        public Criteria andJcxdsxIdNotIn(List<Long> values) {
            addCriterion("JCXDSX_ID not in", values, "jcxdsxId");
            return (Criteria) this;
        }

        public Criteria andJcxdsxIdBetween(Long value1, Long value2) {
            addCriterion("JCXDSX_ID between", value1, value2, "jcxdsxId");
            return (Criteria) this;
        }

        public Criteria andJcxdsxIdNotBetween(Long value1, Long value2) {
            addCriterion("JCXDSX_ID not between", value1, value2, "jcxdsxId");
            return (Criteria) this;
        }

        public Criteria andJcxdsjIsNull() {
            addCriterion("JCXDSJ is null");
            return (Criteria) this;
        }

        public Criteria andJcxdsjIsNotNull() {
            addCriterion("JCXDSJ is not null");
            return (Criteria) this;
        }

        public Criteria andJcxdsjEqualTo(String value) {
            addCriterion("JCXDSJ =", value, "jcxdsj");
            return (Criteria) this;
        }

        public Criteria andJcxdsjNotEqualTo(String value) {
            addCriterion("JCXDSJ <>", value, "jcxdsj");
            return (Criteria) this;
        }

        public Criteria andJcxdsjGreaterThan(String value) {
            addCriterion("JCXDSJ >", value, "jcxdsj");
            return (Criteria) this;
        }

        public Criteria andJcxdsjGreaterThanOrEqualTo(String value) {
            addCriterion("JCXDSJ >=", value, "jcxdsj");
            return (Criteria) this;
        }

        public Criteria andJcxdsjLessThan(String value) {
            addCriterion("JCXDSJ <", value, "jcxdsj");
            return (Criteria) this;
        }

        public Criteria andJcxdsjLessThanOrEqualTo(String value) {
            addCriterion("JCXDSJ <=", value, "jcxdsj");
            return (Criteria) this;
        }

        public Criteria andJcxdsjLike(String value) {
            addCriterion("JCXDSJ like", value, "jcxdsj");
            return (Criteria) this;
        }

        public Criteria andJcxdsjNotLike(String value) {
            addCriterion("JCXDSJ not like", value, "jcxdsj");
            return (Criteria) this;
        }

        public Criteria andJcxdsjIn(List<String> values) {
            addCriterion("JCXDSJ in", values, "jcxdsj");
            return (Criteria) this;
        }

        public Criteria andJcxdsjNotIn(List<String> values) {
            addCriterion("JCXDSJ not in", values, "jcxdsj");
            return (Criteria) this;
        }

        public Criteria andJcxdsjBetween(String value1, String value2) {
            addCriterion("JCXDSJ between", value1, value2, "jcxdsj");
            return (Criteria) this;
        }

        public Criteria andJcxdsjNotBetween(String value1, String value2) {
            addCriterion("JCXDSJ not between", value1, value2, "jcxdsj");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("CREATEDATE is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("CREATEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("CREATEDATE =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("CREATEDATE <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("CREATEDATE >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("CREATEDATE <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("CREATEDATE in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("CREATEDATE not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andModifydateIsNull() {
            addCriterion("MODIFYDATE is null");
            return (Criteria) this;
        }

        public Criteria andModifydateIsNotNull() {
            addCriterion("MODIFYDATE is not null");
            return (Criteria) this;
        }

        public Criteria andModifydateEqualTo(Date value) {
            addCriterion("MODIFYDATE =", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotEqualTo(Date value) {
            addCriterion("MODIFYDATE <>", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThan(Date value) {
            addCriterion("MODIFYDATE >", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFYDATE >=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThan(Date value) {
            addCriterion("MODIFYDATE <", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThanOrEqualTo(Date value) {
            addCriterion("MODIFYDATE <=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateIn(List<Date> values) {
            addCriterion("MODIFYDATE in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotIn(List<Date> values) {
            addCriterion("MODIFYDATE not in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateBetween(Date value1, Date value2) {
            addCriterion("MODIFYDATE between", value1, value2, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotBetween(Date value1, Date value2) {
            addCriterion("MODIFYDATE not between", value1, value2, "modifydate");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNull() {
            addCriterion("CREATEUSER is null");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNotNull() {
            addCriterion("CREATEUSER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuserEqualTo(String value) {
            addCriterion("CREATEUSER =", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotEqualTo(String value) {
            addCriterion("CREATEUSER <>", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThan(String value) {
            addCriterion("CREATEUSER >", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATEUSER >=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThan(String value) {
            addCriterion("CREATEUSER <", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThanOrEqualTo(String value) {
            addCriterion("CREATEUSER <=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLike(String value) {
            addCriterion("CREATEUSER like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotLike(String value) {
            addCriterion("CREATEUSER not like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserIn(List<String> values) {
            addCriterion("CREATEUSER in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotIn(List<String> values) {
            addCriterion("CREATEUSER not in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserBetween(String value1, String value2) {
            addCriterion("CREATEUSER between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotBetween(String value1, String value2) {
            addCriterion("CREATEUSER not between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserIsNull() {
            addCriterion("MODIFYUSER is null");
            return (Criteria) this;
        }

        public Criteria andModifyuserIsNotNull() {
            addCriterion("MODIFYUSER is not null");
            return (Criteria) this;
        }

        public Criteria andModifyuserEqualTo(String value) {
            addCriterion("MODIFYUSER =", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserNotEqualTo(String value) {
            addCriterion("MODIFYUSER <>", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserGreaterThan(String value) {
            addCriterion("MODIFYUSER >", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFYUSER >=", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserLessThan(String value) {
            addCriterion("MODIFYUSER <", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserLessThanOrEqualTo(String value) {
            addCriterion("MODIFYUSER <=", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserLike(String value) {
            addCriterion("MODIFYUSER like", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserNotLike(String value) {
            addCriterion("MODIFYUSER not like", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserIn(List<String> values) {
            addCriterion("MODIFYUSER in", values, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserNotIn(List<String> values) {
            addCriterion("MODIFYUSER not in", values, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserBetween(String value1, String value2) {
            addCriterion("MODIFYUSER between", value1, value2, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserNotBetween(String value1, String value2) {
            addCriterion("MODIFYUSER not between", value1, value2, "modifyuser");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated do_not_delete_during_merge Sun Nov 25 13:54:42 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table CHECKMIS.ST_GZXS_JCQKB_MX
     *
     * @mbg.generated Sun Nov 25 13:54:42 CST 2018
     */
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