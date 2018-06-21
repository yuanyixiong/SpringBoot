package online.shixun.demo.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class EshopResource implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_resource.id
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_resource.is_del
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    private Integer isDel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_resource.create_time
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_resource.update_time
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_resource.resource_name
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    private String resourceName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_resource.resource_parent_id
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    private String resourceParentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_resource.resource_url
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    private String resourceUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_resource.resource_ico
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    private String resourceIco;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_resource.resource_index
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    private Integer resourceIndex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_resource.resource_description
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    private String resourceDescription;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_resource.resource_image
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    private String resourceImage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_resource.id
     *
     * @return the value of eshop_resource.id
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_resource.id
     *
     * @param id the value for eshop_resource.id
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_resource.is_del
     *
     * @return the value of eshop_resource.is_del
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_resource.is_del
     *
     * @param isDel the value for eshop_resource.is_del
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_resource.create_time
     *
     * @return the value of eshop_resource.create_time
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_resource.create_time
     *
     * @param createTime the value for eshop_resource.create_time
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_resource.update_time
     *
     * @return the value of eshop_resource.update_time
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_resource.update_time
     *
     * @param updateTime the value for eshop_resource.update_time
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_resource.resource_name
     *
     * @return the value of eshop_resource.resource_name
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_resource.resource_name
     *
     * @param resourceName the value for eshop_resource.resource_name
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_resource.resource_parent_id
     *
     * @return the value of eshop_resource.resource_parent_id
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public String getResourceParentId() {
        return resourceParentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_resource.resource_parent_id
     *
     * @param resourceParentId the value for eshop_resource.resource_parent_id
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public void setResourceParentId(String resourceParentId) {
        this.resourceParentId = resourceParentId == null ? null : resourceParentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_resource.resource_url
     *
     * @return the value of eshop_resource.resource_url
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_resource.resource_url
     *
     * @param resourceUrl the value for eshop_resource.resource_url
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_resource.resource_ico
     *
     * @return the value of eshop_resource.resource_ico
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public String getResourceIco() {
        return resourceIco;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_resource.resource_ico
     *
     * @param resourceIco the value for eshop_resource.resource_ico
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public void setResourceIco(String resourceIco) {
        this.resourceIco = resourceIco == null ? null : resourceIco.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_resource.resource_index
     *
     * @return the value of eshop_resource.resource_index
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public Integer getResourceIndex() {
        return resourceIndex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_resource.resource_index
     *
     * @param resourceIndex the value for eshop_resource.resource_index
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public void setResourceIndex(Integer resourceIndex) {
        this.resourceIndex = resourceIndex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_resource.resource_description
     *
     * @return the value of eshop_resource.resource_description
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public String getResourceDescription() {
        return resourceDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_resource.resource_description
     *
     * @param resourceDescription the value for eshop_resource.resource_description
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription == null ? null : resourceDescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_resource.resource_image
     *
     * @return the value of eshop_resource.resource_image
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public String getResourceImage() {
        return resourceImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_resource.resource_image
     *
     * @param resourceImage the value for eshop_resource.resource_image
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
     */
    public void setResourceImage(String resourceImage) {
        this.resourceImage = resourceImage == null ? null : resourceImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_resource
     *
     * @mbg.generated Fri May 11 10:30:06 CST 2018
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
        sb.append(", resourceName=").append(resourceName);
        sb.append(", resourceParentId=").append(resourceParentId);
        sb.append(", resourceUrl=").append(resourceUrl);
        sb.append(", resourceIco=").append(resourceIco);
        sb.append(", resourceIndex=").append(resourceIndex);
        sb.append(", resourceDescription=").append(resourceDescription);
        sb.append(", resourceImage=").append(resourceImage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}