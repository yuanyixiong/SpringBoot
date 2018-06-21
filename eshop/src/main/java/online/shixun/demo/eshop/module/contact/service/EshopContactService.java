/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.contact.service;

import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.dto.EshopContact;
import online.shixun.demo.eshop.dto.EshopUser;
import online.shixun.demo.eshop.module.contact.mapper.EshopContactMapper;
import online.shixun.demo.eshop.util.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

/**
 * @ClassName EshopContactService
 * @Description TODO
 * @Date 2018/05/21 10:44
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class EshopContactService {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private EshopContactMapper contactMapper;

    @Transactional
    public int saveContact(EshopContact contact, EshopUser user) {
        contact.setCreateTime(new Date());
        contact.setUpdateTime(new Date());
        contact.setIsDel(BeanEnum.UNDEL.getIndex());
        contact.setId(BeanUtils.getId());
        //记录登陆的用户
        if (Objects.nonNull(user)) {
            contact.setUserId(user.getId());
        }
        return contactMapper.insertSelective(contact);
    }
}
