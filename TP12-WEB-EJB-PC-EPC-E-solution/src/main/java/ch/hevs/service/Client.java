package ch.hevs.service;

import java.util.List;

import ch.hevs.businessobject.Game;

public interface Client {
	Client getClient(long idClient);
	
	List<Client> getAllClients();
	
	Game getGameFromClient(long idClient);
	
	Boolean insertUpdateClient(Client c);
	
}
