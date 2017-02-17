package com.ding.favorites.domain.view;



/**
 * @Description:
 * @Auth: yuyang
 * @Date: 2017/1/17 12:25
 * @Version: 1.0
 **/

public class CollectorView {


    private Long id;

    private Long userId;

    private Long counts;

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

    public Long getCounts() {
        return counts;
    }

    public void setCounts(Long counts) {
        this.counts = counts;
    }
}
