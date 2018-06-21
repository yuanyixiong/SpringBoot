/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import online.shixun.demo.eshopadmin.core.model.BaseModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eshop_user", schema = "eshop", catalog = "")
public class EshopUserModel extends BaseModel {
    private String userEmail;
    private String userLoginName;
    private String userNicakName;
    private String userPassword;
    private String userRealName;
    private Integer userGender;
    private String userDescription;
    private String userImage;

    //特殊属性
    private List<EshopRoleModel> roles = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(targetEntity = EshopRoleModel.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "eshop_user_role",//中间表
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id")//关联列
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")//另一个表的列
            }
    )
    public List<EshopRoleModel> getRoles() {
        return roles;
    }

    public void setRoles(List<EshopRoleModel> roles) {
        this.roles = roles;
    }

    @Basic
    @Column(name = "user_email", nullable = true, length = 50)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_login_name", nullable = true, length = 20)
    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    @Basic
    @Column(name = "user_nicak_name", nullable = true, length = 20)
    public String getUserNicakName() {
        return userNicakName;
    }

    public void setUserNicakName(String userNicakName) {
        this.userNicakName = userNicakName;
    }

    @Basic
    @Column(name = "user_password", nullable = false, length = 200)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_real_name", nullable = true, length = 20)
    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    @Basic
    @Column(name = "user_gender", nullable = true)
    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    @Basic
    @Column(name = "user_description", nullable = true, length = 200)
    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    @Basic
    @Column(name = "user_image", nullable = true, length = 200)
    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopUserModel userModel = (EshopUserModel) o;
        if (userEmail != null ? !userEmail.equals(userModel.userEmail) : userModel.userEmail != null) return false;
        if (userLoginName != null ? !userLoginName.equals(userModel.userLoginName) : userModel.userLoginName != null)
            return false;
        if (userNicakName != null ? !userNicakName.equals(userModel.userNicakName) : userModel.userNicakName != null)
            return false;
        if (userPassword != null ? !userPassword.equals(userModel.userPassword) : userModel.userPassword != null)
            return false;
        if (userRealName != null ? !userRealName.equals(userModel.userRealName) : userModel.userRealName != null)
            return false;
        if (userGender != null ? !userGender.equals(userModel.userGender) : userModel.userGender != null) return false;
        if (userDescription != null ? !userDescription.equals(userModel.userDescription) : userModel.userDescription != null)
            return false;
        if (userImage != null ? !userImage.equals(userModel.userImage) : userModel.userImage != null) return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userLoginName != null ? userLoginName.hashCode() : 0);
        result = 31 * result + (userNicakName != null ? userNicakName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userRealName != null ? userRealName.hashCode() : 0);
        result = 31 * result + (userGender != null ? userGender.hashCode() : 0);
        result = 31 * result + (userDescription != null ? userDescription.hashCode() : 0);
        result = 31 * result + (userImage != null ? userImage.hashCode() : 0);
        return result;
    }
}
