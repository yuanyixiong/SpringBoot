/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.core.service;

/**
 * 系统角色的枚举
 */
public enum RoleEnum {

    ROLE_CONNECTION_CLIENT("CONNECTION_CLIENT");//登入前台系统的权限

    // 成员变量
    protected String name;

    RoleEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
