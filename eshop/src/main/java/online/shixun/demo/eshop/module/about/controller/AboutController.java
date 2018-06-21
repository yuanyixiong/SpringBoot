/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.about.controller;

import online.shixun.demo.eshop.core.service.Node;
import online.shixun.demo.eshop.dto.EshopAbout;
import online.shixun.demo.eshop.dto.EshopResource;
import online.shixun.demo.eshop.module.about.service.EshopAboutService;
import online.shixun.demo.eshop.module.user.service.EshopResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName AboutController
 * @Description TODO
 * @Date 2018/05/21 10:31
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
@RequestMapping("/about")
public class AboutController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopResourceService resourceService;

    @Autowired
    private EshopAboutService aboutService;


    @GetMapping("/main")
    public ModelAndView main(ModelAndView mav, final EshopAbout eshopAbout) {
        //加载水平导航栏菜单
        List<Node<EshopResource>> levelNavigationMenu = resourceService.initLevelNavigation();
        //加载垂直导航栏菜单
        List<Node<EshopResource>> verticalNavigationMenu = resourceService.initVerticalNavigation();

        //设置数据到请求中
        mav.addObject("levelNavigationMenu", levelNavigationMenu);
        mav.addObject("verticalNavigationMenu", verticalNavigationMenu);


        List<EshopAbout> list = aboutService.getEshopAbouts();
        EshopAbout result = null;
        if (Objects.nonNull(eshopAbout) && Objects.nonNull(eshopAbout.getId())) {
            result = list.stream().filter(about -> Objects.equals(about.getId(), eshopAbout.getId())).findAny().get();
        } else {
            result = list.stream().findFirst().get();
        }
        mav.addObject("list", list);
        mav.addObject("eshopAbout", result);
        mav.setViewName("/about");
        return mav;
    }
}

