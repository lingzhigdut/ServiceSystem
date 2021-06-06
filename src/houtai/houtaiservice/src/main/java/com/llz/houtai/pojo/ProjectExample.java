package com.llz.houtai.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andIdcustomerIsNull() {
            addCriterion("idcustomer is null");
            return (Criteria) this;
        }

        public Criteria andIdcustomerIsNotNull() {
            addCriterion("idcustomer is not null");
            return (Criteria) this;
        }

        public Criteria andIdcustomerEqualTo(Integer value) {
            addCriterion("idcustomer =", value, "idcustomer");
            return (Criteria) this;
        }

        public Criteria andIdcustomerNotEqualTo(Integer value) {
            addCriterion("idcustomer <>", value, "idcustomer");
            return (Criteria) this;
        }

        public Criteria andIdcustomerGreaterThan(Integer value) {
            addCriterion("idcustomer >", value, "idcustomer");
            return (Criteria) this;
        }

        public Criteria andIdcustomerGreaterThanOrEqualTo(Integer value) {
            addCriterion("idcustomer >=", value, "idcustomer");
            return (Criteria) this;
        }

        public Criteria andIdcustomerLessThan(Integer value) {
            addCriterion("idcustomer <", value, "idcustomer");
            return (Criteria) this;
        }

        public Criteria andIdcustomerLessThanOrEqualTo(Integer value) {
            addCriterion("idcustomer <=", value, "idcustomer");
            return (Criteria) this;
        }

        public Criteria andIdcustomerIn(List<Integer> values) {
            addCriterion("idcustomer in", values, "idcustomer");
            return (Criteria) this;
        }

        public Criteria andIdcustomerNotIn(List<Integer> values) {
            addCriterion("idcustomer not in", values, "idcustomer");
            return (Criteria) this;
        }

        public Criteria andIdcustomerBetween(Integer value1, Integer value2) {
            addCriterion("idcustomer between", value1, value2, "idcustomer");
            return (Criteria) this;
        }

        public Criteria andIdcustomerNotBetween(Integer value1, Integer value2) {
            addCriterion("idcustomer not between", value1, value2, "idcustomer");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andTaskconditionIsNull() {
            addCriterion("taskcondition is null");
            return (Criteria) this;
        }

        public Criteria andTaskconditionIsNotNull() {
            addCriterion("taskcondition is not null");
            return (Criteria) this;
        }

        public Criteria andTaskconditionEqualTo(Integer value) {
            addCriterion("taskcondition =", value, "taskcondition");
            return (Criteria) this;
        }

        public Criteria andTaskconditionNotEqualTo(Integer value) {
            addCriterion("taskcondition <>", value, "taskcondition");
            return (Criteria) this;
        }

        public Criteria andTaskconditionGreaterThan(Integer value) {
            addCriterion("taskcondition >", value, "taskcondition");
            return (Criteria) this;
        }

        public Criteria andTaskconditionGreaterThanOrEqualTo(Integer value) {
            addCriterion("taskcondition >=", value, "taskcondition");
            return (Criteria) this;
        }

        public Criteria andTaskconditionLessThan(Integer value) {
            addCriterion("taskcondition <", value, "taskcondition");
            return (Criteria) this;
        }

        public Criteria andTaskconditionLessThanOrEqualTo(Integer value) {
            addCriterion("taskcondition <=", value, "taskcondition");
            return (Criteria) this;
        }

        public Criteria andTaskconditionIn(List<Integer> values) {
            addCriterion("taskcondition in", values, "taskcondition");
            return (Criteria) this;
        }

        public Criteria andTaskconditionNotIn(List<Integer> values) {
            addCriterion("taskcondition not in", values, "taskcondition");
            return (Criteria) this;
        }

        public Criteria andTaskconditionBetween(Integer value1, Integer value2) {
            addCriterion("taskcondition between", value1, value2, "taskcondition");
            return (Criteria) this;
        }

        public Criteria andTaskconditionNotBetween(Integer value1, Integer value2) {
            addCriterion("taskcondition not between", value1, value2, "taskcondition");
            return (Criteria) this;
        }

        public Criteria andIdserverIsNull() {
            addCriterion("idserver is null");
            return (Criteria) this;
        }

        public Criteria andIdserverIsNotNull() {
            addCriterion("idserver is not null");
            return (Criteria) this;
        }

        public Criteria andIdserverEqualTo(Integer value) {
            addCriterion("idserver =", value, "idserver");
            return (Criteria) this;
        }

        public Criteria andIdserverNotEqualTo(Integer value) {
            addCriterion("idserver <>", value, "idserver");
            return (Criteria) this;
        }

        public Criteria andIdserverGreaterThan(Integer value) {
            addCriterion("idserver >", value, "idserver");
            return (Criteria) this;
        }

        public Criteria andIdserverGreaterThanOrEqualTo(Integer value) {
            addCriterion("idserver >=", value, "idserver");
            return (Criteria) this;
        }

        public Criteria andIdserverLessThan(Integer value) {
            addCriterion("idserver <", value, "idserver");
            return (Criteria) this;
        }

        public Criteria andIdserverLessThanOrEqualTo(Integer value) {
            addCriterion("idserver <=", value, "idserver");
            return (Criteria) this;
        }

        public Criteria andIdserverIn(List<Integer> values) {
            addCriterion("idserver in", values, "idserver");
            return (Criteria) this;
        }

        public Criteria andIdserverNotIn(List<Integer> values) {
            addCriterion("idserver not in", values, "idserver");
            return (Criteria) this;
        }

        public Criteria andIdserverBetween(Integer value1, Integer value2) {
            addCriterion("idserver between", value1, value2, "idserver");
            return (Criteria) this;
        }

        public Criteria andIdserverNotBetween(Integer value1, Integer value2) {
            addCriterion("idserver not between", value1, value2, "idserver");
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