package online.shixun.demo.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class EshopColor implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_color.id
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_color.is_del
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private Integer isDel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_color.create_time
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_color.update_time
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_color.color_name
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private String colorName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_color.color_parent_id
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private String colorParentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_color.color_img_url
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private String colorImgUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_color
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_color.id
     *
     * @return the value of eshop_color.id
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_color.id
     *
     * @param id the value for eshop_color.id
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_color.is_del
     *
     * @return the value of eshop_color.is_del
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_color.is_del
     *
     * @param isDel the value for eshop_color.is_del
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_color.create_time
     *
     * @return the value of eshop_color.create_time
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_color.create_time
     *
     * @param createTime the value for eshop_color.create_time
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_color.update_time
     *
     * @return the value of eshop_color.update_time
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_color.update_time
     *
     * @param updateTime the value for eshop_color.update_time
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_color.color_name
     *
     * @return the value of eshop_color.color_name
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public String getColorName() {
        return colorName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_color.color_name
     *
     * @param colorName the value for eshop_color.color_name
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setColorName(String colorName) {
        this.colorName = colorName == null ? null : colorName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_color.color_parent_id
     *
     * @return the value of eshop_color.color_parent_id
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public String getColorParentId() {
        return colorParentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_color.color_parent_id
     *
     * @param colorParentId the value for eshop_color.color_parent_id
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setColorParentId(String colorParentId) {
        this.colorParentId = colorParentId == null ? null : colorParentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_color.color_img_url
     *
     * @return the value of eshop_color.color_img_url
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public String getColorImgUrl() {
        return colorImgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_color.color_img_url
     *
     * @param colorImgUrl the value for eshop_color.color_img_url
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setColorImgUrl(String colorImgUrl) {
        this.colorImgUrl = colorImgUrl == null ? null : colorImgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_color
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
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
        sb.append(", colorName=").append(colorName);
        sb.append(", colorParentId=").append(colorParentId);
        sb.append(", colorImgUrl=").append(colorImgUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}