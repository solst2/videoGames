package ch.hevs.test;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//import org.junit.jupiter.api.Test;

import ch.hevs.businessobject.*;

class DbTest {/*

	@Test
	void test() {
		EntityTransaction tx = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoGames");
			EntityManager em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Client c1 = new Client("Sascha", "Burgener", "Ich bin ein Informatiker", 22);
			Client c2 = new Client("Solange", "Steiner", "Hier kommt eine Beschreibung", 22);
			
			Category cat1 = new Category("Kategorie1", "Hier kommt eine Beschreibung");
			Category cat2 = new Category("Kategorie2", "Hier kommt eine Beschreibung");

			Developer d1 = new Developer("Xavier", "Kalbermatten", "xavier.kalbermatten@students.hevs.ch");
			Developer d2 = new Developer("Patrick", "Garbely", "patrick.garbely@studentss.hevs.ch");
			
			Game g1 = new Game("Call of Duty Black Ops III", "heavy", 18);
			Game g2 = new Game("Super Marion", "easy", 6);
			
			
			d1.addGame(g1);
			d2.addGame(g2);
			
			cat1.addGame(g1);
			cat2.addGame(g2);
			
			c1.addGame(g1);
			c2.addGame(g2);
			
			em.persist(c1);
			em.persist(c2);
			
			em.persist(d1);
			em.persist(d2);
			
			em.persist(g1);
			em.persist(g2);
			
			em.persist(cat1);
			em.persist(cat2);
			
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

}