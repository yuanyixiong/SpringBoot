/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.core.service;

/**
 * 图片的枚举
 */
public enum ImgEnum {
    DEF("默认", 2), UNDEF("非默认", 1);//显示状态，图片状态默认为显示的主要图片/反之次要

    // 成员变量
    protected String name;
    protected int index;

    ImgEnum(String name, int index) {
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
