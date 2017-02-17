package com.ding.favorites.service.impl;


import com.ding.favorites.dao.FavoritesMapper;
import com.ding.favorites.domain.Favorites;
import com.ding.favorites.service.FavoritesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FavoritesServiceImpl implements FavoritesService {

	public Logger logger = LoggerFactory.getLogger(FavoritesServiceImpl.class);
	
	@Autowired
	private FavoritesMapper favoritesMapper;
	
	/**
	 * 保存
	 * @param userId
	 * @param count
	 * @param name
	 * @return
	 */
	public Favorites saveFavorites(Long userId, Long count, String name){
		Favorites favorites = new Favorites();
		favorites.setName(name);
		favorites.setUserId(userId);
		favorites.setCount(count);
		favorites.setCreateTime(DateUtils.getCurrentTime());
		favorites.setLastModifyTime(DateUtils.getCurrentTime());
		favoritesRepository.save(favorites);
		return favorites;
	}

}
