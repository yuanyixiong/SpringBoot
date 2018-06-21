/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.product.dao;

import online.shixun.demo.eshopadmin.model.EshopProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("eshopProductDao")
public interface EshopProductDao extends JpaRepository<EshopProductModel, String> {
}
