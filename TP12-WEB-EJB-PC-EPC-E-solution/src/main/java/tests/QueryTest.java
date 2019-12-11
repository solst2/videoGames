package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Client;
import ch.hevs.businessobject.Developer;
import ch.hevs.businessobject.Game;
import ch.hevs.businessobject.Person;

class QueryTest {

	@Test
	void test() {
		EntityTransaction tx = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
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
			
			
			g1.addDeveloper(d1);
			g2.addDeveloper(d2);
			
			cat1.addGame(g1);
			cat2.addGame(g2);
			
			c1.addGame(g1);
			c2.addGame(g2);
			
			em.persist(c1);
			em.persist(c2);
			
			em.persist(cat1);
			em.persist(cat2);
			
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
