/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.product.controller;

import online.shixun.demo.eshop.dto.EshopProduct;
import online.shixun.demo.eshop.module.product.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 推荐部分，控制器
 * 1.相关产品
 */
@RestController
@RequestMapping("recommend")
public class RecommendController {


    @Autowired
    private RecommendService recommendService;

    /**
     * 推荐：相关产品,根据产品的特性(品牌，类型)查询出相关产品的销售单元信息
     *
     * @param product 根据产品定位推荐
     * @return
     */
    @GetMapping("relatedProducts")
    public ModelAndView relatedProducts(ModelAndView mav, EshopProduct product) {
        List<EshopProduct> products = recommendService.relatedProducts(product);
        mav.addObject("products", products);
        mav.addObject("size", 3);
        mav.setViewName("fragment/recommend/recommendProducts");
        return mav;
    }

    /**
     * 推荐：你可能喜欢[进行中][购买、订单、搜藏、比较历史行为]
     *
     * @param mav
     * @param product
     * @return
     */
    @GetMapping("likeProducts")
    public ModelAndView likeProducts(ModelAndView mav, EshopProduct product) {
        List<EshopProduct> products = recommendService.relatedProducts(product);//recommendService.likeProducts(product);
        mav.addObject("products", products);
        mav.addObject("size", 3);
        mav.setViewName("fragment/recommend/recommendProducts");
        return mav;
    }

    /**
     * 推荐：最新特惠[最近上架的新品]
     *
     * @param mav
     * @return
     */
    @GetMapping("newProductsDetail")
    public ModelAndView newProductsDetail(ModelAndView mav) {
        List<EshopProduct> products = recommendService.newProducts(3);
        mav.addObject("products", products);
        mav.setViewName("fragment/recommend/newProducts");
        return mav;
    }


    /**
     * 推荐：最新特惠[最近上架的新品]
     *
     * @param mav
     * @return
     */
    @GetMapping("newProductsIndex")
    public ModelAndView newProductsIndex(ModelAndView mav) {
        List<EshopProduct> products = recommendService.newProducts(5);
        mav.addObject("products", products);
        mav.addObject("size", 5);
        mav.setViewName("fragment/recommend/recommendProducts");
        return mav;
    }


    /**
     * 推荐：店家推荐[店家推荐的商品]
     *
     * @param mav
     * @return
     */
    @GetMapping("commendProducts")
    public ModelAndView commendProducts(ModelAndView mav) {
        List<EshopProduct> products = recommendService.commendProducts();
        mav.addObject("products", products);
        mav.setViewName("fragment/recommend/commendProducts");
        return mav;
    }

    /**
     * 推荐：畅销产品[畅销的商品]
     *
     * @return
     */
    @GetMapping("hotProducts")
    public ModelAndView hotProducts(ModelAndView mav) {
        List<EshopProduct> products = recommendService.hotProducts();
        mav.addObject("products", products);
        mav.setViewName("fragment/recommend/hotProducts");
        return mav;
    }

    /**
     * 推荐：特价商品[价格最低的商品，评分最高]
     *
     * @return
     */
    @GetMapping("bargainProducts")
    public ModelAndView bargainProducts(ModelAndView mav) {
        List<EshopProduct> products = recommendService.bargainProducts();
        mav.addObject("products", products);
        mav.setViewName("fragment/recommend/bargainProducts");
        return mav;
    }

}
