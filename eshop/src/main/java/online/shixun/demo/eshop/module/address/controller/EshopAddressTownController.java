/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.address.controller;

import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.dto.EshopAddressState;
import online.shixun.demo.eshop.dto.EshopAddressTown;
import online.shixun.demo.eshop.module.address.service.EshopAddressStateService;
import online.shixun.demo.eshop.module.address.service.EshopAddressTownService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName EshopAddressTownController
 * @Description TODO
 * @Date 2018/05/16 14:53
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
@RequestMapping("/address/town")
public class EshopAddressTownController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected EshopAddressTownService eshopAddressTownService;

    @GetMapping("/getTowns")
    public ResponseData getTowns(EshopAddressTown town) {
        ResponseData responseData = new ResponseData();
        List<EshopAddressTown> list = eshopAddressTownService.getTowns(town);
        responseData.setData(list);
        return responseData;
    }
}
