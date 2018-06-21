/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.core.model;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import java.lang.annotation.*;

/**
 * 组合注解动态让hibernate支持DML动态SQL
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@SelectBeforeUpdate
@DynamicInsert
@DynamicUpdate
public @interface DynamicSql {

}
