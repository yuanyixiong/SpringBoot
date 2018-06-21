/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * SpringBoot Tomcat 部署使用
 *
 * @ClassName ServletInitializer
 * @Description TODO
 * @Date 2018/05/25 16:01
 * @Author shixun.online
 * @Version 1.0
 **/
public class ServletInitializer extends SpringBootServletInitializer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StartApplication.class);
    }
}
