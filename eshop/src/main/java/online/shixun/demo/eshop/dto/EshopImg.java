package online.shixun.demo.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class EshopImg implements Serializable {

    //特殊属性
    private EshopProduct product;//产品

    public EshopProduct getProduct() {
        return product;
    }

    public void setProduct(EshopProduct product) {
        this.product = product;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_img.id
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_img.is_del
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private Integer isDel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_img.create_time
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_img.update_time
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_img.img_url
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private String imgUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_img.img_is_def
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private Integer imgIsDef;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_img.img_name
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private String imgName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_img.product_id
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private String productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_img
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_img.id
     *
     * @return the value of eshop_img.id
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_img.id
     *
     * @param id the value for eshop_img.id
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_img.is_del
     *
     * @return the value of eshop_img.is_del
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_img.is_del
     *
     * @param isDel the value for eshop_img.is_del
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_img.create_time
     *
     * @return the value of eshop_img.create_time
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_img.create_time
     *
     * @param createTime the value for eshop_img.create_time
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_img.update_time
     *
     * @return the value of eshop_img.update_time
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_img.update_time
     *
     * @param updateTime the value for eshop_img.update_time
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_img.img_url
     *
     * @return the value of eshop_img.img_url
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_img.img_url
     *
     * @param imgUrl the value for eshop_img.img_url
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_img.img_is_def
     *
     * @return the value of eshop_img.img_is_def
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public Integer getImgIsDef() {
        return imgIsDef;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_img.img_is_def
     *
     * @param imgIsDef the value for eshop_img.img_is_def
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setImgIsDef(Integer imgIsDef) {
        this.imgIsDef = imgIsDef;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_img.img_name
     *
     * @return the value of eshop_img.img_name
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_img.img_name
     *
     * @param imgName the value for eshop_img.img_name
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setImgName(String imgName) {
        this.imgName = imgName == null ? null : imgName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_img.product_id
     *
     * @return the value of eshop_img.product_id
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public String getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_img.product_id
     *
     * @param productId the value for eshop_img.product_id
     *
     * @mbg.generated Fri May 11 10:31:51 CST 2018
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_img
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
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", imgIsDef=").append(imgIsDef);
        sb.append(", imgName=").append(imgName);
        sb.append(", productId=").append(productId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}