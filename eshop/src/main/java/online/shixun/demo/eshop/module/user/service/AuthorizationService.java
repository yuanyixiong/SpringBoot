/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.user.service;

import online.shixun.demo.eshop.module.user.mapper.AuthorizationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AuthorizationService
 * @Description TODO
 * @Date 2018/05/11 13:51
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class AuthorizationService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthorizationMapper authorizationMapper;


    /**
     * 授权
     *
     * @param userId 授权用户编号
     * @param roleId 授予权限编号
     */
    public int authorization(String userId, String roleId) {
        return authorizationMapper.authorization(userId, roleId);
    }

    /**
     * 撤销授权
     *
     * @param userId 撤销用户编号
     * @param roleId 撤销权限编号
     */
    public int uauthorization(String userId, String roleId) {
        return authorizationMapper.uauthorization(userId, roleId);
    }
}
