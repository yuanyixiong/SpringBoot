/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.product.dao;

import online.shixun.demo.eshopadmin.model.EshopSizeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("eshopSizeDao")
public interface EshopSizeDao extends JpaRepository<EshopSizeModel, String> {
}
