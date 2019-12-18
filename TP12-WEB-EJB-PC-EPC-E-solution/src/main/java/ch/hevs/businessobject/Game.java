package ch.hevs.businessobject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	private String difficultyLevel;
	private int ageLimit;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Developer developer;
	@ManyToOne
	private Category category;
	@ManyToOne
	private Client client;
	
	
	public Developer getDeveloper() {
		return developer;
	}
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
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
	public String getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public int getAgeLimit() {
		return ageLimit;
	}
	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}
	public Game(String name, String difficultyLevel, int ageLimit) {
		this.name = name;
		this.difficultyLevel = difficultyLevel;
		this.ageLimit = ageLimit;
	}
	public Game() {
		
	}
}
