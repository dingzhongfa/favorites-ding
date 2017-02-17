package com.ding.favorites.domain;

import com.ding.favorites.domain.enums.NoticeType;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    // 消息id
    private String id;

    // 用户id
    private String userId;

    // 收藏夹id
    private String collectId;

    // 类型
    private NoticeType type;

    // 消息源用户
    private String operId;

    // 是否已读，0-已读，1-未读
    private Byte readed;

    // 消息时间
    private Date createTime;

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

    public String getCollectId() {
        return collectId;
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId;
    }

    public NoticeType getType() {
        return type;
    }

    public void setType(NoticeType type) {
        this.type = type;
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    public Byte getReaded() {
        return readed;
    }

    public void setReaded(Byte readed) {
        this.readed = readed;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}