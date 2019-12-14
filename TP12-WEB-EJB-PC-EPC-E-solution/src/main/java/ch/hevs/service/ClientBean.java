package ch.hevs.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.hevs.businessobject.Game;

public class ClientBean implements Client{
	@PersistenceContext(name = "videoGames")
	private EntityManager em;
	@Override
	public Client getClient(long idClient) {
		Query query = em.createQuery("FROM Client c Where c.id:=id");
		query.setParameter("id", idClient);
		return (Client) query.getSingleResult();
	}

	@Override
	public List<Client> getAllClients() {
		return em.createQuery("FROM Client").getResultList();
	}

	@Override
	public Game getGameFromClient(long idClient) {
		Query query = em.createQuery("From Game g Where g.client:=id");
		query.setParameter("id", idClient);
		return (Game) query.getSingleResult();
	}

	@Override
	public Boolean insertUpdateClient(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

}
