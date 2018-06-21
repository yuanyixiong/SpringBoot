/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.collect.controller;

import com.github.pagehelper.PageInfo;
import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.dto.EshopCollectItem;
import online.shixun.demo.eshop.dto.EshopSize;
import online.shixun.demo.eshop.module.collect.service.EshopCollectItemService;
import online.shixun.demo.eshop.module.collect.service.EshopCollectService;
import online.shixun.demo.eshop.module.product.service.EshopSizeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName EshopCollectItemController
 * @Description TODO
 * @Date 2018/05/14 16:01
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
@RequestMapping("/collectItem")
public class EshopCollectItemController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${system.page.collectItmeSize}")
    private Integer pageSize;

    @Autowired
    private EshopCollectItemService collectItemService;

    @Autowired
    private EshopSizeService sizeService;

    @GetMapping("/getCollectItems")
    public ModelAndView getCollectItems(ModelAndView mav, EshopCollectItem collectItem, @RequestParam(defaultValue = "1") Integer pageNum) {
        PageInfo<EshopCollectItem> pageInfo = collectItemService.getCollectItems(collectItem, pageNum, pageSize);
        List<EshopSize> sizes = sizeService.getSizes(new EshopSize());
        mav.addObject("pageInfo", pageInfo);
        mav.addObject("sizes", sizes);
        mav.setViewName("fragment/wishlist/collect_item");
        return mav;
    }


    @GetMapping("/delete")
    public ResponseData delete(EshopCollectItem collectItem) {
        ResponseData responseData = new ResponseData();
        collectItemService.deleteById(collectItem);
        responseData.setData("删除成功");
        return responseData;
    }

    @GetMapping("/edit")
    public ResponseData edit(EshopCollectItem collectItem) {
        ResponseData responseData = new ResponseData();
        collectItemService.edit(collectItem);
        responseData.setData("保存成功");
        return responseData;
    }
}
