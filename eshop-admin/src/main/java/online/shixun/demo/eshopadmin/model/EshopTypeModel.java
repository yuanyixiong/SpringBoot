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
@Table(name = "eshop_type", schema = "eshop", catalog = "")
public class EshopTypeModel extends BaseModel {
    private String typeName;
    private String typeParentId;
    private String typeNote;
    private String typeUrl;
    private String typeImage;
    private String typeIco;
    private Integer typeIndex;
    private String typeDescription;


    @Basic
    @Column(name = "type_name", nullable = true, length = 20)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "type_parent_id", nullable = true, length = 200)
    public String getTypeParentId() {
        return typeParentId;
    }

    public void setTypeParentId(String typeParentId) {
        this.typeParentId = typeParentId;
    }

    @Basic
    @Column(name = "type_note", nullable = true, length = 50)
    public String getTypeNote() {
        return typeNote;
    }

    public void setTypeNote(String typeNote) {
        this.typeNote = typeNote;
    }

    @Basic
    @Column(name = "type_url", nullable = true, length = 200)
    public String getTypeUrl() {
        return typeUrl;
    }

    public void setTypeUrl(String typeUrl) {
        this.typeUrl = typeUrl;
    }

    @Basic
    @Column(name = "type_image", nullable = true, length = 200)
    public String getTypeImage() {
        return typeImage;
    }

    public void setTypeImage(String typeImage) {
        this.typeImage = typeImage;
    }

    @Basic
    @Column(name = "type_ico", nullable = true, length = 200)
    public String getTypeIco() {
        return typeIco;
    }

    public void setTypeIco(String typeIco) {
        this.typeIco = typeIco;
    }

    @Basic
    @Column(name = "type_index", nullable = true)
    public Integer getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(Integer typeIndex) {
        this.typeIndex = typeIndex;
    }

    @Basic
    @Column(name = "type_description", nullable = true, length = 200)
    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopTypeModel typeModel = (EshopTypeModel) o;

        if (typeName != null ? !typeName.equals(typeModel.typeName) : typeModel.typeName != null) return false;
        if (typeParentId != null ? !typeParentId.equals(typeModel.typeParentId) : typeModel.typeParentId != null)
            return false;
        if (typeNote != null ? !typeNote.equals(typeModel.typeNote) : typeModel.typeNote != null) return false;
        if (typeUrl != null ? !typeUrl.equals(typeModel.typeUrl) : typeModel.typeUrl != null) return false;
        if (typeImage != null ? !typeImage.equals(typeModel.typeImage) : typeModel.typeImage != null) return false;
        if (typeIco != null ? !typeIco.equals(typeModel.typeIco) : typeModel.typeIco != null) return false;
        if (typeIndex != null ? !typeIndex.equals(typeModel.typeIndex) : typeModel.typeIndex != null) return false;
        if (typeDescription != null ? !typeDescription.equals(typeModel.typeDescription) : typeModel.typeDescription != null)
            return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (typeParentId != null ? typeParentId.hashCode() : 0);
        result = 31 * result + (typeNote != null ? typeNote.hashCode() : 0);
        result = 31 * result + (typeUrl != null ? typeUrl.hashCode() : 0);
        result = 31 * result + (typeImage != null ? typeImage.hashCode() : 0);
        result = 31 * result + (typeIco != null ? typeIco.hashCode() : 0);
        result = 31 * result + (typeIndex != null ? typeIndex.hashCode() : 0);
        result = 31 * result + (typeDescription != null ? typeDescription.hashCode() : 0);
        return result;
    }
}
