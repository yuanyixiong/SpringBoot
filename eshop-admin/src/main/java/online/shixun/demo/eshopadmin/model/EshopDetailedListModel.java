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
@Table(name = "eshop_detailed_list", schema = "eshop", catalog = "")
public class EshopDetailedListModel extends BaseModel {
    private String userId;
    private String detailedName;
    private Integer detailedNumber;
    private Integer detailedViewcount;

    @Basic
    @Column(name = "user_id", nullable = true, length = 200)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "detailed_name", nullable = true, length = 50)
    public String getDetailedName() {
        return detailedName;
    }

    public void setDetailedName(String detailedName) {
        this.detailedName = detailedName;
    }

    @Basic
    @Column(name = "detailed_number", nullable = true)
    public Integer getDetailedNumber() {
        return detailedNumber;
    }

    public void setDetailedNumber(Integer detailedNumber) {
        this.detailedNumber = detailedNumber;
    }

    @Basic
    @Column(name = "detailed_viewcount", nullable = true)
    public Integer getDetailedViewcount() {
        return detailedViewcount;
    }

    public void setDetailedViewcount(Integer detailedViewcount) {
        this.detailedViewcount = detailedViewcount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopDetailedListModel that = (EshopDetailedListModel) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (detailedName != null ? !detailedName.equals(that.detailedName) : that.detailedName != null) return false;
        if (detailedNumber != null ? !detailedNumber.equals(that.detailedNumber) : that.detailedNumber != null)
            return false;
        if (detailedViewcount != null ? !detailedViewcount.equals(that.detailedViewcount) : that.detailedViewcount != null)
            return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (detailedName != null ? detailedName.hashCode() : 0);
        result = 31 * result + (detailedNumber != null ? detailedNumber.hashCode() : 0);
        result = 31 * result + (detailedViewcount != null ? detailedViewcount.hashCode() : 0);
        return result;
    }
}
