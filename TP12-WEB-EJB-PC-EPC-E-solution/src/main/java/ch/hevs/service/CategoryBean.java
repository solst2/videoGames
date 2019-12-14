package ch.hevs.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.hevs.businessobject.Game;

public class CategoryBean implements Category{
	@PersistenceContext(name = "videoGames")
	private EntityManager em;
	@Override
	public Category getCategory(long idCategory) {
		Query query = em.createQuery("FROM Category c Where c.id:=id");
		query.setParameter("id", idCategory);
		return (Category) query.getSingleResult();
	}

	@Override
	public List<Game> getGameListFromCategory(long idCategory) {
		Query query = em.createQuery("From Game g Where g.category:=id");
		query.setParameter("id", idCategory);
		return (List<Game>) query.getResultList();
	}

	@Override
	public List<Category> getAllCategories() {
		return em.createQuery("FROM Category").getResultList();
	}

	@Override
	public void insertUpdateCategory(Category cat) {
		em.persist(cat);
	}

}
