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
 * @ClassName EshopSlideshowModel
 * @Description TODO
 * @Date 2018/05/23 16:38
 * @Author shixun.online
 * @Version 1.0
 **/
@Entity
@Table(name = "eshop_slideshow", schema = "eshop", catalog = "")
public class EshopSlideshowModel extends BaseModel {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String slideshowName;
    private String slideshowUrl;
    private Integer slideshowIndex;
    private String slideshowHtml;
    private String slideshowImage;

    @Basic
    @Column(name = "slideshow_name")
    public String getSlideshowName() {
        return slideshowName;
    }

    public void setSlideshowName(String slideshowName) {
        this.slideshowName = slideshowName;
    }

    @Basic
    @Column(name = "slideshow_url")
    public String getSlideshowUrl() {
        return slideshowUrl;
    }

    public void setSlideshowUrl(String slideshowUrl) {
        this.slideshowUrl = slideshowUrl;
    }

    @Basic
    @Column(name = "slideshow_index")
    public Integer getSlideshowIndex() {
        return slideshowIndex;
    }

    public void setSlideshowIndex(Integer slideshowIndex) {
        this.slideshowIndex = slideshowIndex;
    }

    @Basic
    @Column(name = "slideshow_html")
    public String getSlideshowHtml() {
        return slideshowHtml;
    }

    public void setSlideshowHtml(String slideshowHtml) {
        this.slideshowHtml = slideshowHtml;
    }

    @Basic
    @Column(name = "slideshow_image")
    public String getSlideshowImage() {
        return slideshowImage;
    }

    public void setSlideshowImage(String slideshowImage) {
        this.slideshowImage = slideshowImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopSlideshowModel that = (EshopSlideshowModel) o;

        if (slideshowName != null ? !slideshowName.equals(that.slideshowName) : that.slideshowName != null)
            return false;
        if (slideshowUrl != null ? !slideshowUrl.equals(that.slideshowUrl) : that.slideshowUrl != null) return false;
        if (slideshowIndex != null ? !slideshowIndex.equals(that.slideshowIndex) : that.slideshowIndex != null)
            return false;
        if (slideshowHtml != null ? !slideshowHtml.equals(that.slideshowHtml) : that.slideshowHtml != null)
            return false;
        if (slideshowImage != null ? !slideshowImage.equals(that.slideshowImage) : that.slideshowImage != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = slideshowName != null ? slideshowName.hashCode() : 0;
        result = 31 * result + (slideshowUrl != null ? slideshowUrl.hashCode() : 0);
        result = 31 * result + (slideshowIndex != null ? slideshowIndex.hashCode() : 0);
        result = 31 * result + (slideshowHtml != null ? slideshowHtml.hashCode() : 0);
        result = 31 * result + (slideshowImage != null ? slideshowImage.hashCode() : 0);
        return result;
    }
}
