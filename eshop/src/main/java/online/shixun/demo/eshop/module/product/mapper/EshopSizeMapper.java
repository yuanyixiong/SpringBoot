package online.shixun.demo.eshop.module.product.mapper;

import java.util.Collection;
import java.util.List;

import online.shixun.demo.eshop.dto.EshopSize;
import online.shixun.demo.eshop.dto.EshopSizeCriteria;
import online.shixun.demo.eshop.dto.EshopType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface EshopSizeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_size
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    @SelectProvider(type = EshopSizeSqlProvider.class, method = "countByExample")
    long countByExample(EshopSizeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_size
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    @DeleteProvider(type = EshopSizeSqlProvider.class, method = "deleteByExample")
    int deleteByExample(EshopSizeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_size
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    @Delete({
            "delete from eshop_size",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_size
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    @Insert({
            "insert into eshop_size (id, is_del, ",
            "create_time, update_time, ",
            "size_name, size_parent_id, ",
            "size_type)",
            "values (#{id,jdbcType=VARCHAR}, #{isDel,jdbcType=INTEGER}, ",
            "#{createTime,jdbcType=DATE}, #{updateTime,jdbcType=DATE}, ",
            "#{sizeName,jdbcType=VARCHAR}, #{sizeParentId,jdbcType=VARCHAR}, ",
            "#{sizeType,jdbcType=VARCHAR})"
    })
    int insert(EshopSize record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_size
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    @InsertProvider(type = EshopSizeSqlProvider.class, method = "insertSelective")
    int insertSelective(EshopSize record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_size
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    @SelectProvider(type = EshopSizeSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "is_del", property = "isDel", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.DATE),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.DATE),
            @Result(column = "size_name", property = "sizeName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "size_parent_id", property = "sizeParentId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "size_type", property = "sizeType", jdbcType = JdbcType.VARCHAR)
    })
    List<EshopSize> selectByExample(EshopSizeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_size
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    @Select({
            "select",
            "id, is_del, create_time, update_time, size_name, size_parent_id, size_type",
            "from eshop_size",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "is_del", property = "isDel", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.DATE),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.DATE),
            @Result(column = "size_name", property = "sizeName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "size_parent_id", property = "sizeParentId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "size_type", property = "sizeType", jdbcType = JdbcType.VARCHAR)
    })
    EshopSize selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_size
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    @UpdateProvider(type = EshopSizeSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EshopSize record, @Param("example") EshopSizeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_size
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    @UpdateProvider(type = EshopSizeSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") EshopSize record, @Param("example") EshopSizeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_size
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    @UpdateProvider(type = EshopSizeSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EshopSize record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_size
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    @Update({
            "update eshop_size",
            "set is_del = #{isDel,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=DATE},",
            "update_time = #{updateTime,jdbcType=DATE},",
            "size_name = #{sizeName,jdbcType=VARCHAR},",
            "size_parent_id = #{sizeParentId,jdbcType=VARCHAR},",
            "size_type = #{sizeType,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(EshopSize record);

    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "is_del", property = "isDel", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.DATE),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.DATE),
            @Result(column = "size_name", property = "sizeName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "size_parent_id", property = "sizeParentId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "size_type", property = "sizeType", jdbcType = JdbcType.VARCHAR)
    })
    @Select(value = {
            "<script>",
            "select * from eshop_size where is_del=2 ",
            "<foreach collection='list' index='index' item='item' open='and id in (' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "</script>"
    })
    List<EshopSize> getEshopSizesByIds(Collection<String> ids);


    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "is_del", property = "isDel", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.DATE),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.DATE),
            @Result(column = "size_name", property = "sizeName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "size_parent_id", property = "sizeParentId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "size_type", property = "sizeType", jdbcType = JdbcType.VARCHAR)
    })
    @Select(value = {
            "SELECT size.*",
            "FROM `eshop_size` size",
            "INNER JOIN `eshop_type_size` ts ON ts.`size_id`=size.`id` AND ts.type_id=#{id} AND size.is_del=2",
    })
    List<EshopSize> getSizes(EshopType eshopType);
}