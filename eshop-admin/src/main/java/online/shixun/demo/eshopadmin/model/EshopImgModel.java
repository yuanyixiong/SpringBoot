/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.model;

import online.shixun.demo.eshopadmin.core.model.BaseModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "eshop_img", schema = "eshop", catalog = "")
public class EshopImgModel extends BaseModel {
    private String imgUrl;
    private Integer imgIsDef;
    private String imgName;
    private String productId;

    //界面使用的图片文件信息，数据库不保存
    private Long imgSize;

    public EshopImgModel(String id, Integer isDel, Date createTime, Date updateTime, String imgUrl, Integer imgIsDef, String imgName) {
        super(id, isDel, createTime, updateTime);
        this.imgUrl = imgUrl;
        this.imgIsDef = imgIsDef;
        this.imgName = imgName;
    }

    public EshopImgModel() {
    }

    @Transient
    public Long getImgSize() {
        return imgSize;
    }

    public void setImgSize(Long imgSize) {
        this.imgSize = imgSize;
    }

    @Basic
    @Column(name = "img_url", nullable = true, length = 100)
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Basic
    @Column(name = "img_is_def", nullable = true)
    public Integer getImgIsDef() {
        return imgIsDef;
    }

    public void setImgIsDef(Integer imgIsDef) {
        this.imgIsDef = imgIsDef;
    }

    @Basic
    @Column(name = "img_name", nullable = true, length = 200)
    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    @Basic
    @Column(name = "product_id", nullable = true, length = 200)
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

        EshopImgModel imgModel = (EshopImgModel) o;
        if (imgUrl != null ? !imgUrl.equals(imgModel.imgUrl) : imgModel.imgUrl != null) return false;
        if (imgIsDef != null ? !imgIsDef.equals(imgModel.imgIsDef) : imgModel.imgIsDef != null) return false;
        if (imgName != null ? !imgName.equals(imgModel.imgName) : imgModel.imgName != null) return false;
        if (productId != null ? !productId.equals(imgModel.productId) : imgModel.productId != null) return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        result = 31 * result + (imgIsDef != null ? imgIsDef.hashCode() : 0);
        result = 31 * result + (imgName != null ? imgName.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        return result;
    }
}
