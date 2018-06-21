/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.product.service;

import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.dto.EshopColor;
import online.shixun.demo.eshop.dto.EshopColorCriteria;
import online.shixun.demo.eshop.module.product.mapper.EshopColorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class EshopColorService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopColorMapper colorMapper;


    public List<EshopColor> getColors(Collection<String> ids) {
        return colorMapper.getEshopColorsByIds(ids);
    }

    public List<EshopColor> getColors(EshopColor color) {
        EshopColorCriteria eshopColorCriteria = new EshopColorCriteria();
        EshopColorCriteria.Criteria criteria = eshopColorCriteria.createCriteria();
        criteria.andIsDelEqualTo(BeanEnum.UNDEL.getIndex());//未删
        if (Objects.nonNull(color)) {
            //其他条件
        }
        return colorMapper.selectByExample(eshopColorCriteria);
    }

}
