/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.system.dao;

import online.shixun.demo.eshopadmin.model.EshopRoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository("eshopRoleDao")
public interface EshopRoleDao extends JpaRepository<EshopRoleModel, String> {

    @Query(value = "SELECT r.* FROM `eshop_role` r INNER JOIN  `eshop_user_role` u ON u.`role_id`=r.`id` WHERE u.`user_id`= :userId", nativeQuery = true)
    List<EshopRoleModel> findRolesByUserId(@Param("userId") String userId);

    @Query(value = "SELECT * FROM eshop_role WHERE id in ( :ids )", nativeQuery = true)
    List<EshopRoleModel> findRolesByIds(@Param("ids") Collection<String> ids);
}