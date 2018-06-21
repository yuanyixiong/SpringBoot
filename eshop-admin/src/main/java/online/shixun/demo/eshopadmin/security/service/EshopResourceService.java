/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.security.service;

import online.shixun.demo.eshopadmin.core.response.Node;
import online.shixun.demo.eshopadmin.core.service.RecursionService;
import online.shixun.demo.eshopadmin.model.EshopResourceModel;
import online.shixun.demo.eshopadmin.security.dao.EshopResourceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("securityResourceService")
public class EshopResourceService implements RecursionService<EshopResourceModel, String> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private EshopResourceDao resourceDao;

    @Autowired
    public EshopResourceService(@Qualifier("securityResourceDao") EshopResourceDao resourceDao) {
        this.resourceDao = resourceDao;
    }

    @Override
    public void initNode(Node<EshopResourceModel> node) {
        logger.info(String.format("resource_parent_id:%s", node.getData().getId()));
        //查询主菜单的子菜单
        resourceDao.findChildren(node.getData().getId()).forEach(tempNode -> {
            //包装子菜单类型
            Node<EshopResourceModel> next_menu = new Node(tempNode.getId(), tempNode.getResourceName(), tempNode.getResourceIndex(), tempNode);
            //将子菜单添加到主菜单中
            node.getNodes().add(next_menu);
            //递归初始化
            initNode(next_menu);
            //排序刚初始化完成的菜单
            Collections.sort(node.getNodes());
        });
    }

    @Override
    public List<Node<EshopResourceModel>> initNode(String rootNodeId) {
        EshopResourceModel node = resourceDao.findById(rootNodeId).get();
        Node menu = new Node(node.getId(), node.getResourceName(), node.getResourceIndex(), node);
        initNode(menu);
        return menu.getNodes();
    }
}