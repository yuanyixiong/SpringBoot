/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.product.service;

import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.model.EshopColorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("eshopColorService")
public class EshopColorService extends BaseServiceAbstractPage<EshopColorModel, String> {

    @Autowired
    public EshopColorService(@Qualifier("eshopColorDao") JpaRepository<EshopColorModel, String> jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public void setCondition(EshopColorModel model, StringBuilder whereSql, Map<String, Object> params) {
    }
}
