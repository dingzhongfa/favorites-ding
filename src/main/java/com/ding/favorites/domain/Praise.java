package com.ding.favorites.domain;

import java.io.Serializable;
import java.util.Date;

public class Praise implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    // 收藏id
    private String collectId;

    // 用户id
    private String userId;

    // 点赞时间
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollectId() {
        return collectId;
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}