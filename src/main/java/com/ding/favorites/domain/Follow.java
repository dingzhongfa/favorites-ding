package com.ding.favorites.domain;

import com.ding.favorites.domain.enums.FollowStatus;

import java.io.Serializable;
import java.util.Date;

public class Follow implements Serializable {

    private static final long serialVersionUID = 1L;

    // 评论id
    private String id;

    // 用户id
    private String userId;

    // 粉丝id
    private String followId;

    // 状态
    private FollowStatus status;

    // 创建日期
    private Date createTime;

    // 最后修改日期
    private Date lastModifyTime;

    // 粉丝名字
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFollowId() {
        return followId;
    }

    public void setFollowId(String followId) {
        this.followId = followId;
    }

    public FollowStatus getStatus() {
        return status;
    }

    public void setStatus(FollowStatus status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}