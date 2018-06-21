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
@Table(name = "eshop_resource", schema = "eshop", catalog = "")
public class EshopResourceModel extends BaseModel {
    private String resourceName;
    private String resourceParentId;
    private String resourceUrl;
    private String resourceIco;
    private Integer resourceIndex;
    private String resourceDescription;
    private String resourceImage;

    @Basic
    @Column(name = "resource_name", nullable = true, length = 20)
    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Basic
    @Column(name = "resource_parent_id", nullable = true, length = 200)
    public String getResourceParentId() {
        return resourceParentId;
    }

    public void setResourceParentId(String resourceParentId) {
        this.resourceParentId = resourceParentId;
    }

    @Basic
    @Column(name = "resource_url", nullable = true, length = 200)
    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    @Basic
    @Column(name = "resource_ico", nullable = true, length = 200)
    public String getResourceIco() {
        return resourceIco;
    }

    public void setResourceIco(String resourceIco) {
        this.resourceIco = resourceIco;
    }

    @Basic
    @Column(name = "resource_index", nullable = true)
    public Integer getResourceIndex() {
        return resourceIndex;
    }

    public void setResourceIndex(Integer resourceIndex) {
        this.resourceIndex = resourceIndex;
    }

    @Basic
    @Column(name = "resource_description", nullable = true, length = 200)
    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopResourceModel that = (EshopResourceModel) o;
        if (resourceName != null ? !resourceName.equals(that.resourceName) : that.resourceName != null) return false;
        if (resourceParentId != null ? !resourceParentId.equals(that.resourceParentId) : that.resourceParentId != null)
            return false;
        if (resourceUrl != null ? !resourceUrl.equals(that.resourceUrl) : that.resourceUrl != null) return false;
        if (resourceIco != null ? !resourceIco.equals(that.resourceIco) : that.resourceIco != null) return false;
        if (resourceIndex != null ? !resourceIndex.equals(that.resourceIndex) : that.resourceIndex != null)
            return false;
        if (resourceDescription != null ? !resourceDescription.equals(that.resourceDescription) : that.resourceDescription != null)
            return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (resourceName != null ? resourceName.hashCode() : 0);
        result = 31 * result + (resourceParentId != null ? resourceParentId.hashCode() : 0);
        result = 31 * result + (resourceUrl != null ? resourceUrl.hashCode() : 0);
        result = 31 * result + (resourceIco != null ? resourceIco.hashCode() : 0);
        result = 31 * result + (resourceIndex != null ? resourceIndex.hashCode() : 0);
        result = 31 * result + (resourceDescription != null ? resourceDescription.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "resource_image")
    public String getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(String resourceImage) {
        this.resourceImage = resourceImage;
    }
}
