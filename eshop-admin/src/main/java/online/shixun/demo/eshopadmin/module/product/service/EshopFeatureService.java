/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.product.service;

import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.model.EshopFeatureModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("eshopFeatureService")
public class EshopFeatureService extends BaseServiceAbstractPage<EshopFeatureModel, String> {

    @Autowired
    public EshopFeatureService(@Qualifier("eshopFeatureDao") JpaRepository<EshopFeatureModel, String> jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public void setCondition(EshopFeatureModel model, StringBuilder whereSql, Map<String, Object> params) {
    }
}
