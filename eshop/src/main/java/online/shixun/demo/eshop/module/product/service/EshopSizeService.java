/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.product.service;

import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.dto.EshopSize;
import online.shixun.demo.eshop.dto.EshopSizeCriteria;
import online.shixun.demo.eshop.dto.EshopType;
import online.shixun.demo.eshop.module.product.mapper.EshopSizeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;


@Service
public class EshopSizeService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopSizeMapper sizeMapper;

    public List<EshopSize> getSizes(Collection<String> ids) {
        return sizeMapper.getEshopSizesByIds(ids);
    }


    public List<EshopSize> getSizes(EshopType eshopType) {
        return sizeMapper.getSizes(eshopType);
    }

    public List<EshopSize> getSizes(EshopSize eshopSize) {
        EshopSizeCriteria eshopSizeCriteria = new EshopSizeCriteria();
        EshopSizeCriteria.Criteria criteria = eshopSizeCriteria.createCriteria();
        criteria.andIsDelEqualTo(BeanEnum.UNDEL.getIndex());
        if (Objects.nonNull(eshopSize)) {

        }
        return sizeMapper.selectByExample(eshopSizeCriteria);
    }
}
