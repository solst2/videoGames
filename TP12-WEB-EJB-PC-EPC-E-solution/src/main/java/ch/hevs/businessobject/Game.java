package ch.hevs.businessobject;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	private String difficultyLevel;
	private int ageLimit;
	/*@ManyToMany(cascade = CascadeType.ALL, mappedBy = "games")
	@JoinColumn(nullable = false)
	private Set<Developer> developers;
	@ManyToOne
	private Category category;
	@ManyToOne
	private Client client;*/
	
	
	/*public Set<Developer> getDevelopers() {
		return developers;
	}
	public void setDevelopers(Set<Developer> developers) {
		this.developers = developers;
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
	}*/
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
	
	//helper Mehtoden
	/*public void addDeveloper(Developer d) {
		developers.add(d);
		d.addGame(this);
	}
	
	public void addCategory(Category c) {
		category = c;
		c.addGame(this);
	}*/
}
