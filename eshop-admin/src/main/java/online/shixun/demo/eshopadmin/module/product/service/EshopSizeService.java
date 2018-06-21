/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.product.service;

import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.model.EshopSizeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("eshopSizeService")
public class EshopSizeService extends BaseServiceAbstractPage<EshopSizeModel, String> {

    @Autowired
    public EshopSizeService(@Qualifier("eshopSizeDao") JpaRepository<EshopSizeModel, String> jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public void setCondition(EshopSizeModel model, StringBuilder whereSql, Map<String, Object> params) {
    }
}
