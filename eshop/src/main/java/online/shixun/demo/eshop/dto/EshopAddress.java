package online.shixun.demo.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class EshopAddress implements Serializable {

    private EshopAddressState state;
    private EshopAddressProvince province;
    private EshopAddressCity city;
    private EshopAddressTown town;

    public EshopAddressState getState() {
        return state;
    }

    public void setState(EshopAddressState state) {
        this.state = state;
    }

    public EshopAddressProvince getProvince() {
        return province;
    }

    public void setProvince(EshopAddressProvince province) {
        this.province = province;
    }

    public EshopAddressCity getCity() {
        return city;
    }

    public void setCity(EshopAddressCity city) {
        this.city = city;
    }

    public EshopAddressTown getTown() {
        return town;
    }

    public void setTown(EshopAddressTown town) {
        this.town = town;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.id
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.is_del
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private Integer isDel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.create_time
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.update_time
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.user_id
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.state_id
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private String stateId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.province_id
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private String provinceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.city_id
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private String cityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.town_id
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private String townId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.address_location
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private String addressLocation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.address_phone
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private String addressPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.address_postcode
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private Integer addressPostcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.address_faddr_axes
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private String addressFaddrAxes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.address_is_def
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private Integer addressIsDef;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.address_name
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private String addressName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_address.address_recipients
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private String addressRecipients;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_address
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.id
     *
     * @return the value of eshop_address.id
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.id
     *
     * @param id the value for eshop_address.id
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.is_del
     *
     * @return the value of eshop_address.is_del
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.is_del
     *
     * @param isDel the value for eshop_address.is_del
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.create_time
     *
     * @return the value of eshop_address.create_time
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.create_time
     *
     * @param createTime the value for eshop_address.create_time
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.update_time
     *
     * @return the value of eshop_address.update_time
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.update_time
     *
     * @param updateTime the value for eshop_address.update_time
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.user_id
     *
     * @return the value of eshop_address.user_id
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.user_id
     *
     * @param userId the value for eshop_address.user_id
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.state_id
     *
     * @return the value of eshop_address.state_id
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public String getStateId() {
        return stateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.state_id
     *
     * @param stateId the value for eshop_address.state_id
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setStateId(String stateId) {
        this.stateId = stateId == null ? null : stateId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.province_id
     *
     * @return the value of eshop_address.province_id
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public String getProvinceId() {
        return provinceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.province_id
     *
     * @param provinceId the value for eshop_address.province_id
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.city_id
     *
     * @return the value of eshop_address.city_id
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.city_id
     *
     * @param cityId the value for eshop_address.city_id
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.town_id
     *
     * @return the value of eshop_address.town_id
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public String getTownId() {
        return townId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.town_id
     *
     * @param townId the value for eshop_address.town_id
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setTownId(String townId) {
        this.townId = townId == null ? null : townId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.address_location
     *
     * @return the value of eshop_address.address_location
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public String getAddressLocation() {
        return addressLocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.address_location
     *
     * @param addressLocation the value for eshop_address.address_location
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setAddressLocation(String addressLocation) {
        this.addressLocation = addressLocation == null ? null : addressLocation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.address_phone
     *
     * @return the value of eshop_address.address_phone
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public String getAddressPhone() {
        return addressPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.address_phone
     *
     * @param addressPhone the value for eshop_address.address_phone
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone == null ? null : addressPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.address_postcode
     *
     * @return the value of eshop_address.address_postcode
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public Integer getAddressPostcode() {
        return addressPostcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.address_postcode
     *
     * @param addressPostcode the value for eshop_address.address_postcode
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setAddressPostcode(Integer addressPostcode) {
        this.addressPostcode = addressPostcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.address_faddr_axes
     *
     * @return the value of eshop_address.address_faddr_axes
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public String getAddressFaddrAxes() {
        return addressFaddrAxes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.address_faddr_axes
     *
     * @param addressFaddrAxes the value for eshop_address.address_faddr_axes
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setAddressFaddrAxes(String addressFaddrAxes) {
        this.addressFaddrAxes = addressFaddrAxes == null ? null : addressFaddrAxes.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.address_is_def
     *
     * @return the value of eshop_address.address_is_def
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public Integer getAddressIsDef() {
        return addressIsDef;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.address_is_def
     *
     * @param addressIsDef the value for eshop_address.address_is_def
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setAddressIsDef(Integer addressIsDef) {
        this.addressIsDef = addressIsDef;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.address_name
     *
     * @return the value of eshop_address.address_name
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.address_name
     *
     * @param addressName the value for eshop_address.address_name
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_address.address_recipients
     *
     * @return the value of eshop_address.address_recipients
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public String getAddressRecipients() {
        return addressRecipients;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_address.address_recipients
     *
     * @param addressRecipients the value for eshop_address.address_recipients
     * @mbg.generated Thu May 17 16:36:46 CST 2018
     */
    public void setAddressRecipients(String addressRecipients) {
        this.addressRecipients = addressRecipients == null ? null : addressRecipients.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_address
     *
     * @mbg.generated Thu May 17 16:36:46 CST 2018
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
        sb.append(", stateId=").append(stateId);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", cityId=").append(cityId);
        sb.append(", townId=").append(townId);
        sb.append(", addressLocation=").append(addressLocation);
        sb.append(", addressPhone=").append(addressPhone);
        sb.append(", addressPostcode=").append(addressPostcode);
        sb.append(", addressFaddrAxes=").append(addressFaddrAxes);
        sb.append(", addressIsDef=").append(addressIsDef);
        sb.append(", addressName=").append(addressName);
        sb.append(", addressRecipients=").append(addressRecipients);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}