/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.address.controller;

import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.dto.EshopAddressCity;
import online.shixun.demo.eshop.dto.EshopAddressProvince;
import online.shixun.demo.eshop.module.address.service.EshopAddressCityService;
import online.shixun.demo.eshop.module.address.service.EshopAddressProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName EshopAddressProvinceController
 * @Description TODO
 * @Date 2018/05/16 14:53
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
@RequestMapping("/address/province")
public class EshopAddressProvinceController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopAddressProvinceService addressProvinceService;

    @GetMapping("/getProvinces")
    public ResponseData getProvinces(EshopAddressProvince province) {
        ResponseData responseData = new ResponseData();
        List<EshopAddressProvince> list = addressProvinceService.getProvinces(province);
        responseData.setData(list);
        return responseData;
    }

}
