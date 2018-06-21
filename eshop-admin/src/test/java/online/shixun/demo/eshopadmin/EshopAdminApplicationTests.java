/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin;

import online.shixun.demo.eshopadmin.model.EshopResourceModel;
import online.shixun.demo.eshopadmin.module.brand.service.EshopBrandService;
import online.shixun.demo.eshopadmin.module.system.service.EshopResourceService;
import online.shixun.demo.eshopadmin.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

/***
 * 测试类 测试项目搭建
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EshopAdminApplicationTests {

    @Autowired
    private EshopBrandService brandService;

    @Autowired
    private EshopResourceService resourceService;

    /**
     * 测试数据访问层搭建
     */
    @Test
    public void test_getModel() throws Exception {
        System.out.println(brandService.getModel("1"));
        System.out.println("over");
    }


    /**
     * 测试分页
     */
    @Test
    public void test_getModelsPage() throws Exception {
        EshopResourceModel eshopResourceModel = new EshopResourceModel();
//        eshopResourceModel.setResourceName("管理");
        PageRequest pageRequest = null;//PageRequest.of(0,0);
        Sort sort = null;//Sort.by(Sort.Order.desc("resourceName"),Sort.Order.asc("resourceName"));
        Page<EshopResourceModel> pages = resourceService.getModelsPage(eshopResourceModel, null, null);
        System.out.println("===================================================");
        pages.stream().forEach(resource -> {
            System.out.println(resource);
        });


        //起始页码：0
        //终止页码：总页数-1

        //分页汇总信息
        System.out.println(String.format("总页数：%s", pages.getTotalPages()));
        System.out.println(String.format("总数据量：%s", pages.getTotalElements()));

        //当前页信息
        if (pages.getPageable().isPaged()) {
            System.out.println(String.format("每页显示数据量：%s", pages.getPageable().getPageSize()));
            System.out.println(String.format("当前页码：%s", pages.getPageable().getPageNumber()));
        }

        //上一页信息
        System.out.println(String.format("是否有上一页：%s", pages.previousPageable().isPaged()));
        if (pages.previousPageable().isPaged()) {
            System.out.println(String.format("上一页页码：%s", pages.previousPageable().getPageNumber()));
        }

        //下一页信息
        System.out.println(String.format("是否有下一页：%s", pages.nextPageable().isPaged()));
        if (pages.nextPageable().isPaged()) {
            System.out.println(String.format("下一页页码：%s", pages.nextPageable().getPageNumber()));
        }
        System.out.println("over");
    }



    public static void main(String[] args) {
        System.out.println( MD5Util.encode("123456"));
    }
}
