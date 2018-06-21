/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.model;

import online.shixun.demo.eshopadmin.core.model.BaseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @ClassName EshopBuyerCartItemModel
 * @Description TODO
 * @Date 2018/05/23 16:38
 * @Author shixun.online
 * @Version 1.0
 **/
@Entity
@Table(name = "eshop_buyer_cart_item", schema = "eshop", catalog = "")
public class EshopBuyerCartItemModel extends BaseModel {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String productId;
    private String skuId;
    private Integer amount;
    private String buyerCartId;

    @Basic
    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "sku_id")
    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    @Basic
    @Column(name = "amount")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "buyer_cart_id")
    public String getBuyerCartId() {
        return buyerCartId;
    }

    public void setBuyerCartId(String buyerCartId) {
        this.buyerCartId = buyerCartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopBuyerCartItemModel that = (EshopBuyerCartItemModel) o;

        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (skuId != null ? !skuId.equals(that.skuId) : that.skuId != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (buyerCartId != null ? !buyerCartId.equals(that.buyerCartId) : that.buyerCartId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (skuId != null ? skuId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (buyerCartId != null ? buyerCartId.hashCode() : 0);
        return result;
    }
}
