package com.bs.yuyue.pojo;

import javax.persistence.*;

@Entity
public class User {
    @Id
    private int id;
    private String name;
    private String password;
    private String avatar;
    private int roleId=1;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId", referencedColumnName = "id", insertable = false, updatable = false)
    private RoleItem roleItem;

    public RoleItem getRoleItem() {
        return roleItem;
    }

    public void setRoleItem(RoleItem roleItem) {
        this.roleItem = roleItem;
    }
}
