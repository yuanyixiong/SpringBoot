/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.product.service;

import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.model.EshopProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("eshopProductService")
public class EshopProductService extends BaseServiceAbstractPage<EshopProductModel, String> {

    @Autowired
    public EshopProductService(@Qualifier("eshopProductDao") JpaRepository<EshopProductModel, String> jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public void setCondition(EshopProductModel model, StringBuilder whereSql, Map<String, Object> params) {
    }

}
