package ch.hevs.service;

import java.util.List;

import ch.hevs.businessobject.Game;

public interface Category {
	
	Category getCategory(long idCategory);
	
	List<Game> getGameListFromCategory(long idCategory);
	
	List<Category> getAllCategories();
	
	void insertUpdateCategory(Category cat);
	
}
