/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.address.service;

import online.shixun.demo.eshop.dto.EshopAddressCity;
import online.shixun.demo.eshop.dto.EshopAddressCityCriteria;
import online.shixun.demo.eshop.module.address.mapper.EshopAddressCityMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName EshopAddressCityService
 * @Description TODO
 * @Date 2018/05/16 14:52
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class EshopAddressCityService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopAddressCityMapper eshopAddressCityMapper;

    public List<EshopAddressCity> getCitys(EshopAddressCity city) {
        EshopAddressCityCriteria example = new EshopAddressCityCriteria();
        if (Objects.nonNull(city)) {
            EshopAddressCityCriteria.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(city.getProvinceCode())) {
                criteria.andProvinceCodeEqualTo(city.getProvinceCode());
            }
        }
        return eshopAddressCityMapper.selectByExample(example);
    }
}
