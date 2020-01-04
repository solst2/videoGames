package ch.hevs.businessobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String lastname;
	private String fristname;
	
	public Person() {
	}
	public Person(String lastname, String fristname) {
		this.lastname = lastname;
		this.fristname = fristname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFristname() {
		return fristname;
	}
	public void setFristname(String fristname) {
		this.fristname = fristname;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", lastname=" + lastname + ", fristname=" + fristname + "]";
	}
	

}
