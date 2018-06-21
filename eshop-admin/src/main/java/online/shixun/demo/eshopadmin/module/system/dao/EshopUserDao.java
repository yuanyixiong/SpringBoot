/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.system.dao;

import online.shixun.demo.eshopadmin.model.EshopUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("eshopUserDao")
public interface EshopUserDao extends JpaRepository<EshopUserModel, String> {
}
