package online.shixun.demo.eshop.module.product.mapper;

import java.util.List;
import online.shixun.demo.eshop.dto.EshopSku;
import online.shixun.demo.eshop.dto.EshopSkuCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface EshopSkuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @SelectProvider(type=EshopSkuSqlProvider.class, method="countByExample")
    long countByExample(EshopSkuCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @DeleteProvider(type=EshopSkuSqlProvider.class, method="deleteByExample")
    int deleteByExample(EshopSkuCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @Delete({
        "delete from eshop_sku",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @Insert({
        "insert into eshop_sku (id, is_del, ",
        "create_time, update_time, ",
        "product_id, color_id, ",
        "size_id, sku_delive_fee, ",
        "sku_price, sku_stock, ",
        "sku_market_price, sku_sales, ",
        "sku_upper_limit, sku_location, ",
        "sku_img, sku_index, ",
        "sku_name, create_user_id, ",
        "update_user_id, sku_status, ",
        "sku_type, sku_rank)",
        "values (#{id,jdbcType=VARCHAR}, #{isDel,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=DATE}, #{updateTime,jdbcType=DATE}, ",
        "#{productId,jdbcType=VARCHAR}, #{colorId,jdbcType=VARCHAR}, ",
        "#{sizeId,jdbcType=VARCHAR}, #{skuDeliveFee,jdbcType=REAL}, ",
        "#{skuPrice,jdbcType=REAL}, #{skuStock,jdbcType=INTEGER}, ",
        "#{skuMarketPrice,jdbcType=REAL}, #{skuSales,jdbcType=INTEGER}, ",
        "#{skuUpperLimit,jdbcType=INTEGER}, #{skuLocation,jdbcType=VARCHAR}, ",
        "#{skuImg,jdbcType=VARCHAR}, #{skuIndex,jdbcType=INTEGER}, ",
        "#{skuName,jdbcType=VARCHAR}, #{createUserId,jdbcType=VARCHAR}, ",
        "#{updateUserId,jdbcType=VARCHAR}, #{skuStatus,jdbcType=INTEGER}, ",
        "#{skuType,jdbcType=INTEGER}, #{skuRank,jdbcType=REAL})"
    })
    int insert(EshopSku record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @InsertProvider(type=EshopSkuSqlProvider.class, method="insertSelective")
    int insertSelective(EshopSku record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @SelectProvider(type=EshopSkuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="color_id", property="colorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="size_id", property="sizeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_delive_fee", property="skuDeliveFee", jdbcType=JdbcType.REAL),
        @Result(column="sku_price", property="skuPrice", jdbcType=JdbcType.REAL),
        @Result(column="sku_stock", property="skuStock", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_market_price", property="skuMarketPrice", jdbcType=JdbcType.REAL),
        @Result(column="sku_sales", property="skuSales", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_upper_limit", property="skuUpperLimit", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_location", property="skuLocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_img", property="skuImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_index", property="skuIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_name", property="skuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user_id", property="updateUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_status", property="skuStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_type", property="skuType", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_rank", property="skuRank", jdbcType=JdbcType.REAL)
    })
    List<EshopSku> selectByExample(EshopSkuCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @Select({
        "select",
        "id, is_del, create_time, update_time, product_id, color_id, size_id, sku_delive_fee, ",
        "sku_price, sku_stock, sku_market_price, sku_sales, sku_upper_limit, sku_location, ",
        "sku_img, sku_index, sku_name, create_user_id, update_user_id, sku_status, sku_type, ",
        "sku_rank",
        "from eshop_sku",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="color_id", property="colorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="size_id", property="sizeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_delive_fee", property="skuDeliveFee", jdbcType=JdbcType.REAL),
        @Result(column="sku_price", property="skuPrice", jdbcType=JdbcType.REAL),
        @Result(column="sku_stock", property="skuStock", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_market_price", property="skuMarketPrice", jdbcType=JdbcType.REAL),
        @Result(column="sku_sales", property="skuSales", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_upper_limit", property="skuUpperLimit", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_location", property="skuLocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_img", property="skuImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_index", property="skuIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_name", property="skuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user_id", property="updateUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_status", property="skuStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_type", property="skuType", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_rank", property="skuRank", jdbcType=JdbcType.REAL)
    })
    EshopSku selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @UpdateProvider(type=EshopSkuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EshopSku record, @Param("example") EshopSkuCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @UpdateProvider(type=EshopSkuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EshopSku record, @Param("example") EshopSkuCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @UpdateProvider(type=EshopSkuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EshopSku record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_sku
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @Update({
        "update eshop_sku",
        "set is_del = #{isDel,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=DATE},",
          "update_time = #{updateTime,jdbcType=DATE},",
          "product_id = #{productId,jdbcType=VARCHAR},",
          "color_id = #{colorId,jdbcType=VARCHAR},",
          "size_id = #{sizeId,jdbcType=VARCHAR},",
          "sku_delive_fee = #{skuDeliveFee,jdbcType=REAL},",
          "sku_price = #{skuPrice,jdbcType=REAL},",
          "sku_stock = #{skuStock,jdbcType=INTEGER},",
          "sku_market_price = #{skuMarketPrice,jdbcType=REAL},",
          "sku_sales = #{skuSales,jdbcType=INTEGER},",
          "sku_upper_limit = #{skuUpperLimit,jdbcType=INTEGER},",
          "sku_location = #{skuLocation,jdbcType=VARCHAR},",
          "sku_img = #{skuImg,jdbcType=VARCHAR},",
          "sku_index = #{skuIndex,jdbcType=INTEGER},",
          "sku_name = #{skuName,jdbcType=VARCHAR},",
          "create_user_id = #{createUserId,jdbcType=VARCHAR},",
          "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
          "sku_status = #{skuStatus,jdbcType=INTEGER},",
          "sku_type = #{skuType,jdbcType=INTEGER},",
          "sku_rank = #{skuRank,jdbcType=REAL}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(EshopSku record);
}