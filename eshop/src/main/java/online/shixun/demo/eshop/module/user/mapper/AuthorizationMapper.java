/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.user.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName AuthorizationMapper
 * @Description TODO
 * @Date 2018/05/11 13:45
 * @Author shixun.online
 * @Version 1.0
 **/
@Mapper
public interface AuthorizationMapper {

    /**
     * 授权
     *
     * @param userId 授权用户编号
     * @param roleId 授予权限编号
     */
    @Insert(value = "INSERT INTO `eshop_user_role`(`user_id`,`role_id`) VALUES(#{userId},#{roleId})")
    int authorization(@Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * 撤销授权
     *
     * @param userId 撤销用户编号
     * @param roleId 撤销权限编号
     */
    @Delete(value = "DELETE FROM eshop_user_role WHERE `user_id`=#{userId} AND `role_id`=#{roleId}")
    int uauthorization(@Param("userId") String userId, @Param("roleId") String roleId);
}
