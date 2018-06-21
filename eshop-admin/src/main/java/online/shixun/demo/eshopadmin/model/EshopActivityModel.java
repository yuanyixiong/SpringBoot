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
 * @ClassName EshopActivityModel
 * @Description TODO
 * @Date 2018/05/23 16:37
 * @Author shixun.online
 * @Version 1.0
 **/
@Entity
@Table(name = "eshop_activity", schema = "eshop", catalog = "")
public class EshopActivityModel extends BaseModel {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String activityName;
    private String activityContent;
    private Date activityStartTime;
    private Date activityEndTime;
    private Integer activityIndex;

    @Basic
    @Column(name = "activity_name")
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Basic
    @Column(name = "activity_content")
    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    @Basic
    @Column(name = "activity_start_time")
    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    @Basic
    @Column(name = "activity_end_time")
    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    @Basic
    @Column(name = "activity_index")
    public Integer getActivityIndex() {
        return activityIndex;
    }

    public void setActivityIndex(Integer activityIndex) {
        this.activityIndex = activityIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopActivityModel that = (EshopActivityModel) o;

        if (activityName != null ? !activityName.equals(that.activityName) : that.activityName != null) return false;
        if (activityContent != null ? !activityContent.equals(that.activityContent) : that.activityContent != null)
            return false;
        if (activityStartTime != null ? !activityStartTime.equals(that.activityStartTime) : that.activityStartTime != null)
            return false;
        if (activityEndTime != null ? !activityEndTime.equals(that.activityEndTime) : that.activityEndTime != null)
            return false;
        if (activityIndex != null ? !activityIndex.equals(that.activityIndex) : that.activityIndex != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = activityName != null ? activityName.hashCode() : 0;
        result = 31 * result + (activityContent != null ? activityContent.hashCode() : 0);
        result = 31 * result + (activityStartTime != null ? activityStartTime.hashCode() : 0);
        result = 31 * result + (activityEndTime != null ? activityEndTime.hashCode() : 0);
        result = 31 * result + (activityIndex != null ? activityIndex.hashCode() : 0);
        return result;
    }
}
