package com.ding.favorites.domain;

import com.ding.favorites.domain.enums.CollectType;
import com.ding.favorites.domain.enums.IsDelete;

import java.io.Serializable;
import java.util.Date;

public class Collection implements Serializable {

    private static final long serialVersionUID = 1L;
    // 收藏id
    private String id;

    // 用户id
    private String userId;

    // 收藏夹id
    private String favoritesId;

    // url地址
    private String url;

    // 主题
    private String title;

    // 描述
    private String description;

    // 收藏logo的url
    private String logoUrl;

    // 编码类型
    private String charset;

    // 权限
    private CollectType type;

    // 备注
    private String remark;

    // 是否删除
    private IsDelete isDelet;

    // 收藏日期
    private Date createTime;

    // 最后修改时间
    private Date lastModifyTime;

    // 收藏夹名
    private String category;

    // ??
    private String newFavorites;

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

    public String getFavoritesId() {
        return favoritesId;
    }

    public void setFavoritesId(String favoritesId) {
        this.favoritesId = favoritesId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public CollectType getType() {
        return type;
    }

    public void setType(CollectType type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public IsDelete getIsDelet() {
        return isDelet;
    }

    public void setIsDelet(IsDelete isDelet) {
        this.isDelet = isDelet;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNewFavorites() {
        return newFavorites;
    }

    public void setNewFavorites(String newFavorites) {
        this.newFavorites = newFavorites;
    }
}