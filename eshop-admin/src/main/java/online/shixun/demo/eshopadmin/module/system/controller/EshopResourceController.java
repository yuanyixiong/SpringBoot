/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.system.controller;

import online.shixun.demo.eshopadmin.core.controller.BaseController;
import online.shixun.demo.eshopadmin.core.response.Node;
import online.shixun.demo.eshopadmin.core.response.ResponseData;
import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.model.EshopResourceModel;
import online.shixun.demo.eshopadmin.security.service.EshopResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/resource")
public class EshopResourceController extends BaseController<EshopResourceModel, String> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private EshopResourceService resourceService;

    @Override
    public String getMainPageUrl() {
        return "resource/resourceMain";
    }

    @Override
    public String getFromPageUrl() {
        return "resource/resourceFrom";
    }

    @Autowired
    public EshopResourceController(@Qualifier("eshopResourceService") BaseServiceAbstractPage baseServiceAbstractPage, @Qualifier("securityResourceService") EshopResourceService resourceService) {
        super(baseServiceAbstractPage);
        this.resourceService = resourceService;
    }

    @Override
    public Sort getPagesSort() {
        return Sort.by(Sort.Order.asc("id"), Sort.Order.asc("resourceParentId"), Sort.Order.asc("resourceIndex"), Sort.Order.asc("updateTime"));
    }

    /**
     * 加载带有层次结构的所有资源数据
     *
     * @return
     */
    @GetMapping("/getResources")
    public ResponseData getResources() {
        ResponseData responseData = new ResponseData();
        //获取所有资源数据
        List<Node<EshopResourceModel>> nodes = this.resourceService.initNode("root");
        responseData.setData(nodes);
        return responseData;
    }

}