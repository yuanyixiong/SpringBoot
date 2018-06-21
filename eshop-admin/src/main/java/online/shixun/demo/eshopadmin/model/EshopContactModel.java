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
@Table(name = "eshop_contact", schema = "eshop", catalog = "")
public class EshopContactModel extends BaseModel {
    private String userId;
    private Integer contactContent;
    private String contactEmail;
    private String contactMessage;

    @Basic
    @Column(name = "user_id", nullable = true, length = 200)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "contact_content", nullable = true)
    public Integer getContactContent() {
        return contactContent;
    }

    public void setContactContent(Integer contactContent) {
        this.contactContent = contactContent;
    }

    @Basic
    @Column(name = "contact_email", nullable = true, length = 50)
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Basic
    @Column(name = "contact_message", nullable = true, length = 2000)
    public String getContactMessage() {
        return contactMessage;
    }

    public void setContactMessage(String contactMessage) {
        this.contactMessage = contactMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopContactModel that = (EshopContactModel) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (contactContent != null ? !contactContent.equals(that.contactContent) : that.contactContent != null)
            return false;
        if (contactEmail != null ? !contactEmail.equals(that.contactEmail) : that.contactEmail != null) return false;
        if (contactMessage != null ? !contactMessage.equals(that.contactMessage) : that.contactMessage != null)
            return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (contactContent != null ? contactContent.hashCode() : 0);
        result = 31 * result + (contactEmail != null ? contactEmail.hashCode() : 0);
        result = 31 * result + (contactMessage != null ? contactMessage.hashCode() : 0);
        return result;
    }
}
