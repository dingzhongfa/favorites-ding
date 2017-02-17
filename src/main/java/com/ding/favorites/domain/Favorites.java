package com.ding.favorites.domain;

import java.io.Serializable;
import java.util.Date;

public class Favorites implements Serializable {

    private static final long serialVersionUID = 1L;

    // 收藏夹id
    private String id;

    // 用户id
    private String userId;

    // 收藏夹名
    private String name;

    // 数量
    private Long count;

    // 创建日期
    private Date createTime;

    // 最后修改时间
    private Date lastModifyTime;

    // 公开数量
    private Long publicCount;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
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

    public Long getPublicCount() {
        return publicCount;
    }

    public void setPublicCount(Long publicCount) {
        this.publicCount = publicCount;
    }
}