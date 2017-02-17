package com.ding.favorites.service;



import com.ding.favorites.domain.enums.NoticeType;
import com.ding.favorites.domain.view.CollectSummary;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface NoticeService {
	
	public void saveNotice(String collectId, NoticeType type, String userId, String operId);
	
	public List<CollectSummary> getNoticeCollects(NoticeType type, String userId, PageInfo pageInfo);

}
