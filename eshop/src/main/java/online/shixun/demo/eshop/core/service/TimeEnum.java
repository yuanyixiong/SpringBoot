/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.core.service;

import java.util.Arrays;
import java.util.Objects;

/**
 * @ClassName TimeEnum
 * @Description TODO
 * @Date 2018/05/14 15:02
 * @Author shixun.online
 * @Version 1.0
 **/
public enum TimeEnum {

    TRIMESTER("三个月内", 1), SEMESTER("半年内", 2), A_YEAR("今年内", 3), TOW_YEARS("过去一年", 4), THREE_YEARS("过去两年", 5), FOUR_YEARS("过去三年", 6), MORE_YEARS("更多", 7), USER_DEFINED("自定义", 8);//时间界限

    // 成员变量
    protected String name;
    protected int index;

    TimeEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    /**
     * 根据指定的时间类型索引获取时间枚举
     *
     * @param index
     * @return
     */
    public static TimeEnum getTimeEnum(int index) {
        return Arrays.stream(TimeEnum.values()).filter(timeEnum -> Objects.equals(timeEnum.getIndex(), index)).findFirst().get();
    }
}

