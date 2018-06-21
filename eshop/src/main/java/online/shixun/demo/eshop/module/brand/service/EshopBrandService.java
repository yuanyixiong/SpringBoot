/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.brand.service;

import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.dto.EshopBrand;
import online.shixun.demo.eshop.dto.EshopBrandCriteria;
import online.shixun.demo.eshop.module.brand.mapper.EshopBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
@Service
public class EshopBrandService {

    /***
     * 注入品牌模块的数据访问层
     */
    @Autowired
    private EshopBrandMapper eshopBrandMapper;

    /**
     * 获得所有品牌数据
     *
     * @return
     */
    public List<EshopBrand> getBrands(EshopBrand brand) {
        EshopBrandCriteria eshopBrandCriteria = new EshopBrandCriteria();
        EshopBrandCriteria.Criteria criteria = eshopBrandCriteria.createCriteria();
        criteria.andIsDelEqualTo(BeanEnum.UNDEL.getIndex());//未删
        if (Objects.nonNull(brand)) {
            //其他条件
        }
        return eshopBrandMapper.selectByExample(eshopBrandCriteria);
    }
}
