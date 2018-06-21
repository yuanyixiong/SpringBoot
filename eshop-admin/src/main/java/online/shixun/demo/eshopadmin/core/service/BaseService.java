/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.core.service;

import online.shixun.demo.eshopadmin.core.model.BaseModel;
import online.shixun.demo.eshopadmin.util.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 通用CURD Service接口,提供了基础的CURD及分页的定义
 *
 * @param <Model> CURD操作的数据模型
 * @param <ID>    模型的编码
 */
public interface BaseService<Model extends BaseModel, ID extends Serializable> {

    /**
     * 日志类
     *
     * @return
     */
    Logger getLogger();

    /**
     * 数据库访问类
     *
     * @return
     */
    JpaRepository<Model, ID> getJpaRepository();

    /**
     * jap实体管理对象
     *
     * @return
     */
    EntityManager getEntityManager();

    /**
     * 添加
     *
     * @param model
     * @return
     */
    default Model saveModel(Model model) throws Exception {
        this.getLogger().info("执行saveModel");
        Model result = this.getJpaRepository().save(model);
        this.getLogger().debug(result.toString());
        return result;
    }

    /**
     * 批量保存
     *
     * @param bean             保存的数据
     * @param refreshFrequency 内存刷新频率
     */
    default void batchInsert(List<Model> bean, int refreshFrequency) throws Exception {
        for (int i = 0; i < bean.size(); i++) {
            this.saveModel(bean.get(i));
            if (i % refreshFrequency == 0) {
                this.getJpaRepository().flush();
            }
        }
    }

    /**
     * 批量更新
     *
     * @param bean             更新的数据
     * @param beanId           更新的数据ID
     * @param refreshFrequency 内存刷新频率
     */
    default void batchUpdate(List<Model> bean, List<ID> beanId, int refreshFrequency) throws Exception {
        for (int i = 0; i < bean.size(); i++) {
            this.editModel(bean.get(i), beanId.get(i));
            if (i % refreshFrequency == 0) {
                this.getJpaRepository().flush();
            }
        }
    }

    /**
     * 更新
     *
     * @param model
     * @return
     */
    default Model editModel(Model model, ID id) throws Exception {
        this.getLogger().info("执行editModel");
        Optional<Model> optional = this.getJpaRepository().findById(id);
        if (!optional.isPresent()) {
            return saveModel(model);
        }
        //复制属性
        BeanUtils.copyPropertiesIgnoreNull(model, optional.get());
        Model result = this.getJpaRepository().save(optional.get());
        this.getLogger().debug(result.toString());
        return result;
    }

    /**
     * 根据编号删除
     *
     * @param id
     * @return
     */
    default void deleteModel(ID id) throws Exception {
        this.getLogger().info("执行deleteModel");
        this.getJpaRepository().deleteById(id);
        this.getLogger().debug(id.toString());
    }


    /**
     * 根据条件删除
     *
     * @param model
     */
    default void deleteModel(Model model) {
        this.getJpaRepository().delete(model);
    }

    /**
     * 根据编号查询
     *
     * @param id
     * @return
     */
    default Model getModel(ID id) throws Exception {
        this.getLogger().info("执行getModel");
        Model result = this.getJpaRepository().findById(id).get();
        this.getLogger().info(result.toString());
        return result;
    }

