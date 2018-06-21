/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.address.service;

import online.shixun.demo.eshop.dto.EshopAddressState;
import online.shixun.demo.eshop.dto.EshopAddressStateCriteria;
import online.shixun.demo.eshop.dto.EshopAddressTown;
import online.shixun.demo.eshop.dto.EshopAddressTownCriteria;
import online.shixun.demo.eshop.module.address.mapper.EshopAddressStateMapper;
import online.shixun.demo.eshop.module.address.mapper.EshopAddressTownMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName EshopAddressTownService
 * @Description TODO
 * @Date 2018/05/16 14:53
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class EshopAddressTownService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopAddressTownMapper eshopAddressTownMapper;

    public List<EshopAddressTown> getTowns(EshopAddressTown town) {
        EshopAddressTownCriteria example = new EshopAddressTownCriteria();
        if (Objects.nonNull(town)) {
            EshopAddressTownCriteria.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(town.getCityCode())) {
                criteria.andCityCodeEqualTo(town.getCityCode());
            }
        }
        return eshopAddressTownMapper.selectByExample(example);
    }
}
