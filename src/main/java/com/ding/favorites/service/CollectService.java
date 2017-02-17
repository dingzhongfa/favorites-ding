package com.ding.favorites.service;

import com.ding.favorites.domain.Collection;
import com.ding.favorites.domain.view.CollectSummary;
import com.github.pagehelper.PageInfo;


import java.util.List;
import java.util.Map;

public interface CollectService {
	
	public List<CollectSummary> getCollects(String type, Long userId, PageInfo pageInfo, Long favoritesId, Long specUserId);
	
	public void saveCollect(Collection collect);
	
	public void updateCollect(Collection newCollect);
	
	public boolean checkCollect(Collection collect);
	
	public void importHtml(Map<String, String> map, Long favoritesId, Long userId, String type);
	
	public StringBuilder exportToHtml(Long favoritesId);
	
	public List<CollectSummary> searchMy(Long userId, String key, PageInfo pageInfo);
	
	public List<CollectSummary> searchOther(Long userId, String key, PageInfo pageInfo);
	
	public void otherCollect(Collection collect);
	
	public void like(Long userId, long id);

}
