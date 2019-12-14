package ch.hevs.service;

import java.util.List;

import javax.persistence.*;

import ch.hevs.businessobject.Game;


public class DeveloperBean implements Developer{
	@PersistenceContext(name = "videoGames")
	private EntityManager em;
	@Override
	public Developer getDeveloper(long idDeveloper) {
		Query query = em.createQuery("FROM Developer d Where d.id:=id");
		query.setParameter("id", idDeveloper);
		return (Developer) query.getSingleResult();
	}
	
	@Override
	public List<Game> getGameListFromDeveloperId(long idDeveloper) {
		Query query = em.createQuery("From Game g, IN(g.developers) d Where d.id:=id");
		query.setParameter("id", idDeveloper);
		return (List<Game>) query.getResultList();
	}

	@Override
	public List<Developer> getAllDevelopers() {
		return em.createQuery("FROM Developer").getResultList();
	}

	@Override
	public void insertUpdateDeveloper(Developer d) {
		em.persist(d);
	}
}