    /**
     * 分页
     *
     * @param model       分页的数据实体
     * @param pageRequest [选传]分页信息 负责 分页信息,提供了PageRequest则带分页 效果，没提供则不带分页效果
     * @param sort        [选传]排序信息 负责排序,提供了Sort则带排序 效果，没提供则不带排序效果
     * @return
     */
    default Page<Model> getModelsPage(Model model, PageRequest pageRequest, Sort sort) throws Exception {
        /**
         * 初始化HQL
         */
        this.getLogger().info("[getModelsPage]初始化数据查询HQL");
        StringBuilder selectSql = new StringBuilder(String.format("from %s where 1=1", model.getClass().getTypeName()));//分页数据hql
        this.getLogger().info(String.format("[getModelsPage]完成初始化数据查询HQL:%s", selectSql.toString()));

        /**
         *组装动态HQL
         */
        this.getLogger().info("[getModelsPage]组装动态数据查询HQL");
        Map<String, Object> params = new HashMap<>();//动态hql的参数
        StringBuilder whereSql = new StringBuilder();//动态条件hql
        setBaseCondition(model, whereSql, params);//设置通用的hql条件
        setCondition(model, whereSql, params);//子类设置特有的hql条件

        /**
         * 组装HQL排序
         */
        this.getLogger().info("[getModelsPage]组装HQL排序");
        StringBuilder orderSql = new StringBuilder();//动态排序hql
        if (Objects.nonNull(sort)) {
            List<Sort.Order> orders = sort.stream().collect(Collectors.toList());//获取排序集合
            //遍历所有排序列
            for (int i = 0; i < orders.size(); i++) {
                //排序的分割
                if (i == 0) {
                    orderSql.append(" ORDER BY ");
                } else {
                    orderSql.append(" , ");
                }
                //设置排序列和排序的方向
                orderSql.append(String.format(" %s %s ", orders.get(i).getProperty(), orders.get(i).getDirection()));
            }
        }

        /**
         *执行HQL
         */
        this.getLogger().info("[getModelsPage]执行数据查询HQL");
        String querySql = selectSql.append(whereSql).append(orderSql).toString();
        Query query = this.getEntityManager().createQuery(querySql, model.getClass());
        this.setParameters(query, params);
        this.getLogger().info(String.format("[getModelsPage]动态HQL组装完成：%s", whereSql.toString()));
        if (Objects.nonNull(pageRequest)) {
            //分页
            query.setFirstResult(pageRequest.getPageNumber() * pageRequest.getPageSize());
            query.setMaxResults(pageRequest.getPageSize());
        }
        List<Model> resultList = query.getResultList();

        //没提供分页信息，返回基础查询数据
        return Objects.isNull(pageRequest) ? new PageImpl<Model>(resultList) : new PageImpl<Model>(resultList, pageRequest, getCount(model));
    }

    /**
     * 统计数据
     *
     * @param model
     * @return
     */
    default Long getCount(Model model) throws Exception {
        /**
         * 初始化HQL
         */
        this.getLogger().info("[getCount]初始化数据查询HQL");
        StringBuilder countSelectSql = new StringBuilder(String.format("select count(*) from %s where 1=1", model.getClass().getTypeName())); //统计数据hql
        this.getLogger().info(String.format("[getCount]完成初始化数据查询HQL:%s", countSelectSql.toString()));

        /**
         *组装动态HQL
         */
        this.getLogger().info("[getCount]组装动态数据查询HQL");
        Map<String, Object> params = new HashMap<>();//动态hql的参数
        StringBuilder whereSql = new StringBuilder();//动态hql
        setBaseCondition(model, whereSql, params);//设置通用的hql条件
        setCondition(model, whereSql, params);//子类设置特有的hql条件
        this.getLogger().info(String.format("[getCount]动态HQL组装完成：%s", whereSql.toString()));

        /**
         *执行HQL
         */
        this.getLogger().info("[getCount]执行数据查询HQL");
        String countSql = countSelectSql.append(whereSql).toString();
        Query countQuery = this.getEntityManager().createQuery(countSql, Long.class);
        this.setParameters(countQuery, params);
        return (Long) countQuery.getSingleResult();
    }

    /**
     * 给hql参数设置值
     *
     * @param query  查询
     * @param params 参数
     */
    default void setParameters(Query query, Map<String, Object> params) throws Exception {
        this.getLogger().info("[setParameters]设置动态查询HQL的条件");
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }

    /**
     * 子类设置特有的hql条件
     *
     * @param model    条件实体
     * @param whereSql 动态hql
     * @param params   动态hql的参数
     */
    void setCondition(Model model, StringBuilder whereSql, Map<String, Object> params);

    /**
     * 设置通用的hql条件
     *
     * @param model    条件实体
     * @param whereSql 动态hql
     * @param params   动态hql的参数
     */
    default void setBaseCondition(Model model, StringBuilder whereSql, Map<String, Object> params) {
        //数据删除状态，准确匹配
        if (Objects.nonNull(model.getIsDel()) && model.getIsDel() > 0) {
            whereSql.append(" and isDel = :isDel ");
            params.put("isDel", model.getIsDel());
        }
        //数据编码模糊匹配
        if (StringUtils.isNotBlank(model.getId())) {
            whereSql.append(" and id like :id ");
            params.put("id", StringUtils.join("%", model.getId(), "%"));
        }
        /*if (Objects.nonNull(model.getCreateTime())) {
            whereSql.append(" and createTime = :createTime ");
            params.put("createTime", model.getCreateTime());
        }
        if (Objects.nonNull(model.getUpdateTime())) {
            whereSql.append(" and updateTime = :updateTime ");
            params.put("updateTime", model.getUpdateTime());
        }*/
    }


}
