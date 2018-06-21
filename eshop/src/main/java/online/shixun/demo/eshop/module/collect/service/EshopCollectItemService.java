/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.collect.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.shixun.demo.eshop.dto.EshopCollect;
import online.shixun.demo.eshop.dto.EshopCollectItem;
import online.shixun.demo.eshop.dto.EshopCollectItemCriteria;
import online.shixun.demo.eshop.module.collect.mapper.EshopCollectItemMapper;
import online.shixun.demo.eshop.module.collect.mapper.EshopCollectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.Objects;

/**
 * @ClassName EshopCollectItemService
 * @Description TODO
 * @Date 2018/05/15 10:51
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class EshopCollectItemService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopCollectItemMapper collectItemMapper;

    @Autowired
    private EshopCollectMapper collectMapper;

    public PageInfo<EshopCollectItem> getCollectItems(EshopCollectItem collectItem, int pageNum, int pageSize) {
        EshopCollect eshopCollect = collectMapper.selectByPrimaryKey(collectItem.getCollectId());
        if (Objects.nonNull(eshopCollect)) {
            eshopCollect.setCollectViewcount(eshopCollect.getCollectViewcount() + 1);
            collectMapper.updateByPrimaryKey(eshopCollect);
        }

        PageHelper.startPage(pageNum, pageSize);//分页
        return new PageInfo<>(collectItemMapper.getCollectItems(collectItem));
    }

    /**
     * 根据收藏项编码移除，收藏项
     *
     * @param collectItem
     * @return
     */
    @Transient
    public int deleteById(EshopCollectItem collectItem) {
        EshopCollect eshopCollect = collectMapper.selectByPrimaryKey(collectItem.getCollectId());
        eshopCollect.setCollectNumber(eshopCollect.getCollectNumber() - 1);
        collectMapper.updateByPrimaryKey(eshopCollect);
        return collectItemMapper.deleteByPrimaryKey(collectItem.getId());
    }

    /**
     * 根据收藏编码移除，收藏项
     *
     * @param collectId
     * @return
     */
    public int deleteByCollectId(String collectId) {
        EshopCollectItemCriteria eshopCollectItemCriteria = new EshopCollectItemCriteria();
        EshopCollectItemCriteria.Criteria criteria = eshopCollectItemCriteria.createCriteria();
        criteria.andCollectIdEqualTo(collectId);
        return collectItemMapper.deleteByExample(eshopCollectItemCriteria);
    }

    public int addCollectItem(String skuId, String collect_id) {
        return collectItemMapper.addCollectItem(skuId, collect_id);
    }

    /**
     * 更新
     *
     * @param collectItem
     * @return
     */
    public int edit(EshopCollectItem collectItem) {
        return collectItemMapper.updateByPrimaryKeySelective(collectItem);
    }
}
