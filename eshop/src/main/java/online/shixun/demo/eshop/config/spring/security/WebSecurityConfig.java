/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.config.spring.security;

import online.shixun.demo.eshop.core.service.RoleEnum;
import online.shixun.demo.eshop.dto.EshopUser;
import online.shixun.demo.eshop.module.user.service.EshopResourceService;
import online.shixun.demo.eshop.module.user.service.EshopRoleService;
import online.shixun.demo.eshop.module.user.service.EshopUserService;
import online.shixun.demo.eshop.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Spring Security的配置
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());


    private EshopUserService userService;


    @Autowired
    public WebSecurityConfig(EshopUserService userService) {
        this.userService = userService;
    }

    //密码授权
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //system Details Service验证
        auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
                logger.info("encode");
                return MD5Util.encode((String) rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                logger.info("matches");
                return encodedPassword.equals(MD5Util.encode((String) rawPassword));
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("开始权限配置");
        http
                .authorizeRequests()//[访问URL][开始配置]
                .antMatchers("/collect/**", "/order/**", "/pay/**").hasRole(RoleEnum.ROLE_CONNECTION_CLIENT.getName())//收藏/订单/支付 必须登陆
                .antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/plugins/**", "/403", "/404", "/500", "/**").permitAll()// 这些URL的资源允许所有用户访问
                //.anyRequest().authenticated() //尚未匹配的任何URL要求用户进行身份验证
                .and()//[访问URL][结束配置]
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())//[访问未经授权处理]
                .and()
                .formLogin() //[登入][开始配置]
                .usernameParameter("userLoginName").passwordParameter("userPassword") //修改表单提交的账号密码属性默认(username,password)
                .loginPage("/login")//登入的请求
                .successHandler(authenticationSuccessHandler())//[登陆认证成功处理]
                .failureUrl("/login?error")//登录失败之后发送的请求 无法和failureHandler共存
                .permitAll()
                .and() //[登入][结束配置]
                .logout() //[登出][开始配置]
                .deleteCookies("JSESSIONID")//清除cookies缓存
                .invalidateHttpSession(true)//销毁session
                .permitAll()
                .and() //[登出][结束配置]
                .csrf().disable();//禁用CSRF
        logger.info("完成权限配置");
    }


    /**
     * 登陆认证成功处理,完成加载用户菜单
     *
     * @return
     */
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {

        return (httpServletRequest, httpServletResponse, authentication) -> {
            logger.info("登入认证成功");

            //检查当前用户是否拥有登入系统的权限
            boolean isExist = false;
            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                if (grantedAuthority.getAuthority().equals("ROLE_"+RoleEnum.ROLE_CONNECTION_CLIENT.getName())) {
                    isExist = true;
                    break;
                }
            }

            //当前登入用户,没有登入系统的角色权限
            if (!isExist) {
                httpServletResponse.sendRedirect("/403");
                logger.info("登入认证成功,没有登入系统的角色权限");
                return;
            }

            //设置用户信息到session
            EshopUser eshopUser = userService.getUserByUserLoginName(authentication.getName());
            httpServletRequest.getSession().setAttribute("currentUser", eshopUser);
            //当前登入用户,有登入系统的角色权限[去首页]
            httpServletRequest.getRequestDispatcher("/index").forward(httpServletRequest, httpServletResponse);
        };
    }

    /**
     * 访问未经授权处理
     *
     * @return
     */
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (httpServletRequest, httpServletResponse, accessDeniedException) -> {
            logger.info("访问未经授权处理");
            String header = httpServletRequest.getHeader("X-Requested-With");
            boolean isAjax = header != null && "XMLHttpRequest".equals(header);
            //是否是ajax请求
            if (!isAjax) {
                logger.info("同步请求权限不足");
                httpServletResponse.sendRedirect("/403");
            } else {
                logger.info("ajax请求权限不足");
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setContentType("text/plain");
                httpServletResponse.getWriter().write("权限不足");
                httpServletResponse.getWriter().close();
            }
        };
    }
}

