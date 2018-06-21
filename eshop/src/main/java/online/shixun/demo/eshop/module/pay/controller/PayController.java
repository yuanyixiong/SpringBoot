/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.pay.controller;

import online.shixun.demo.eshop.core.service.AddressEnum;
import online.shixun.demo.eshop.core.service.OrderEnum;
import online.shixun.demo.eshop.dto.*;
import online.shixun.demo.eshop.module.address.service.EshopAddressCityService;
import online.shixun.demo.eshop.module.address.service.EshopAddressProvinceService;
import online.shixun.demo.eshop.module.address.service.EshopAddressStateService;
import online.shixun.demo.eshop.module.address.service.EshopAddressTownService;
import online.shixun.demo.eshop.module.collect.service.EshopCollectItemService;
import online.shixun.demo.eshop.module.collect.service.EshopCollectService;
import online.shixun.demo.eshop.module.pay.service.PayService;
import online.shixun.demo.eshop.module.product.service.EshopProductService;
import online.shixun.demo.eshop.module.product.service.EshopSkuService;
import online.shixun.demo.eshop.module.shopping.service.TrolleyService;
import online.shixun.demo.eshop.module.user.service.EshopAddressService;
import online.shixun.demo.eshop.module.user.service.EshopUserService;
import online.shixun.demo.eshop.util.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName PayController
 * @Description TODO
 * @Date 2018/05/16 11:12
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
@RequestMapping("/pay")
public class PayController {

    private static final String COOKIE_NAME = "trolley";

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PayService payService;

    @Autowired
    private TrolleyService trolleyService;

    @Autowired
    private EshopProductService productService;

    @Autowired
    private EshopAddressService addressService;

    @Autowired
    private EshopSkuService skuService;


    @GetMapping("/main")
    public ModelAndView main(ModelAndView mav, EshopUser user, HttpServletRequest request, HttpServletResponse response) {

        //加载用户的配送地址列表
        List<EshopAddress> addresses = addressService.getUserAddress(user.getId());//当前用户的所有地址
        EshopAddress defAddresse = Objects.nonNull(addresses) && addresses.size() > 0 ? addresses.stream().filter(addresse -> Objects.equals(AddressEnum.DEF.getIndex(), addresse.getIsDel())).findFirst().get() : null;//当前用户的默认地址

        //将缓存中的数据转移到数据库
        //读取Cookie中购物车信息
        EshopBuyerCart eshopBuyerCart = new EshopBuyerCart();
        try {
            eshopBuyerCart = (EshopBuyerCart) CookieUtil.readCookie(request, COOKIE_NAME, EshopBuyerCart.class);
            //[清空Cookie]
            CookieUtil.emptyCookie(response, COOKIE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //从数据库加载用户购买的商品信息
        for (EshopBuyerCartItem item : trolleyService.getBuyerCart(user).getItems()) {
            eshopBuyerCart.addItem(item);
        }

        Set<String> skuId = new HashSet<>();
        eshopBuyerCart.getItems().forEach(itme -> skuId.add(Objects.isNull(itme.getSku()) ? itme.getSkuId() : itme.getSku().getId()));
        List<EshopProductWithBLOBs> products = skuId.size() > 0 ? productService.getProductsBySkuIds(skuId) : new ArrayList<>();

        Map<String, EshopSku> skuMap = new HashMap<>();
        products.forEach(product -> {
            product.getSkus().forEach(sku -> {
                skuMap.put(sku.getId(), sku);
            });
        });

        //查询商品
        eshopBuyerCart.getItems().forEach(item -> {
            EshopSku sku = skuMap.get(Objects.isNull(item.getSku()) ? item.getSkuId() : item.getSku().getId());
            if (Objects.nonNull(sku)) {
                item.setSku(sku);
                item.setIsHave(sku.getSkuStock() > 0);
                item.setStock(sku.getSkuStock());
                item.setProductId(sku.getProductId());
            }
        });

        mav.addObject("buyerCart", eshopBuyerCart);
        mav.addObject("addresses", addresses);
        mav.addObject("defAddresse", defAddresse);
        mav.setViewName("checkout");
        return mav;
    }

    @PostMapping("/placeOrder")
    public ModelAndView placeOrder(ModelAndView mav, HttpSession session, EshopOrder order) {
        //保存数据到订单
        EshopUser eshopUser = (EshopUser) session.getAttribute("currentUser");
        order.setUserId(eshopUser.getId());
        order.setOrderState(OrderEnum.StatusEnum.submit.getIndex());//订单提交
        order.setOrderIsPaiy(OrderEnum.IsPaiyEnum.payment_wait.getIndex());//待付款
        payService.save(order);

        //减去库存
        EshopBuyerCart eshopBuyerCart = trolleyService.getBuyerCart(eshopUser);
        eshopBuyerCart.getItems().forEach(item -> skuService.reduceSku(item.getSkuId(), item.getAmount()));

        //清空购物车的数据
        trolleyService.emptyBuyerItme(eshopUser);
        mav.setViewName("payment");
        return mav;
    }

}
