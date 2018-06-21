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
 * @ClassName EshopAboutModel
 * @Description TODO
 * @Date 2018/05/23 16:37
 * @Author shixun.online
 * @Version 1.0
 **/
@Entity
@Table(name = "eshop_about", schema = "eshop", catalog = "")
public class EshopAboutModel extends BaseModel {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String aboutTitle;
    private String aboutContent;
    private Integer aboutIndex;

    @Basic
    @Column(name = "about_title")
    public String getAboutTitle() {
        return aboutTitle;
    }

    public void setAboutTitle(String aboutTitle) {
        this.aboutTitle = aboutTitle;
    }

    @Basic
    @Column(name = "about_content")
    public String getAboutContent() {
        return aboutContent;
    }

    public void setAboutContent(String aboutContent) {
        this.aboutContent = aboutContent;
    }

    @Basic
    @Column(name = "about_index")
    public Integer getAboutIndex() {
        return aboutIndex;
    }

    public void setAboutIndex(Integer aboutIndex) {
        this.aboutIndex = aboutIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopAboutModel that = (EshopAboutModel) o;

        if (aboutTitle != null ? !aboutTitle.equals(that.aboutTitle) : that.aboutTitle != null) return false;
        if (aboutContent != null ? !aboutContent.equals(that.aboutContent) : that.aboutContent != null) return false;
        if (aboutIndex != null ? !aboutIndex.equals(that.aboutIndex) : that.aboutIndex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aboutTitle != null ? aboutTitle.hashCode() : 0;
        result = 31 * result + (aboutContent != null ? aboutContent.hashCode() : 0);
        result = 31 * result + (aboutIndex != null ? aboutIndex.hashCode() : 0);
        return result;
    }
}
