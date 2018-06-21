/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.product.mapper;

import online.shixun.demo.eshop.dto.EshopProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;

import java.util.List;

/**
 * 推荐部分,数据访问
 * 1.相关产品
 */
@Mapper
public interface RecommendMapper {

    /**
     * 推荐：相关产品,根据产品的特性(品牌，类型)查询出相关产品的销售单元信息
     *
     * @param product 推荐的参考产品
     * @return 推荐三个最近上架的相关产品，1.品牌类型一致，2.品牌一致，3.类型一致
     */
    @ResultType(EshopProduct.class)
    @ResultMap("recommendProductsResultMap")
    List<EshopProduct> relatedProducts(EshopProduct product);


    /**
     * 推荐：你可能喜欢[进行中]
     *
     * @param product 推荐的参考产品
     * @return
     */
    @ResultType(EshopProduct.class)
    @ResultMap("recommendProductsResultMap")
    List<EshopProduct> likeProducts(EshopProduct product);

    /**
     * 推荐：畅销产品
     *
     * @return
     */
    @ResultType(EshopProduct.class)
    @ResultMap("recommendProductsResultMap")
    List<EshopProduct> hotProducts();

    /**
     * 推荐：店家推荐
     *
     * @return
     */
    @ResultType(EshopProduct.class)
    @ResultMap("recommendProductsResultMap")
    List<EshopProduct> commendProducts();


    /**
     * 推荐：最新特惠
     *
     * @return
     */
    @ResultType(EshopProduct.class)
    @ResultMap("recommendProductsResultMap")
    List<EshopProduct> newProducts(@Param("size") int size);

    /**
     * 推荐：特价商品[价格最低的商品，评分最高]
     *
     * @return
     */
    @ResultType(EshopProduct.class)
    @ResultMap("recommendProductsResultMap")
    List<EshopProduct> bargainProducts();
}
