package online.shixun.demo.eshop.module.user.mapper;

import java.util.List;
import online.shixun.demo.eshop.dto.EshopUser;
import online.shixun.demo.eshop.dto.EshopUserCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface EshopUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_user
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    @SelectProvider(type=EshopUserSqlProvider.class, method="countByExample")
    long countByExample(EshopUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_user
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    @DeleteProvider(type=EshopUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(EshopUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_user
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    @Delete({
        "delete from eshop_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_user
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    @Insert({
        "insert into eshop_user (id, is_del, ",
        "create_time, update_time, ",
        "user_email, user_login_name, ",
        "user_nicak_name, user_password, ",
        "user_real_name, user_gender, ",
        "user_description, user_image)",
        "values (#{id,jdbcType=VARCHAR}, #{isDel,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=DATE}, #{updateTime,jdbcType=DATE}, ",
        "#{userEmail,jdbcType=VARCHAR}, #{userLoginName,jdbcType=VARCHAR}, ",
        "#{userNicakName,jdbcType=VARCHAR}, #{userPassword,jdbcType=VARCHAR}, ",
        "#{userRealName,jdbcType=VARCHAR}, #{userGender,jdbcType=INTEGER}, ",
        "#{userDescription,jdbcType=VARCHAR}, #{userImage,jdbcType=VARCHAR})"
    })
    int insert(EshopUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_user
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    @InsertProvider(type=EshopUserSqlProvider.class, method="insertSelective")
    int insertSelective(EshopUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_user
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    @SelectProvider(type=EshopUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="user_email", property="userEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_login_name", property="userLoginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_nicak_name", property="userNicakName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_real_name", property="userRealName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_gender", property="userGender", jdbcType=JdbcType.INTEGER),
        @Result(column="user_description", property="userDescription", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_image", property="userImage", jdbcType=JdbcType.VARCHAR)
    })
    List<EshopUser> selectByExample(EshopUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_user
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    @Select({
        "select",
        "id, is_del, create_time, update_time, user_email, user_login_name, user_nicak_name, ",
        "user_password, user_real_name, user_gender, user_description, user_image",
        "from eshop_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="user_email", property="userEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_login_name", property="userLoginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_nicak_name", property="userNicakName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_real_name", property="userRealName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_gender", property="userGender", jdbcType=JdbcType.INTEGER),
        @Result(column="user_description", property="userDescription", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_image", property="userImage", jdbcType=JdbcType.VARCHAR)
    })
    EshopUser selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_user
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    @UpdateProvider(type=EshopUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EshopUser record, @Param("example") EshopUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_user
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    @UpdateProvider(type=EshopUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EshopUser record, @Param("example") EshopUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_user
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    @UpdateProvider(type=EshopUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EshopUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_user
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    @Update({
        "update eshop_user",
        "set is_del = #{isDel,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=DATE},",
          "update_time = #{updateTime,jdbcType=DATE},",
          "user_email = #{userEmail,jdbcType=VARCHAR},",
          "user_login_name = #{userLoginName,jdbcType=VARCHAR},",
          "user_nicak_name = #{userNicakName,jdbcType=VARCHAR},",
          "user_password = #{userPassword,jdbcType=VARCHAR},",
          "user_real_name = #{userRealName,jdbcType=VARCHAR},",
          "user_gender = #{userGender,jdbcType=INTEGER},",
          "user_description = #{userDescription,jdbcType=VARCHAR},",
          "user_image = #{userImage,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(EshopUser record);
}