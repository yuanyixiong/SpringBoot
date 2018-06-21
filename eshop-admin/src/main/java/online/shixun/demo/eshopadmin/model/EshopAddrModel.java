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
@Table(name = "eshop_addr", schema = "eshop", catalog = "")
public class EshopAddrModel extends BaseModel {
    private String userId;
    private Integer addrIsDef;
    private Integer addrState;
    private Integer addrProvince;
    private Integer addrCity;
    private Integer addrPostcode;
    private String addrPhone;
    private String addrFaddrAxes;
    private String addrLocation;

    @Basic
    @Column(name = "user_id", nullable = true, length = 200)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "addr_is_def", nullable = true)
    public Integer getAddrIsDef() {
        return addrIsDef;
    }

    public void setAddrIsDef(Integer addrIsDef) {
        this.addrIsDef = addrIsDef;
    }

    @Basic
    @Column(name = "addr_state", nullable = true)
    public Integer getAddrState() {
        return addrState;
    }

    public void setAddrState(Integer addrState) {
        this.addrState = addrState;
    }

    @Basic
    @Column(name = "addr_province", nullable = true)
    public Integer getAddrProvince() {
        return addrProvince;
    }

    public void setAddrProvince(Integer addrProvince) {
        this.addrProvince = addrProvince;
    }

    @Basic
    @Column(name = "addr_city", nullable = true)
    public Integer getAddrCity() {
        return addrCity;
    }

    public void setAddrCity(Integer addrCity) {
        this.addrCity = addrCity;
    }

    @Basic
    @Column(name = "addr_postcode", nullable = true)
    public Integer getAddrPostcode() {
        return addrPostcode;
    }

    public void setAddrPostcode(Integer addrPostcode) {
        this.addrPostcode = addrPostcode;
    }

    @Basic
    @Column(name = "addr_phone", nullable = true, length = 20)
    public String getAddrPhone() {
        return addrPhone;
    }

    public void setAddrPhone(String addrPhone) {
        this.addrPhone = addrPhone;
    }

    @Basic
    @Column(name = "addr_faddr_axes", nullable = true, length = 20)
    public String getAddrFaddrAxes() {
        return addrFaddrAxes;
    }

    public void setAddrFaddrAxes(String addrFaddrAxes) {
        this.addrFaddrAxes = addrFaddrAxes;
    }

    @Basic
    @Column(name = "addr_location", nullable = true, length = 500)
    public String getAddrLocation() {
        return addrLocation;
    }

    public void setAddrLocation(String addrLocation) {
        this.addrLocation = addrLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EshopAddrModel that = (EshopAddrModel) o;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (addrIsDef != null ? !addrIsDef.equals(that.addrIsDef) : that.addrIsDef != null) return false;
        if (addrState != null ? !addrState.equals(that.addrState) : that.addrState != null) return false;
        if (addrProvince != null ? !addrProvince.equals(that.addrProvince) : that.addrProvince != null) return false;
        if (addrCity != null ? !addrCity.equals(that.addrCity) : that.addrCity != null) return false;
        if (addrPostcode != null ? !addrPostcode.equals(that.addrPostcode) : that.addrPostcode != null) return false;
        if (addrPhone != null ? !addrPhone.equals(that.addrPhone) : that.addrPhone != null) return false;
        if (addrFaddrAxes != null ? !addrFaddrAxes.equals(that.addrFaddrAxes) : that.addrFaddrAxes != null)
            return false;
        if (addrLocation != null ? !addrLocation.equals(that.addrLocation) : that.addrLocation != null) return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (addrIsDef != null ? addrIsDef.hashCode() : 0);
        result = 31 * result + (addrState != null ? addrState.hashCode() : 0);
        result = 31 * result + (addrProvince != null ? addrProvince.hashCode() : 0);
        result = 31 * result + (addrCity != null ? addrCity.hashCode() : 0);
        result = 31 * result + (addrPostcode != null ? addrPostcode.hashCode() : 0);
        result = 31 * result + (addrPhone != null ? addrPhone.hashCode() : 0);
        result = 31 * result + (addrFaddrAxes != null ? addrFaddrAxes.hashCode() : 0);
        result = 31 * result + (addrLocation != null ? addrLocation.hashCode() : 0);
        return result;
    }
}
