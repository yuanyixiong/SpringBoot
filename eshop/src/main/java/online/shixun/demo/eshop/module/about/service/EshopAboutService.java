/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.about.service;

import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.dto.EshopAbout;
import online.shixun.demo.eshop.dto.EshopAboutCriteria;
import online.shixun.demo.eshop.module.about.mapper.EshopAboutMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EshopAboutService
 * @Description TODO
 * @Date 2018/05/21 14:08
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class EshopAboutService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopAboutMapper aboutMapper;

    public List<EshopAbout> getEshopAbouts() {
        EshopAboutCriteria example = new EshopAboutCriteria();
        EshopAboutCriteria.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(BeanEnum.UNDEL.getIndex());
        example.setOrderByClause("about_index desc");
        return aboutMapper.selectByExampleWithBLOBs(example);
    }
}
