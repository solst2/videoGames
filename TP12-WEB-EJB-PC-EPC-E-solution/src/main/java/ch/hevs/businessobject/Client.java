package ch.hevs.businessobject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client extends Person{
	private String description;
	private int age;
	@OneToMany(mappedBy="client")
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
	public Client(String firstname, String lastname, String description, int age) {
		super(firstname, lastname);
		this.description = description;
		this.age = age;
		this.games = new HashSet<Game>();
	}
	public Client() {
		super();
	}
	//helper Methode
	public void addGame(Game g){
		games.add(g);
		g.setClient(this);
	}
	
	public void removeGame(Game g) {
		games.remove(g);
		g.setClient(null);
	}
	@Override
	public String toString() {
		return super.toString() + "Client [description=" + description + ", age=" + age + ", games=" + games + "]";
	}
	
}
