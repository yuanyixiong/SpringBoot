/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.product.controller;

import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.dto.EshopSize;
import online.shixun.demo.eshop.dto.EshopType;
import online.shixun.demo.eshop.module.product.service.EshopSizeService;
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
 * 产品尺码
 */
@RestController
@RequestMapping(value = "/size")
public class EshopSizeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopSizeService sizeService;


    @GetMapping("/getSizes")
    public ResponseData getSizes(String ids) {
        ResponseData responseData = new ResponseData();
        List<EshopSize> sizes = sizeService.getSizes(Arrays.stream(ids.split(",")).collect(Collectors.toList()));
        responseData.setData(sizes);
        return responseData;
    }

    @GetMapping("/getSizesBySize")
    public ResponseData getSizes(EshopType type) {
        ResponseData responseData = new ResponseData();
        List<EshopSize> sizes = sizeService.getSizes(type);
        responseData.setData(sizes);
        return responseData;
    }
}
