package com.ding.favorites.domain.undecitioned;


import java.io.Serializable;

/**
 *  浏览记录entity
 * Created by chenzhimin on 2017/1/5.
 */

public class LookRecord extends Entitys implements Serializable{

    private static final long serialVersionUID = 1L;


    private Long id;

    private Long userId;

    private Long collectId;

    private Long createTime;

    private Long lastModifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCollectId() {
        return collectId;
    }

    public void setCollectId(Long collectId) {
        this.collectId = collectId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
