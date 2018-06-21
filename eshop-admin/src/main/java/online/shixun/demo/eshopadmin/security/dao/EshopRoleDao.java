/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.security.dao;

import online.shixun.demo.eshopadmin.model.EshopRoleModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("securityRoleDao")
public interface EshopRoleDao extends CrudRepository<EshopRoleModel, String> {


}