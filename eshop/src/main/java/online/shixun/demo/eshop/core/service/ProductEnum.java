/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.core.service;

/**
 * 产品枚举
 */
public enum ProductEnum {
    NEW("新品", 2), UNNEW("旧品", 1), //新品
    HOT("畅销", 2), UNHOT("不畅销", 1), //畅销
    COMMEND("推荐", 2), UNCOMMEND("不推荐", 1),//推荐
    SHOW("上架", 2), UNSHOW("下架", 1);//上下架

    // 成员变量
    protected String name;
    protected int index;

    ProductEnum(String name, int index) {
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
