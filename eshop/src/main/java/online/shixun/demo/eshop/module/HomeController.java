package online.shixun.demo.eshop.module;

import com.github.pagehelper.PageInfo;
import online.shixun.demo.eshop.core.service.Node;
import online.shixun.demo.eshop.core.service.SlideshowEnum;
import online.shixun.demo.eshop.dto.EshopProductWithBLOBs;
import online.shixun.demo.eshop.dto.EshopResource;
import online.shixun.demo.eshop.dto.EshopSlideshow;
import online.shixun.demo.eshop.dto.EshopType;
import online.shixun.demo.eshop.module.product.service.EshopProductService;
import online.shixun.demo.eshop.module.product.service.RecommendService;
import online.shixun.demo.eshop.module.slideshow.service.EshopSlideshowService;
import online.shixun.demo.eshop.module.type.service.EshopTypeService;
import online.shixun.demo.eshop.module.user.service.EshopResourceService;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
@RestController
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private EshopProductService productService;

    @Autowired
    private EshopTypeService typeService;

    @Autowired
    private EshopResourceService resourceService;

    @Autowired
    private EshopSlideshowService slideshowService;

    @RequestMapping(value = {"/", "/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView brandMain(ModelAndView mav) {
        //加载水平导航栏菜单
        List<Node<EshopResource>> levelNavigationMenu = resourceService.initLevelNavigation();
        //加载垂直导航栏菜单
        List<Node<EshopResource>> verticalNavigationMenu = resourceService.initVerticalNavigation();
        //设置数据到请求中
        mav.addObject("levelNavigationMenu", levelNavigationMenu);
        mav.addObject("verticalNavigationMenu", verticalNavigationMenu);


        //加载商品类型
        List<Node<EshopType>> productTypeMenu = typeService.initProductTypeMenu();
        //设置数据到请求中
        mav.addObject("productTypeMenu", productTypeMenu);

        //加载轮播图(广告)
        mav.addObject("main_slideshows", slideshowService.getSlideshows(SlideshowEnum.INDEX_MAIN));//首页-轮播图
        mav.addObject("camera_slideshows", slideshowService.getSlideshows(SlideshowEnum.INDEX_CAMERA));//首页-数码-轮播图
        mav.addObject("jewelry_slideshows", slideshowService.getSlideshows(SlideshowEnum.INDEX_JEWELRY));//首页-珠宝-轮播图
        mav.addObject("sport_slideshows",  slideshowService.getSlideshows(SlideshowEnum.INDEX_SPORT));//首页-运动-轮播图

        //设置转发的页面
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView mav){
        //加载水平导航栏菜单
        List<Node<EshopResource>> levelNavigationMenu = resourceService.initLevelNavigation();
        //加载垂直导航栏菜单
        List<Node<EshopResource>> verticalNavigationMenu = resourceService.initVerticalNavigation();
        //设置数据到请求中
        mav.addObject("levelNavigationMenu", levelNavigationMenu);
        mav.addObject("verticalNavigationMenu", verticalNavigationMenu);

        mav.setViewName("login");
        return mav;
    }

    /**
     * 加载商品列表
     *
     * @param mav
     * @param types 子类型id数组字符串","分割 示例：1，2，4
     * @return
     */
    @GetMapping("/index/getProducts")
    public ModelAndView getProducts(ModelAndView mav, @RequestParam(defaultValue = "") String types, @RequestParam(defaultValue = "1") Integer pageSize) {
        logger.info("types:" + types);
        //拆分数组成集合
        Set<String> types_set = Arrays.stream(types.split(",")).filter(Strings::isNotBlank).collect(Collectors.toSet());
        //查询商品
        PageInfo<EshopProductWithBLOBs> pageInfo = productService.getProducts(null, null, types_set, null, null, null, null, 1, pageSize);
        mav.addObject("pageInfo", pageInfo);
        mav.setViewName("fragment/index/products");
        return mav;
    }

}
