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
@Table(name = "eshop_comment", schema = "eshop", catalog = "")
public class EshopCommentModel extends BaseModel {
    private String userId;
    private String productId;
    private Double commonRank;
    private String commonContent;

    @Basic
    @Column(name = "user_id", nullable = true, length = 200)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "product_id", nullable = true, length = 200)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "common_rank", nullable = true, precision = 0)
    public Double getCommonRank() {
        return commonRank;
    }

    public void setCommonRank(Double commonRank) {
        this.commonRank = commonRank;
    }

    @Basic
    @Column(name = "common_content", nullable = true, length = 500)
    public String getCommonContent() {
        return commonContent;
    }

    public void setCommonContent(String commonContent) {
        this.commonContent = commonContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EshopCommentModel that = (EshopCommentModel) o;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (commonRank != null ? !commonRank.equals(that.commonRank) : that.commonRank != null) return false;
        if (commonContent != null ? !commonContent.equals(that.commonContent) : that.commonContent != null)
            return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (commonRank != null ? commonRank.hashCode() : 0);
        result = 31 * result + (commonContent != null ? commonContent.hashCode() : 0);
        return result;
    }
}
