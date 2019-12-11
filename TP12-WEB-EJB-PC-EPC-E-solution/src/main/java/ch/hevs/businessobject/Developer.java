package ch.hevs.businessobject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Developer extends Person{
	
	private String mail;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Game> games;
	
	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Developer(String firstname, String lastname, String mail) {
		super(firstname, lastname);
		this.mail = mail;
		this.games = new HashSet<Game>();
	}
	public Developer() {
	}
	//helper Methode
	public void addGame(Game g) {
		games.add(g);
	}
}
