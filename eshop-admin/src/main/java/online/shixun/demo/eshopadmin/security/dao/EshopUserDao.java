/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.security.dao;

import online.shixun.demo.eshopadmin.model.EshopUserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("securityUserDao")
public interface EshopUserDao extends org.springframework.data.repository.Repository<EshopUserModel, String> {

    /**
     * 根据登入的用户名查询用户
     *
     * @param userLoginName
     * @return
     */
    @Query(value = "select * from eshop_user where user_login_name=:userLoginName and is_del=2", nativeQuery = true)
    EshopUserModel findUser(@Param("userLoginName") String userLoginName);


}
