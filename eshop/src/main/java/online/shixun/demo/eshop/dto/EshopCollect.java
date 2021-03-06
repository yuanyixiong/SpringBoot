package online.shixun.demo.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class EshopCollect implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect.id
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect.is_del
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    private Integer isDel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect.create_time
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect.update_time
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect.user_id
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect.collect_name
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    private String collectName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect.collect_number
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    private Integer collectNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_collect.collect_viewcount
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    private Integer collectViewcount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_collect
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect.id
     *
     * @return the value of eshop_collect.id
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect.id
     *
     * @param id the value for eshop_collect.id
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect.is_del
     *
     * @return the value of eshop_collect.is_del
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect.is_del
     *
     * @param isDel the value for eshop_collect.is_del
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect.create_time
     *
     * @return the value of eshop_collect.create_time
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect.create_time
     *
     * @param createTime the value for eshop_collect.create_time
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect.update_time
     *
     * @return the value of eshop_collect.update_time
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect.update_time
     *
     * @param updateTime the value for eshop_collect.update_time
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect.user_id
     *
     * @return the value of eshop_collect.user_id
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect.user_id
     *
     * @param userId the value for eshop_collect.user_id
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect.collect_name
     *
     * @return the value of eshop_collect.collect_name
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public String getCollectName() {
        return collectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect.collect_name
     *
     * @param collectName the value for eshop_collect.collect_name
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public void setCollectName(String collectName) {
        this.collectName = collectName == null ? null : collectName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect.collect_number
     *
     * @return the value of eshop_collect.collect_number
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public Integer getCollectNumber() {
        return collectNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect.collect_number
     *
     * @param collectNumber the value for eshop_collect.collect_number
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public void setCollectNumber(Integer collectNumber) {
        this.collectNumber = collectNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_collect.collect_viewcount
     *
     * @return the value of eshop_collect.collect_viewcount
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public Integer getCollectViewcount() {
        return collectViewcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_collect.collect_viewcount
     *
     * @param collectViewcount the value for eshop_collect.collect_viewcount
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
     */
    public void setCollectViewcount(Integer collectViewcount) {
        this.collectViewcount = collectViewcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_collect
     *
     * @mbg.generated Tue May 15 16:17:45 CST 2018
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
        sb.append(", userId=").append(userId);
        sb.append(", collectName=").append(collectName);
        sb.append(", collectNumber=").append(collectNumber);
        sb.append(", collectViewcount=").append(collectViewcount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public EshopCollect(String id, Integer isDel, Date createTime, Date updateTime, String userId, String collectName, Integer collectNumber, Integer collectViewcount) {
        this.id = id;
        this.isDel = isDel;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userId = userId;
        this.collectName = collectName;
        this.collectNumber = collectNumber;
        this.collectViewcount = collectViewcount;
    }

    public EshopCollect() {
    }
}