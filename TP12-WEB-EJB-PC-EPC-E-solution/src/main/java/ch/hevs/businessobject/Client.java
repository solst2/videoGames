package ch.hevs.businessobject;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Client extends Person{
	
	private String description;
	private int age;
	@OneToMany(mappedBy="client", cascade = CascadeType.ALL)
	private Set<Game> games;
	public Set<Game> getGames() {
		return games;
	}
	public void setGames(Set<Game> games) {
		this.games = games;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Client(String description, int age, String firstname, String lastname) {
		super(firstname, lastname);
		this.description = description;
		this.age = age;
	}
	public Client() {
		super();
	}
	
}
