/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.core.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * 模型的基类
 */
@MappedSuperclass
@DynamicSql
public abstract class BaseModel {

    private String id;  //数据id
    private Integer isDel;//是否移除 1-移除/2-未移除
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime; //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;//最近更新时间

    @Id
    @Column(name = "id", nullable = false, length = 200)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "isDel", nullable = false, length = 200)
    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BaseModel(String id, Integer isDel, Date createTime, Date updateTime) {
        this.id = id;
        this.isDel = isDel;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public BaseModel(String id, Integer isDel) {
        this.id = id;
        this.isDel = isDel;
    }

    public BaseModel(String id) {
        this.id = id;
    }

    public BaseModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseModel baseModel = (BaseModel) o;

        return id != null ? id.equals(baseModel.id) : baseModel.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
