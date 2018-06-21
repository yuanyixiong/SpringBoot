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
import java.math.BigDecimal;


@Entity
@Table(name = "eshop_detail", schema = "eshop", catalog = "")
public class EshopDetailModel extends BaseModel {
    private String orderId;
    private String detailName;
    private String detailColor;
    private String detailSize;
    private BigDecimal detailProice;
    private Integer detailAmount;
    private String detailUrl;


    @Basic
    @Column(name = "order_id", nullable = true, length = 200)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "detail_name", nullable = true, length = 50)
    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    @Basic
    @Column(name = "detail_color", nullable = true, length = 20)
    public String getDetailColor() {
        return detailColor;
    }

    public void setDetailColor(String detailColor) {
        this.detailColor = detailColor;
    }

    @Basic
    @Column(name = "detail_size", nullable = true, length = 20)
    public String getDetailSize() {
        return detailSize;
    }

    public void setDetailSize(String detailSize) {
        this.detailSize = detailSize;
    }

    @Basic
    @Column(name = "detail_proice", nullable = true, precision = 2)
    public BigDecimal getDetailProice() {
        return detailProice;
    }

    public void setDetailProice(BigDecimal detailProice) {
        this.detailProice = detailProice;
    }

    @Basic
    @Column(name = "detail_amount", nullable = true)
    public Integer getDetailAmount() {
        return detailAmount;
    }

    public void setDetailAmount(Integer detailAmount) {
        this.detailAmount = detailAmount;
    }

    @Basic
    @Column(name = "detail_url", nullable = true, length = 100)
    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopDetailModel that = (EshopDetailModel) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (detailName != null ? !detailName.equals(that.detailName) : that.detailName != null) return false;
        if (detailColor != null ? !detailColor.equals(that.detailColor) : that.detailColor != null) return false;
        if (detailSize != null ? !detailSize.equals(that.detailSize) : that.detailSize != null) return false;
        if (detailProice != null ? !detailProice.equals(that.detailProice) : that.detailProice != null) return false;
        if (detailAmount != null ? !detailAmount.equals(that.detailAmount) : that.detailAmount != null) return false;
        if (detailUrl != null ? !detailUrl.equals(that.detailUrl) : that.detailUrl != null) return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (detailName != null ? detailName.hashCode() : 0);
        result = 31 * result + (detailColor != null ? detailColor.hashCode() : 0);
        result = 31 * result + (detailSize != null ? detailSize.hashCode() : 0);
        result = 31 * result + (detailProice != null ? detailProice.hashCode() : 0);
        result = 31 * result + (detailAmount != null ? detailAmount.hashCode() : 0);
        result = 31 * result + (detailUrl != null ? detailUrl.hashCode() : 0);
        return result;
    }
}
