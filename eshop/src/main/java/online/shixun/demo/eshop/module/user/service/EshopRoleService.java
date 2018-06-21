/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.user.service;

import online.shixun.demo.eshop.core.service.RoleEnum;
import online.shixun.demo.eshop.dto.EshopRole;
import online.shixun.demo.eshop.dto.EshopRoleCriteria;
import online.shixun.demo.eshop.module.user.mapper.EshopRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName EshopRoleService
 * @Description TODO
 * @Date 2018/05/11 9:55
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class EshopRoleService {

    @Autowired
    private EshopRoleMapper roleMapper;

    /**
     * 获得登陆系统的角色权限
     *
     * @return
     */
    public EshopRole getRoleConnection() {
        EshopRoleCriteria eshopRoleCriteria = new EshopRoleCriteria();
        EshopRoleCriteria.Criteria criteria = eshopRoleCriteria.createCriteria();
        criteria.andRoleNameEqualTo("ROLE_"+RoleEnum.ROLE_CONNECTION_CLIENT.getName());
        return roleMapper.selectByExample(eshopRoleCriteria).get(0);
    }
}
