/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.product.service;

import online.shixun.demo.eshop.dto.EshopProduct;
import online.shixun.demo.eshop.module.product.mapper.RecommendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐部分，业务
 * 1.相关产品
 */
@Service
public class RecommendService {

    @Autowired
    private RecommendMapper recommendMapper;


    /**
     * 推荐：相关产品,根据产品的特性(品牌，类型)查询出相关产品的销售单元信息
     *
     * @param product 推荐的参考产品
     * @return 推荐三个最近上架的相关产品，1.品牌类型一致，2.品牌一致，3.类型一致
     */
    public List<EshopProduct> relatedProducts(EshopProduct product) {
        return recommendMapper.relatedProducts(product);
    }

    /**
     * 推荐：你可能喜欢[进行中][历史行为]
     *
     * @param product 推荐的参考产品
     * @return
     */
    public List<EshopProduct> likeProducts(EshopProduct product) {
        return new ArrayList<>();//recommendMapper.likeProducts(product);
    }

    /**
     * 推荐：最新特惠
     *
     * @param size 首页显示5个/详细页面显示3个
     * @return
     */
    public List<EshopProduct> newProducts(int size) {
        return recommendMapper.newProducts(size);
    }

    /**
     * 推荐：畅销产品[畅销的商品]
     *
     * @return
     */
    public List<EshopProduct> hotProducts() {
        return recommendMapper.hotProducts();
    }

    /**
     * 推荐：店家推荐[店家推荐的商品]
     *
     * @return
     */
    public List<EshopProduct> commendProducts() {
        return recommendMapper.commendProducts();
    }

    /**
     * 推荐：特价商品[价格最低的商品，评分最高]
     *
     * @return
     */
    public List<EshopProduct> bargainProducts() {
        return recommendMapper.bargainProducts();
    }
}
