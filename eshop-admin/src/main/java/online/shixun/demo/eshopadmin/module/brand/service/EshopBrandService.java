/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.brand.service;

import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.model.EshopBrandModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service("eshopBrandService")
public class EshopBrandService extends BaseServiceAbstractPage<EshopBrandModel, String> {

    @Autowired
    public EshopBrandService(@Qualifier("eshopBrandDao") JpaRepository<EshopBrandModel, String> jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public void setCondition(EshopBrandModel model, StringBuilder whereSql, Map<String, Object> params) {
        if (Objects.nonNull(model.getCreateTime())) {
            whereSql.append(" and createTime = :createTime ");
            params.put("createTime", model.getCreateTime());
        }
        if (Objects.nonNull(model.getUpdateTime())) {
            whereSql.append(" and updateTime = :updateTime ");
            params.put("updateTime", model.getUpdateTime());
        }
        if (StringUtils.isNotBlank(model.getBrandName())) {
            whereSql.append(" and brandName like :brandName ");
            params.put("brandName", StringUtils.join("%", model.getBrandName(), "%"));
        }
    }
}
