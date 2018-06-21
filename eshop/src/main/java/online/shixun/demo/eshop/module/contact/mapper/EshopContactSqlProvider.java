package online.shixun.demo.eshop.module.contact.mapper;

import java.util.List;
import java.util.Map;
import online.shixun.demo.eshop.dto.EshopContact;
import online.shixun.demo.eshop.dto.EshopContactCriteria.Criteria;
import online.shixun.demo.eshop.dto.EshopContactCriteria.Criterion;
import online.shixun.demo.eshop.dto.EshopContactCriteria;
import org.apache.ibatis.jdbc.SQL;

public class EshopContactSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_contact
     *
     * @mbg.generated Fri May 11 10:30:55 CST 2018
     */
    public String countByExample(EshopContactCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("eshop_contact");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_contact
     *
     * @mbg.generated Fri May 11 10:30:55 CST 2018
     */
    public String deleteByExample(EshopContactCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("eshop_contact");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_contact
     *
     * @mbg.generated Fri May 11 10:30:55 CST 2018
     */
    public String insertSelective(EshopContact record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("eshop_contact");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDel() != null) {
            sql.VALUES("is_del", "#{isDel,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=DATE}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=DATE}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getContactContent() != null) {
            sql.VALUES("contact_content", "#{contactContent,jdbcType=INTEGER}");
        }
        
        if (record.getContactEmail() != null) {
            sql.VALUES("contact_email", "#{contactEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getContactMessage() != null) {
            sql.VALUES("contact_message", "#{contactMessage,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_contact
     *
     * @mbg.generated Fri May 11 10:30:55 CST 2018
     */
    public String selectByExample(EshopContactCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("is_del");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("user_id");
        sql.SELECT("contact_content");
        sql.SELECT("contact_email");
        sql.SELECT("contact_message");
        sql.FROM("eshop_contact");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_contact
     *
     * @mbg.generated Fri May 11 10:30:55 CST 2018
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        EshopContact record = (EshopContact) parameter.get("record");
        EshopContactCriteria example = (EshopContactCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("eshop_contact");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDel() != null) {
            sql.SET("is_del = #{record.isDel,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=DATE}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=DATE}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        }
        
        if (record.getContactContent() != null) {
            sql.SET("contact_content = #{record.contactContent,jdbcType=INTEGER}");
        }
        
        if (record.getContactEmail() != null) {
            sql.SET("contact_email = #{record.contactEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getContactMessage() != null) {
            sql.SET("contact_message = #{record.contactMessage,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_contact
     *
     * @mbg.generated Fri May 11 10:30:55 CST 2018
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("eshop_contact");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("is_del = #{record.isDel,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=DATE}");
        sql.SET("update_time = #{record.updateTime,jdbcType=DATE}");
        sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        sql.SET("contact_content = #{record.contactContent,jdbcType=INTEGER}");
        sql.SET("contact_email = #{record.contactEmail,jdbcType=VARCHAR}");
        sql.SET("contact_message = #{record.contactMessage,jdbcType=VARCHAR}");
        
        EshopContactCriteria example = (EshopContactCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_contact
     *
     * @mbg.generated Fri May 11 10:30:55 CST 2018
     */
    public String updateByPrimaryKeySelective(EshopContact record) {
        SQL sql = new SQL();
        sql.UPDATE("eshop_contact");
        
        if (record.getIsDel() != null) {
            sql.SET("is_del = #{isDel,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=DATE}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=DATE}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getContactContent() != null) {
            sql.SET("contact_content = #{contactContent,jdbcType=INTEGER}");
        }
        
        if (record.getContactEmail() != null) {
            sql.SET("contact_email = #{contactEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getContactMessage() != null) {
            sql.SET("contact_message = #{contactMessage,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_contact
     *
     * @mbg.generated Fri May 11 10:30:55 CST 2018
     */
    protected void applyWhere(SQL sql, EshopContactCriteria example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}