/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.system.controller;

import online.shixun.demo.eshopadmin.core.controller.BaseController;
import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.model.EshopRoleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/role")
public class EshopRoleController extends BaseController<EshopRoleModel, String> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String getMainPageUrl() {
        return "role/roleMain";
    }

    @Override
    public String getFromPageUrl() {
        return "role/roleFrom";
    }

    @Autowired
    public EshopRoleController(@Qualifier("eshopRoleService") BaseServiceAbstractPage baseServiceAbstractPage) {
        super(baseServiceAbstractPage);
    }

    @Override
    public Sort getPagesSort() {
        return Sort.by(Sort.Order.asc("updateTime"));
    }

}