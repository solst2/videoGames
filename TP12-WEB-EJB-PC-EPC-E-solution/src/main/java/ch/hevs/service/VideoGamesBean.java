package ch.hevs.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ejb.Stateless;
import ch.hevs.businessobject.*;

@Stateless
public class VideoGamesBean implements VideoGames{
	@PersistenceContext(name = "videoGames")
	private EntityManager em;
	@Override
	public Client getClient(long idClient) {
		Query query = em.createQuery("FROM Client c Where c.id:=id");
		query.setParameter("id", idClient);
		return (Client) query.getSingleResult();
	}
	
	@Override
	public List<Game> getGamesFromClient(long idClient){
		Query query = em.createQuery("SELECT c.games FROM Client c Where c.id:=id");
		query.setParameter("id", idClient);
		return (List<Game>) query.getResultList();
	}

	@Override
	public List<Client> getAllClients() {
		return em.createQuery("FROM Client").getResultList();
	}

	@Override
	public Developer getDeveloper(long idDeveloper) {
		Query query = em.createQuery("FROM Developer d Where d.id:=id");
		query.setParameter("id", idDeveloper);
		return (Developer) query.getSingleResult();
	}

	@Override
	public List<Developer> getAllDevelopers() {
		return em.createQuery("FROM Developer").getResultList();
	}

	@Override
	public Category getCategory(long idCategory) {
		Query query = em.createQuery("FROM Category c Where c.id:=id");
		query.setParameter("id", idCategory);
		return (Category) query.getSingleResult();
	}

	@Override
	public List<Category> getAllCategories() {
		return em.createQuery("FROM Category").getResultList();
	}

	@Override
	public Game getGame(long idGame) {
		Query query = em.createQuery("FROM Game g Where g.id:=id");
		query.setParameter("id", idGame);
		return (Game) query.getSingleResult();
	}

	@Override
	public List<Game> getAllGames() {
		return em.createQuery("FROM Game").getResultList();
	}

	@Override
	public void rent(Client c, Game g) {
		c.addGame(g);
		em.persist(c);
	}

	@Override
	public void giveBack(Client c, Game g) {
		c.removeGame(g);
		em.persist(c);
	}

	@Override
	public void insertClient(Client c) {
		em.persist(c);
	}

	@Override
	public void updateClient(Client c) {
		em.merge(c);
	}

	@Override
	public void deleteClient(Client c) {
		for(Game g : c.getGames()) {
			g.setClient(null);
			em.persist(g);
		}
		em.remove(c);
	}

	@Override
	public void insertDeveloper(Developer d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDeveloper(Developer d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDeveloper(Object d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertCategory(Category c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Category c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertGame(Game g, Category c, Developer d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGame(Game g, Category c, Developer d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGame(Game g, Category c, Developer d) {
		// TODO Auto-generated method stub
		
	}
}
