package online.shixun.demo.eshop.dto;

import online.shixun.demo.eshop.core.service.BeanEnum;

import java.io.Serializable;
import java.util.Date;

public class EshopUser implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_user.id
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_user.is_del
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    private Integer isDel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_user.create_time
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_user.update_time
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_user.user_email
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    private String userEmail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_user.user_login_name
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    private String userLoginName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_user.user_nicak_name
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    private String userNicakName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_user.user_password
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    private String userPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_user.user_real_name
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    private String userRealName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_user.user_gender
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    private Integer userGender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_user.user_description
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    private String userDescription;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_user.user_image
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    private String userImage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_user
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_user.id
     *
     * @return the value of eshop_user.id
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_user.id
     *
     * @param id the value for eshop_user.id
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_user.is_del
     *
     * @return the value of eshop_user.is_del
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_user.is_del
     *
     * @param isDel the value for eshop_user.is_del
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_user.create_time
     *
     * @return the value of eshop_user.create_time
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_user.create_time
     *
     * @param createTime the value for eshop_user.create_time
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_user.update_time
     *
     * @return the value of eshop_user.update_time
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_user.update_time
     *
     * @param updateTime the value for eshop_user.update_time
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_user.user_email
     *
     * @return the value of eshop_user.user_email
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_user.user_email
     *
     * @param userEmail the value for eshop_user.user_email
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_user.user_login_name
     *
     * @return the value of eshop_user.user_login_name
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public String getUserLoginName() {
        return userLoginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_user.user_login_name
     *
     * @param userLoginName the value for eshop_user.user_login_name
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName == null ? null : userLoginName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_user.user_nicak_name
     *
     * @return the value of eshop_user.user_nicak_name
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public String getUserNicakName() {
        return userNicakName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_user.user_nicak_name
     *
     * @param userNicakName the value for eshop_user.user_nicak_name
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public void setUserNicakName(String userNicakName) {
        this.userNicakName = userNicakName == null ? null : userNicakName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_user.user_password
     *
     * @return the value of eshop_user.user_password
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_user.user_password
     *
     * @param userPassword the value for eshop_user.user_password
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_user.user_real_name
     *
     * @return the value of eshop_user.user_real_name
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public String getUserRealName() {
        return userRealName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_user.user_real_name
     *
     * @param userRealName the value for eshop_user.user_real_name
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName == null ? null : userRealName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_user.user_gender
     *
     * @return the value of eshop_user.user_gender
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public Integer getUserGender() {
        return userGender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_user.user_gender
     *
     * @param userGender the value for eshop_user.user_gender
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_user.user_description
     *
     * @return the value of eshop_user.user_description
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public String getUserDescription() {
        return userDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_user.user_description
     *
     * @param userDescription the value for eshop_user.user_description
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription == null ? null : userDescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_user.user_image
     *
     * @return the value of eshop_user.user_image
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public String getUserImage() {
        return userImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_user.user_image
     *
     * @param userImage the value for eshop_user.user_image
     * @mbg.generated Wed May 16 14:30:10 CST 2018
     */
    public void setUserImage(String userImage) {
        this.userImage = userImage == null ? null : userImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_user
     *
     * @mbg.generated Wed May 16 14:30:10 CST 2018
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
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userLoginName=").append(userLoginName);
        sb.append(", userNicakName=").append(userNicakName);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userRealName=").append(userRealName);
        sb.append(", userGender=").append(userGender);
        sb.append(", userDescription=").append(userDescription);
        sb.append(", userImage=").append(userImage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public EshopUser(String id, Integer isDel, Date createTime,Date updateTime, String userEmail, String userLoginName, String userPassword, String userDescription) {
        this.id = id;
        this.isDel = isDel;
        this.createTime=createTime;
        this.updateTime = updateTime;
        this.userEmail = userEmail;
        this.userLoginName = userLoginName;
        this.userPassword = userPassword;
        this.userDescription = userDescription;
    }

    public EshopUser() {
    }
}