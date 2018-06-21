/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/***
 * 启动类
 */
@EnableAutoConfiguration
@SpringBootApplication
@RestController
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @RequestMapping(value = "index",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("/index");
        return mav;
    }

    /**
     * 数据分析页面，后期更改
     * @param mav
     * @return
     */
    @GetMapping("/home")
    public ModelAndView main(ModelAndView mav) {
        mav.setViewName("/fragments/home");
        return mav;
    }
}
