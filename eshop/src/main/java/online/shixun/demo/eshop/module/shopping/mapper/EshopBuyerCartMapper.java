package online.shixun.demo.eshop.module.shopping.mapper;

import java.util.List;
import online.shixun.demo.eshop.dto.EshopBuyerCart;
import online.shixun.demo.eshop.dto.EshopBuyerCartCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface EshopBuyerCartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @SelectProvider(type=EshopBuyerCartSqlProvider.class, method="countByExample")
    long countByExample(EshopBuyerCartCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @DeleteProvider(type=EshopBuyerCartSqlProvider.class, method="deleteByExample")
    int deleteByExample(EshopBuyerCartCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @Delete({
        "delete from eshop_buyer_cart",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @Insert({
        "insert into eshop_buyer_cart (id, is_del, ",
        "create_time, update_time, ",
        "user_id)",
        "values (#{id,jdbcType=VARCHAR}, #{isDel,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=DATE}, #{updateTime,jdbcType=DATE}, ",
        "#{userId,jdbcType=VARCHAR})"
    })
    int insert(EshopBuyerCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @InsertProvider(type=EshopBuyerCartSqlProvider.class, method="insertSelective")
    int insertSelective(EshopBuyerCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @SelectProvider(type=EshopBuyerCartSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR)
    })
    List<EshopBuyerCart> selectByExample(EshopBuyerCartCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @Select({
        "select",
        "id, is_del, create_time, update_time, user_id",
        "from eshop_buyer_cart",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR)
    })
    EshopBuyerCart selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @UpdateProvider(type=EshopBuyerCartSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EshopBuyerCart record, @Param("example") EshopBuyerCartCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @UpdateProvider(type=EshopBuyerCartSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EshopBuyerCart record, @Param("example") EshopBuyerCartCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @UpdateProvider(type=EshopBuyerCartSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EshopBuyerCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_buyer_cart
     *
     * @mbg.generated Wed May 23 17:20:31 CST 2018
     */
    @Update({
        "update eshop_buyer_cart",
        "set is_del = #{isDel,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=DATE},",
          "update_time = #{updateTime,jdbcType=DATE},",
          "user_id = #{userId,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(EshopBuyerCart record);
}