/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.system.service;

import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.model.EshopResourceModel;
import online.shixun.demo.eshopadmin.module.system.dao.EshopResourceDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;


@Service("eshopResourceService")
public class EshopResourceService extends BaseServiceAbstractPage<EshopResourceModel, String> {

    @Autowired
    public EshopResourceService(@Qualifier("eshopResourceDao") JpaRepository<EshopResourceModel, String> jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public void setCondition(EshopResourceModel model, StringBuilder whereSql, Map<String, Object> params) {
        if (StringUtils.isNotBlank(model.getResourceName())) {
            whereSql.append(" and resourceName like :resourceName ");
            params.put("resourceName", StringUtils.join("%", model.getResourceName(), "%"));
        }
        if (StringUtils.isNotBlank(model.getResourceParentId())) {
            whereSql.append(" and resourceParentId like :resourceParentId ");
            params.put("resourceParentId", StringUtils.join("%", model.getResourceParentId(), "%"));
        }
    }

    public List<EshopResourceModel> findResourcesByRole(String roleId) {
        return ((EshopResourceDao) super.getJpaRepository()).findResourcesByRole(roleId);
    }


    public List<EshopResourceModel> findResourcesByIds(Collection<String> ids) {
        return ((EshopResourceDao) super.getJpaRepository()).findResourcesByIds(ids);
    }
}