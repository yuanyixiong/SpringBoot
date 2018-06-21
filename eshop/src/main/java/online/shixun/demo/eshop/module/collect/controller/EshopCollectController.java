/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.collect.controller;

import com.github.pagehelper.PageInfo;
import online.shixun.demo.eshop.controller.BaseController;
import online.shixun.demo.eshop.core.response.ResponseData;
import online.shixun.demo.eshop.core.service.Node;
import online.shixun.demo.eshop.core.service.TimeEnum;
import online.shixun.demo.eshop.dto.EshopCollect;
import online.shixun.demo.eshop.dto.EshopResource;
import online.shixun.demo.eshop.module.collect.service.EshopCollectService;
import online.shixun.demo.eshop.module.user.service.EshopResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @ClassName EshopCollectController
 * @Description TODO
 * @Date 2018/05/14 16:01
 * @Author shixun.online
 * @Version 1.0
 **/
@RestController
@RequestMapping("/collect")
public class EshopCollectController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${system.page.collectSize}")
    private Integer pageSize;

    @Autowired
    private EshopResourceService resourceService;

    @Autowired
    private EshopCollectService collectService;

    @GetMapping("/main")
    public ModelAndView main(ModelAndView mav) {
        //加载水平导航栏菜单
        List<Node<EshopResource>> levelNavigationMenu = resourceService.initLevelNavigation();
        //加载垂直导航栏菜单
        List<Node<EshopResource>> verticalNavigationMenu = resourceService.initVerticalNavigation();
        //设置数据到请求中
        mav.addObject("levelNavigationMenu", levelNavigationMenu);
        mav.addObject("verticalNavigationMenu", verticalNavigationMenu);

        mav.addObject("title", "collect");
        mav.setViewName("wishlist");
        return mav;
    }

    @GetMapping("/getCollects")
    public ModelAndView getCollects(ModelAndView mav, EshopCollect collect, Date beginTime, Date endTime, @RequestParam(defaultValue = "1") Integer timeEnumIndex, @RequestParam(defaultValue = "0") Integer pageNum, String action) {
        try {
            PageInfo<EshopCollect> pageInfo = collectService.getCollects(collect, TimeEnum.getTimeEnum(timeEnumIndex), beginTime, endTime, pageNum, this.pageSize);
            mav.addObject("pageInfo", pageInfo);
        } catch (ParseException e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }
        mav.addObject("timeEnumIndex", timeEnumIndex);
        mav.addObject("collect", collect);
        mav.addObject("beginTime", beginTime);
        mav.addObject("endTime", endTime);
        mav.addObject("action", action);
        mav.setViewName("fragment/wishlist/collect_table");
        return mav;
    }

    @GetMapping("/addCollect")
    public ResponseData addCollect(String skuId, String userId) {
        ResponseData responseData = new ResponseData();
        collectService.addCollect(skuId, userId);
        responseData.setData("已加入收藏");
        return responseData;
    }

    @GetMapping("/fakeDelete")
    public ResponseData fakeDelete(EshopCollect collect) {
        ResponseData responseData = new ResponseData();
        collectService.fakeDelete(collect);
        responseData.setData("已加入回收站");
        return responseData;
    }

    @GetMapping("/realDelete")
    public ResponseData realDelete(EshopCollect collect) {
        ResponseData responseData = new ResponseData();
        collectService.realDelete(collect);
        responseData.setData("已删除");
        return responseData;
    }

    @GetMapping("/restoreDelete")
    public ResponseData restoreDelete(EshopCollect collect) {
        ResponseData responseData = new ResponseData();
        collectService.restoreDelete(collect);
        responseData.setData("已还原");
        return responseData;
    }
}
