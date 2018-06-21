/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.security.dao;

import online.shixun.demo.eshopadmin.model.EshopResourceModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("securityResourceDao")
public interface EshopResourceDao extends CrudRepository<EshopResourceModel, String> {

    @Query(value = "select * from eshop_resource where resource_parent_id=:resourceId and is_del=2", nativeQuery = true)
    List<EshopResourceModel> findChildren(@Param("resourceId") String resourceId);



}