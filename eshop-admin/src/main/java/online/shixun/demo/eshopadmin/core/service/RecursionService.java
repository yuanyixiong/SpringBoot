/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.core.service;

import online.shixun.demo.eshopadmin.core.model.BaseModel;
import online.shixun.demo.eshopadmin.core.response.Node;

import java.io.Serializable;
import java.util.List;

/**
 * 递归初始化
 *
 * @param <Model>
 * @param <ID>
 */
public interface RecursionService<Model extends BaseModel, ID extends Serializable> {
    /**
     * 递归初始化节点
     *
     * @param node 当前节点,用来初始化其子节点
     */
    void initNode(Node<Model> node);

    /**
     * 根据节点编号查询出子节点
     *
     * @return
     */
    List<Node<Model>> initNode(ID rootNodeId);
}
