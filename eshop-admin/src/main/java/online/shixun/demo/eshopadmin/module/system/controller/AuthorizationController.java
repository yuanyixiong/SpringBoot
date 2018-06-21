/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.system.controller;

import online.shixun.demo.eshopadmin.core.response.Node;
import online.shixun.demo.eshopadmin.core.response.PageResultForBootstrapTable;
import online.shixun.demo.eshopadmin.core.response.ResponseData;
import online.shixun.demo.eshopadmin.core.response.State;
import online.shixun.demo.eshopadmin.core.service.ResourceNodeEnum;
import online.shixun.demo.eshopadmin.model.EshopResourceModel;
import online.shixun.demo.eshopadmin.model.EshopRoleModel;
import online.shixun.demo.eshopadmin.model.EshopUserModel;
import online.shixun.demo.eshopadmin.module.system.service.EshopRoleService;
import online.shixun.demo.eshopadmin.module.system.service.EshopUserService;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * 授权中心，以用户为中心开始
 */
@RestController
@RequestMapping("/system/authorization")
public class AuthorizationController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${system.page.size}")
    protected Integer pageSize;//分页页码 application.yml 文件注入

    private EshopUserService userService;
    private EshopRoleService roleService;
    private online.shixun.demo.eshopadmin.security.service.EshopResourceService securityResourceService;
    private online.shixun.demo.eshopadmin.module.system.service.EshopResourceService systemResourceService;

    @Autowired
    public AuthorizationController(
            @Qualifier("eshopUserService") EshopUserService userService,
            @Qualifier("eshopRoleService") EshopRoleService roleService,
            @Qualifier("securityResourceService") online.shixun.demo.eshopadmin.security.service.EshopResourceService securityResourceService,
            @Qualifier("eshopResourceService") online.shixun.demo.eshopadmin.module.system.service.EshopResourceService systemResourceService) {
        this.userService = userService;
        this.roleService = roleService;
        this.securityResourceService = securityResourceService;
        this.systemResourceService = systemResourceService;
    }

    /**
     * 进入模块主页
     *
     * @param mav
     * @return
     */
    @GetMapping("/main")
    public ModelAndView main(ModelAndView mav) {
        mav.setViewName("authorization/authorizationMain");
        return mav;
    }


    /**
     * @param pagesSize
     * @param offset
     * @param sort
     * @param order
     * @param model
     * @return
     */
    @GetMapping("/users")
    public PageResultForBootstrapTable users(Integer pagesSize, Integer offset, String sort, String order, EshopUserModel model) {

        logger.info("" + pagesSize);
        Page<EshopUserModel> pages = null;
        List<EshopUserModel> checkeds = new ArrayList<>();
        try {
            PageRequest pageRequest = PageRequest.of(offset == 0 ? offset : offset / this.pageSize, this.pageSize);//设置分页
            pages = userService.getModelsPage(model, pageRequest, Sort.by(order.equals("asc") ? Sort.Order.asc(sort) : Sort.Order.desc(sort)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new PageResultForBootstrapTable<>(pages.getTotalElements(), pages.getContent(), checkeds);
    }

    @GetMapping("/roles")
    public PageResultForBootstrapTable roles(Integer pagesSize, Integer offset, String sort, String order, String userId) {
        Page<EshopRoleModel> pages = null;
        List<EshopRoleModel> checkeds = new ArrayList<>();
        try {
            //查询出所有角色
            PageRequest pageRequest = PageRequest.of(offset == 0 ? offset : offset / this.pageSize, this.pageSize);//设置分页
            pages = roleService.getModelsPage(new EshopRoleModel(), pageRequest, Sort.by(order.equals("asc") ? Sort.Order.asc(sort) : Sort.Order.desc(sort)));
            //查询出当前用户拥有的角色
            checkeds.addAll(roleService.findRolesByUserId(userId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new PageResultForBootstrapTable<>(pages.getTotalElements(), pages.getContent(), checkeds);
    }


    @GetMapping("/resources")
    public List<Node<EshopResourceModel>> resources(String roleId) {
        //获取[后台]所有资源数据
        List<Node<EshopResourceModel>> nodes = this.securityResourceService.initNode(ResourceNodeEnum.EHSOP_ADMIN.getName());
        if (Strings.isNotBlank(roleId)) {
            //查询出当前角色拥有的资源数据转成map 通过hash算法提高查找速度
            Map<String, Boolean> checkeds = new HashMap<String, Boolean>() {{
                systemResourceService.findResourcesByRole(roleId).stream().forEach(resourceModel -> {
                    put(resourceModel.getId(), true);
                });
            }};
            //设置节点选中
            recursionChecked(nodes, checkeds);
        }
        return nodes;
    }

    /**
     * 递归设置节点选中
     *
     * @param nodes
     * @param checkeds
     */
    private void recursionChecked(List<Node<EshopResourceModel>> nodes, Map<String, Boolean> checkeds) {
        //设置节点选中
        nodes.stream().forEach(node -> {
            //匹配节点，验证是否选中
            if (Objects.nonNull(checkeds.get(node.getId()))) {
                node.setState(new State(true, false, true, false));
            }
            //检验节点是否存在子节点
            if (Objects.nonNull(node.getNodes()) && node.getNodes().size() > 0) {
                recursionChecked(node.getNodes(), checkeds);
            }
        });
    }


    /**
     * 给用户授权角色
     *
     * @param userId  授权用户编号
     * @param roleIds 授予的角色权限编号
     * @return
     */
    @PostMapping("/authorizationRole")
    public ResponseData authorizationRole(String userId, String roleIds) {
        ResponseData responseData = new ResponseData();
        try {
            userService.authorizationRole(userId, roleIds);
            responseData.setData("授权角色成功");
        } catch (Exception e) {
            responseData.setError(String.format("授权角色失败[%s]", e.getMessage()));
        }
        return responseData;
    }

    /**
     * 给角色授权资源
     *
     * @param roleId
     * @param resourceIds
     * @return
     */
    @PostMapping("/authorizationResource")
    public ResponseData authorizationResource(String roleId, String resourceIds) {
        ResponseData responseData = new ResponseData();
        try {
            userService.authorizationResource(roleId, resourceIds);
            responseData.setData("授权资源成功");
        } catch (Exception e) {
            responseData.setError(String.format("授权资源失败[%s]", e.getMessage()));
        }
        return responseData;
    }

}
