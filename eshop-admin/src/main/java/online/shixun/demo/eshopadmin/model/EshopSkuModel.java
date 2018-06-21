/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.model;

import online.shixun.demo.eshopadmin.core.model.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "eshop_sku", schema = "eshop", catalog = "")
public class EshopSkuModel extends BaseModel {
    private Double skuDeliveFee;
    private Double skuPrice;
    private Integer skuStock;
    private Double skuMarketPrice;
    private Integer skuSales;
    private Integer skuUpperLimit;
    private String skuLocation;
    private String skuImg;
    private Integer skuIndex;
    private String skuName;
    private String createUserId;
    private String updateUserId;
    private Integer skuStatus;
    private Integer skuType;
    private Double skuRank;

    //特殊属性
    private EshopColorModel colorModel;
    private EshopSizeModel sizeModel;
    private EshopProductModel productModel;

    @ManyToOne(targetEntity = EshopColorModel.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "color_id", referencedColumnName = "id")
    public EshopColorModel getColorModel() {
        return colorModel;
    }

    public void setColorModel(EshopColorModel colorModel) {
        this.colorModel = colorModel;
    }

    @ManyToOne(targetEntity = EshopSizeModel.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    public EshopSizeModel getSizeModel() {
        return sizeModel;
    }

    public void setSizeModel(EshopSizeModel sizeModel) {
        this.sizeModel = sizeModel;
    }

    @ManyToOne(targetEntity = EshopProductModel.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public EshopProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(EshopProductModel productModel) {
        this.productModel = productModel;
    }

    @Basic
    @Column(name = "sku_delive_fee", nullable = true, precision = 2)
    public Double getSkuDeliveFee() {
        return skuDeliveFee;
    }

    public void setSkuDeliveFee(Double skuDeliveFee) {
        this.skuDeliveFee = skuDeliveFee;
    }

    @Basic
    @Column(name = "sku_price", nullable = true, precision = 2)
    public Double getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(Double skuPrice) {
        this.skuPrice = skuPrice;
    }

    @Basic
    @Column(name = "sku_stock", nullable = true)
    public Integer getSkuStock() {
        return skuStock;
    }

    public void setSkuStock(Integer skuStock) {
        this.skuStock = skuStock;
    }

    @Basic
    @Column(name = "sku_market_price", nullable = true, precision = 2)
    public Double getSkuMarketPrice() {
        return skuMarketPrice;
    }

    public void setSkuMarketPrice(Double skuMarketPrice) {
        this.skuMarketPrice = skuMarketPrice;
    }

    @Basic
    @Column(name = "sku_sales", nullable = true)
    public Integer getSkuSales() {
        return skuSales;
    }

    public void setSkuSales(Integer skuSales) {
        this.skuSales = skuSales;
    }

    @Basic
    @Column(name = "sku_upper_limit", nullable = true)
    public Integer getSkuUpperLimit() {
        return skuUpperLimit;
    }

    public void setSkuUpperLimit(Integer skuUpperLimit) {
        this.skuUpperLimit = skuUpperLimit;
    }

    @Basic
    @Column(name = "sku_location", nullable = true, length = 200)
    public String getSkuLocation() {
        return skuLocation;
    }

    public void setSkuLocation(String skuLocation) {
        this.skuLocation = skuLocation;
    }

    @Basic
    @Column(name = "sku_img", nullable = true, length = 200)
    public String getSkuImg() {
        return skuImg;
    }

    public void setSkuImg(String skuImg) {
        this.skuImg = skuImg;
    }

    @Basic
    @Column(name = "sku_index", nullable = true)
    public Integer getSkuIndex() {
        return skuIndex;
    }

    public void setSkuIndex(Integer skuIndex) {
        this.skuIndex = skuIndex;
    }

    @Basic
    @Column(name = "sku_name", nullable = true, length = 100)
    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    @Basic
    @Column(name = "create_user_id", nullable = true, length = 200)
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    @Basic
    @Column(name = "update_user_id", nullable = true, length = 200)
    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    @Basic
    @Column(name = "sku_status", nullable = true)
    public Integer getSkuStatus() {
        return skuStatus;
    }

    public void setSkuStatus(Integer skuStatus) {
        this.skuStatus = skuStatus;
    }

    @Basic
    @Column(name = "sku_type", nullable = true)
    public Integer getSkuType() {
        return skuType;
    }

    public void setSkuType(Integer skuType) {
        this.skuType = skuType;
    }

    @Basic
    @Column(name = "sku_rank", nullable = true, precision = 0)
    public Double getSkuRank() {
        return skuRank;
    }

    public void setSkuRank(Double skuRank) {
        this.skuRank = skuRank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopSkuModel skuModel = (EshopSkuModel) o;
        if (skuDeliveFee != null ? !skuDeliveFee.equals(skuModel.skuDeliveFee) : skuModel.skuDeliveFee != null)
            return false;
        if (skuPrice != null ? !skuPrice.equals(skuModel.skuPrice) : skuModel.skuPrice != null) return false;
        if (skuStock != null ? !skuStock.equals(skuModel.skuStock) : skuModel.skuStock != null) return false;
        if (skuMarketPrice != null ? !skuMarketPrice.equals(skuModel.skuMarketPrice) : skuModel.skuMarketPrice != null)
            return false;
        if (skuSales != null ? !skuSales.equals(skuModel.skuSales) : skuModel.skuSales != null) return false;
        if (skuUpperLimit != null ? !skuUpperLimit.equals(skuModel.skuUpperLimit) : skuModel.skuUpperLimit != null)
            return false;
        if (skuLocation != null ? !skuLocation.equals(skuModel.skuLocation) : skuModel.skuLocation != null)
            return false;
        if (skuImg != null ? !skuImg.equals(skuModel.skuImg) : skuModel.skuImg != null) return false;
        if (skuIndex != null ? !skuIndex.equals(skuModel.skuIndex) : skuModel.skuIndex != null) return false;
        if (skuName != null ? !skuName.equals(skuModel.skuName) : skuModel.skuName != null) return false;
        if (createUserId != null ? !createUserId.equals(skuModel.createUserId) : skuModel.createUserId != null)
            return false;
        if (updateUserId != null ? !updateUserId.equals(skuModel.updateUserId) : skuModel.updateUserId != null)
            return false;
        if (skuStatus != null ? !skuStatus.equals(skuModel.skuStatus) : skuModel.skuStatus != null) return false;
        if (skuType != null ? !skuType.equals(skuModel.skuType) : skuModel.skuType != null) return false;
        if (skuRank != null ? !skuRank.equals(skuModel.skuRank) : skuModel.skuRank != null) return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (skuDeliveFee != null ? skuDeliveFee.hashCode() : 0);
        result = 31 * result + (skuPrice != null ? skuPrice.hashCode() : 0);
        result = 31 * result + (skuStock != null ? skuStock.hashCode() : 0);
        result = 31 * result + (skuMarketPrice != null ? skuMarketPrice.hashCode() : 0);
        result = 31 * result + (skuSales != null ? skuSales.hashCode() : 0);
        result = 31 * result + (skuUpperLimit != null ? skuUpperLimit.hashCode() : 0);
        result = 31 * result + (skuLocation != null ? skuLocation.hashCode() : 0);
        result = 31 * result + (skuImg != null ? skuImg.hashCode() : 0);
        result = 31 * result + (skuIndex != null ? skuIndex.hashCode() : 0);
        result = 31 * result + (skuName != null ? skuName.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (updateUserId != null ? updateUserId.hashCode() : 0);
        result = 31 * result + (skuStatus != null ? skuStatus.hashCode() : 0);
        result = 31 * result + (skuType != null ? skuType.hashCode() : 0);
        result = 31 * result + (skuRank != null ? skuRank.hashCode() : 0);
        return result;
    }
}
