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
public enum AddressEnum {

    UNDEF("非默认", 1), DEF("默认", 2);//登入前台系统的权限

    // 成员变量
    protected String name;
    protected int index;

    AddressEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
