package com.ding.favorites.service;


import com.ding.favorites.domain.Favorites;

public interface FavoritesService {
	
	public Favorites saveFavorites(Long userId, Long count, String name);

}
