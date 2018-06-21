/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.system.service;

import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.model.EshopResourceModel;
import online.shixun.demo.eshopadmin.model.EshopRoleModel;
import online.shixun.demo.eshopadmin.model.EshopUserModel;
import online.shixun.demo.eshopadmin.module.system.dao.EshopUserDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service("eshopUserService")
public class EshopUserService extends BaseServiceAbstractPage<EshopUserModel, String> {

    private EshopRoleService roleService;
    private EshopResourceService resourceService;

    @Autowired
    public EshopUserService(@Qualifier("eshopUserDao") JpaRepository<EshopUserModel, String> jpaRepository,
                            @Qualifier("eshopRoleService") EshopRoleService roleService,
                            @Qualifier("eshopResourceService") EshopResourceService resourceService) {
        super(jpaRepository);
        this.roleService = roleService;
        this.resourceService = resourceService;
    }

    @Override
    public void setCondition(EshopUserModel model, StringBuilder whereSql, Map<String, Object> params) {
        if (StringUtils.isNotBlank(model.getUserLoginName())) {
            whereSql.append(" and userLoginName like :userLoginName ");
            params.put("userLoginName", StringUtils.join("%", model.getUserLoginName(), "%"));
        }
        if (StringUtils.isNotBlank(model.getUserEmail())) {
            whereSql.append(" and userEmail like :userEmail ");
            params.put("userEmail", StringUtils.join("%", model.getUserEmail(), "%"));
        }
        if (StringUtils.isNotBlank(model.getUserNicakName())) {
            whereSql.append(" and userNicakName like :userNicakName ");
            params.put("userNicakName", StringUtils.join("%", model.getUserNicakName(), "%"));
        }
        if (StringUtils.isNotBlank(model.getUserRealName())) {
            whereSql.append(" and userRealName like :userRealName ");
            params.put("userRealName", StringUtils.join("%", model.getUserRealName(), "%"));
        }
        if (Objects.nonNull(model.getUserGender()) && model.getUserGender() > 0) {
            whereSql.append(" and userGender = :userGender ");
            params.put("userGender", model.getUserGender());
        }
    }

    /**
     * 给用户授权角色
     *
     * @param userId  用户编号
     * @param roleIds 角色编号数组
     */
    public void authorizationRole(String userId, String roleIds) throws Exception {
        EshopUserModel userModel = ((EshopUserDao) super.getJpaRepository()).getOne(userId);
        Set<String> ids = Arrays.stream(roleIds.split(",")).collect(Collectors.toSet());
        List<EshopRoleModel> roleModels = roleService.findRolesByIds(ids);
        userModel.setRoles(roleModels);
        ((EshopUserDao) super.getJpaRepository()).save(userModel);
    }

    /**
     * 给角色授权资源
     *
     * @param roleId      角色编号
     * @param resourceIds 资源编号数组
     */
    public void authorizationResource(String roleId, String resourceIds) throws Exception {
        EshopRoleModel roleModel=roleService.getModel(roleId);
        Set<String> ids = Arrays.stream(resourceIds.split(",")).collect(Collectors.toSet());
        List<EshopResourceModel> resourceModels = resourceService.findResourcesByIds(ids);
        roleModel.setResources(resourceModels);
        roleService.saveModel(roleModel);
    }
}
