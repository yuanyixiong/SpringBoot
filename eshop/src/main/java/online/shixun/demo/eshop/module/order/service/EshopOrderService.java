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
import online.shixun.demo.eshop.core.service.OrderEnum;
import online.shixun.demo.eshop.core.service.TimeEnum;
import online.shixun.demo.eshop.dto.EshopOrder;
import online.shixun.demo.eshop.dto.EshopOrderCriteria;
import online.shixun.demo.eshop.module.order.mapper.EshopOrderMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName EshopOrderService
 * @Description TODO
 * @Date 2018/05/17 14:26
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class EshopOrderService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopOrderMapper orderMapper;

    @Autowired
    private EshopOrderItemService orderItemService;

    public EshopOrder getOrder(String id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    public PageInfo<EshopOrder> getOrders(EshopOrder order, String action, TimeEnum timeEnum, Date beginTime, Date endTime, Integer pageNum, Integer pageSize) throws ParseException {
        EshopOrderCriteria eshopOrderCriteria = new EshopOrderCriteria();
        EshopOrderCriteria.Criteria criteria = eshopOrderCriteria.createCriteria();

        //and
        if (Objects.nonNull(order)) {
            //用户[必传]
            if (Objects.nonNull(order.getUserId())) {
                criteria.andUserIdEqualTo(order.getUserId());
            } else {
                throw new NullPointerException("用户编号为空");
            }
            if (Objects.nonNull(order.getIsDel())) {
                criteria.andIsDelEqualTo(order.getIsDel());
            }
        } else {
            throw new NullPointerException("用户编号为空");
        }

        //and
        if (StringUtils.isNotBlank(action)) {
            switch (action) {
                case "payment":
                    //待付款
                    criteria.andOrderIsPaiyEqualTo(OrderEnum.IsPaiyEnum.payment_wait.getIndex());//未付款
                    criteria.andOrderStateEqualTo(OrderEnum.StatusEnum.submit.getIndex());//提交订单
                    break;
                case "shipments":
                    //待发货
                    criteria.andOrderIsPaiyEqualTo(OrderEnum.IsPaiyEnum.payment_succeed.getIndex());//已付款
                    criteria.andOrderStateEqualTo(OrderEnum.StatusEnum.submit.getIndex());//提交订单
                    break;
                case "receiving":
                    //待收货
                    criteria.andOrderIsPaiyIn(List.of(
                            OrderEnum.IsPaiyEnum.payment_succeed.getIndex(),//已付款
                            OrderEnum.IsPaiyEnum.payment_freight.getIndex()//到付
                    ));
                    criteria.andOrderStateIn(List.of(
                            OrderEnum.StatusEnum.allocation.getIndex(),//仓库配货
                            OrderEnum.StatusEnum.come.getIndex(),//商品出库
                            OrderEnum.StatusEnum.wait.getIndex()//等待收货
                    ));
                    break;
                case "comment":
                    //待评价
                    criteria.andOrderIsPaiyEqualTo(OrderEnum.IsPaiyEnum.payment_succeed.getIndex());//已付款
                    criteria.andOrderStateEqualTo(OrderEnum.StatusEnum.accomplish.getIndex());//完成
                    break;
                case "refund":
                    //退货
                    criteria.andOrderIsPaiyIn(List.of(
                            OrderEnum.IsPaiyEnum.refund_wait.getIndex(),//待退款
                            OrderEnum.IsPaiyEnum.refund_error.getIndex(),//退款失败
                            OrderEnum.IsPaiyEnum.refund_succeed.getIndex()//退款成功
                    ));
                    criteria.andOrderStateIn(List.of(
                            OrderEnum.StatusEnum.refund_wait.getIndex(),//待退货
                            OrderEnum.StatusEnum.refund_succeed.getIndex()//已退货
                    ));
                    break;
            }
        }

        // and 时间
        if (Objects.nonNull(timeEnum)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            switch (timeEnum) {
                case TRIMESTER://近三个月内
                    calendar.add(Calendar.MONTH, -3);
                    endTime = new Date();
                    beginTime = calendar.getTime();
                    criteria.andUpdateTimeBetween(beginTime, endTime);
                    break;
                case SEMESTER://近半年内
                    calendar.add(Calendar.MONTH, -6);
                    endTime = new Date();
                    beginTime = calendar.getTime();
                    criteria.andUpdateTimeBetween(beginTime, endTime);
                    break;
                case A_YEAR://今年内
                    endTime = new Date();
                    beginTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear()));
                    criteria.andUpdateTimeBetween(beginTime, endTime);
                    break;
                case TOW_YEARS://过去一年
                    calendar.add(Calendar.YEAR, -1);
                    beginTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear()));
                    endTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear() + 1));
                    criteria.andUpdateTimeBetween(beginTime, endTime);
                    break;
                case THREE_YEARS://过去两年
                    calendar.add(Calendar.YEAR, -2);
                    beginTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear()));
                    endTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear() + 1));
                    criteria.andUpdateTimeBetween(beginTime, endTime);
                    break;
                case FOUR_YEARS://过去三年
                    calendar.add(Calendar.YEAR, -3);
                    beginTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear()));
                    endTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear() + 1));
                    criteria.andUpdateTimeBetween(beginTime, endTime);
                    break;
                case MORE_YEARS://更多
                    calendar.add(Calendar.YEAR, -3);
                    beginTime = new SimpleDateFormat("yyyy").parse(String.valueOf(calendar.getWeekYear()));
                    criteria.andUpdateTimeLessThanOrEqualTo(beginTime);// 三年前的
                    break;
                case USER_DEFINED://用户自定义
                    criteria.andUpdateTimeBetween(beginTime, endTime);
                    break;
            }
        }

        //时间倒序
        eshopOrderCriteria.setOrderByClause("`update_time` DESC,`create_time` DESC,order_is_paiy asc,order_state asc");

        //分页
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(orderMapper.selectByExample(eshopOrderCriteria));
    }


    /**
     * 移除订单列表-假删
     *
     * @param order
     * @return
     */
    public int fakeDelete(EshopOrder order) {
        //订单状态
        // [可删]1:提交订单
        // [可删]5:完成
        // [可删]7已退货
        order = orderMapper.selectByPrimaryKey(order.getId());
        if (Objects.equals(order.getIsDel(), BeanEnum.UNDEL.getIndex()) &&
                (
                        Objects.equals(order.getOrderState(), OrderEnum.StatusEnum.submit.getIndex())
                                || Objects.equals(order.getOrderState(), OrderEnum.StatusEnum.accomplish.getIndex())
                                || Objects.equals(order.getOrderState(), OrderEnum.StatusEnum.refund_succeed.getIndex())
                )
                ) {
            EshopOrderCriteria example = new EshopOrderCriteria();
            example.createCriteria().andIdEqualTo(order.getId());
            order.setIsDel(BeanEnum.DEL.getIndex());
            return orderMapper.updateByExampleSelective(order, example);
        }
        return -1;
    }

    /**
     * 移除订单列表-真删
     *
     * @param order
     * @return
     */
    public int realDelete(EshopOrder order) {
        order = orderMapper.selectByPrimaryKey(order.getId());
        if (Objects.equals(order.getIsDel(), BeanEnum.DEL.getIndex())) {
            orderItemService.deleteByOrderId(order.getId());
            return orderMapper.deleteByPrimaryKey(order.getId());
        }
        return -1;
    }

    /**
     * 还原删除
     *
     * @param order
     * @return
     */
    public int restoreDelete(EshopOrder order) {
        if (Objects.equals(orderMapper.selectByPrimaryKey(order.getId()).getIsDel(), BeanEnum.DEL.getIndex())) {
            EshopOrderCriteria example = new EshopOrderCriteria();
            example.createCriteria().andIdEqualTo(order.getId());
            order.setIsDel(BeanEnum.UNDEL.getIndex());
            return orderMapper.updateByExampleSelective(order, example);
        }
        return -1;
    }
}
