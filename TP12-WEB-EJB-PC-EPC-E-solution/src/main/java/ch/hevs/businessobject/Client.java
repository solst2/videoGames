package ch.hevs.businessobject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client extends Person{
	private String description;
	private int yearOfBirth;
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
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public Client(String firstname, String lastname, String description, int yearOfBirth) {
		super(firstname, lastname);
		this.description = description;
		this.yearOfBirth = yearOfBirth;
		this.games = new HashSet<Game>();
	}
	public Client() {
		super();
	}
	//helper Methode
	public void addGame(Game g){
		games.add(g);
	}
	
	public void removeGame(Game g) {
		System.out.println("##removeGame###");
		/*System.out.println("##BEFORE###" + games.size());
		games.remove(g);
		System.out.println("##AFTER###" + games.size());
		g.setClient(null);
		System.out.println("##CLIENT###" + g.getClient());*/
	}
	@Override
	public String toString() {
		return super.toString() + "Client [description=" + description + ", year of birth=" + yearOfBirth;
	}
	
}
