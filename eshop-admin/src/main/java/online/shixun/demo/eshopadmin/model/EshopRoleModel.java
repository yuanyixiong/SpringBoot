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
@Table(name = "eshop_role", schema = "eshop", catalog = "")
public class EshopRoleModel extends BaseModel {
    private String roleName;
    private String roleDescription;

    //特殊属性
    private List<EshopResourceModel> resources = new ArrayList<>();
    private List<EshopUserModel> users = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(targetEntity = EshopResourceModel.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "eshop_role_resource",//中间表
            joinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")//关联列
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "resource_id", referencedColumnName = "id")//另一个表的列
            }
    )
    public List<EshopResourceModel> getResources() {
        return resources;
    }

    public void setResources(List<EshopResourceModel> resources) {
        this.resources = resources;
    }


    @JsonIgnore
    @ManyToMany(targetEntity = EshopUserModel.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "eshop_user_role",//中间表
            joinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")//关联列
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id")//另一个表的列
            }
    )
    public List<EshopUserModel> getUsers() {
        return users;
    }

    public void setUsers(List<EshopUserModel> users) {
        this.users = users;
    }

    @Basic
    @Column(name = "role_name", nullable = true, length = 100)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_description", nullable = true, length = 200)
    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EshopRoleModel roleModel = (EshopRoleModel) o;
        if (roleName != null ? !roleName.equals(roleModel.roleName) : roleModel.roleName != null) return false;
        if (roleDescription != null ? !roleDescription.equals(roleModel.roleDescription) : roleModel.roleDescription != null)
            return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (roleDescription != null ? roleDescription.hashCode() : 0);
        return result;
    }
}
