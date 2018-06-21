/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.brand.controller;

import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.dto.EshopBrand;
import online.shixun.demo.eshop.module.brand.service.EshopBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class EshopBrandController {

    @Autowired
    private EshopBrandService brandService;


    @GetMapping("/getBrandsByBrand")
    public ResponseData getBrands(EshopBrand brand) {
        ResponseData responseData = new ResponseData();
        List<EshopBrand> brands = brandService.getBrands(brand);
        responseData.setData(brands);
        return responseData;
    }
}
