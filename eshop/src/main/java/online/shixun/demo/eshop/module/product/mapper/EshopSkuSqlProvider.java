package online.shixun.demo.eshop.module.product.mapper;

import java.util.List;
import java.util.Map;
import online.shixun.demo.eshop.dto.EshopSku;
import online.shixun.demo.eshop.dto.EshopSkuCriteria.Criteria;
import online.shixun.demo.eshop.dto.EshopSkuCriteria.Criterion;
import online.shixun.demo.eshop.dto.EshopSkuCriteria;
import org.apache.ibatis.jdbc.SQL;

public class EshopSkuSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public String countByExample(EshopSkuCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("eshop_sku");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public String deleteByExample(EshopSkuCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("eshop_sku");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public String insertSelective(EshopSku record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("eshop_sku");
        
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
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=VARCHAR}");
        }
        
        if (record.getColorId() != null) {
            sql.VALUES("color_id", "#{colorId,jdbcType=VARCHAR}");
        }
        
        if (record.getSizeId() != null) {
            sql.VALUES("size_id", "#{sizeId,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuDeliveFee() != null) {
            sql.VALUES("sku_delive_fee", "#{skuDeliveFee,jdbcType=REAL}");
        }
        
        if (record.getSkuPrice() != null) {
            sql.VALUES("sku_price", "#{skuPrice,jdbcType=REAL}");
        }
        
        if (record.getSkuStock() != null) {
            sql.VALUES("sku_stock", "#{skuStock,jdbcType=INTEGER}");
        }
        
        if (record.getSkuMarketPrice() != null) {
            sql.VALUES("sku_market_price", "#{skuMarketPrice,jdbcType=REAL}");
        }
        
        if (record.getSkuSales() != null) {
            sql.VALUES("sku_sales", "#{skuSales,jdbcType=INTEGER}");
        }
        
        if (record.getSkuUpperLimit() != null) {
            sql.VALUES("sku_upper_limit", "#{skuUpperLimit,jdbcType=INTEGER}");
        }
        
        if (record.getSkuLocation() != null) {
            sql.VALUES("sku_location", "#{skuLocation,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuImg() != null) {
            sql.VALUES("sku_img", "#{skuImg,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuIndex() != null) {
            sql.VALUES("sku_index", "#{skuIndex,jdbcType=INTEGER}");
        }
        
        if (record.getSkuName() != null) {
            sql.VALUES("sku_name", "#{skuName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUserId() != null) {
            sql.VALUES("create_user_id", "#{createUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateUserId() != null) {
            sql.VALUES("update_user_id", "#{updateUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuStatus() != null) {
            sql.VALUES("sku_status", "#{skuStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSkuType() != null) {
            sql.VALUES("sku_type", "#{skuType,jdbcType=INTEGER}");
        }
        
        if (record.getSkuRank() != null) {
            sql.VALUES("sku_rank", "#{skuRank,jdbcType=REAL}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public String selectByExample(EshopSkuCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("is_del");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("product_id");
        sql.SELECT("color_id");
        sql.SELECT("size_id");
        sql.SELECT("sku_delive_fee");
        sql.SELECT("sku_price");
        sql.SELECT("sku_stock");
        sql.SELECT("sku_market_price");
        sql.SELECT("sku_sales");
        sql.SELECT("sku_upper_limit");
        sql.SELECT("sku_location");
        sql.SELECT("sku_img");
        sql.SELECT("sku_index");
        sql.SELECT("sku_name");
        sql.SELECT("create_user_id");
        sql.SELECT("update_user_id");
        sql.SELECT("sku_status");
        sql.SELECT("sku_type");
        sql.SELECT("sku_rank");
        sql.FROM("eshop_sku");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        EshopSku record = (EshopSku) parameter.get("record");
        EshopSkuCriteria example = (EshopSkuCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("eshop_sku");
        
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
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{record.productId,jdbcType=VARCHAR}");
        }
        
        if (record.getColorId() != null) {
            sql.SET("color_id = #{record.colorId,jdbcType=VARCHAR}");
        }
        
        if (record.getSizeId() != null) {
            sql.SET("size_id = #{record.sizeId,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuDeliveFee() != null) {
            sql.SET("sku_delive_fee = #{record.skuDeliveFee,jdbcType=REAL}");
        }
        
        if (record.getSkuPrice() != null) {
            sql.SET("sku_price = #{record.skuPrice,jdbcType=REAL}");
        }
        
        if (record.getSkuStock() != null) {
            sql.SET("sku_stock = #{record.skuStock,jdbcType=INTEGER}");
        }
        
        if (record.getSkuMarketPrice() != null) {
            sql.SET("sku_market_price = #{record.skuMarketPrice,jdbcType=REAL}");
        }
        
        if (record.getSkuSales() != null) {
            sql.SET("sku_sales = #{record.skuSales,jdbcType=INTEGER}");
        }
        
        if (record.getSkuUpperLimit() != null) {
            sql.SET("sku_upper_limit = #{record.skuUpperLimit,jdbcType=INTEGER}");
        }
        
        if (record.getSkuLocation() != null) {
            sql.SET("sku_location = #{record.skuLocation,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuImg() != null) {
            sql.SET("sku_img = #{record.skuImg,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuIndex() != null) {
            sql.SET("sku_index = #{record.skuIndex,jdbcType=INTEGER}");
        }
        
        if (record.getSkuName() != null) {
            sql.SET("sku_name = #{record.skuName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUserId() != null) {
            sql.SET("create_user_id = #{record.createUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateUserId() != null) {
            sql.SET("update_user_id = #{record.updateUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuStatus() != null) {
            sql.SET("sku_status = #{record.skuStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSkuType() != null) {
            sql.SET("sku_type = #{record.skuType,jdbcType=INTEGER}");
        }
        
        if (record.getSkuRank() != null) {
            sql.SET("sku_rank = #{record.skuRank,jdbcType=REAL}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("eshop_sku");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("is_del = #{record.isDel,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=DATE}");
        sql.SET("update_time = #{record.updateTime,jdbcType=DATE}");
        sql.SET("product_id = #{record.productId,jdbcType=VARCHAR}");
        sql.SET("color_id = #{record.colorId,jdbcType=VARCHAR}");
        sql.SET("size_id = #{record.sizeId,jdbcType=VARCHAR}");
        sql.SET("sku_delive_fee = #{record.skuDeliveFee,jdbcType=REAL}");
        sql.SET("sku_price = #{record.skuPrice,jdbcType=REAL}");
        sql.SET("sku_stock = #{record.skuStock,jdbcType=INTEGER}");
        sql.SET("sku_market_price = #{record.skuMarketPrice,jdbcType=REAL}");
        sql.SET("sku_sales = #{record.skuSales,jdbcType=INTEGER}");
        sql.SET("sku_upper_limit = #{record.skuUpperLimit,jdbcType=INTEGER}");
        sql.SET("sku_location = #{record.skuLocation,jdbcType=VARCHAR}");
        sql.SET("sku_img = #{record.skuImg,jdbcType=VARCHAR}");
        sql.SET("sku_index = #{record.skuIndex,jdbcType=INTEGER}");
        sql.SET("sku_name = #{record.skuName,jdbcType=VARCHAR}");
        sql.SET("create_user_id = #{record.createUserId,jdbcType=VARCHAR}");
        sql.SET("update_user_id = #{record.updateUserId,jdbcType=VARCHAR}");
        sql.SET("sku_status = #{record.skuStatus,jdbcType=INTEGER}");
        sql.SET("sku_type = #{record.skuType,jdbcType=INTEGER}");
        sql.SET("sku_rank = #{record.skuRank,jdbcType=REAL}");
        
        EshopSkuCriteria example = (EshopSkuCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public String updateByPrimaryKeySelective(EshopSku record) {
        SQL sql = new SQL();
        sql.UPDATE("eshop_sku");
        
        if (record.getIsDel() != null) {
            sql.SET("is_del = #{isDel,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=DATE}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=DATE}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=VARCHAR}");
        }
        
        if (record.getColorId() != null) {
            sql.SET("color_id = #{colorId,jdbcType=VARCHAR}");
        }
        
        if (record.getSizeId() != null) {
            sql.SET("size_id = #{sizeId,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuDeliveFee() != null) {
            sql.SET("sku_delive_fee = #{skuDeliveFee,jdbcType=REAL}");
        }
        
        if (record.getSkuPrice() != null) {
            sql.SET("sku_price = #{skuPrice,jdbcType=REAL}");
        }
        
        if (record.getSkuStock() != null) {
            sql.SET("sku_stock = #{skuStock,jdbcType=INTEGER}");
        }
        
        if (record.getSkuMarketPrice() != null) {
            sql.SET("sku_market_price = #{skuMarketPrice,jdbcType=REAL}");
        }
        
        if (record.getSkuSales() != null) {
            sql.SET("sku_sales = #{skuSales,jdbcType=INTEGER}");
        }
        
        if (record.getSkuUpperLimit() != null) {
            sql.SET("sku_upper_limit = #{skuUpperLimit,jdbcType=INTEGER}");
        }
        
        if (record.getSkuLocation() != null) {
            sql.SET("sku_location = #{skuLocation,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuImg() != null) {
            sql.SET("sku_img = #{skuImg,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuIndex() != null) {
            sql.SET("sku_index = #{skuIndex,jdbcType=INTEGER}");
        }
        
        if (record.getSkuName() != null) {
            sql.SET("sku_name = #{skuName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUserId() != null) {
            sql.SET("create_user_id = #{createUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateUserId() != null) {
            sql.SET("update_user_id = #{updateUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuStatus() != null) {
            sql.SET("sku_status = #{skuStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSkuType() != null) {
            sql.SET("sku_type = #{skuType,jdbcType=INTEGER}");
        }
        
        if (record.getSkuRank() != null) {
            sql.SET("sku_rank = #{skuRank,jdbcType=REAL}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    protected void applyWhere(SQL sql, EshopSkuCriteria example, boolean includeExamplePhrase) {
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