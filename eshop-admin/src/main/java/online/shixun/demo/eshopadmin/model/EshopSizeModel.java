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
@Table(name = "eshop_size", schema = "eshop", catalog = "")
public class EshopSizeModel extends BaseModel {
    private String sizeName;
    private String sizeParentId;
    private String sizeType;

    public EshopSizeModel() {
    }

    public EshopSizeModel(String id) {
        super(id);
    }

    @Basic
    @Column(name = "size_name", nullable = true, length = 20)
    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    @Basic
    @Column(name = "size_parent_id", nullable = true, length = 200)
    public String getSizeParentId() {
        return sizeParentId;
    }

    public void setSizeParentId(String sizeParentId) {
        this.sizeParentId = sizeParentId;
    }

    @Basic
    @Column(name = "size_type", nullable = true, length = 200)
    public String getSizeType() {
        return sizeType;
    }

    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopSizeModel sizeModel = (EshopSizeModel) o;
        if (sizeName != null ? !sizeName.equals(sizeModel.sizeName) : sizeModel.sizeName != null) return false;
        if (sizeParentId != null ? !sizeParentId.equals(sizeModel.sizeParentId) : sizeModel.sizeParentId != null)
            return false;
        if (sizeType != null ? !sizeType.equals(sizeModel.sizeType) : sizeModel.sizeType != null) return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (sizeName != null ? sizeName.hashCode() : 0);
        result = 31 * result + (sizeParentId != null ? sizeParentId.hashCode() : 0);
        result = 31 * result + (sizeType != null ? sizeType.hashCode() : 0);
        return result;
    }
}
