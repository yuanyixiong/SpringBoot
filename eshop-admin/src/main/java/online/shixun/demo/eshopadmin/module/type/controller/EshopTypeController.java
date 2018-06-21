/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.type.controller;

import online.shixun.demo.eshopadmin.core.controller.BaseController;
import online.shixun.demo.eshopadmin.core.response.Node;
import online.shixun.demo.eshopadmin.core.response.ResponseData;
import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.core.service.TypeNodeEnum;
import online.shixun.demo.eshopadmin.model.EshopTypeModel;
import online.shixun.demo.eshopadmin.module.type.service.EshopTypeService;
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
@RequestMapping("/shopping/mall/type")
public class EshopTypeController extends BaseController<EshopTypeModel, String> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String getMainPageUrl() {
        return "type/typeMain";
    }

    @Override
    public String getFromPageUrl() {
        return "type/typeFrom";
    }

    @Autowired
    public EshopTypeController(@Qualifier("eshopTypeService") BaseServiceAbstractPage baseServiceAbstractPage) {
        super(baseServiceAbstractPage);
    }

    @Override
    public Sort getPagesSort() {
        return Sort.by(Sort.Order.asc("updateTime"));
    }

    /**
     * 加载带有层次结构的所有资源数据
     *
     * @return
     */
    @GetMapping("/getTypes")
    public ResponseData getTypes() {
        ResponseData responseData = new ResponseData();
        //获取用户登陆时候缓存的所有菜单数据[后期操作缓存]
        List<Node<EshopTypeModel>> nodes = ((EshopTypeService) this.baseServiceAbstractPage).initNode(TypeNodeEnum.ROOT.getName());
        responseData.setData(nodes);
        return responseData;
    }
}