package online.shixun.demo.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class EshopAbout implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_about.id
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_about.is_del
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    private Integer isDel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_about.create_time
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_about.update_time
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_about.about_title
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    private String aboutTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_about.about_index
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    private Integer aboutIndex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_about.about_content
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    private String aboutContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_about
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_about.id
     *
     * @return the value of eshop_about.id
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_about.id
     *
     * @param id the value for eshop_about.id
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_about.is_del
     *
     * @return the value of eshop_about.is_del
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_about.is_del
     *
     * @param isDel the value for eshop_about.is_del
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_about.create_time
     *
     * @return the value of eshop_about.create_time
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_about.create_time
     *
     * @param createTime the value for eshop_about.create_time
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_about.update_time
     *
     * @return the value of eshop_about.update_time
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_about.update_time
     *
     * @param updateTime the value for eshop_about.update_time
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_about.about_title
     *
     * @return the value of eshop_about.about_title
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    public String getAboutTitle() {
        return aboutTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_about.about_title
     *
     * @param aboutTitle the value for eshop_about.about_title
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    public void setAboutTitle(String aboutTitle) {
        this.aboutTitle = aboutTitle == null ? null : aboutTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_about.about_index
     *
     * @return the value of eshop_about.about_index
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    public Integer getAboutIndex() {
        return aboutIndex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_about.about_index
     *
     * @param aboutIndex the value for eshop_about.about_index
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    public void setAboutIndex(Integer aboutIndex) {
        this.aboutIndex = aboutIndex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_about.about_content
     *
     * @return the value of eshop_about.about_content
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    public String getAboutContent() {
        return aboutContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_about.about_content
     *
     * @param aboutContent the value for eshop_about.about_content
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    public void setAboutContent(String aboutContent) {
        this.aboutContent = aboutContent == null ? null : aboutContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_about
     *
     * @mbg.generated Mon May 21 14:34:29 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", isDel=").append(isDel);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", aboutTitle=").append(aboutTitle);
        sb.append(", aboutIndex=").append(aboutIndex);
        sb.append(", aboutContent=").append(aboutContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}