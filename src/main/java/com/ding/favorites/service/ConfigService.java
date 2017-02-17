package com.ding.favorites.service;


import com.ding.favorites.domain.undecitioned.Config;

public interface ConfigService {
	
	public Config saveConfig(Long userId, String favoritesId);

	public void updateConfig(Long id, String type, String defaultFavorites);
}
