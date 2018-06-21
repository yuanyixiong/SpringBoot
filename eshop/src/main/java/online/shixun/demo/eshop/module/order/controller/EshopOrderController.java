/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.order.controller;

import com.github.pagehelper.PageInfo;
import online.shixun.demo.eshop.controller.BaseController;
import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.core.service.Node;
import online.shixun.demo.eshop.core.service.OrderEnum;
import online.shixun.demo.eshop.core.service.TimeEnum;
import online.shixun.demo.eshop.dto.EshopOrder;
import online.shixun.demo.eshop.dto.EshopResource;
import online.shixun.demo.eshop.module.order.service.EshopOrderService;
import online.shixun.demo.eshop.module.user.service.EshopResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @ClassName EshopOrderController
 * @Description TODO
 * @Date 2018/05/14 17:30
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
@RequestMapping("/order")
public class EshopOrderController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${system.page.orderSize}")
    private Integer pageSize;


    @Autowired
    private EshopResourceService resourceService;

    @Autowired
    private EshopOrderService orderService;

    @GetMapping("/main")
    public ModelAndView main(ModelAndView mav) {
        //加载水平导航栏菜单
        List<Node<EshopResource>> levelNavigationMenu = resourceService.initLevelNavigation();
        //加载垂直导航栏菜单
        List<Node<EshopResource>> verticalNavigationMenu = resourceService.initVerticalNavigation();
        //设置数据到请求中
        mav.addObject("levelNavigationMenu", levelNavigationMenu);
        mav.addObject("verticalNavigationMenu", verticalNavigationMenu);

        mav.addObject("title", "order");
        mav.setViewName("wishlist");
        return mav;
    }


    @GetMapping("/getOrders")
    public ModelAndView getOrders(ModelAndView mav, EshopOrder order, Date beginTime, Date endTime, @RequestParam(defaultValue = "1") Integer timeEnumIndex, @RequestParam(defaultValue = "0") Integer pageNum, String action) {
        try {
            PageInfo<EshopOrder> pageInfo = orderService.getOrders(order,action,TimeEnum.getTimeEnum(timeEnumIndex), beginTime, endTime, pageNum, this.pageSize);
            mav.addObject("pageInfo", pageInfo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mav.addObject("timeEnumIndex", timeEnumIndex);
        mav.addObject("order", order);
        mav.addObject("beginTime", beginTime);
        mav.addObject("endTime", endTime);
        mav.addObject("action", action);
        mav.setViewName("fragment/wishlist/order_table");
        return mav;
    }

    @GetMapping("/fakeDelete")
    public ResponseData fakeDelete(EshopOrder order) {
        ResponseData responseData = new ResponseData();
        int row = orderService.fakeDelete(order);
        responseData.setData(row > 0 ? "已经加入回收站" : "订单已经进入物流系统");
        return responseData;
    }

    @GetMapping("/realDelete")
    public ResponseData realDelete(EshopOrder order) {
        ResponseData responseData = new ResponseData();
        orderService.realDelete(order);
        responseData.setData("已删除");
        return responseData;
    }

    @GetMapping("/restoreDelete")
    public ResponseData restoreDelete(EshopOrder order) {
        ResponseData responseData = new ResponseData();
        orderService.restoreDelete(order);
        responseData.setData("已还原");
        return responseData;
    }

}
