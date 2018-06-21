package online.shixun.demo.eshop.module.order.mapper;

import java.util.List;
import online.shixun.demo.eshop.dto.EshopOrder;
import online.shixun.demo.eshop.dto.EshopOrderCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface EshopOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_order
     *
     * @mbg.generated Thu May 17 15:54:17 CST 2018
     */
    @SelectProvider(type=EshopOrderSqlProvider.class, method="countByExample")
    long countByExample(EshopOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_order
     *
     * @mbg.generated Thu May 17 15:54:17 CST 2018
     */
    @DeleteProvider(type=EshopOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(EshopOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_order
     *
     * @mbg.generated Thu May 17 15:54:17 CST 2018
     */
    @Delete({
        "delete from eshop_order",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_order
     *
     * @mbg.generated Thu May 17 15:54:17 CST 2018
     */
    @Insert({
        "insert into eshop_order (id, is_del, ",
        "create_time, update_time, ",
        "user_id, address_id, ",
        "order_deliver_fee, order_total_fee, ",
        "order_price, order_payment_way, ",
        "order_payment_cash, order_is_paiy, ",
        "order_state, order_recipients)",
        "values (#{id,jdbcType=VARCHAR}, #{isDel,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=DATE}, #{updateTime,jdbcType=DATE}, ",
        "#{userId,jdbcType=VARCHAR}, #{addressId,jdbcType=VARCHAR}, ",
        "#{orderDeliverFee,jdbcType=REAL}, #{orderTotalFee,jdbcType=REAL}, ",
        "#{orderPrice,jdbcType=REAL}, #{orderPaymentWay,jdbcType=INTEGER}, ",
        "#{orderPaymentCash,jdbcType=INTEGER}, #{orderIsPaiy,jdbcType=INTEGER}, ",
        "#{orderState,jdbcType=INTEGER}, #{orderRecipients,jdbcType=VARCHAR})"
    })
    int insert(EshopOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_order
     *
     * @mbg.generated Thu May 17 15:54:17 CST 2018
     */
    @InsertProvider(type=EshopOrderSqlProvider.class, method="insertSelective")
    int insertSelective(EshopOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_order
     *
     * @mbg.generated Thu May 17 15:54:17 CST 2018
     */
    @SelectProvider(type=EshopOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_deliver_fee", property="orderDeliverFee", jdbcType=JdbcType.REAL),
        @Result(column="order_total_fee", property="orderTotalFee", jdbcType=JdbcType.REAL),
        @Result(column="order_price", property="orderPrice", jdbcType=JdbcType.REAL),
        @Result(column="order_payment_way", property="orderPaymentWay", jdbcType=JdbcType.INTEGER),
        @Result(column="order_payment_cash", property="orderPaymentCash", jdbcType=JdbcType.INTEGER),
        @Result(column="order_is_paiy", property="orderIsPaiy", jdbcType=JdbcType.INTEGER),
        @Result(column="order_state", property="orderState", jdbcType=JdbcType.INTEGER),
        @Result(column="order_recipients", property="orderRecipients", jdbcType=JdbcType.VARCHAR)
    })
    List<EshopOrder> selectByExample(EshopOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_order
     *
     * @mbg.generated Thu May 17 15:54:17 CST 2018
     */
    @Select({
        "select",
        "id, is_del, create_time, update_time, user_id, address_id, order_deliver_fee, ",
        "order_total_fee, order_price, order_payment_way, order_payment_cash, order_is_paiy, ",
        "order_state, order_recipients",
        "from eshop_order",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_deliver_fee", property="orderDeliverFee", jdbcType=JdbcType.REAL),
        @Result(column="order_total_fee", property="orderTotalFee", jdbcType=JdbcType.REAL),
        @Result(column="order_price", property="orderPrice", jdbcType=JdbcType.REAL),
        @Result(column="order_payment_way", property="orderPaymentWay", jdbcType=JdbcType.INTEGER),
        @Result(column="order_payment_cash", property="orderPaymentCash", jdbcType=JdbcType.INTEGER),
        @Result(column="order_is_paiy", property="orderIsPaiy", jdbcType=JdbcType.INTEGER),
        @Result(column="order_state", property="orderState", jdbcType=JdbcType.INTEGER),
        @Result(column="order_recipients", property="orderRecipients", jdbcType=JdbcType.VARCHAR)
    })
    EshopOrder selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_order
     *
     * @mbg.generated Thu May 17 15:54:17 CST 2018
     */
    @UpdateProvider(type=EshopOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EshopOrder record, @Param("example") EshopOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_order
     *
     * @mbg.generated Thu May 17 15:54:17 CST 2018
     */
    @UpdateProvider(type=EshopOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EshopOrder record, @Param("example") EshopOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_order
     *
     * @mbg.generated Thu May 17 15:54:17 CST 2018
     */
    @UpdateProvider(type=EshopOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EshopOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_order
     *
     * @mbg.generated Thu May 17 15:54:17 CST 2018
     */
    @Update({
        "update eshop_order",
        "set is_del = #{isDel,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=DATE},",
          "update_time = #{updateTime,jdbcType=DATE},",
          "user_id = #{userId,jdbcType=VARCHAR},",
          "address_id = #{addressId,jdbcType=VARCHAR},",
          "order_deliver_fee = #{orderDeliverFee,jdbcType=REAL},",
          "order_total_fee = #{orderTotalFee,jdbcType=REAL},",
          "order_price = #{orderPrice,jdbcType=REAL},",
          "order_payment_way = #{orderPaymentWay,jdbcType=INTEGER},",
          "order_payment_cash = #{orderPaymentCash,jdbcType=INTEGER},",
          "order_is_paiy = #{orderIsPaiy,jdbcType=INTEGER},",
          "order_state = #{orderState,jdbcType=INTEGER},",
          "order_recipients = #{orderRecipients,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(EshopOrder record);
}