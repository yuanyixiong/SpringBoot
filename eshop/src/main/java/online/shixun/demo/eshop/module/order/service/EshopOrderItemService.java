/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.dto.EshopCollect;
import online.shixun.demo.eshop.dto.EshopCollectItemCriteria;
import online.shixun.demo.eshop.dto.EshopOrderItem;
import online.shixun.demo.eshop.dto.EshopOrderItemCriteria;
import online.shixun.demo.eshop.module.order.mapper.EshopOrderItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @ClassName EshopOrderItemService
 * @Description TODO
 * @Date 2018/05/17 14:26
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class EshopOrderItemService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopOrderItemMapper orderItemMapper;

    public PageInfo<EshopOrderItem> getOrderItems(EshopOrderItem orderItem, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);//分页
        EshopOrderItemCriteria example = new EshopOrderItemCriteria();
        EshopOrderItemCriteria.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderItem.getOrderId());
        criteria.andIsDelEqualTo(BeanEnum.UNDEL.getIndex());
        return new PageInfo<>(orderItemMapper.selectByExample(example));
    }

    /**
     * 根据订单编码移除，订单项
     *
     * @param orderId
     * @return
     */
    public int deleteByOrderId(String orderId) {
        EshopOrderItemCriteria eshopOrderItemCriteria = new EshopOrderItemCriteria();
        EshopOrderItemCriteria.Criteria criteria = eshopOrderItemCriteria.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        return orderItemMapper.deleteByExample(eshopOrderItemCriteria);
    }
}
