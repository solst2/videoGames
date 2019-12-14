package ch.hevs.service;

import java.util.List;

import ch.hevs.businessobject.Game;

public interface Developer {
	Developer getDeveloper(long idDeveloper);
	
	List<Game> getGameListFromDeveloperId(long idDeveloper);
	
	List<Developer> getAllDevelopers();
	
	void insertUpdateDeveloper(Developer d);
	
}
