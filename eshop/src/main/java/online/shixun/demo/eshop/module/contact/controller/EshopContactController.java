/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.contact.controller;

import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.core.service.Node;
import online.shixun.demo.eshop.dto.EshopContact;
import online.shixun.demo.eshop.dto.EshopResource;
import online.shixun.demo.eshop.dto.EshopUser;
import online.shixun.demo.eshop.module.contact.service.EshopContactService;
import online.shixun.demo.eshop.module.user.service.EshopResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName EshopContactController
 * @Description TODO
 * @Date 2018/05/21 10:26
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
@RequestMapping("/contact")
public class EshopContactController {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private EshopResourceService resourceService;

    @Autowired
    private EshopContactService contactService;

    /**
     * 保存用户反馈信息
     *
     * @param mav
     * @param contact
     * @param session
     * @return
     */
    @PostMapping("/save")
    public ModelAndView saveContact(ModelAndView mav, EshopContact contact, HttpSession session) {
        ResponseData responseData = new ResponseData();
        EshopUser user = null;
        if (Objects.nonNull(session.getAttribute("currentUser"))) {
            user = (EshopUser) session.getAttribute("currentUser");
        }
        contactService.saveContact(contact, user);
        responseData.setData("提交成功，管理员会尽快处理");
        mav.addObject("contact", contact);
        mav.addObject("responseData", responseData);
        mav.setViewName("contact");
        return mav;
    }

    @GetMapping("/main")
    public ModelAndView main(ModelAndView mav) {
        //加载水平导航栏菜单
        List<Node<EshopResource>> levelNavigationMenu = resourceService.initLevelNavigation();
        //加载垂直导航栏菜单
        List<Node<EshopResource>> verticalNavigationMenu = resourceService.initVerticalNavigation();

        //设置数据到请求中
        mav.addObject("levelNavigationMenu", levelNavigationMenu);
        mav.addObject("verticalNavigationMenu", verticalNavigationMenu);
        mav.setViewName("/contact");
        return mav;
    }

}
