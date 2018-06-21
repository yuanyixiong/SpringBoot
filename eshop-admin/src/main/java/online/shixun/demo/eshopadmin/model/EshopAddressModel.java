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
 * @ClassName EshopAddressModel
 * @Description TODO
 * @Date 2018/05/23 16:37
 * @Author shixun.online
 * @Version 1.0
 **/
@Entity
@Table(name = "eshop_address", schema = "eshop", catalog = "")
public class EshopAddressModel extends BaseModel {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String userId;
    private String stateId;
    private String provinceId;
    private String cityId;
    private String townId;
    private String addressLocation;
    private String addressPhone;
    private Integer addressPostcode;
    private String addressFaddrAxes;
    private Integer addressIsDef;
    private String addressName;
    private String addressRecipients;

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "state_id")
    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    @Basic
    @Column(name = "province_id")
    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    @Basic
    @Column(name = "city_id")
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "town_id")
    public String getTownId() {
        return townId;
    }

    public void setTownId(String townId) {
        this.townId = townId;
    }

    @Basic
    @Column(name = "address_location")
    public String getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(String addressLocation) {
        this.addressLocation = addressLocation;
    }

    @Basic
    @Column(name = "address_phone")
    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    @Basic
    @Column(name = "address_postcode")
    public Integer getAddressPostcode() {
        return addressPostcode;
    }

    public void setAddressPostcode(Integer addressPostcode) {
        this.addressPostcode = addressPostcode;
    }

    @Basic
    @Column(name = "address_faddr_axes")
    public String getAddressFaddrAxes() {
        return addressFaddrAxes;
    }

    public void setAddressFaddrAxes(String addressFaddrAxes) {
        this.addressFaddrAxes = addressFaddrAxes;
    }

    @Basic
    @Column(name = "address_is_def")
    public Integer getAddressIsDef() {
        return addressIsDef;
    }

    public void setAddressIsDef(Integer addressIsDef) {
        this.addressIsDef = addressIsDef;
    }

    @Basic
    @Column(name = "address_name")
    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    @Basic
    @Column(name = "address_recipients")
    public String getAddressRecipients() {
        return addressRecipients;
    }

    public void setAddressRecipients(String addressRecipients) {
        this.addressRecipients = addressRecipients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopAddressModel that = (EshopAddressModel) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (stateId != null ? !stateId.equals(that.stateId) : that.stateId != null) return false;
        if (provinceId != null ? !provinceId.equals(that.provinceId) : that.provinceId != null) return false;
        if (cityId != null ? !cityId.equals(that.cityId) : that.cityId != null) return false;
        if (townId != null ? !townId.equals(that.townId) : that.townId != null) return false;
        if (addressLocation != null ? !addressLocation.equals(that.addressLocation) : that.addressLocation != null)
            return false;
        if (addressPhone != null ? !addressPhone.equals(that.addressPhone) : that.addressPhone != null) return false;
        if (addressPostcode != null ? !addressPostcode.equals(that.addressPostcode) : that.addressPostcode != null)
            return false;
        if (addressFaddrAxes != null ? !addressFaddrAxes.equals(that.addressFaddrAxes) : that.addressFaddrAxes != null)
            return false;
        if (addressIsDef != null ? !addressIsDef.equals(that.addressIsDef) : that.addressIsDef != null) return false;
        if (addressName != null ? !addressName.equals(that.addressName) : that.addressName != null) return false;
        if (addressRecipients != null ? !addressRecipients.equals(that.addressRecipients) : that.addressRecipients != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (stateId != null ? stateId.hashCode() : 0);
        result = 31 * result + (provinceId != null ? provinceId.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (townId != null ? townId.hashCode() : 0);
        result = 31 * result + (addressLocation != null ? addressLocation.hashCode() : 0);
        result = 31 * result + (addressPhone != null ? addressPhone.hashCode() : 0);
        result = 31 * result + (addressPostcode != null ? addressPostcode.hashCode() : 0);
        result = 31 * result + (addressFaddrAxes != null ? addressFaddrAxes.hashCode() : 0);
        result = 31 * result + (addressIsDef != null ? addressIsDef.hashCode() : 0);
        result = 31 * result + (addressName != null ? addressName.hashCode() : 0);
        result = 31 * result + (addressRecipients != null ? addressRecipients.hashCode() : 0);
        return result;
    }
}
