/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.product.dao;

import online.shixun.demo.eshopadmin.model.EshopColorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("eshopColorDao")
public interface EshopColorDao extends JpaRepository<EshopColorModel, String> {

}
