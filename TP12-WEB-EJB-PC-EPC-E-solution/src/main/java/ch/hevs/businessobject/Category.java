package ch.hevs.businessobject;

import java.io.Console;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	private String description;
	@OneToMany(mappedBy="category", cascade = CascadeType.REMOVE)
	private Set<Game> games;
	
	public Set<Game> getGames() {
		return games;
	}
	public void setGames(Set<Game> games) {
		this.games = games;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category(String name, String description) {
		this.name = name;
		this.description = description;
		this.games = new HashSet<Game>();
	}
	public Category() {
		this.games = new HashSet<Game>();
	}
	//helper Methode
	public void addGame(Game g) {
		games.add(g);
		g.setCategory(this);
	}
}
