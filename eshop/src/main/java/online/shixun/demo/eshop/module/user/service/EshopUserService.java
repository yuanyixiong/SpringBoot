/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.user.service;

import online.shixun.demo.eshop.dto.EshopUser;
import online.shixun.demo.eshop.dto.EshopUserCriteria;
import online.shixun.demo.eshop.module.user.mapper.EshopRoleMapper;
import online.shixun.demo.eshop.module.user.mapper.EshopUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
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

@Service
@EnableCaching(proxyTargetClass = true) // CGLib 代理
public class EshopUserService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopUserMapper userMapper;


    @Autowired
    private EshopRoleMapper roleMapper;


    public void register(EshopUser user) {
        userMapper.insert(user);
    }

    public EshopUser getUser(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public void editUser(EshopUser user) {
        EshopUserCriteria eshopUserCriteria = new EshopUserCriteria();
        EshopUserCriteria.Criteria criteria = eshopUserCriteria.createCriteria();
        criteria.andIdEqualTo(user.getId());
        userMapper.updateByExampleSelective(user, eshopUserCriteria);
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

        EshopUserCriteria eshopUserCriteria = new EshopUserCriteria();
        EshopUserCriteria.Criteria criteria = eshopUserCriteria.createCriteria();
        criteria.andUserLoginNameEqualTo(userLoginName);
        List<EshopUser> list = userMapper.selectByExample(eshopUserCriteria);

        if (Objects.isNull(list) || list.size() == 0) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        EshopUser user = list.get(0);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        roleMapper.getRoles(user).forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        return new User(user.getUserLoginName(), user.getUserPassword(), authorities);
    }

    public EshopUser getUserByUserLoginName(String userLoginName) {
        EshopUserCriteria eshopUserCriteria = new EshopUserCriteria();
        EshopUserCriteria.Criteria criteria = eshopUserCriteria.createCriteria();
        criteria.andUserLoginNameEqualTo(userLoginName);
        List<EshopUser> list = userMapper.selectByExample(eshopUserCriteria);
        if (Objects.isNull(list) || list.size() == 0) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return list.get(0);
    }
}
