package ch.hevs.service;

import java.util.List;

import ch.hevs.businessobject.*;

public interface VideoGames {
	//Methods for the Clients
	Client getClient(long idClient);
	
	List<Game> getGamesFromClient(long idClient);
	
	List<Client> getAllClients();
	
	//Methods for the Developers
	Developer getDeveloper(long idDeveloper);
	
	List<Developer> getAllDevelopers();
	
	//Methods for the Categories
	Category getCategory(long idCategory);
	
	List<Category> getAllCategories();
	
	//Mehtods for the Games
	Game getGame(long idGame);
	
	List<Game> getAllGames();
	
	//Methods for the Update, Insert and Delete
	void insert(Object o);
	
	void update(Object o);
	
	void delete(Object o);
	
	//Methods fot the Rental
	void rent(Client c, Game g);
	
	void giveBack(Client c, Game g);
}
