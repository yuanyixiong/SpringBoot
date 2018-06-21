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
import java.sql.Date;

/**
 * @ClassName EshopCollectModel
 * @Description TODO
 * @Date 2018/05/23 16:38
 * @Author shixun.online
 * @Version 1.0
 **/
@Entity
@Table(name = "eshop_collect", schema = "eshop", catalog = "")
public class EshopCollectModel extends BaseModel {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Date createTime;
    private String collectName;
    private Integer collectNumber;
    private Integer collectViewcount;

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "collect_name")
    public String getCollectName() {
        return collectName;
    }

    public void setCollectName(String collectName) {
        this.collectName = collectName;
    }

    @Basic
    @Column(name = "collect_number")
    public Integer getCollectNumber() {
        return collectNumber;
    }

    public void setCollectNumber(Integer collectNumber) {
        this.collectNumber = collectNumber;
    }

    @Basic
    @Column(name = "collect_viewcount")
    public Integer getCollectViewcount() {
        return collectViewcount;
    }

    public void setCollectViewcount(Integer collectViewcount) {
        this.collectViewcount = collectViewcount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopCollectModel that = (EshopCollectModel) o;

        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (collectName != null ? !collectName.equals(that.collectName) : that.collectName != null) return false;
        if (collectNumber != null ? !collectNumber.equals(that.collectNumber) : that.collectNumber != null)
            return false;
        if (collectViewcount != null ? !collectViewcount.equals(that.collectViewcount) : that.collectViewcount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = createTime != null ? createTime.hashCode() : 0;
        result = 31 * result + (collectName != null ? collectName.hashCode() : 0);
        result = 31 * result + (collectNumber != null ? collectNumber.hashCode() : 0);
        result = 31 * result + (collectViewcount != null ? collectViewcount.hashCode() : 0);
        return result;
    }
}
