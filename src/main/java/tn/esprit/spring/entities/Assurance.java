package tn.esprit.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Assurance {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long assuranceid;
	 private String name;
	 private String localisation ;
	 @ManyToMany(cascade = CascadeType.ALL)
	 private Set<User> user;
		
	 public long getAssuranceid() {
		return assuranceid;
	}
	public Assurance() {
		super();
	}
	public Assurance(long assuranceid, String name, String localisation) {
		super();
		this.assuranceid = assuranceid;
		this.name = name;
		this.localisation = localisation;
	}
	public void setAssuranceid(long assuranceid) {
		this.assuranceid = assuranceid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
	
	
}
