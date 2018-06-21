/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.module.shopping.service;

import online.shixun.demo.eshop.core.service.BeanEnum;
import online.shixun.demo.eshop.dto.*;
import online.shixun.demo.eshop.module.product.service.EshopSkuService;
import online.shixun.demo.eshop.module.shopping.mapper.EshopBuyerCartItemMapper;
import online.shixun.demo.eshop.module.shopping.mapper.EshopBuyerCartMapper;
import online.shixun.demo.eshop.util.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName TrolleyService
 * @Description TODO
 * @Date 2018/05/11 15:30
 * @Author shixun.online
 * @Version 1.0
 **/
@Service
public class TrolleyService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EshopBuyerCartMapper buyerCartMapper;

    @Autowired
    private EshopBuyerCartItemMapper buyerCartItemMapper;

    @Autowired
    private EshopSkuService skuService;

    /**
     * 获取用户的购物车
     *
     * @param user
     * @return
     */
    public EshopBuyerCart getBuyerCart(EshopUser user) {
        EshopBuyerCart eshopBuyerCart = null;

        EshopBuyerCartCriteria eshopBuyerCartCriteria = new EshopBuyerCartCriteria();
        EshopBuyerCartCriteria.Criteria criteria = eshopBuyerCartCriteria.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        List<EshopBuyerCart> list = buyerCartMapper.selectByExample(eshopBuyerCartCriteria);

        //当前用户的购物车不存在创建用户的购物车
        if (Objects.isNull(list) || list.size() == 0) {
            eshopBuyerCart = new EshopBuyerCart(BeanUtils.getId(), BeanEnum.UNDEL.getIndex(), new Date(), new Date(), user.getId());
            eshopBuyerCart.setId(BeanUtils.getId());
            eshopBuyerCart.setCreateTime(new Date());
            eshopBuyerCart.setUpdateTime(new Date());
            buyerCartMapper.insert(eshopBuyerCart);
        } else {
            //加载购物车数据
            eshopBuyerCart = list.get(0);
            List<EshopBuyerCartItem> items = buyerCartItemMapper.getEshopBuyerCartItemByBuyerCartId(eshopBuyerCart.getId());
            eshopBuyerCart.getItems().addAll(items);
        }
        return eshopBuyerCart;
    }


    /**
     * 添加数据到购物车
     *
     * @param user
     * @param items
     */
    public void addBuyerItme(EshopUser user, List<EshopBuyerCartItem> items) {
        //取出用户数据库的购物车数据
        EshopBuyerCart eshopBuyerCart = getBuyerCart(user);
        items.forEach(eshopBuyerCart::addItem);

        eshopBuyerCart.getItems().forEach(EshopBuyerCartItem -> {
            if (Objects.isNull(EshopBuyerCartItem.getId())) {
                EshopBuyerCartItem.setId(BeanUtils.getId());
                EshopBuyerCartItem.setBuyerCartId(eshopBuyerCart.getId());
                EshopBuyerCartItem.setProductId(skuService.getSku(EshopBuyerCartItem.getSku()).getProductId());
                EshopBuyerCartItem.setSkuId(EshopBuyerCartItem.getSku() == null ? EshopBuyerCartItem.getSkuId() : EshopBuyerCartItem.getSku().getId());
                EshopBuyerCartItem.setCreateTime(new Date());
                EshopBuyerCartItem.setUpdateTime(new Date());
                buyerCartItemMapper.insert(EshopBuyerCartItem);
            } else {
                buyerCartItemMapper.updateByPrimaryKey(EshopBuyerCartItem);
            }
        });
    }

    /**
     * 删除购物车数据
     *
     * @param id
     */
    public int removeBuyerItme(String id) {
        return buyerCartItemMapper.deleteByPrimaryKey(id);
    }

    public EshopBuyerCartItem getBuyerCartItem(String id) {
        return buyerCartItemMapper.selectByPrimaryKey(id);
    }

    public int editBuyerCartItem(EshopBuyerCartItem buyerCartItem) {
        return buyerCartItemMapper.updateByPrimaryKeySelective(buyerCartItem);
    }

    /**
     * 清空购物车
     */
    public int emptyBuyerItme(EshopUser user) {
        //清除数据库购物车数据
        EshopBuyerCartCriteria eshopBuyerCartCriteria = new EshopBuyerCartCriteria();
        EshopBuyerCartCriteria.Criteria buyerCartCriteria = eshopBuyerCartCriteria.createCriteria();
        buyerCartCriteria.andUserIdEqualTo(user.getId());
        EshopBuyerCart eshopBuyerCart = buyerCartMapper.selectByExample(eshopBuyerCartCriteria).stream().findFirst().get();

        //清除购物车数据
        EshopBuyerCartItemCriteria eshopBuyerCartItemCriteria = new EshopBuyerCartItemCriteria();
        EshopBuyerCartItemCriteria.Criteria buyerCartItemCriteria = eshopBuyerCartItemCriteria.createCriteria();
        buyerCartItemCriteria.andBuyerCartIdEqualTo(eshopBuyerCart.getId());
        return buyerCartItemMapper.deleteByExample(eshopBuyerCartItemCriteria);
    }
}
