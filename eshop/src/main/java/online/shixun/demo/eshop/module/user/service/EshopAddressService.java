/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.user.service;

import online.shixun.demo.eshop.core.service.AddressEnum;
import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.dto.*;
import online.shixun.demo.eshop.module.address.service.EshopAddressCityService;
import online.shixun.demo.eshop.module.address.service.EshopAddressProvinceService;
import online.shixun.demo.eshop.module.address.service.EshopAddressStateService;
import online.shixun.demo.eshop.module.address.service.EshopAddressTownService;
import online.shixun.demo.eshop.module.user.mapper.EshopAddressMapper;
import online.shixun.demo.eshop.util.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName EshopAddressService
 * @Description TODO
 * @Date 2018/05/16 16:32
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class EshopAddressService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopAddressMapper eshopAddressMapper;

    @Autowired
    private EshopAddressStateService addressStateService;

    @Autowired
    private EshopAddressProvinceService addressProvinceService;

    @Autowired
    private EshopAddressCityService addressCityService;

    @Autowired
    private EshopAddressTownService addressTownService;

    /**
     * 加载用户的默认地址
     *
     * @param userId
     * @return
     */
    public EshopAddress getUserDefAddress(String userId) {
        EshopAddressCriteria eshopAddressCriteria = new EshopAddressCriteria();
        EshopAddressCriteria.Criteria criteria = eshopAddressCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);//指定用户
        criteria.andIsDelEqualTo(BeanEnum.UNDEL.getIndex()); //地址未删
        criteria.andAddressIsDefEqualTo(AddressEnum.DEF.getIndex());//默认地址
        eshopAddressCriteria.setOrderByClause("update_time desc");
        List<EshopAddress> list = eshopAddressMapper.selectByExample(eshopAddressCriteria);
        return Objects.isNull(list) ? null : list.size() > 0 ? list.stream().findFirst().get() : null;
    }

    /**
     * 加载用户的所有地址
     *
     * @param userId
     * @return
     */
    public List<EshopAddress> getUserAddress(String userId) {
        return eshopAddressMapper.getUserAddress(userId);
    }

    public int fakeDelete(EshopAddress address) {
        address = eshopAddressMapper.selectByPrimaryKey(address.getId());
        address.setIsDel(BeanEnum.DEL.getIndex());
        return eshopAddressMapper.updateByPrimaryKeySelective(address);
    }

    public int edit(EshopAddress address) {
        if (Objects.nonNull(address.getAddressIsDef())) {
            EshopAddress record = new EshopAddress();
            record.setAddressIsDef(AddressEnum.UNDEF.getIndex());
            EshopAddressCriteria example = new EshopAddressCriteria();
            EshopAddressCriteria.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(address.getUserId());
            eshopAddressMapper.updateByExampleSelective(record, example);
        }
        return eshopAddressMapper.updateByPrimaryKeySelective(address);
    }

    public int save(EshopAddress address) {
        address.setId(BeanUtils.getId());
        address.setAddressIsDef(AddressEnum.UNDEF.getIndex());
        address.setIsDel(BeanEnum.UNDEL.getIndex());
        address.setAddressName("暂无");
        address.setCreateTime(new Date());
        address.setUpdateTime(new Date());
        return eshopAddressMapper.insertSelective(address);
    }
}
