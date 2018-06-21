/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.model;

import online.shixun.demo.eshopadmin.core.model.BaseModel;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "eshop_order", schema = "eshop", catalog = "")
public class EshopOrderModel extends BaseModel {
    private String userId;
    private Double orderDeliverFee;
    private Double orderTotalFee;
    private Double orderPrice;
    private Integer orderPaymentWay;
    private Integer orderPaymentCash;
    private Integer orderIsPaiy;
    private Integer orderState;
    private String addressId;
    private String orderRecipients;

    @Basic
    @Column(name = "user_id", nullable = true, length = 200)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "order_deliver_fee", nullable = true, precision = 2)
    public Double getOrderDeliverFee() {
        return orderDeliverFee;
    }

    public void setOrderDeliverFee(Double orderDeliverFee) {
        this.orderDeliverFee = orderDeliverFee;
    }

    @Basic
    @Column(name = "order_total_fee", nullable = true, precision = 2)
    public Double getOrderTotalFee() {
        return orderTotalFee;
    }

    public void setOrderTotalFee(Double orderTotalFee) {
        this.orderTotalFee = orderTotalFee;
    }

    @Basic
    @Column(name = "order_price", nullable = true, precision = 2)
    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Basic
    @Column(name = "order_payment_way", nullable = true)
    public Integer getOrderPaymentWay() {
        return orderPaymentWay;
    }

    public void setOrderPaymentWay(Integer orderPaymentWay) {
        this.orderPaymentWay = orderPaymentWay;
    }

    @Basic
    @Column(name = "order_payment_cash", nullable = true)
    public Integer getOrderPaymentCash() {
        return orderPaymentCash;
    }

    public void setOrderPaymentCash(Integer orderPaymentCash) {
        this.orderPaymentCash = orderPaymentCash;
    }

    @Basic
    @Column(name = "order_is_paiy", nullable = true)
    public Integer getOrderIsPaiy() {
        return orderIsPaiy;
    }

    public void setOrderIsPaiy(Integer orderIsPaiy) {
        this.orderIsPaiy = orderIsPaiy;
    }

    @Basic
    @Column(name = "order_state", nullable = true)
    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopOrderModel that = (EshopOrderModel) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (orderDeliverFee != null ? !orderDeliverFee.equals(that.orderDeliverFee) : that.orderDeliverFee != null)
            return false;
        if (orderTotalFee != null ? !orderTotalFee.equals(that.orderTotalFee) : that.orderTotalFee != null)
            return false;
        if (orderPrice != null ? !orderPrice.equals(that.orderPrice) : that.orderPrice != null) return false;
        if (orderPaymentWay != null ? !orderPaymentWay.equals(that.orderPaymentWay) : that.orderPaymentWay != null)
            return false;
        if (orderPaymentCash != null ? !orderPaymentCash.equals(that.orderPaymentCash) : that.orderPaymentCash != null)
            return false;
        if (orderIsPaiy != null ? !orderIsPaiy.equals(that.orderIsPaiy) : that.orderIsPaiy != null) return false;
        if (orderState != null ? !orderState.equals(that.orderState) : that.orderState != null) return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (orderDeliverFee != null ? orderDeliverFee.hashCode() : 0);
        result = 31 * result + (orderTotalFee != null ? orderTotalFee.hashCode() : 0);
        result = 31 * result + (orderPrice != null ? orderPrice.hashCode() : 0);
        result = 31 * result + (orderPaymentWay != null ? orderPaymentWay.hashCode() : 0);
        result = 31 * result + (orderPaymentCash != null ? orderPaymentCash.hashCode() : 0);
        result = 31 * result + (orderIsPaiy != null ? orderIsPaiy.hashCode() : 0);
        result = 31 * result + (orderState != null ? orderState.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "address_id")
    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "order_recipients")
    public String getOrderRecipients() {
        return orderRecipients;
    }

    public void setOrderRecipients(String orderRecipients) {
        this.orderRecipients = orderRecipients;
    }
}
