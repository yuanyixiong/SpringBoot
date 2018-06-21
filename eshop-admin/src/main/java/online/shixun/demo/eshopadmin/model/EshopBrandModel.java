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
@Table(name = "eshop_brand", schema = "eshop", catalog = "")
public class EshopBrandModel extends BaseModel {
    private String brandName;
    private String brandDescription;
    private String brandLogo;

    @Basic
    @Column(name = "brand_name", nullable = true, length = 20)
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Basic
    @Column(name = "brand_description", nullable = true, length = 500)
    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    @Basic
    @Column(name = "brand_logo", nullable = true, length = 100)
    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopBrandModel that = (EshopBrandModel) o;

        if (brandName != null ? !brandName.equals(that.brandName) : that.brandName != null) return false;
        if (brandDescription != null ? !brandDescription.equals(that.brandDescription) : that.brandDescription != null)
            return false;
        if (brandLogo != null ? !brandLogo.equals(that.brandLogo) : that.brandLogo != null) return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        result = 31 * result + (brandDescription != null ? brandDescription.hashCode() : 0);
        result = 31 * result + (brandLogo != null ? brandLogo.hashCode() : 0);
        return result;
    }
}
