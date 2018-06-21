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
 * @ClassName EshopAddressCityModel
 * @Description TODO
 * @Date 2018/05/23 16:37
 * @Author shixun.online
 * @Version 1.0
 **/
@Entity
@Table(name = "eshop_address_city", schema = "eshop", catalog = "")
public class EshopAddressCityModel extends BaseModel {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String code;
    private String name;
    private String provinceCode;

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "province_code")
    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopAddressCityModel that = (EshopAddressCityModel) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (provinceCode != null ? !provinceCode.equals(that.provinceCode) : that.provinceCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (provinceCode != null ? provinceCode.hashCode() : 0);
        return result;
    }
}
