/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.type.service;

import online.shixun.demo.eshopadmin.core.response.Node;
import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.core.service.RecursionService;
import online.shixun.demo.eshopadmin.model.EshopTypeModel;
import online.shixun.demo.eshopadmin.module.type.dao.EshopTypeDao;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service("eshopTypeService")
public class EshopTypeService extends BaseServiceAbstractPage<EshopTypeModel, String> implements RecursionService<EshopTypeModel, String> {

    @Autowired
    public EshopTypeService(@Qualifier("eshopTypeDao") JpaRepository<EshopTypeModel, String> jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public void setCondition(EshopTypeModel model, StringBuilder whereSql, Map<String, Object> params) {
        if (Strings.isNotBlank(model.getTypeName())) {
            whereSql.append(" and typeName like :typeName");
            params.put("typeName", String.join("%", model.getTypeName(), "%"));
        }
        if (Strings.isNotBlank(model.getTypeNote())) {
            whereSql.append(" and typeNote like :typeNote");
            params.put("typeNote", String.join("%", model.getTypeNote(), "%"));
        }
    }

    @Override
    public void initNode(Node<EshopTypeModel> node) {
        //查询主菜单的子菜单
        ((EshopTypeDao) super.getJpaRepository()).findChildren(node.getData().getId()).forEach(tempNode -> {
            //包装子菜单类型
            Node next_node = new Node(tempNode.getId(), tempNode.getTypeName(), tempNode.getTypeIndex(), tempNode);
            //将子菜单添加到主菜单中
            node.getNodes().add(next_node);
            //递归初始化
            initNode(next_node);
            //排序刚初始化完成的菜单
            Collections.sort(node.getNodes());
        });
    }

    @Override
    public List<Node<EshopTypeModel>> initNode(String rootNodeId) {
        EshopTypeModel node = ((EshopTypeDao) super.getJpaRepository()).findById(rootNodeId).get();
        Node menu = new Node(node.getId(), node.getTypeName(), node.getTypeIndex(), node);
        initNode(menu);
        return menu.getNodes();
    }
}
