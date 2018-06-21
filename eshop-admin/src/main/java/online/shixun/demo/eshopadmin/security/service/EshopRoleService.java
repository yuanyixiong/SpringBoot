/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.security.service;

import online.shixun.demo.eshopadmin.model.EshopRoleModel;
import online.shixun.demo.eshopadmin.security.dao.EshopRoleDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("securityRoleService")
public class EshopRoleService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private EshopRoleDao roleDao;

    @Autowired
    public EshopRoleService(@Qualifier("securityRoleDao") EshopRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    public List<EshopRoleModel> getAllRoles() {
        List<EshopRoleModel> roles = new ArrayList<>();
        roleDao.findAll().forEach(role -> {
            roles.add(role);
            //优化jpa查询的加载，使用的懒加载-加载资源
            role.getResources().forEach(resource -> {
            });
        });
        return roles;
    }
}