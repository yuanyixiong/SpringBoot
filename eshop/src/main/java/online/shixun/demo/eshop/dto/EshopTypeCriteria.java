package online.shixun.demo.eshop.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EshopTypeCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public EshopTypeCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
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
     * This method corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
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

        public Criteria andTypeNameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("type_name =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("type_name >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("type_name <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("type_name like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("type_name not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("type_name in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdIsNull() {
            addCriterion("type_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdIsNotNull() {
            addCriterion("type_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdEqualTo(String value) {
            addCriterion("type_parent_id =", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdNotEqualTo(String value) {
            addCriterion("type_parent_id <>", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdGreaterThan(String value) {
            addCriterion("type_parent_id >", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("type_parent_id >=", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdLessThan(String value) {
            addCriterion("type_parent_id <", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdLessThanOrEqualTo(String value) {
            addCriterion("type_parent_id <=", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdLike(String value) {
            addCriterion("type_parent_id like", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdNotLike(String value) {
            addCriterion("type_parent_id not like", value, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdIn(List<String> values) {
            addCriterion("type_parent_id in", values, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdNotIn(List<String> values) {
            addCriterion("type_parent_id not in", values, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdBetween(String value1, String value2) {
            addCriterion("type_parent_id between", value1, value2, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeParentIdNotBetween(String value1, String value2) {
            addCriterion("type_parent_id not between", value1, value2, "typeParentId");
            return (Criteria) this;
        }

        public Criteria andTypeNoteIsNull() {
            addCriterion("type_note is null");
            return (Criteria) this;
        }

        public Criteria andTypeNoteIsNotNull() {
            addCriterion("type_note is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNoteEqualTo(String value) {
            addCriterion("type_note =", value, "typeNote");
            return (Criteria) this;
        }

        public Criteria andTypeNoteNotEqualTo(String value) {
            addCriterion("type_note <>", value, "typeNote");
            return (Criteria) this;
        }

        public Criteria andTypeNoteGreaterThan(String value) {
            addCriterion("type_note >", value, "typeNote");
            return (Criteria) this;
        }

        public Criteria andTypeNoteGreaterThanOrEqualTo(String value) {
            addCriterion("type_note >=", value, "typeNote");
            return (Criteria) this;
        }

        public Criteria andTypeNoteLessThan(String value) {
            addCriterion("type_note <", value, "typeNote");
            return (Criteria) this;
        }

        public Criteria andTypeNoteLessThanOrEqualTo(String value) {
            addCriterion("type_note <=", value, "typeNote");
            return (Criteria) this;
        }

        public Criteria andTypeNoteLike(String value) {
            addCriterion("type_note like", value, "typeNote");
            return (Criteria) this;
        }

        public Criteria andTypeNoteNotLike(String value) {
            addCriterion("type_note not like", value, "typeNote");
            return (Criteria) this;
        }

        public Criteria andTypeNoteIn(List<String> values) {
            addCriterion("type_note in", values, "typeNote");
            return (Criteria) this;
        }

        public Criteria andTypeNoteNotIn(List<String> values) {
            addCriterion("type_note not in", values, "typeNote");
            return (Criteria) this;
        }

        public Criteria andTypeNoteBetween(String value1, String value2) {
            addCriterion("type_note between", value1, value2, "typeNote");
            return (Criteria) this;
        }

        public Criteria andTypeNoteNotBetween(String value1, String value2) {
            addCriterion("type_note not between", value1, value2, "typeNote");
            return (Criteria) this;
        }

        public Criteria andTypeUrlIsNull() {
            addCriterion("type_url is null");
            return (Criteria) this;
        }

        public Criteria andTypeUrlIsNotNull() {
            addCriterion("type_url is not null");
            return (Criteria) this;
        }

        public Criteria andTypeUrlEqualTo(String value) {
            addCriterion("type_url =", value, "typeUrl");
            return (Criteria) this;
        }

        public Criteria andTypeUrlNotEqualTo(String value) {
            addCriterion("type_url <>", value, "typeUrl");
            return (Criteria) this;
        }

        public Criteria andTypeUrlGreaterThan(String value) {
            addCriterion("type_url >", value, "typeUrl");
            return (Criteria) this;
        }

        public Criteria andTypeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("type_url >=", value, "typeUrl");
            return (Criteria) this;
        }

        public Criteria andTypeUrlLessThan(String value) {
            addCriterion("type_url <", value, "typeUrl");
            return (Criteria) this;
        }

        public Criteria andTypeUrlLessThanOrEqualTo(String value) {
            addCriterion("type_url <=", value, "typeUrl");
            return (Criteria) this;
        }

        public Criteria andTypeUrlLike(String value) {
            addCriterion("type_url like", value, "typeUrl");
            return (Criteria) this;
        }

        public Criteria andTypeUrlNotLike(String value) {
            addCriterion("type_url not like", value, "typeUrl");
            return (Criteria) this;
        }

        public Criteria andTypeUrlIn(List<String> values) {
            addCriterion("type_url in", values, "typeUrl");
            return (Criteria) this;
        }

        public Criteria andTypeUrlNotIn(List<String> values) {
            addCriterion("type_url not in", values, "typeUrl");
            return (Criteria) this;
        }

        public Criteria andTypeUrlBetween(String value1, String value2) {
            addCriterion("type_url between", value1, value2, "typeUrl");
            return (Criteria) this;
        }

        public Criteria andTypeUrlNotBetween(String value1, String value2) {
            addCriterion("type_url not between", value1, value2, "typeUrl");
            return (Criteria) this;
        }

        public Criteria andTypeImageIsNull() {
            addCriterion("type_image is null");
            return (Criteria) this;
        }

        public Criteria andTypeImageIsNotNull() {
            addCriterion("type_image is not null");
            return (Criteria) this;
        }

        public Criteria andTypeImageEqualTo(String value) {
            addCriterion("type_image =", value, "typeImage");
            return (Criteria) this;
        }

        public Criteria andTypeImageNotEqualTo(String value) {
            addCriterion("type_image <>", value, "typeImage");
            return (Criteria) this;
        }

        public Criteria andTypeImageGreaterThan(String value) {
            addCriterion("type_image >", value, "typeImage");
            return (Criteria) this;
        }

        public Criteria andTypeImageGreaterThanOrEqualTo(String value) {
            addCriterion("type_image >=", value, "typeImage");
            return (Criteria) this;
        }

        public Criteria andTypeImageLessThan(String value) {
            addCriterion("type_image <", value, "typeImage");
            return (Criteria) this;
        }

        public Criteria andTypeImageLessThanOrEqualTo(String value) {
            addCriterion("type_image <=", value, "typeImage");
            return (Criteria) this;
        }

        public Criteria andTypeImageLike(String value) {
            addCriterion("type_image like", value, "typeImage");
            return (Criteria) this;
        }

        public Criteria andTypeImageNotLike(String value) {
            addCriterion("type_image not like", value, "typeImage");
            return (Criteria) this;
        }

        public Criteria andTypeImageIn(List<String> values) {
            addCriterion("type_image in", values, "typeImage");
            return (Criteria) this;
        }

        public Criteria andTypeImageNotIn(List<String> values) {
            addCriterion("type_image not in", values, "typeImage");
            return (Criteria) this;
        }

        public Criteria andTypeImageBetween(String value1, String value2) {
            addCriterion("type_image between", value1, value2, "typeImage");
            return (Criteria) this;
        }

        public Criteria andTypeImageNotBetween(String value1, String value2) {
            addCriterion("type_image not between", value1, value2, "typeImage");
            return (Criteria) this;
        }

        public Criteria andTypeIcoIsNull() {
            addCriterion("type_ico is null");
            return (Criteria) this;
        }

        public Criteria andTypeIcoIsNotNull() {
            addCriterion("type_ico is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIcoEqualTo(String value) {
            addCriterion("type_ico =", value, "typeIco");
            return (Criteria) this;
        }

        public Criteria andTypeIcoNotEqualTo(String value) {
            addCriterion("type_ico <>", value, "typeIco");
            return (Criteria) this;
        }

        public Criteria andTypeIcoGreaterThan(String value) {
            addCriterion("type_ico >", value, "typeIco");
            return (Criteria) this;
        }

        public Criteria andTypeIcoGreaterThanOrEqualTo(String value) {
            addCriterion("type_ico >=", value, "typeIco");
            return (Criteria) this;
        }

        public Criteria andTypeIcoLessThan(String value) {
            addCriterion("type_ico <", value, "typeIco");
            return (Criteria) this;
        }

        public Criteria andTypeIcoLessThanOrEqualTo(String value) {
            addCriterion("type_ico <=", value, "typeIco");
            return (Criteria) this;
        }

        public Criteria andTypeIcoLike(String value) {
            addCriterion("type_ico like", value, "typeIco");
            return (Criteria) this;
        }

        public Criteria andTypeIcoNotLike(String value) {
            addCriterion("type_ico not like", value, "typeIco");
            return (Criteria) this;
        }

        public Criteria andTypeIcoIn(List<String> values) {
            addCriterion("type_ico in", values, "typeIco");
            return (Criteria) this;
        }

        public Criteria andTypeIcoNotIn(List<String> values) {
            addCriterion("type_ico not in", values, "typeIco");
            return (Criteria) this;
        }

        public Criteria andTypeIcoBetween(String value1, String value2) {
            addCriterion("type_ico between", value1, value2, "typeIco");
            return (Criteria) this;
        }

        public Criteria andTypeIcoNotBetween(String value1, String value2) {
            addCriterion("type_ico not between", value1, value2, "typeIco");
            return (Criteria) this;
        }

        public Criteria andTypeIndexIsNull() {
            addCriterion("type_index is null");
            return (Criteria) this;
        }

        public Criteria andTypeIndexIsNotNull() {
            addCriterion("type_index is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIndexEqualTo(Integer value) {
            addCriterion("type_index =", value, "typeIndex");
            return (Criteria) this;
        }

        public Criteria andTypeIndexNotEqualTo(Integer value) {
            addCriterion("type_index <>", value, "typeIndex");
            return (Criteria) this;
        }

        public Criteria andTypeIndexGreaterThan(Integer value) {
            addCriterion("type_index >", value, "typeIndex");
            return (Criteria) this;
        }

        public Criteria andTypeIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_index >=", value, "typeIndex");
            return (Criteria) this;
        }

        public Criteria andTypeIndexLessThan(Integer value) {
            addCriterion("type_index <", value, "typeIndex");
            return (Criteria) this;
        }

        public Criteria andTypeIndexLessThanOrEqualTo(Integer value) {
            addCriterion("type_index <=", value, "typeIndex");
            return (Criteria) this;
        }

        public Criteria andTypeIndexIn(List<Integer> values) {
            addCriterion("type_index in", values, "typeIndex");
            return (Criteria) this;
        }

        public Criteria andTypeIndexNotIn(List<Integer> values) {
            addCriterion("type_index not in", values, "typeIndex");
            return (Criteria) this;
        }

        public Criteria andTypeIndexBetween(Integer value1, Integer value2) {
            addCriterion("type_index between", value1, value2, "typeIndex");
            return (Criteria) this;
        }

        public Criteria andTypeIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("type_index not between", value1, value2, "typeIndex");
            return (Criteria) this;
        }

        public Criteria andTypeDescriptionIsNull() {
            addCriterion("type_description is null");
            return (Criteria) this;
        }

        public Criteria andTypeDescriptionIsNotNull() {
            addCriterion("type_description is not null");
            return (Criteria) this;
        }

        public Criteria andTypeDescriptionEqualTo(String value) {
            addCriterion("type_description =", value, "typeDescription");
            return (Criteria) this;
        }

        public Criteria andTypeDescriptionNotEqualTo(String value) {
            addCriterion("type_description <>", value, "typeDescription");
            return (Criteria) this;
        }

        public Criteria andTypeDescriptionGreaterThan(String value) {
            addCriterion("type_description >", value, "typeDescription");
            return (Criteria) this;
        }

        public Criteria andTypeDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("type_description >=", value, "typeDescription");
            return (Criteria) this;
        }

        public Criteria andTypeDescriptionLessThan(String value) {
            addCriterion("type_description <", value, "typeDescription");
            return (Criteria) this;
        }

        public Criteria andTypeDescriptionLessThanOrEqualTo(String value) {
            addCriterion("type_description <=", value, "typeDescription");
            return (Criteria) this;
        }

        public Criteria andTypeDescriptionLike(String value) {
            addCriterion("type_description like", value, "typeDescription");
            return (Criteria) this;
        }

        public Criteria andTypeDescriptionNotLike(String value) {
            addCriterion("type_description not like", value, "typeDescription");
            return (Criteria) this;
        }

        public Criteria andTypeDescriptionIn(List<String> values) {
            addCriterion("type_description in", values, "typeDescription");
            return (Criteria) this;
        }

        public Criteria andTypeDescriptionNotIn(List<String> values) {
            addCriterion("type_description not in", values, "typeDescription");
            return (Criteria) this;
        }

        public Criteria andTypeDescriptionBetween(String value1, String value2) {
            addCriterion("type_description between", value1, value2, "typeDescription");
            return (Criteria) this;
        }

        public Criteria andTypeDescriptionNotBetween(String value1, String value2) {
            addCriterion("type_description not between", value1, value2, "typeDescription");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table eshop_type
     *
     * @mbg.generated do_not_delete_during_merge Fri May 11 10:31:51 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table eshop_type
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
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