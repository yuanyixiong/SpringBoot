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
@Table(name = "eshop_color", schema = "eshop", catalog = "")
public class EshopColorModel extends BaseModel {
    private String colorName;
    private String colorParentId;
    private String colorImgUrl;

    public EshopColorModel() {
    }

    public EshopColorModel(String id) {
        super(id);
    }

    @Basic
    @Column(name = "color_name", nullable = true, length = 20)
    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    @Basic
    @Column(name = "color_parent_id", nullable = true, length = 200)
    public String getColorParentId() {
        return colorParentId;
    }

    public void setColorParentId(String colorParentId) {
        this.colorParentId = colorParentId;
    }

    @Basic
    @Column(name = "color_img_url", nullable = true, length = 50)
    public String getColorImgUrl() {
        return colorImgUrl;
    }

    public void setColorImgUrl(String colorImgUrl) {
        this.colorImgUrl = colorImgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopColorModel that = (EshopColorModel) o;

        if (colorName != null ? !colorName.equals(that.colorName) : that.colorName != null) return false;
        if (colorParentId != null ? !colorParentId.equals(that.colorParentId) : that.colorParentId != null)
            return false;
        if (colorImgUrl != null ? !colorImgUrl.equals(that.colorImgUrl) : that.colorImgUrl != null) return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (colorName != null ? colorName.hashCode() : 0);
        result = 31 * result + (colorParentId != null ? colorParentId.hashCode() : 0);
        result = 31 * result + (colorImgUrl != null ? colorImgUrl.hashCode() : 0);
        return result;
    }
}
