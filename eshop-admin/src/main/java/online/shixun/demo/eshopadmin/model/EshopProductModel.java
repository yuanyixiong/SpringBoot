/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import online.shixun.demo.eshopadmin.core.model.BaseModel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "eshop_product", schema = "eshop", catalog = "")
public class EshopProductModel extends BaseModel {
    private String productName;
    private String productWeight;
    private Integer productIsNew;
    private Integer productIsHot;
    private Integer productIsCommend;
    private Integer productIsShow;
    private Integer productSales;
    private String productDescription;
    private String productInformation;
    private String productAfterSale;

    //逻辑映射
    private String productColors;
    private String productSizes;
    private String productFeatures;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productCheckTime;
    //特殊属性
    private EshopTypeModel typeModel;//商品类型
    private EshopBrandModel brandModel;//商品品牌
    private EshopUserModel userModel;//审核用户
    private List<EshopImgModel> imgModel;//商品图片，商品移除同步移除
    private List<EshopSkuModel> skuModel;//商品最小销售单元，商品移除同步移除
    private List<EshopCommentModel> commentModel;//商品评价，商品移除同步移除

    public void setProductCheckTime(java.sql.Date productCheckTime) {
        this.productCheckTime = productCheckTime;
    }

    @JsonIgnore
    @ManyToOne(targetEntity = EshopTypeModel.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    public EshopTypeModel getTypeModel() {
        return typeModel;
    }

    public void setTypeModel(EshopTypeModel typeModel) {
        this.typeModel = typeModel;
    }

    @JsonIgnore
    @ManyToOne(targetEntity = EshopBrandModel.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    public EshopBrandModel getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(EshopBrandModel brandModel) {
        this.brandModel = brandModel;
    }

    @JsonIgnore
    @ManyToOne(targetEntity = EshopUserModel.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "check_user_id", referencedColumnName = "id")
    public EshopUserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(EshopUserModel userModel) {
        this.userModel = userModel;
    }

    @JsonIgnore
    @OneToMany(targetEntity = EshopImgModel.class, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public List<EshopImgModel> getImgModel() {
        return imgModel;
    }

    public void setImgModel(List<EshopImgModel> imgModel) {
        this.imgModel = imgModel;
    }

    @JsonIgnore
    @OneToMany(targetEntity = EshopSkuModel.class, fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public List<EshopSkuModel> getSkuModel() {
        return skuModel;
    }

    public void setSkuModel(List<EshopSkuModel> skuModel) {
        this.skuModel = skuModel;
    }

    @JsonIgnore
    @OneToMany(targetEntity = EshopCommentModel.class, fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public List<EshopCommentModel> getCommentModel() {
        return commentModel;
    }

    public void setCommentModel(List<EshopCommentModel> commentModel) {
        this.commentModel = commentModel;
    }

    @Basic
    @Column(name = "product_name", nullable = true, length = 50)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "product_weight", nullable = true, length = 20)
    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    @Basic
    @Column(name = "product_is_new", nullable = true)
    public Integer getProductIsNew() {
        return productIsNew;
    }

    public void setProductIsNew(Integer productIsNew) {
        this.productIsNew = productIsNew;
    }

    @Basic
    @Column(name = "product_is_hot", nullable = true)
    public Integer getProductIsHot() {
        return productIsHot;
    }

    public void setProductIsHot(Integer productIsHot) {
        this.productIsHot = productIsHot;
    }

    @Basic
    @Column(name = "product_is_commend", nullable = true)
    public Integer getProductIsCommend() {
        return productIsCommend;
    }

    public void setProductIsCommend(Integer productIsCommend) {
        this.productIsCommend = productIsCommend;
    }

    @Basic
    @Column(name = "product_is_show", nullable = true)
    public Integer getProductIsShow() {
        return productIsShow;
    }

    public void setProductIsShow(Integer productIsShow) {
        this.productIsShow = productIsShow;
    }

    @Basic
    @Column(name = "product_sales", nullable = true)
    public Integer getProductSales() {
        return productSales;
    }

    public void setProductSales(Integer productSales) {
        this.productSales = productSales;
    }

    @Basic
    @Column(name = "product_description", nullable = true, length = -1)
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Basic
    @Column(name = "product_information", nullable = true, length = -1)
    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }

    @Basic
    @Column(name = "product_after_sale", nullable = true, length = -1)
    public String getProductAfterSale() {
        return productAfterSale;
    }

    public void setProductAfterSale(String productAfterSale) {
        this.productAfterSale = productAfterSale;
    }

    @Basic
    @Column(name = "product_colors", nullable = true, length = 200)
    public String getProductColors() {
        return productColors;
    }

    public void setProductColors(String productColors) {
        this.productColors = productColors;
    }

    @Basic
    @Column(name = "product_sizes", nullable = true, length = 200)
    public String getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(String productSizes) {
        this.productSizes = productSizes;
    }

    @Basic
    @Column(name = "product_features", nullable = true, length = 200)
    public String getProductFeatures() {
        return productFeatures;
    }

    public void setProductFeatures(String productFeatures) {
        this.productFeatures = productFeatures;
    }

    @Basic
    @Column(name = "product_check_time", nullable = true)
    public Date getProductCheckTime() {
        return productCheckTime;
    }

    public void setProductCheckTime(Date productCheckTime) {
        this.productCheckTime = productCheckTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopProductModel that = (EshopProductModel) o;

        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productWeight != null ? !productWeight.equals(that.productWeight) : that.productWeight != null)
            return false;
        if (productIsNew != null ? !productIsNew.equals(that.productIsNew) : that.productIsNew != null) return false;
        if (productIsHot != null ? !productIsHot.equals(that.productIsHot) : that.productIsHot != null) return false;
        if (productIsCommend != null ? !productIsCommend.equals(that.productIsCommend) : that.productIsCommend != null)
            return false;
        if (productIsShow != null ? !productIsShow.equals(that.productIsShow) : that.productIsShow != null)
            return false;
        if (productSales != null ? !productSales.equals(that.productSales) : that.productSales != null) return false;
        if (productDescription != null ? !productDescription.equals(that.productDescription) : that.productDescription != null)
            return false;
        if (productInformation != null ? !productInformation.equals(that.productInformation) : that.productInformation != null)
            return false;
        if (productAfterSale != null ? !productAfterSale.equals(that.productAfterSale) : that.productAfterSale != null)
            return false;
        if (productColors != null ? !productColors.equals(that.productColors) : that.productColors != null)
            return false;
        if (productSizes != null ? !productSizes.equals(that.productSizes) : that.productSizes != null) return false;
        if (productFeatures != null ? !productFeatures.equals(that.productFeatures) : that.productFeatures != null)
            return false;
        if (productCheckTime != null ? !productCheckTime.equals(that.productCheckTime) : that.productCheckTime != null)
            return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productWeight != null ? productWeight.hashCode() : 0);
        result = 31 * result + (productIsNew != null ? productIsNew.hashCode() : 0);
        result = 31 * result + (productIsHot != null ? productIsHot.hashCode() : 0);
        result = 31 * result + (productIsCommend != null ? productIsCommend.hashCode() : 0);
        result = 31 * result + (productIsShow != null ? productIsShow.hashCode() : 0);
        result = 31 * result + (productSales != null ? productSales.hashCode() : 0);
        result = 31 * result + (productDescription != null ? productDescription.hashCode() : 0);
        result = 31 * result + (productInformation != null ? productInformation.hashCode() : 0);
        result = 31 * result + (productAfterSale != null ? productAfterSale.hashCode() : 0);
        result = 31 * result + (productColors != null ? productColors.hashCode() : 0);
        result = 31 * result + (productSizes != null ? productSizes.hashCode() : 0);
        result = 31 * result + (productFeatures != null ? productFeatures.hashCode() : 0);
        result = 31 * result + (productCheckTime != null ? productCheckTime.hashCode() : 0);
        return result;
    }
}
