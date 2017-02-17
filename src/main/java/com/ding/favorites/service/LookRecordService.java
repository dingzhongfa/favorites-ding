package com.ding.favorites.service;



import com.ding.favorites.domain.view.CollectSummary;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 浏览记录service接口
 * Created by chenzhimin on 2017/1/12.
 */
public interface LookRecordService {

    public void saveLookRecord(Long userId, Long collectId);

    public List<CollectSummary> getLookRecords(Long userId, PageInfo pageInfo);
}
