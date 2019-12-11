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
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String cmd;
			while (true) {
				System.out
						.println("Write a query [or 'populate' or 'quit']: ");
				cmd = reader.readLine();

				if ("populate".equals(cmd)) {
					populate();
				} else if ("quit".equals(cmd)) {
					System.out.println("The End");
					break;
				} else {
					executeRequest(cmd);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void executeRequest(String cmd) {
		List result = null;
		EntityTransaction tx = null;
		try {

			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoGame");
			EntityManager em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			result = em.createQuery(cmd).getResultList();
			Iterator it = result.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
			tx.commit();

		} catch (Exception e) {
			System.err.println(e.getMessage());
			try {
				tx.rollback();
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (SecurityException e1) {
				e1.printStackTrace();
			} 
		}
	}

	public static void populate() {
		EntityTransaction tx = null;
		try {

			
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("videoGame");
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
			
			g1.addCategory(cat1);
			g1.addCategory(cat2);
			
			g1.addDeveloper(d1);
			g2.addDeveloper(d2);
			
			c1.addGame(g1);
			c2.addGame(g2);
			
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
