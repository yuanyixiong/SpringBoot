/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.type.dao;

import online.shixun.demo.eshopadmin.model.EshopTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("eshopTypeDao")
public interface EshopTypeDao extends JpaRepository<EshopTypeModel, String> {

    @Query(value = "select * from eshop_type where type_parent_id=:id  ", nativeQuery = true)
    List<EshopTypeModel> findChildren(@Param("id") String id);
}
