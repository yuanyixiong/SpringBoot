/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.shopping.controller;

import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.core.service.Node;
import online.shixun.demo.eshop.dto.EshopProductWithBLOBs;
import online.shixun.demo.eshop.dto.EshopResource;
import online.shixun.demo.eshop.module.product.service.EshopProductService;
import online.shixun.demo.eshop.module.shopping.model.ComparisonTable;
import online.shixun.demo.eshop.module.user.service.EshopResourceService;
import online.shixun.demo.eshop.util.CookieUtil;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("comparison")
public class ComparisonController {


    private static final String COOKIE_NAME = "comparisonTable";

    @Autowired
    private EshopResourceService resourceService;

    @Autowired
    private EshopProductService productService;


    /**
     * 查询当前的对比列表数据个数
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/getListSize")
    public ResponseData getListSize(HttpServletRequest request) {
        ResponseData responseData = new ResponseData();
        try {
            ComparisonTable comparisonTable = (ComparisonTable) CookieUtil.readCookie(request, COOKIE_NAME, ComparisonTable.class);
            //验证Cookie中商品对比列表,如果为空则，新建商品对比列表
            if (Objects.isNull(comparisonTable)) {
                comparisonTable = new ComparisonTable();
            }
            responseData.setData(comparisonTable.getSkuIds().stream().filter(t -> Strings.isNotBlank(t)).collect(Collectors.toList()).size());
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setError(e.getMessage());
        }
        return responseData;
    }

    /**
     * 去商品对比页面
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

        List<EshopProductWithBLOBs> products = new ArrayList<>();
        try {
            //读取Cookie中商品对比列表数据
            ComparisonTable comparisonTable = (ComparisonTable) CookieUtil.readCookie(request, COOKIE_NAME, ComparisonTable.class);

            //验证Cookie中商品对比列表,如果为空则，新建商品对比列表
            if (Objects.isNull(comparisonTable)) {
                comparisonTable = new ComparisonTable();
            }

            Set<String> skuId = new HashSet<>();
            comparisonTable.getSkuIds().forEach(skuId::add);
            products = skuId.size() > 0 ? productService.getProductsBySkuIds(skuId) : new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("products", products);
        mav.setViewName("compare");
        return mav;
    }

    /**
     * 加入商品到商品对比列表
     *
     * @param skuId    销售单元id
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = "/addItem")
    public ResponseData addItem(String skuId, HttpServletRequest request, HttpServletResponse response) {
        ResponseData responseData = new ResponseData();
        try {
            //读取Cookie中的商品对比列表
            ComparisonTable comparisonTable = (ComparisonTable) CookieUtil.readCookie(request, COOKIE_NAME, ComparisonTable.class);

            //将当前商品追加到商品对比列表中
            if (Strings.isNotBlank(skuId)) {
                comparisonTable.addItem(skuId);
            }

            //排序：根据商品对比列表添加顺序倒序
            Collections.sort(comparisonTable.getSkuIds(), (o1, o2) -> -1);

            //将商品对比列表写入Cookie
            CookieUtil.saveCookie(response, COOKIE_NAME, comparisonTable);

            responseData.setData("商品已加入商品对比列表");
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setError("加入商品对比列表失败");
        }
        return responseData;
    }


    /**
     * 移除商品对比列表中的商品
     *
     * @param request
     * @param response
     * @param skuId    销售单元id
     * @return
     * @throws IOException
     */
    @GetMapping("/removeItem")
    public ResponseData removeItem(HttpServletRequest request, HttpServletResponse response, String skuId) throws IOException {
        ResponseData responseData = new ResponseData();
        try {
            //读取Cookie中商品对比列表数据
            ComparisonTable comparisonTable = (ComparisonTable) CookieUtil.readCookie(request, COOKIE_NAME, ComparisonTable.class);
            //找到商品对比列表中要移除的商品，并进行移除
            comparisonTable.getSkuIds().remove(skuId);
            //重新保存购物车
            CookieUtil.saveCookie(response, COOKIE_NAME, comparisonTable);
            responseData.setData("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setData("删除失败");
        }
        return responseData;
    }
}
