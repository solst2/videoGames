package ch.hevs.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.ejb.Stateless;
import ch.hevs.businessobject.*;

@Stateless
public class VideoGamesBean implements VideoGames{
	
	@PersistenceContext(name = "videoGames")
	private EntityManager em;

	@Resource 
	private SessionContext ctx;
	
	@Override
	public boolean isAdmin() {
		return ctx.isCallerInRole("Admin");
	}
	
	//Methods fot the Clients
	@Override
	public Client getClient(long idClient) {
		Query query = em.createQuery("FROM Client c where c.id=:id");
		query.setParameter("id", idClient);
		Client test = (Client)query.getSingleResult();
		System.out.println("#getClient" + test.toString());
		return (Client) query.getSingleResult();
	}
	
	@Override
	public List<Game> getGamesFromClient(long idClient){
		List<Game> games = (List<Game>) em.createQuery("SELECT c.games FROM Client c where c.id=:id").setParameter("id", idClient).getResultList();
		System.out.println("#" + idClient);
		for(Game g1: games) {
			System.out.println("#" + g1.getName());
		}
		return games;
	}

	@Override
	public List<Client> getAllClients() {
		return em.createQuery("From Client").getResultList();
	}

	//Methods fot the Developers
	@Override
	public Developer getDeveloper(long idDeveloper) {
		Query query = em.createQuery("FROM Developer d where d.id=:id");
		query.setParameter("id", idDeveloper);
		return (Developer) query.getSingleResult();
	}
	
	@Override
	public Developer getDeveloperFromAGame(long idGame) {
		Query query = em.createQuery("SELECT d FROM Game g, IN(g.developer) d where g.id=:id");
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
		Query query = em.createQuery("FROM Category c where c.id=:id");
		query.setParameter("id", idCategory);
		return (Category) query.getSingleResult();
	}
	
	@Override
	public Category getCategoryFromAGame(long idGame) {
		Query query = em.createQuery("SELECT c FROM Game g, IN(g.category) c Where g.id=:id");
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
		Query query = em.createQuery("FROM Game g where g.id=:id");
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
		Game game = em.merge(g);
		game.setClient(c);
		em.persist(game);
	}

	@Override
	public void giveBack(Client c, Game g) {
		System.out.println("##giveBack###" + c.getLastname() + " " + g.getName());
		Game game = em.merge(g);
		game.setClient(null);
		em.persist(game);
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
		Client client = em.merge(c);
		em.remove(client);
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
	public void deleteDeveloper(Developer d) {
		Developer dev = em.merge(d);
		em.remove(dev);
	}

	@Override
	public void insertCategory(Category c) {
		em.persist(c);
	}

	@Override
	public void updateCategory(Category c) {
		em.merge(c);
	}

	@Override
	public void deleteCategory(Category c) {
		Category cat = em.merge(c);
		em.remove(cat);
	}

	@Override
	public void insertGame(Game g, Category c, Developer d) {
		g.setCategory(c);
		g.setDeveloper(d);
		em.persist(g);
	}

	@Override
	public void updateGame(Game g, Category c, Developer d) {
		g.setCategory(c);
		g.setDeveloper(d);
		em.merge(g);
	}

	@Override
	public void deleteGame(Game g) {
		Game deleteGame = em.merge(g);
		em.remove(deleteGame);
	}
}
