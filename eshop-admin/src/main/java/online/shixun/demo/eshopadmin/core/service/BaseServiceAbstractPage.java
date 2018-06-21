/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.core.service;

import online.shixun.demo.eshopadmin.core.model.BaseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * 通用CURD Service接口实现,需要分页的继承该类，该类对BaseService接口所需的组件完成了初始化,子类仅需扩展条件便可实现常规性的CURD及分页
 *
 * @param <Model> 操作的数据对象
 * @param <ID>    数据对象的编号
 */
public abstract class BaseServiceAbstractPage<Model extends BaseModel, ID extends Serializable> implements BaseService<Model, ID> {

    private JpaRepository<Model, ID> jpaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public BaseServiceAbstractPage(JpaRepository<Model, ID> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public JpaRepository getJpaRepository() {
        return this.jpaRepository;
    }

    @Override
    public Logger getLogger() {
        return LoggerFactory.getLogger(getClass());
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
