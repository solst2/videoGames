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
	
	//Methods fot the Clients
	@Override
	public Client getClient(long idClient) {
		Query query = em.createQuery("FROM Client c Where c.id:=id");
		query.setParameter("id", idClient);
		return (Client) query.getSingleResult();
	}
	
	@Override
	public List<Game> getGamesFromClient(long idClient){
		//2 Lösung evt. Query query = em.createQuery("FROM Game g, IN(g.client) c  Where c.id:=id");
		Query query = em.createQuery("SELECT g FROM Client c, IN(c.games) g Where c.id:=id");
		query.setParameter("id", idClient);
		return (List<Game>) query.getResultList();
	}

	@Override
	public List<Client> getAllClients() {
		return em.createQuery("FROM Client").getResultList();
	}

	//Methods fot the Developers
	@Override
	public Developer getDeveloper(long idDeveloper) {
		Query query = em.createQuery("FROM Developer d Where d.id:=id");
		query.setParameter("id", idDeveloper);
		return (Developer) query.getSingleResult();
	}
	
	@Override
	public Developer getDeveloperFromAGame(long idGame) {
		Query query = em.createQuery("SELECT d FROM Game g, IN(g.developer) d Where g.id:=id");
		query.setParameter("id", idGame);
		return (Developer) query.getSingleResult();
	}

	@Override
	public List<Developer> getAllDevelopers() {
		return em.createQuery("FROM Developer").getResultList();
	}

	//Methods fot the Categories
	@Override
	public Category getCategory(long idCategory) {
		Query query = em.createQuery("FROM Category c Where c.id:=id");
		query.setParameter("id", idCategory);
		return (Category) query.getSingleResult();
	}
	
	@Override
	public Category getCategoryFromAGame(long idGame) {
		Query query = em.createQuery("SELECT c FROM Game g, IN(g.category) c Where g.id:=id");
		query.setParameter("id", idGame);
		return (Category) query.getSingleResult();
	}

	@Override
	public List<Category> getAllCategories() {
		return em.createQuery("FROM Category").getResultList();
	}

	//Methods fot the Games
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

	//Methods to Rent a Game or give back the Game
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

	//Insert, Update, Delte Methods
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
		em.persist(d);
	}

	@Override
	public void updateDeveloper(Developer d) {
		em.merge(d);
	}

	@Override
	public void deleteDeveloper(Object d) {
		em.remove(d);
	}

	@Override
	public void insertCategory(Category c) {
		em.persist(c);
	}

	@Override
	public void update(Category c) {
		em.merge(c);
	}

	@Override
	public void delete(Category c) {
		em.remove(c);
	}

	@Override
	public void insertGame(Game g, Category c, Developer d) {
		em.persist(g);
		c.addGame(g);
		em.persist(c);
		d.addGame(g);
		em.persist(d);
	}

	@Override
	public void updateGame(Game g, Category c, Developer d) {
		c.addGame(g);
		d.addGame(g);
		em.merge(g);
		em.merge(c);
		em.merge(d);
	}

	@Override
	public void deleteGame(Game g) {
		em.remove(g);
		Category cat = g.getCategory();
		Developer dev = g.getDeveloper();
		cat.removeGame(g);
		dev.removeGame(g);
		em.merge(cat);
		em.merge(dev);
	}
}
