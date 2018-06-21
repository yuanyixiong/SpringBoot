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
@Table(name = "eshop_feature", schema = "eshop", catalog = "")
public class EshopFeatureModel extends BaseModel {
    private String featureName;
    private String featureValue;
    private Integer featureIndex;


    @Basic
    @Column(name = "feature_name", nullable = true, length = 200)
    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    @Basic
    @Column(name = "feature_value", nullable = true, length = 200)
    public String getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }

    @Basic
    @Column(name = "feature_index", nullable = true)
    public Integer getFeatureIndex() {
        return featureIndex;
    }

    public void setFeatureIndex(Integer featureIndex) {
        this.featureIndex = featureIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopFeatureModel that = (EshopFeatureModel) o;
        if (featureName != null ? !featureName.equals(that.featureName) : that.featureName != null) return false;
        if (featureValue != null ? !featureValue.equals(that.featureValue) : that.featureValue != null) return false;
        if (featureIndex != null ? !featureIndex.equals(that.featureIndex) : that.featureIndex != null) return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (featureName != null ? featureName.hashCode() : 0);
        result = 31 * result + (featureValue != null ? featureValue.hashCode() : 0);
        result = 31 * result + (featureIndex != null ? featureIndex.hashCode() : 0);
        return result;
    }
}
