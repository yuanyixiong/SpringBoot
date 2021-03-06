package online.shixun.demo.eshop.module.product.mapper;

import java.util.Collection;
import java.util.List;
import online.shixun.demo.eshop.dto.EshopColor;
import online.shixun.demo.eshop.dto.EshopColorCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface EshopColorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_color
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @SelectProvider(type=EshopColorSqlProvider.class, method="countByExample")
    long countByExample(EshopColorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_color
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @DeleteProvider(type=EshopColorSqlProvider.class, method="deleteByExample")
    int deleteByExample(EshopColorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_color
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @Delete({
        "delete from eshop_color",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_color
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @Insert({
        "insert into eshop_color (id, is_del, ",
        "create_time, update_time, ",
        "color_name, color_parent_id, ",
        "color_img_url)",
        "values (#{id,jdbcType=VARCHAR}, #{isDel,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=DATE}, #{updateTime,jdbcType=DATE}, ",
        "#{colorName,jdbcType=VARCHAR}, #{colorParentId,jdbcType=VARCHAR}, ",
        "#{colorImgUrl,jdbcType=VARCHAR})"
    })
    int insert(EshopColor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_color
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @InsertProvider(type=EshopColorSqlProvider.class, method="insertSelective")
    int insertSelective(EshopColor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_color
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @SelectProvider(type=EshopColorSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="color_name", property="colorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="color_parent_id", property="colorParentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="color_img_url", property="colorImgUrl", jdbcType=JdbcType.VARCHAR)
    })
    List<EshopColor> selectByExample(EshopColorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_color
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @Select({
        "select",
        "id, is_del, create_time, update_time, color_name, color_parent_id, color_img_url",
        "from eshop_color",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="color_name", property="colorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="color_parent_id", property="colorParentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="color_img_url", property="colorImgUrl", jdbcType=JdbcType.VARCHAR)
    })
    EshopColor selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_color
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @UpdateProvider(type=EshopColorSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EshopColor record, @Param("example") EshopColorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_color
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @UpdateProvider(type=EshopColorSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EshopColor record, @Param("example") EshopColorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_color
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @UpdateProvider(type=EshopColorSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EshopColor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_color
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    @Update({
        "update eshop_color",
        "set is_del = #{isDel,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=DATE},",
          "update_time = #{updateTime,jdbcType=DATE},",
          "color_name = #{colorName,jdbcType=VARCHAR},",
          "color_parent_id = #{colorParentId,jdbcType=VARCHAR},",
          "color_img_url = #{colorImgUrl,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(EshopColor record);

    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "is_del", property = "isDel", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.DATE),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.DATE),
            @Result(column = "color_name", property = "colorName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "color_parent_id", property = "colorParentId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "color_img_url", property = "colorImgUrl", jdbcType = JdbcType.VARCHAR)
    })
    @Select(value = {
            "<script>",
            "select * from eshop_color where is_del=2 ",
            "<foreach collection='list' index='index' item='item' open='and id in (' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "</script>"
    })
    List<EshopColor> getEshopColorsByIds(Collection<String> ids);
}