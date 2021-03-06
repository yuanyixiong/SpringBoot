package online.shixun.demo.eshop.module.collect.mapper;

import java.util.List;
import online.shixun.demo.eshop.dto.EshopCollectItem;
import online.shixun.demo.eshop.dto.EshopCollectItemCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface EshopCollectItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_collect_item
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    @SelectProvider(type=EshopCollectItemSqlProvider.class, method="countByExample")
    long countByExample(EshopCollectItemCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_collect_item
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    @DeleteProvider(type=EshopCollectItemSqlProvider.class, method="deleteByExample")
    int deleteByExample(EshopCollectItemCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_collect_item
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    @Delete({
        "delete from eshop_collect_item",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_collect_item
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    @Insert({
        "insert into eshop_collect_item (id, collect_id, ",
        "product_id, color_id, ",
        "size_id, is_del, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=VARCHAR}, #{collectId,jdbcType=VARCHAR}, ",
        "#{productId,jdbcType=VARCHAR}, #{colorId,jdbcType=VARCHAR}, ",
        "#{sizeId,jdbcType=VARCHAR}, #{isDel,jdbcType=INTEGER}, #{createTime,jdbcType=DATE}, ",
        "#{updateTime,jdbcType=DATE})"
    })
    int insert(EshopCollectItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_collect_item
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    @InsertProvider(type=EshopCollectItemSqlProvider.class, method="insertSelective")
    int insertSelective(EshopCollectItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_collect_item
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    @SelectProvider(type=EshopCollectItemSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="collect_id", property="collectId", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="color_id", property="colorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="size_id", property="sizeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE)
    })
    List<EshopCollectItem> selectByExample(EshopCollectItemCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_collect_item
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    @Select({
        "select",
        "id, collect_id, product_id, color_id, size_id, is_del, create_time, update_time",
        "from eshop_collect_item",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="collect_id", property="collectId", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="color_id", property="colorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="size_id", property="sizeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE)
    })
    EshopCollectItem selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_collect_item
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    @UpdateProvider(type=EshopCollectItemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EshopCollectItem record, @Param("example") EshopCollectItemCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_collect_item
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    @UpdateProvider(type=EshopCollectItemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EshopCollectItem record, @Param("example") EshopCollectItemCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_collect_item
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    @UpdateProvider(type=EshopCollectItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EshopCollectItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_collect_item
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    @Update({
        "update eshop_collect_item",
        "set collect_id = #{collectId,jdbcType=VARCHAR},",
          "product_id = #{productId,jdbcType=VARCHAR},",
          "color_id = #{colorId,jdbcType=VARCHAR},",
          "size_id = #{sizeId,jdbcType=VARCHAR},",
          "is_del = #{isDel,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=DATE},",
          "update_time = #{updateTime,jdbcType=DATE}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(EshopCollectItem record);

    @ResultType(EshopCollectItem.class)
    @ResultMap("collectItemBaseResultMap")
    List<EshopCollectItem> getCollectItems(EshopCollectItem collectItem);


    @Insert(value = {
            "INSERT INTO `eshop_collect_item`(`id`,`product_id`,`color_id`,`size_id`,`collect_id`,`is_del`,`create_time`,`update_time`)",
            "SELECT",
            "REPLACE(UUID(),'-','') AS id,",
            "sku.`product_id`  AS product_id,",
            "sku.`color_id` AS color_id,",
            "sku.`size_id` AS size_id,",
            "#{collect_id} AS collect_id,",
            "2,SYSDATE(),SYSDATE()",
            " FROM",
            "`eshop_sku` sku",
            "WHERE sku.id=#{skuId}",
    })
    int addCollectItem(@Param("skuId") String skuId, @Param("collect_id") String collect_id);
}