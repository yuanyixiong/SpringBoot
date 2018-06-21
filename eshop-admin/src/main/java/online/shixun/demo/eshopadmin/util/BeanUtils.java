/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Bean操作工具
 */
public class BeanUtils {

    /**
     * 查询出对象中为空的属性或集合
     *
     * @param source 查询的对象
     * @return
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            //过滤掉属性为null
            //过滤掉集合为null或者集合里面不存在数据的
            if (srcValue == null || (srcValue instanceof Collection && ((Collection) srcValue).size() == 0)) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 复制对象的属性，不复制空属性或空集合
     *
     * @param source 复制值的对象
     * @param target 填充值的目标对象
     */
    public static void copyPropertiesIgnoreNull(Object source, Object target) {
        org.springframework.beans.BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }


    /**
     * 生成ID
     *
     * @return
     */
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}