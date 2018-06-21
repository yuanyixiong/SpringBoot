/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.system.service;

import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.model.EshopRoleModel;
import online.shixun.demo.eshopadmin.module.system.dao.EshopRoleDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;


@Service("eshopRoleService")
public class EshopRoleService extends BaseServiceAbstractPage<EshopRoleModel, String> {

    @Autowired
    public EshopRoleService(@Qualifier("eshopRoleDao") JpaRepository<EshopRoleModel, String> jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public void setCondition(EshopRoleModel model, StringBuilder whereSql, Map<String, Object> params) {
        if (StringUtils.isNotBlank(model.getRoleName())) {
            whereSql.append(" and roleName like :roleName ");
            params.put("roleName", StringUtils.join("%", model.getRoleName(), "%"));
        }
    }


    public List<EshopRoleModel> findRolesByUserId(String userId) {
        return ((EshopRoleDao) super.getJpaRepository()).findRolesByUserId(userId);
    }


    public List<EshopRoleModel> findRolesByIds(Collection<String> ids) {
        return ((EshopRoleDao) super.getJpaRepository()).findRolesByIds(ids);
    }
}