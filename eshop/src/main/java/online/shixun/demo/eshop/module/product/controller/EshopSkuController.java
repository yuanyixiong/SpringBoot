/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.product.controller;

import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.dto.EshopSku;
import online.shixun.demo.eshop.module.product.service.EshopSkuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品尺码
 */
@RestController
@RequestMapping(value = "/sku")
public class EshopSkuController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopSkuService skuService;

    /**
     * 销售单元详情
     *
     * @param sku
     * @return
     */
    @GetMapping("/getSku")
    public ResponseData getSku(EshopSku sku) {
        ResponseData responseData = new ResponseData();
        sku = skuService.getSku(sku);
        responseData.setData(sku);
        return responseData;
    }
}
