/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.core.service;

public enum UserEnum {

    UACTIVATE("未激活", 1), ACTIVATE("已激活", 2);//激活状态

    // 成员变量
    protected String name;
    protected int index;

    UserEnum(String name, int index) {
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
