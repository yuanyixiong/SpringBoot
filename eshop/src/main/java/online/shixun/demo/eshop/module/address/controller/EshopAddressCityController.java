/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.address.controller;

import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.dto.EshopAddressCity;
import online.shixun.demo.eshop.module.address.service.EshopAddressCityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName EshopAddressCityController
 * @Description TODO
 * @Date 2018/05/16 14:52
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
@RequestMapping("/address/city")
public class EshopAddressCityController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopAddressCityService addressCityService;

    @GetMapping("/getCitys")
    public ResponseData getCitys(EshopAddressCity city) {
        ResponseData responseData = new ResponseData();
        List<EshopAddressCity> list = addressCityService.getCitys(city);
        responseData.setData(list);
        return responseData;
    }
}
