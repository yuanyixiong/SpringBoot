package online.shixun.demo.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class EshopCollectItem implements Serializable {

    private EshopProduct product;

    public EshopProduct getProduct() {
        return product;
    }

    public void setProduct(EshopProduct product) {
        this.product = product;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect_item.id
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect_item.collect_id
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    private String collectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect_item.product_id
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    private String productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect_item.color_id
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    private String colorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect_item.size_id
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    private String sizeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect_item.is_del
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    private Integer isDel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect_item.create_time
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect_item.update_time
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_collect_item
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect_item.id
     *
     * @return the value of eshop_collect_item.id
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect_item.id
     *
     * @param id the value for eshop_collect_item.id
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect_item.collect_id
     *
     * @return the value of eshop_collect_item.collect_id
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public String getCollectId() {
        return collectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect_item.collect_id
     *
     * @param collectId the value for eshop_collect_item.collect_id
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public void setCollectId(String collectId) {
        this.collectId = collectId == null ? null : collectId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect_item.product_id
     *
     * @return the value of eshop_collect_item.product_id
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public String getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect_item.product_id
     *
     * @param productId the value for eshop_collect_item.product_id
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect_item.color_id
     *
     * @return the value of eshop_collect_item.color_id
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public String getColorId() {
        return colorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect_item.color_id
     *
     * @param colorId the value for eshop_collect_item.color_id
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public void setColorId(String colorId) {
        this.colorId = colorId == null ? null : colorId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect_item.size_id
     *
     * @return the value of eshop_collect_item.size_id
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public String getSizeId() {
        return sizeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect_item.size_id
     *
     * @param sizeId the value for eshop_collect_item.size_id
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public void setSizeId(String sizeId) {
        this.sizeId = sizeId == null ? null : sizeId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect_item.is_del
     *
     * @return the value of eshop_collect_item.is_del
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect_item.is_del
     *
     * @param isDel the value for eshop_collect_item.is_del
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect_item.create_time
     *
     * @return the value of eshop_collect_item.create_time
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect_item.create_time
     *
     * @param createTime the value for eshop_collect_item.create_time
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect_item.update_time
     *
     * @return the value of eshop_collect_item.update_time
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect_item.update_time
     *
     * @param updateTime the value for eshop_collect_item.update_time
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_collect_item
     *
     * @mbg.generated Wed May 23 17:26:39 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", collectId=").append(collectId);
        sb.append(", productId=").append(productId);
        sb.append(", colorId=").append(colorId);
        sb.append(", sizeId=").append(sizeId);
        sb.append(", isDel=").append(isDel);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}