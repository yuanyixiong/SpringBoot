/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.type.controller;

import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.dto.EshopType;
import online.shixun.demo.eshop.module.type.service.EshopTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 产品颜色
 */
@RestController
@RequestMapping(value = "/type")
public class EshopTypeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopTypeService typeService;

    @GetMapping("/getTypesByType")
    public ResponseData getTypes(EshopType type) {
        ResponseData responseData = new ResponseData();
        List<EshopType> types = typeService.getTypes(type);
        responseData.setData(types);
        return responseData;
    }
}
