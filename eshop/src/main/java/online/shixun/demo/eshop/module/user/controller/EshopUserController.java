/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.user.controller;

import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.core.service.UserEnum;
import online.shixun.demo.eshop.dto.EshopUser;
import online.shixun.demo.eshop.module.user.service.AuthorizationService;
import online.shixun.demo.eshop.module.user.service.EshopRoleService;
import online.shixun.demo.eshop.module.user.service.EshopUserService;
import online.shixun.demo.eshop.util.BeanUtils;
import online.shixun.demo.eshop.util.JavaMailUtile_QQ;
import online.shixun.demo.eshop.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class EshopUserController {

    @Value("${system.java.mail.from}")
    private String from;

    @Value("${system.java.mail.username}")
    private String username;

    @Value("${system.java.mail.password}")
    private String password;

    @Value("${system.java.mail.title}")
    private String title;

    @Value("${system.java.mail.html.activate}")
    private String activate;

    @Value("${system.java.mail.html.register}")
    private String register;

    @Value("${system.java.mail.login.loginUrl}")
    private String loginUrl;

    @Value("${system.java.mail.login.loginPassword}")
    private String loginPassword;

    @Autowired
    private EshopUserService userService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private EshopRoleService roleService;

    /**
     * 用户注册
     *
     * @param email
     * @return
     */
    @PostMapping("/register")
    public ResponseData register(String email) {
        ResponseData responseData = new ResponseData();
        try {
            String userId = BeanUtils.getId();
            //发送邮件-激活
            JavaMailUtile_QQ.sendHTML(email, this.from, this.username, this.password, this.title, this.activate.replaceAll("email=email&id=userId", String.format("email=%s&id=%s", email, userId)));
            //注册用户,邮箱就是用户账户，密码通过MD5加密，默认123456
            this.userService.register(new EshopUser(userId, BeanEnum.UNDEL.getIndex(), new Date(), new Date(), email, email, MD5Util.encode(this.loginPassword), UserEnum.UACTIVATE.getName()));
            responseData.setData("注册成功,请在邮箱中查看,并且点击激活账户");
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setData(e.getMessage());
        }
        return responseData;
    }

    /**
     * 用户激活
     *
     * @param mav
     * @param email
     * @param id
     * @return
     */
    @GetMapping("/activate")
    public ModelAndView activate(ModelAndView mav, String email, String id) {
        EshopUser user = this.userService.getUser(id);
        if (Objects.isNull(user)) {
            //激活失败
            try {
                //发送邮件-注册
                JavaMailUtile_QQ.sendHTML(email, this.from, this.username, this.password, this.title, this.register);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //激活成功
            user.setUserDescription(UserEnum.ACTIVATE.getName());
            user.setUpdateTime(new Date());
            this.userService.editUser(user);
            //授予登入系统权限
            authorizationService.authorization(user.getId(), roleService.getRoleConnection().getId());
        }
        mav.setViewName(String.format("redirect:%s", this.loginUrl));
        return mav;
    }
}