package ch.hevs.service;

import java.util.List;

import ch.hevs.businessobject.*;

public interface VideoGames {
	//Methods for the Clients
	Client getClient(long idClient);
	
	List<Game> getGamesFromClient(long idClient);
	
	List<Client> getAllClients();
	
	boolean isAdmin();
	
	void insertClient(Client c);
	
	void updateClient(Client c);
	
	void deleteClient(Client c);
	
	//Methods for the Developers
	Developer getDeveloper(long idDeveloper);
	
	Developer getDeveloperFromAGame(long idGame);
	
	List<Developer> getAllDevelopers();
	
	void insertDeveloper(Developer d);
	
	void updateDeveloper(Developer d);
	
	void deleteDeveloper(Developer d);
	
	//Methods for the Categories
	Category getCategory(long idCategory);
	
	Category getCategoryFromAGame(long idGame);
	
	List<Category> getAllCategories();
	
	void insertCategory(Category c);
	
	void updateCategory(Category c);
	
	void deleteCategory(Category c);
	
	//Mehtods for the Games
	Game getGame(long idGame);
	
	List<Game> getAllGames();
	
	void insertGame(Game g, Category c, Developer d);
	
	void updateGame(Game g, Category c, Developer d);
	
	void deleteGame(Game g);
	
	//Methods fot the Rental
	void rent(Client c, Game g);
	
	public void giveBack(Client c, Game g);
}
