package com.ding.favorites.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    // 用户id
    private String id;

    // 用户名
    private String userName;

    // 密码
    private String password;

    // 邮箱
    private String email;

    // 头像url
    private String profilePicture;

    // 用户介绍
    private String introduction;

    // 注册日期
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}