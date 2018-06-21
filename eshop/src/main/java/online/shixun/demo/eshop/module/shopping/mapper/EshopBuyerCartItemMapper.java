package online.shixun.demo.eshop.module.shopping.mapper;

import java.util.List;

import jdk.jfr.MemoryAddress;
import online.shixun.demo.eshop.dto.EshopBuyerCartItem;
import online.shixun.demo.eshop.dto.EshopBuyerCartItemCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface EshopBuyerCartItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart_item
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @SelectProvider(type=EshopBuyerCartItemSqlProvider.class, method="countByExample")
    long countByExample(EshopBuyerCartItemCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart_item
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @DeleteProvider(type=EshopBuyerCartItemSqlProvider.class, method="deleteByExample")
    int deleteByExample(EshopBuyerCartItemCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart_item
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @Delete({
        "delete from eshop_buyer_cart_item",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart_item
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @Insert({
        "insert into eshop_buyer_cart_item (id, is_del, ",
        "create_time, update_time, ",
        "product_id, sku_id, ",
        "amount, buyer_cart_id)",
        "values (#{id,jdbcType=VARCHAR}, #{isDel,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=DATE}, #{updateTime,jdbcType=DATE}, ",
        "#{productId,jdbcType=VARCHAR}, #{skuId,jdbcType=VARCHAR}, ",
        "#{amount,jdbcType=INTEGER}, #{buyerCartId,jdbcType=VARCHAR})"
    })
    int insert(EshopBuyerCartItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart_item
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @InsertProvider(type=EshopBuyerCartItemSqlProvider.class, method="insertSelective")
    int insertSelective(EshopBuyerCartItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart_item
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @SelectProvider(type=EshopBuyerCartItemSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_id", property="skuId", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="buyer_cart_id", property="buyerCartId", jdbcType=JdbcType.VARCHAR)
    })
    List<EshopBuyerCartItem> selectByExample(EshopBuyerCartItemCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart_item
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @Select({
        "select",
        "id, is_del, create_time, update_time, product_id, sku_id, amount, buyer_cart_id",
        "from eshop_buyer_cart_item",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_id", property="skuId", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="buyer_cart_id", property="buyerCartId", jdbcType=JdbcType.VARCHAR)
    })
    EshopBuyerCartItem selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart_item
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @UpdateProvider(type=EshopBuyerCartItemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EshopBuyerCartItem record, @Param("example") EshopBuyerCartItemCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart_item
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @UpdateProvider(type=EshopBuyerCartItemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EshopBuyerCartItem record, @Param("example") EshopBuyerCartItemCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart_item
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @UpdateProvider(type=EshopBuyerCartItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EshopBuyerCartItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart_item
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @Update({
        "update eshop_buyer_cart_item",
        "set is_del = #{isDel,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=DATE},",
          "update_time = #{updateTime,jdbcType=DATE},",
          "product_id = #{productId,jdbcType=VARCHAR},",
          "sku_id = #{skuId,jdbcType=VARCHAR},",
          "amount = #{amount,jdbcType=INTEGER},",
          "buyer_cart_id = #{buyerCartId,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(EshopBuyerCartItem record);

    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
            @Result(column="sku_id", property="skuId", jdbcType=JdbcType.VARCHAR),
            @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
            @Result(column="buyer_cart_id", property="buyerCartId", jdbcType=JdbcType.VARCHAR)
    })
    @Select(value = "select * from eshop_buyer_cart_item where buyer_cart_id=#{buyerCartId}")
    List<EshopBuyerCartItem> getEshopBuyerCartItemByBuyerCartId(@Param("buyerCartId") String buyerCartId);
}