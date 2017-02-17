package com.ding.favorites.domain.undecitioned;


import java.io.Serializable;

/**
 * Created by DingYS on 2016/12/29.
 */

public class UrlLibrary extends Entitys implements Serializable{

    private Long id;

    private String url;

    private String logoUrl;

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

}
