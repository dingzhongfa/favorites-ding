package com.ding.favorites.domain;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    // 评论id
    private String id;

    // 收藏id
    private String collectId;

    // 内容
    private String content;

    // 被评论用户
    private String userId;

    // 评论用户
    private String replyUserId;

    // 评论时间
    private Date commentTime;

    // 被评论用户名字
    private String userName;

    // 评论用户名字
    private String replyUserName;

    // ??
    private String profilePicture;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollectId() {
        return collectId;
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(String replyUserId) {
        this.replyUserId = replyUserId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}