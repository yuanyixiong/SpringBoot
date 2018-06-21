/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.security.service;

import online.shixun.demo.eshopadmin.model.EshopUserModel;
import online.shixun.demo.eshopadmin.security.dao.EshopUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("securityUserService")
public class EshopUserService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private EshopUserDao userDao;

    @Autowired
    public EshopUserService(@Qualifier("securityUserDao") EshopUserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * spring securtiy 登入功能
     *
     * @param userLoginName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userLoginName) throws UsernameNotFoundException {
        logger.info("验证登入");
        EshopUserModel eshopUserModel = userDao.findUser(userLoginName);
        if (Objects.isNull(eshopUserModel)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        eshopUserModel.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        return new User(eshopUserModel.getUserLoginName(), eshopUserModel.getUserPassword(), authorities);
    }

    /**
     * 初始化用户的菜单
     *
     * @param userLoginName
     * @return
     */
    @Transactional
    public EshopUserModel initUserMenusByUserLoginName(String userLoginName) {
        //String加载用户的所有菜单
        EshopUserModel eshopUserModel = userDao.findUser(userLoginName);
        //优化jpa多表数据加载使用的懒加载-加载角色-加载资源
        eshopUserModel.getRoles().forEach(role ->role.getResources().forEach(resource->{}));
        return eshopUserModel;
    }

}
