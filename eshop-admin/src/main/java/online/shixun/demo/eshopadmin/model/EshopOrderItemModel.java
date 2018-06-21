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
import java.math.BigDecimal;

/**
 * @ClassName EshopOrderItemModel
 * @Description TODO
 * @Date 2018/05/23 16:38
 * @Author shixun.online
 * @Version 1.0
 **/
@Entity
@Table(name = "eshop_order_item", schema = "eshop", catalog = "")
public class EshopOrderItemModel extends BaseModel {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String orderId;
    private String colorId;
    private String sizeId;
    private String orderItemName;
    private BigDecimal orderItemProice;
    private Integer orderItemAmount;
    private String orderItemUrl;
    private String productId;

    @Basic
    @Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "color_id")
    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    @Basic
    @Column(name = "size_id")
    public String getSizeId() {
        return sizeId;
    }

    public void setSizeId(String sizeId) {
        this.sizeId = sizeId;
    }

    @Basic
    @Column(name = "order_item_name")
    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    @Basic
    @Column(name = "order_item_proice")
    public BigDecimal getOrderItemProice() {
        return orderItemProice;
    }

    public void setOrderItemProice(BigDecimal orderItemProice) {
        this.orderItemProice = orderItemProice;
    }

    @Basic
    @Column(name = "order_item_amount")
    public Integer getOrderItemAmount() {
        return orderItemAmount;
    }

    public void setOrderItemAmount(Integer orderItemAmount) {
        this.orderItemAmount = orderItemAmount;
    }

    @Basic
    @Column(name = "order_item_url")
    public String getOrderItemUrl() {
        return orderItemUrl;
    }

    public void setOrderItemUrl(String orderItemUrl) {
        this.orderItemUrl = orderItemUrl;
    }

    @Basic
    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopOrderItemModel that = (EshopOrderItemModel) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (colorId != null ? !colorId.equals(that.colorId) : that.colorId != null) return false;
        if (sizeId != null ? !sizeId.equals(that.sizeId) : that.sizeId != null) return false;
        if (orderItemName != null ? !orderItemName.equals(that.orderItemName) : that.orderItemName != null)
            return false;
        if (orderItemProice != null ? !orderItemProice.equals(that.orderItemProice) : that.orderItemProice != null)
            return false;
        if (orderItemAmount != null ? !orderItemAmount.equals(that.orderItemAmount) : that.orderItemAmount != null)
            return false;
        if (orderItemUrl != null ? !orderItemUrl.equals(that.orderItemUrl) : that.orderItemUrl != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (colorId != null ? colorId.hashCode() : 0);
        result = 31 * result + (sizeId != null ? sizeId.hashCode() : 0);
        result = 31 * result + (orderItemName != null ? orderItemName.hashCode() : 0);
        result = 31 * result + (orderItemProice != null ? orderItemProice.hashCode() : 0);
        result = 31 * result + (orderItemAmount != null ? orderItemAmount.hashCode() : 0);
        result = 31 * result + (orderItemUrl != null ? orderItemUrl.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        return result;
    }
}
