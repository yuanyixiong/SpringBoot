/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.core.service;

/**
 * 系统角色的枚举
 */
public enum RoleEnum {

    ROLE_CONNECTION_SERVER("ROLE_CONNECTION_SERVER"),//登入后台系统的权限
    ROLE_SYSTEM_ADMIN("SYSTEM_ADMIN"),//系统管理员权限
    ROLE_COMMON_ADMIN("COMMON_ADMIN");//后台管理员权限

    // 成员变量
    protected String name;

    RoleEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
