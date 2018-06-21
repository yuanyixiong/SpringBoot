/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.product.service;

import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.model.EshopImgModel;
import online.shixun.demo.eshopadmin.module.product.dao.EshopImgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("eshopImgService")
public class EshopImgService extends BaseServiceAbstractPage<EshopImgModel, String> {

    @Autowired
    public EshopImgService(@Qualifier("eshopImgDao") JpaRepository<EshopImgModel, String> jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public void setCondition(EshopImgModel model, StringBuilder whereSql, Map<String, Object> params) {
    }
}
