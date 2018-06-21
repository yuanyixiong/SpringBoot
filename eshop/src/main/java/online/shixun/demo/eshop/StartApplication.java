package online.shixun.demo.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 * 启动类
 *********************************************/
@EnableAutoConfiguration
@SpringBootApplication
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
