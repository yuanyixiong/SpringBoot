/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.shopping.controller;

import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.core.service.Node;
import online.shixun.demo.eshop.dto.*;
import online.shixun.demo.eshop.module.product.service.EshopProductService;
import online.shixun.demo.eshop.module.shopping.service.TrolleyService;
import online.shixun.demo.eshop.module.user.service.EshopResourceService;
import online.shixun.demo.eshop.util.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/trolley")
public class TrolleyController {

    private static final String COOKIE_NAME = "trolley";

    @Autowired
    private EshopResourceService resourceService;

    @Autowired
    private EshopProductService productService;

    @Autowired
    private TrolleyService trolleyService;

    /**
     * 去购物车页面
     *
     * @param mav
     * @param request
     * @return
     */
    @GetMapping(value = "/toList")
    public ModelAndView toList(ModelAndView mav, HttpServletRequest request) {

        //加载水平导航栏菜单
        List<Node<EshopResource>> levelNavigationMenu = resourceService.initLevelNavigation();
        //加载垂直导航栏菜单
        List<Node<EshopResource>> verticalNavigationMenu = resourceService.initVerticalNavigation();

        //设置数据到请求中
        mav.addObject("levelNavigationMenu", levelNavigationMenu);
        mav.addObject("verticalNavigationMenu", verticalNavigationMenu);

        EshopBuyerCart eshopBuyerCart = null;
        try {
            eshopBuyerCart = initEshopBuyerCart(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("buyerCart", eshopBuyerCart);
        mav.setViewName("order");
        return mav;
    }

    /**
     * 去购物车页面
     *
     * @param mav
     * @param request
     * @return
     */
    @GetMapping(value = "/toSimpleList")
    public ModelAndView toSimpleList(ModelAndView mav, HttpServletRequest request) {
        EshopBuyerCart eshopBuyerCart = null;
        try {
            eshopBuyerCart = initEshopBuyerCart(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("buyerCart", eshopBuyerCart);
        mav.setViewName("fragment/shopping/trolley_simple");
        return mav;
    }


    /**
     * 初始化购物车数据
     *
     * @param request
     * @return
     * @throws IOException
     */
    private EshopBuyerCart initEshopBuyerCart(HttpServletRequest request) {
        //读取Cookie中购物车信息
        EshopBuyerCart eshopBuyerCart = null;
        try {
            eshopBuyerCart = (EshopBuyerCart) CookieUtil.readCookie(request, COOKIE_NAME, EshopBuyerCart.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //读取数据库中购物车信息
        EshopUser user = (EshopUser) request.getSession().getAttribute("currentUser");
        if (Objects.nonNull(user)) {
            //登陆用户加载数据库数据
            for (EshopBuyerCartItem item : trolleyService.getBuyerCart(user).getItems()) {
                eshopBuyerCart.addItem(item);
            }
        }

        Set<String> skuIds = new HashSet<>();
        eshopBuyerCart.getItems().forEach(itme -> skuIds.add(Objects.isNull(itme.getSku()) ? itme.getSkuId() : itme.getSku().getId()));
        List<EshopProductWithBLOBs> products = skuIds.size() > 0 ? productService.getProductsBySkuIds(skuIds) : new ArrayList<>();

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
        return eshopBuyerCart;
    }


    /**
     * 添加商品到购物车
     *
     * @param skuId    销售单元id
     * @param amount
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = "/addItem")
    public ResponseData addItem(String skuId, Integer amount, HttpServletRequest request, HttpServletResponse response) {
        ResponseData responseData = new ResponseData();
        try {
            //读取Cookie中购物车信息
            EshopBuyerCart eshopBuyerCart = (EshopBuyerCart) CookieUtil.readCookie(request, COOKIE_NAME, EshopBuyerCart.class);

            //将当前商品追加到购物车中
            if (null != skuId && null != amount) {
                EshopSku sku = new EshopSku();
                sku.setId(skuId);
                EshopBuyerCartItem item = new EshopBuyerCartItem();
                item.setSku(sku);
                item.setAmount(amount);
                eshopBuyerCart.addItem(item);
            }

            //排序：根据购物车商品添加顺序倒序
            List<EshopBuyerCartItem> items = eshopBuyerCart.getItems();
            Collections.sort(items, (o1, o2) -> -1);

            //验证登入与否
            EshopUser user = (EshopUser) request.getSession().getAttribute("currentUser");
            if (Objects.nonNull(user)) {
                //[清空Cookie]
                CookieUtil.emptyCookie(response, COOKIE_NAME);
                //将购物车数据追加到数据库
                trolleyService.addBuyerItme(user, eshopBuyerCart.getItems());
            } else {
                //未登入用户购物车数据保存Cookie
                CookieUtil.saveCookie(response, COOKIE_NAME, eshopBuyerCart);
            }
            responseData.setData("商品已加入购物车");
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setError("加入购物车失败");
        }
        return responseData;
    }


    /**
     * 移除购物车中的商品
     *
     * @param request
     * @param response
     * @param skuId    销售单元id
     * @return
     * @throws IOException
     */
    @GetMapping("/removeItem")
    public ResponseData removeItem(HttpServletRequest request, HttpServletResponse response, String skuId, String id) {
        ResponseData responseData = new ResponseData();
        try {
            if (StringUtils.isNotBlank(id) && !Objects.equals(id, "null")) {
                //登入用户删除数据库中购物车数据
                trolleyService.removeBuyerItme(id);
            } else {
                //未登入用户读取Cookie中购物车数据
                EshopBuyerCart eshopBuyerCart = (EshopBuyerCart) CookieUtil.readCookie(request, COOKIE_NAME, EshopBuyerCart.class);
                //找到购物车中要移除的商品，并进行移除
                int index = -1;
                for (int i = 0; i < eshopBuyerCart.getItems().size(); i++) {
                    if (Objects.equals(eshopBuyerCart.getItems().get(i).getSku().getId(), skuId)) {
                        index = i;
                        break;
                    }
                }
                if (index != -1) {
                    eshopBuyerCart.getItems().remove(index);
                }
                //重新保存购物车
                CookieUtil.saveCookie(response, COOKIE_NAME, eshopBuyerCart);
            }
            responseData.setData("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setData("删除失败");
        }
        return responseData;
    }


    @GetMapping("/down")
    public ResponseData down(HttpServletRequest request, HttpServletResponse response, String skuId, String id) {
        ResponseData responseData = new ResponseData();
        try {
            if (StringUtils.isNotBlank(id) && !Objects.equals(id, "null")) {
                EshopBuyerCartItem buyerCartItem = trolleyService.getBuyerCartItem(id);
                buyerCartItem.setAmount(buyerCartItem.getAmount() - 1);
                if (buyerCartItem.getAmount() <= 0) {
                    trolleyService.removeBuyerItme(id);
                } else {
                    trolleyService.editBuyerCartItem(buyerCartItem);
                }
            } else {
                //未登入用户读取Cookie中购物车数据
                EshopBuyerCart eshopBuyerCart = (EshopBuyerCart) CookieUtil.readCookie(request, COOKIE_NAME, EshopBuyerCart.class);
                //找到购物车中要减少的商品
                int index = -1;
                for (int i = 0; i < eshopBuyerCart.getItems().size(); i++) {
                    if (Objects.equals(eshopBuyerCart.getItems().get(i).getSku().getId(), skuId)) {
                        index = i;
                        break;
                    }
                }
                if (index != -1) {
                    EshopBuyerCartItem item = eshopBuyerCart.getItems().get(index);
                    item.setAmount(item.getAmount() - 1);
                    if (item.getAmount() <= 0) {
                        eshopBuyerCart.getItems().remove(index);
                    } else {
                        eshopBuyerCart.getItems().set(index, item);
                    }
                }
                //重新保存购物车
                CookieUtil.saveCookie(response, COOKIE_NAME, eshopBuyerCart);
            }
            responseData.setData("成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setData("失败");
        }
        return responseData;
    }


    @GetMapping("/up")
    public ResponseData up(HttpServletRequest request, HttpServletResponse response, String skuId, String id) {
        ResponseData responseData = new ResponseData();
        try {
            if (StringUtils.isNotBlank(id) && !Objects.equals(id, "null")) {
                EshopBuyerCartItem buyerCartItem = trolleyService.getBuyerCartItem(id);
                buyerCartItem.setAmount(buyerCartItem.getAmount() + 1);
                trolleyService.editBuyerCartItem(buyerCartItem);
            } else {
                //未登入用户读取Cookie中购物车数据
                EshopBuyerCart eshopBuyerCart = (EshopBuyerCart) CookieUtil.readCookie(request, COOKIE_NAME, EshopBuyerCart.class);
                //找到购物车中要减少的商品
                int index = -1;
                for (int i = 0; i < eshopBuyerCart.getItems().size(); i++) {
                    if (Objects.equals(eshopBuyerCart.getItems().get(i).getSku().getId(), skuId)) {
                        index = i;
                        break;
                    }
                }
                if (index != -1) {
                    EshopBuyerCartItem item = eshopBuyerCart.getItems().get(index);
                    item.setAmount(item.getAmount() + 1);
                    eshopBuyerCart.getItems().set(index, item);
                }
                //重新保存购物车
                CookieUtil.saveCookie(response, COOKIE_NAME, eshopBuyerCart);
            }
            responseData.setData("成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setData("失败");
        }
        return responseData;
    }
}
