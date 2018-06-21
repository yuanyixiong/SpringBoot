/********************************************
 * Copyright (c) 2017, www.qingshixun.com
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.config.thymeleaf;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

/**
 * 自定义的Thymeleaf方言，用于扩展Thymeleaf页面对象
 */
public class ThymeleafDialect extends AbstractDialect implements IExpressionObjectDialect {


    public ThymeleafDialect() {
        super("Math Dialect");
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return new ThymeleafObjectFactory();
    }
}
