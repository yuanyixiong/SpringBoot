/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.address.service;

import online.shixun.demo.eshop.dto.EshopAddressState;
import online.shixun.demo.eshop.dto.EshopAddressStateCriteria;
import online.shixun.demo.eshop.module.address.mapper.EshopAddressStateMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName EshopAddressStateService
 * @Description TODO
 * @Date 2018/05/16 14:53
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class EshopAddressStateService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopAddressStateMapper eshopAddressStateMapper;

    public List<EshopAddressState> getStates(EshopAddressState state) {
        EshopAddressStateCriteria example = new EshopAddressStateCriteria();
        if (Objects.nonNull(state)) {
            EshopAddressStateCriteria.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(state.getCode())) {
                criteria.andCodeEqualTo(state.getCode());
            }
        }
        return eshopAddressStateMapper.selectByExample(example);
    }
}
