/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.util;

import java.util.UUID;

/**
 * Bean操作工具
 */
public class BeanUtils {
    /**
     * 生成ID
     *
     * @return
     */
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}