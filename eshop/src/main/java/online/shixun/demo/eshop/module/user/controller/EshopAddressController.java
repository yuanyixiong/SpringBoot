/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.user.controller;

import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.dto.EshopAddress;
import online.shixun.demo.eshop.module.user.service.EshopAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName EshopAddressController
 * @Description TODO
 * @Date 2018/05/16 16:41
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
@RequestMapping("/address")
public class EshopAddressController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopAddressService eshopAddressService;

    @GetMapping("/getUserDefAddress")
    public ResponseData getUserDefAddress(String userId) {
        ResponseData responseData = new ResponseData();
        EshopAddress address = eshopAddressService.getUserDefAddress(userId);
        responseData.setData(address);
        return responseData;
    }

    @DeleteMapping("/deleteAddress")
    public ResponseData deleteAddress(EshopAddress address) {
        ResponseData responseData = new ResponseData();
        eshopAddressService.fakeDelete(address);
        responseData.setData(address);
        return responseData;
    }

    @PatchMapping("/editAddress")
    public ResponseData editAddress(EshopAddress address) {
        ResponseData responseData = new ResponseData();
        eshopAddressService.edit(address);
        responseData.setData(address);
        return responseData;
    }

    @PostMapping("/saveAddress")
    public ResponseData saveAddress(EshopAddress address) {
        ResponseData responseData = new ResponseData();
        eshopAddressService.save(address);
        responseData.setData(address);
        return responseData;
    }

}
