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
 * @ClassName EshopCollectItemModel
 * @Description TODO
 * @Date 2018/05/23 16:38
 * @Author shixun.online
 * @Version 1.0
 **/
@Entity
@Table(name = "eshop_collect_item", schema = "eshop", catalog = "")
public class EshopCollectItemModel extends BaseModel {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String collectId;
    private String productId;
    private String colorId;
    private String sizeId;

    @Basic
    @Column(name = "collect_id")
    public String getCollectId() {
        return collectId;
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId;
    }

    @Basic
    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopCollectItemModel that = (EshopCollectItemModel) o;

        if (collectId != null ? !collectId.equals(that.collectId) : that.collectId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (colorId != null ? !colorId.equals(that.colorId) : that.colorId != null) return false;
        if (sizeId != null ? !sizeId.equals(that.sizeId) : that.sizeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = collectId != null ? collectId.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (colorId != null ? colorId.hashCode() : 0);
        result = 31 * result + (sizeId != null ? sizeId.hashCode() : 0);
        return result;
    }
}
