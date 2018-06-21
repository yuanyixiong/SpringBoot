/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.system.dao;

import online.shixun.demo.eshopadmin.model.EshopResourceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository("eshopResourceDao")
public interface EshopResourceDao extends JpaRepository<EshopResourceModel, String> {

    @Query(value = "SELECT res.* FROM eshop_resource res INNER JOIN eshop_role_resource rr ON res.`id`=rr.`resource_id`WHERE rr.`role_id`= :roleId", nativeQuery = true)
    List<EshopResourceModel> findResourcesByRole(@Param("roleId") String roleId);

    @Query(value = "SELECT * FROM eshop_resource  WHERE id in ( :ids )", nativeQuery = true)
    List<EshopResourceModel> findResourcesByIds(@Param("ids") Collection<String> ids);

}