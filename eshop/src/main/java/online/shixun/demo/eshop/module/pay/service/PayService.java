/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.pay.service;

import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.dto.EshopOrder;
import online.shixun.demo.eshop.module.order.mapper.EshopOrderItemMapper;
import online.shixun.demo.eshop.module.order.mapper.EshopOrderMapper;
import online.shixun.demo.eshop.util.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @ClassName PayService
 * @Description TODO
 * @Date 2018/05/17 14:03
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class PayService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopOrderMapper orderMapper;

    @Autowired
    private EshopOrderItemMapper orderItemMapper;


    /**
     * 下订单
     *
     * @param order
     */
    @Transactional
    public void save(EshopOrder order) {
        order.setId(BeanUtils.getId());
        order.setIsDel(BeanEnum.UNDEL.getIndex());
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        orderMapper.insert(order);
        order.getItems().forEach(item -> {
            item.setOrderId(order.getId());
            item.setId(BeanUtils.getId());
            item.setIsDel(BeanEnum.UNDEL.getIndex());
            item.setCreateTime(new Date());
            item.setUpdateTime(new Date());
            orderItemMapper.insert(item);
        });
    }
}
