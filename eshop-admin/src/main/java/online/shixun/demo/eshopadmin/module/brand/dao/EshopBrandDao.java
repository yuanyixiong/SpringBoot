/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.brand.dao;

import online.shixun.demo.eshopadmin.model.EshopBrandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("eshopBrandDao")
public interface EshopBrandDao extends JpaRepository<EshopBrandModel, String> {
}
