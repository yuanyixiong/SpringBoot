/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.brand.controller;

import online.shixun.demo.eshopadmin.core.controller.BaseController;
import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.model.EshopBrandModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/shopping/mall/brand")
public class EshopBrandController extends BaseController<EshopBrandModel, String> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String getMainPageUrl() {
        return "brand/brandMain";
    }

    @Override
    public String getFromPageUrl() {
        return "brand/brandFrom";
    }

    @Autowired
    public EshopBrandController(@Qualifier("eshopBrandService") BaseServiceAbstractPage baseServiceAbstractPage) {
        super(baseServiceAbstractPage);
    }

    @Override
    public Sort getPagesSort() {
        return Sort.by(Sort.Order.asc("updateTime"));
    }
}