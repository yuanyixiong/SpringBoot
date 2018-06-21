/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.product.controller;

import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.dto.EshopFeature;
import online.shixun.demo.eshop.module.product.service.EshopFeatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 产品属性
 */
@RestController
@RequestMapping(value = "/feature")
public class EshopFeatureController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopFeatureService featureService;


    @GetMapping("/getFeatures")
    public ResponseData getFeatures(String ids) {
        ResponseData responseData = new ResponseData();
        List<EshopFeature> features = featureService.getFeatures(Arrays.stream(ids.split(",")).collect(Collectors.toList()));
        responseData.setData(features);
        return responseData;
    }
}
