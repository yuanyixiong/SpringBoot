/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.product.controller;

import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.dto.EshopBrand;
import online.shixun.demo.eshop.dto.EshopColor;
import online.shixun.demo.eshop.module.product.service.EshopColorService;
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
 * 产品颜色
 */
@RestController
@RequestMapping(value = "/color")
public class EshopColorController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopColorService colorService;


    @GetMapping("/getColors")
    public ResponseData getColors(String ids) {
        ResponseData responseData = new ResponseData();
        List<EshopColor> colors = colorService.getColors(Arrays.stream(ids.split(",")).collect(Collectors.toList()));
        responseData.setData(colors);
        return responseData;
    }

    @GetMapping("/getColorsByColor")
    public ResponseData getColors(EshopColor color) {
        ResponseData responseData = new ResponseData();
        List<EshopColor> colors = colorService.getColors(color);
        responseData.setData(colors);
        return responseData;
    }
}
