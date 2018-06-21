/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.product.dao;

import online.shixun.demo.eshopadmin.model.EshopSkuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository("eshopSkuDao")
public interface EshopSkuDao extends JpaRepository<EshopSkuModel, String> {

    /**
     * 检索某一个商品的销售单元是否存在
     *
     * @param colorId
     * @param sizeId
     * @param productId
     * @return
     */
    @Query(value = "select * from eshop_sku where color_id= :colorId and size_id= :sizeId and product_id= :productId", nativeQuery = true)
    List<EshopSkuModel> findEshopSkuModel(@Param("colorId") String colorId, @Param("sizeId") String sizeId, @Param("productId") String productId);

    /**
     * 查询某一个商品的所有销售单元
     *
     * @param productId
     * @return
     */
    @Query(value = "select * from eshop_sku where product_id= :productId", nativeQuery = true)
    List<EshopSkuModel> findEshopSkuModelByProduct(@Param("productId") String productId);

    /**
     * 批量删除
     *
     * @param ids id集合
     */
    @Modifying
    @Query(value = "delete from eshop_sku where id in ( :ids ) ", nativeQuery = true)
    void batchReomve(@Param("ids") Collection<String> ids);
}
