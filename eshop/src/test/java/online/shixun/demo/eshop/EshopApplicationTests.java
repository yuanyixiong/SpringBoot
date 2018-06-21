package online.shixun.demo.eshop;

import online.shixun.demo.eshop.module.brand.service.EshopBrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 * 测试类
 *********************************************/
@RunWith(SpringRunner.class)
@SpringBootTest
public class EshopApplicationTests {

    /**
     * 注入品牌服务
     */
    @Autowired
    private EshopBrandService eshopBrandService;

    /**
     * 测试数据访问层搭建
     */
    @Test
    public void test_findAll() {
//        for (EshopBrand eshopBrandModel :
//                eshopBrandService.getEshopBrandList()) {
//            System.out.println(eshopBrandModel);
//        }
//        System.out.println("over");
    }

    /**
     * 测试数据访问层事物
     */
    @Test
    public void test_save() {
//        eshopBrandService.save(new EshopBrand("3", "阿迪达斯", "呵呵", "阿迪达斯。png", 1));
//        System.out.println("save over");
    }

}
