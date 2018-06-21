/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.product.dao;

import online.shixun.demo.eshopadmin.model.EshopImgModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("eshopImgDao")
public interface EshopImgDao extends JpaRepository<EshopImgModel, String> {

    List<EshopImgModel> findByIdIn(String[] ids);

    /**
     * 根据产品的编号查询图片
     *
     * @param productId
     * @return
     */
    @Query(value = "select * from eshop_img where product_id = :productId", nativeQuery = true)
    List<EshopImgModel> findImgModelByProductId(@Param("productId") String productId);
}
