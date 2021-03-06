package ch.hevs.businessobject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	private String difficultyLevel;
	private int ageLimit;
	@ManyToOne (cascade = CascadeType.MERGE)
	@JoinColumn(nullable = false)
	private Developer developer;
	@ManyToOne
	private Category category;
	@ManyToOne (cascade = CascadeType.MERGE)
	private Client client;

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", difficultyLevel=" + difficultyLevel + ", ageLimit=" + ageLimit+"]";
	}
	
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
	@Override
    public boolean equals(Object obj) {
		if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Game gameB = (Game) obj;
        return id == gameB.getId();
	}
	@Override
    public int hashCode() 
    { 
        return (int)this.id; 
    } 
}
