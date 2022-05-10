package tn.esprit.spring.entities;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Favoris implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	public Favoris() {
		super();
	}


	public Favoris(User user, Annonce annonce) {
		super();
		this.user = user;
		this.annonce = annonce;
	}



    @Override
	public String toString() {
		return "Favoris [user : " + user.toString() + ", annonce : " + annonce.toString() + "]";
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	@JsonIgnore
	public User getUser() {
		return user;
	}
	
	
	public void setUser(User user) {
		this.user = user;
	}

	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}


	//Relation
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "annonce_id")
	private Annonce annonce;


}
