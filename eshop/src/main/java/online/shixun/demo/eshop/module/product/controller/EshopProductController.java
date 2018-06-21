/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.product.controller;

import com.github.pagehelper.PageInfo;
import online.shixun.demo.eshop.core.service.Node;
import online.shixun.demo.eshop.core.service.SlideshowEnum;
import online.shixun.demo.eshop.dto.*;
import online.shixun.demo.eshop.module.activity.service.EshopActivityService;
import online.shixun.demo.eshop.module.product.service.EshopProductService;
import online.shixun.demo.eshop.module.slideshow.service.EshopSlideshowService;
import online.shixun.demo.eshop.module.type.service.EshopTypeService;
import online.shixun.demo.eshop.module.user.service.EshopResourceService;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 产品
 */
@RestController
@RequestMapping(value = "/product")
public class EshopProductController {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private EshopResourceService resourceService;

    @Autowired
    private EshopProductService productService;

    @Autowired
    private EshopSlideshowService slideshowService;

    @Autowired
    private EshopActivityService activityService;

    @Autowired
    private EshopTypeService typeService;


    @Value("${system.page.productSize}")
    private Integer pageSize;

    @GetMapping("/detail")
    public ModelAndView detail(ModelAndView mav, String productId, String skuId) {

        //加载水平导航栏菜单
        List<Node<EshopResource>> levelNavigationMenu = resourceService.initLevelNavigation();
        //加载垂直导航栏菜单
        List<Node<EshopResource>> verticalNavigationMenu = resourceService.initVerticalNavigation();

        //设置数据到请求中
        mav.addObject("levelNavigationMenu", levelNavigationMenu);
        mav.addObject("verticalNavigationMenu", verticalNavigationMenu);

        //商品
        EshopProductWithBLOBs product = productService.getProduct(productId);
        mav.addObject("product", product);
        mav.addObject("skuId", skuId);//单击的销售单元

        //商品类型路径
        List<EshopType> parents = typeService.initParentNode(product.getTypeId());
        Collections.sort(parents, (o1, o2) -> -1);//倒序
        mav.addObject("parents", parents);//父类型类型

        mav.setViewName("detail");
        return mav;
    }

    /**
     * 跳转商品列表页
     *
     * @param mav
     * @param pageNum
     * @param classifyChecked
     * @return
     */
    @RequestMapping(value = "/category", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView category(ModelAndView mav,
                                 @RequestParam(defaultValue = "1") Integer pageNum,
                                 String classifyChecked,
                                 @RequestParam(defaultValue = "") String typesChecked,
                                 @RequestParam(defaultValue = "") String colorsChecked,
                                 @RequestParam(defaultValue = "") String brandsChecked,
                                 @RequestParam(defaultValue = "") String sizesChecked,
                                 String productName,
                                 @RequestParam(defaultValue = "1000") Integer priceMax,
                                 @RequestParam(defaultValue = "0") Integer currentPrice) {

        //加载水平导航栏菜单
        List<Node<EshopResource>> levelNavigationMenu = resourceService.initLevelNavigation();
        //加载垂直导航栏菜单
        List<Node<EshopResource>> verticalNavigationMenu = resourceService.initVerticalNavigation();

        //设置数据到请求中
        mav.addObject("levelNavigationMenu", levelNavigationMenu);
        mav.addObject("verticalNavigationMenu", verticalNavigationMenu);

        //控制筛选部分默认勾选
        mav.addObject("productName", productName);
        mav.addObject("classifyChecked", classifyChecked);
        mav.addObject("typesChecked", typesChecked.split(","));//选中的类型id数组
        mav.addObject("priceMax", priceMax);//商品价格限定区间0-priceMax
        mav.addObject("currentPrice", currentPrice);//当前商品价格
        mav.addObject("colorsChecked", colorsChecked.split(","));//选中的颜色id数组
        mav.addObject("brandsChecked", brandsChecked.split(","));//选中的品牌id数组
        mav.addObject("sizesChecked", sizesChecked.split(","));//选中的尺码id数组

        //加载轮播图
        List<EshopSlideshow> slideshows = slideshowService.getSlideshows(SlideshowEnum.CATEGORY_MAIN);
        mav.addObject("slideshows", slideshows);

        //加载热门活动
        List<EshopActivity> activitys = activityService.getActivitys(null);
        mav.addObject("activitys", activitys);

        mav.setViewName("category");
        return mav;
    }


    /**
     * 加载商品列表
     *
     * @param mav
     * @param productName 商品名称
     * @param type        父类型id
     * @param types       子类型id数组字符串","分割 示例：1，2，4
     * @param prices      价格数组(最低-最高)字符串","分割 示例：0-50,200-300,800-1500
     * @param colors      颜色id数组字符串","分割  示例：1，2，4
     * @param brands      品牌id数组字符串","分割  示例：1，2，4
     * @param sizes       尺码id数组字符串","分割  示例：1，2，4
     * @param pageNum     页码
     * @return
     */
    @GetMapping("/getProducts")
    public ModelAndView getProducts(ModelAndView mav,
                                    @RequestParam(defaultValue = "") String productName,
                                    @RequestParam(defaultValue = "") String type,
                                    @RequestParam(defaultValue = "") String types,
                                    @RequestParam(defaultValue = "") String prices,
                                    @RequestParam(defaultValue = "") String colors,
                                    @RequestParam(defaultValue = "") String brands,
                                    @RequestParam(defaultValue = "") String sizes,
                                    @RequestParam(defaultValue = "1") Integer pageNum) {

        logger.info("pageNum:" + pageNum);
        logger.info("productName:" + productName);
        logger.info("type:" + type);
        logger.info("types:" + types);
        logger.info("prices:" + prices);
        logger.info("colors:" + colors);
        logger.info("brands:" + brands);
        logger.info("sizes:" + sizes);

        //拆分数组成集合
        Set<String> types_set = Arrays.stream(types.split(",")).filter(Strings::isNotBlank).collect(Collectors.toSet());
        Set<String> prices_set = Arrays.stream(prices.split(",")).filter(Strings::isNotBlank).collect(Collectors.toSet());
        Set<String> colors_set = Arrays.stream(colors.split(",")).filter(Strings::isNotBlank).collect(Collectors.toSet());
        Set<String> brands_set = Arrays.stream(brands.split(",")).filter(Strings::isNotBlank).collect(Collectors.toSet());
        Set<String> sizes_set = Arrays.stream(sizes.split(",")).filter(Strings::isNotBlank).collect(Collectors.toSet());

        //查询商品
        PageInfo<EshopProductWithBLOBs> pageInfo = productService.getProducts(productName, type, types_set, prices_set, colors_set, brands_set, sizes_set, pageNum, this.pageSize);
        mav.addObject("pageInfo", pageInfo);
        mav.setViewName("fragment/category/products");
        return mav;
    }
}
