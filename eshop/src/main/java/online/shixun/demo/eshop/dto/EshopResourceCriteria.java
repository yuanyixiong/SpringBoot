package online.shixun.demo.eshop.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EshopResourceCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public EshopResourceCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
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
     * This method corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Integer> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Integer> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
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
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNull() {
            addCriterion("resource_name is null");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNotNull() {
            addCriterion("resource_name is not null");
            return (Criteria) this;
        }

        public Criteria andResourceNameEqualTo(String value) {
            addCriterion("resource_name =", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotEqualTo(String value) {
            addCriterion("resource_name <>", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThan(String value) {
            addCriterion("resource_name >", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("resource_name >=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThan(String value) {
            addCriterion("resource_name <", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThanOrEqualTo(String value) {
            addCriterion("resource_name <=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLike(String value) {
            addCriterion("resource_name like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotLike(String value) {
            addCriterion("resource_name not like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameIn(List<String> values) {
            addCriterion("resource_name in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotIn(List<String> values) {
            addCriterion("resource_name not in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameBetween(String value1, String value2) {
            addCriterion("resource_name between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotBetween(String value1, String value2) {
            addCriterion("resource_name not between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdIsNull() {
            addCriterion("resource_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdIsNotNull() {
            addCriterion("resource_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdEqualTo(String value) {
            addCriterion("resource_parent_id =", value, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdNotEqualTo(String value) {
            addCriterion("resource_parent_id <>", value, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdGreaterThan(String value) {
            addCriterion("resource_parent_id >", value, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("resource_parent_id >=", value, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdLessThan(String value) {
            addCriterion("resource_parent_id <", value, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdLessThanOrEqualTo(String value) {
            addCriterion("resource_parent_id <=", value, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdLike(String value) {
            addCriterion("resource_parent_id like", value, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdNotLike(String value) {
            addCriterion("resource_parent_id not like", value, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdIn(List<String> values) {
            addCriterion("resource_parent_id in", values, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdNotIn(List<String> values) {
            addCriterion("resource_parent_id not in", values, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdBetween(String value1, String value2) {
            addCriterion("resource_parent_id between", value1, value2, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceParentIdNotBetween(String value1, String value2) {
            addCriterion("resource_parent_id not between", value1, value2, "resourceParentId");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIsNull() {
            addCriterion("resource_url is null");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIsNotNull() {
            addCriterion("resource_url is not null");
            return (Criteria) this;
        }

        public Criteria andResourceUrlEqualTo(String value) {
            addCriterion("resource_url =", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotEqualTo(String value) {
            addCriterion("resource_url <>", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlGreaterThan(String value) {
            addCriterion("resource_url >", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("resource_url >=", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLessThan(String value) {
            addCriterion("resource_url <", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLessThanOrEqualTo(String value) {
            addCriterion("resource_url <=", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLike(String value) {
            addCriterion("resource_url like", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotLike(String value) {
            addCriterion("resource_url not like", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIn(List<String> values) {
            addCriterion("resource_url in", values, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotIn(List<String> values) {
            addCriterion("resource_url not in", values, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlBetween(String value1, String value2) {
            addCriterion("resource_url between", value1, value2, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotBetween(String value1, String value2) {
            addCriterion("resource_url not between", value1, value2, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceIcoIsNull() {
            addCriterion("resource_ico is null");
            return (Criteria) this;
        }

        public Criteria andResourceIcoIsNotNull() {
            addCriterion("resource_ico is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIcoEqualTo(String value) {
            addCriterion("resource_ico =", value, "resourceIco");
            return (Criteria) this;
        }

        public Criteria andResourceIcoNotEqualTo(String value) {
            addCriterion("resource_ico <>", value, "resourceIco");
            return (Criteria) this;
        }

        public Criteria andResourceIcoGreaterThan(String value) {
            addCriterion("resource_ico >", value, "resourceIco");
            return (Criteria) this;
        }

        public Criteria andResourceIcoGreaterThanOrEqualTo(String value) {
            addCriterion("resource_ico >=", value, "resourceIco");
            return (Criteria) this;
        }

        public Criteria andResourceIcoLessThan(String value) {
            addCriterion("resource_ico <", value, "resourceIco");
            return (Criteria) this;
        }

        public Criteria andResourceIcoLessThanOrEqualTo(String value) {
            addCriterion("resource_ico <=", value, "resourceIco");
            return (Criteria) this;
        }

        public Criteria andResourceIcoLike(String value) {
            addCriterion("resource_ico like", value, "resourceIco");
            return (Criteria) this;
        }

        public Criteria andResourceIcoNotLike(String value) {
            addCriterion("resource_ico not like", value, "resourceIco");
            return (Criteria) this;
        }

        public Criteria andResourceIcoIn(List<String> values) {
            addCriterion("resource_ico in", values, "resourceIco");
            return (Criteria) this;
        }

        public Criteria andResourceIcoNotIn(List<String> values) {
            addCriterion("resource_ico not in", values, "resourceIco");
            return (Criteria) this;
        }

        public Criteria andResourceIcoBetween(String value1, String value2) {
            addCriterion("resource_ico between", value1, value2, "resourceIco");
            return (Criteria) this;
        }

        public Criteria andResourceIcoNotBetween(String value1, String value2) {
            addCriterion("resource_ico not between", value1, value2, "resourceIco");
            return (Criteria) this;
        }

        public Criteria andResourceIndexIsNull() {
            addCriterion("resource_index is null");
            return (Criteria) this;
        }

        public Criteria andResourceIndexIsNotNull() {
            addCriterion("resource_index is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIndexEqualTo(Integer value) {
            addCriterion("resource_index =", value, "resourceIndex");
            return (Criteria) this;
        }

        public Criteria andResourceIndexNotEqualTo(Integer value) {
            addCriterion("resource_index <>", value, "resourceIndex");
            return (Criteria) this;
        }

        public Criteria andResourceIndexGreaterThan(Integer value) {
            addCriterion("resource_index >", value, "resourceIndex");
            return (Criteria) this;
        }

        public Criteria andResourceIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_index >=", value, "resourceIndex");
            return (Criteria) this;
        }

        public Criteria andResourceIndexLessThan(Integer value) {
            addCriterion("resource_index <", value, "resourceIndex");
            return (Criteria) this;
        }

        public Criteria andResourceIndexLessThanOrEqualTo(Integer value) {
            addCriterion("resource_index <=", value, "resourceIndex");
            return (Criteria) this;
        }

        public Criteria andResourceIndexIn(List<Integer> values) {
            addCriterion("resource_index in", values, "resourceIndex");
            return (Criteria) this;
        }

        public Criteria andResourceIndexNotIn(List<Integer> values) {
            addCriterion("resource_index not in", values, "resourceIndex");
            return (Criteria) this;
        }

        public Criteria andResourceIndexBetween(Integer value1, Integer value2) {
            addCriterion("resource_index between", value1, value2, "resourceIndex");
            return (Criteria) this;
        }

        public Criteria andResourceIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_index not between", value1, value2, "resourceIndex");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionIsNull() {
            addCriterion("resource_description is null");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionIsNotNull() {
            addCriterion("resource_description is not null");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionEqualTo(String value) {
            addCriterion("resource_description =", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionNotEqualTo(String value) {
            addCriterion("resource_description <>", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionGreaterThan(String value) {
            addCriterion("resource_description >", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("resource_description >=", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionLessThan(String value) {
            addCriterion("resource_description <", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionLessThanOrEqualTo(String value) {
            addCriterion("resource_description <=", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionLike(String value) {
            addCriterion("resource_description like", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionNotLike(String value) {
            addCriterion("resource_description not like", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionIn(List<String> values) {
            addCriterion("resource_description in", values, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionNotIn(List<String> values) {
            addCriterion("resource_description not in", values, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionBetween(String value1, String value2) {
            addCriterion("resource_description between", value1, value2, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionNotBetween(String value1, String value2) {
            addCriterion("resource_description not between", value1, value2, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceImageIsNull() {
            addCriterion("resource_image is null");
            return (Criteria) this;
        }

        public Criteria andResourceImageIsNotNull() {
            addCriterion("resource_image is not null");
            return (Criteria) this;
        }

        public Criteria andResourceImageEqualTo(String value) {
            addCriterion("resource_image =", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageNotEqualTo(String value) {
            addCriterion("resource_image <>", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageGreaterThan(String value) {
            addCriterion("resource_image >", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageGreaterThanOrEqualTo(String value) {
            addCriterion("resource_image >=", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageLessThan(String value) {
            addCriterion("resource_image <", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageLessThanOrEqualTo(String value) {
            addCriterion("resource_image <=", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageLike(String value) {
            addCriterion("resource_image like", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageNotLike(String value) {
            addCriterion("resource_image not like", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageIn(List<String> values) {
            addCriterion("resource_image in", values, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageNotIn(List<String> values) {
            addCriterion("resource_image not in", values, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageBetween(String value1, String value2) {
            addCriterion("resource_image between", value1, value2, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageNotBetween(String value1, String value2) {
            addCriterion("resource_image not between", value1, value2, "resourceImage");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table eshop_resource
     *
     * @mbg.generated do_not_delete_during_merge Fri May 11 10:30:06 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
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