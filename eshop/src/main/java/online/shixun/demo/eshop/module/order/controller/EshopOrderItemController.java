/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.order.controller;

import com.github.pagehelper.PageInfo;
import online.shixun.demo.eshop.dto.*;
import online.shixun.demo.eshop.module.order.mapper.EshopOrderItemSqlProvider;
import online.shixun.demo.eshop.module.order.service.EshopOrderItemService;
import online.shixun.demo.eshop.module.order.service.EshopOrderService;
import online.shixun.demo.eshop.module.product.service.EshopColorService;
import online.shixun.demo.eshop.module.product.service.EshopSizeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName EshopOrderItemController
 * @Description TODO
 * @Date 2018/05/14 17:30
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
@RequestMapping("/orderItem")
public class EshopOrderItemController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${system.page.orderItmeSize}")
    private Integer pageSize;

    @Autowired
    private EshopOrderService orderService;

    @Autowired
    private EshopOrderItemService orderItemService;

    @Autowired
    private EshopSizeService sizeService;

    @Autowired
    private EshopColorService colorService;

    @GetMapping("/getOrderItems")
    public ModelAndView getOrderItems(ModelAndView mav, EshopOrderItem orderItem, @RequestParam(defaultValue = "1") Integer pageNum) {
        EshopOrder order = orderService.getOrder(orderItem.getOrderId());
        PageInfo<EshopOrderItem> pageInfo = orderItemService.getOrderItems(orderItem, pageNum, pageSize);
        List<EshopSize> sizes = sizeService.getSizes(new EshopSize());
        List<EshopColor> colors = colorService.getColors(new EshopColor());
        mav.addObject("order", order);
        mav.addObject("pageInfo", pageInfo);
        mav.addObject("sizes", sizes);
        mav.addObject("colors", colors);
        mav.setViewName("fragment/wishlist/order_item");
        return mav;
    }
}
