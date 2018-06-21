/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.address.service;

import online.shixun.demo.eshop.dto.EshopAddressCity;
import online.shixun.demo.eshop.dto.EshopAddressCityCriteria;
import online.shixun.demo.eshop.dto.EshopAddressProvince;
import online.shixun.demo.eshop.dto.EshopAddressProvinceCriteria;
import online.shixun.demo.eshop.module.address.mapper.EshopAddressCityMapper;
import online.shixun.demo.eshop.module.address.mapper.EshopAddressProvinceMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName EshopAddressProvinceService
 * @Description TODO
 * @Date 2018/05/16 14:53
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class EshopAddressProvinceService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopAddressProvinceMapper eshopAddressProvinceMapper;

    public List<EshopAddressProvince> getProvinces(EshopAddressProvince province) {
        EshopAddressProvinceCriteria example = new EshopAddressProvinceCriteria();
        if (Objects.nonNull(province)) {
            EshopAddressProvinceCriteria.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(province.getStateCode())) {
                criteria.andStateCodeEqualTo(province.getStateCode());
            }
        }
        return eshopAddressProvinceMapper.selectByExample(example);
    }
}
