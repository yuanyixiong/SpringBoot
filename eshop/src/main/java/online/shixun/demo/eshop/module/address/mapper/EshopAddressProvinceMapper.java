package online.shixun.demo.eshop.module.address.mapper;

import java.util.List;
import online.shixun.demo.eshop.dto.EshopAddressProvince;
import online.shixun.demo.eshop.dto.EshopAddressProvinceCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface EshopAddressProvinceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_address_province
     *
     * @mbg.generated Wed May 16 14:28:20 CST 2018
     */
    @SelectProvider(type=EshopAddressProvinceSqlProvider.class, method="countByExample")
    long countByExample(EshopAddressProvinceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_address_province
     *
     * @mbg.generated Wed May 16 14:28:20 CST 2018
     */
    @DeleteProvider(type=EshopAddressProvinceSqlProvider.class, method="deleteByExample")
    int deleteByExample(EshopAddressProvinceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_address_province
     *
     * @mbg.generated Wed May 16 14:28:20 CST 2018
     */
    @Delete({
        "delete from eshop_address_province",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_address_province
     *
     * @mbg.generated Wed May 16 14:28:20 CST 2018
     */
    @Insert({
        "insert into eshop_address_province (id, is_del, ",
        "create_time, update_time, ",
        "code, name, state_code)",
        "values (#{id,jdbcType=VARCHAR}, #{isDel,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=DATE}, #{updateTime,jdbcType=DATE}, ",
        "#{code,jdbcType=CHAR}, #{name,jdbcType=VARCHAR}, #{stateCode,jdbcType=CHAR})"
    })
    int insert(EshopAddressProvince record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_address_province
     *
     * @mbg.generated Wed May 16 14:28:20 CST 2018
     */
    @InsertProvider(type=EshopAddressProvinceSqlProvider.class, method="insertSelective")
    int insertSelective(EshopAddressProvince record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_address_province
     *
     * @mbg.generated Wed May 16 14:28:20 CST 2018
     */
    @SelectProvider(type=EshopAddressProvinceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="code", property="code", jdbcType=JdbcType.CHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="state_code", property="stateCode", jdbcType=JdbcType.CHAR)
    })
    List<EshopAddressProvince> selectByExample(EshopAddressProvinceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_address_province
     *
     * @mbg.generated Wed May 16 14:28:20 CST 2018
     */
    @Select({
        "select",
        "id, is_del, create_time, update_time, code, name, state_code",
        "from eshop_address_province",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="code", property="code", jdbcType=JdbcType.CHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="state_code", property="stateCode", jdbcType=JdbcType.CHAR)
    })
    EshopAddressProvince selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_address_province
     *
     * @mbg.generated Wed May 16 14:28:20 CST 2018
     */
    @UpdateProvider(type=EshopAddressProvinceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EshopAddressProvince record, @Param("example") EshopAddressProvinceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_address_province
     *
     * @mbg.generated Wed May 16 14:28:20 CST 2018
     */
    @UpdateProvider(type=EshopAddressProvinceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EshopAddressProvince record, @Param("example") EshopAddressProvinceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_address_province
     *
     * @mbg.generated Wed May 16 14:28:20 CST 2018
     */
    @UpdateProvider(type=EshopAddressProvinceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EshopAddressProvince record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_address_province
     *
     * @mbg.generated Wed May 16 14:28:20 CST 2018
     */
    @Update({
        "update eshop_address_province",
        "set is_del = #{isDel,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=DATE},",
          "update_time = #{updateTime,jdbcType=DATE},",
          "code = #{code,jdbcType=CHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "state_code = #{stateCode,jdbcType=CHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(EshopAddressProvince record);
}