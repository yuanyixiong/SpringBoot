/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.product.service;

import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.dto.EshopSku;
import online.shixun.demo.eshop.dto.EshopSkuCriteria;
import online.shixun.demo.eshop.module.product.mapper.EshopSkuMapper;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EshopSkuService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopSkuMapper skuMapper;

    /**
     * 销售单元详情
     *
     * @param sku
     * @return
     */
    public EshopSku getSku(EshopSku sku) {
        EshopSkuCriteria eshopSkuCriteria = new EshopSkuCriteria();
        EshopSkuCriteria.Criteria criteria = eshopSkuCriteria.createCriteria();
        criteria.andIsDelEqualTo(BeanEnum.UNDEL.getIndex());//未删

        if (Objects.nonNull(sku)) {
            if (Strings.isNotBlank(sku.getId())) {
                criteria.andIdEqualTo(sku.getId());
            }
            if (Strings.isNotBlank(sku.getSizeId())) {
                criteria.andSizeIdEqualTo(sku.getSizeId());
            }
            if (Strings.isNotBlank(sku.getColorId())) {
                criteria.andColorIdEqualTo(sku.getColorId());
            }
            if (Strings.isNotBlank(sku.getProductId())) {
                criteria.andProductIdEqualTo(sku.getProductId());
            }
        }
        return skuMapper.selectByExample(eshopSkuCriteria).get(0);
    }

    /**
     * 减少库存
     *
     * @param id
     * @param amount
     * @return
     */
    public int reduceSku(String id, Integer amount) {
        EshopSku sku = skuMapper.selectByPrimaryKey(id);
        sku.setSkuStock(sku.getSkuStock() - amount);
        return skuMapper.updateByPrimaryKeySelective(sku);
    }
}
