package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Reclamation implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id; 
	private String titre;
	private String description;
	@ManyToOne
	private User user;
	private int reclam_user;	
	@ManyToOne
	private Annonce annonce; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public Reclamation() {
		super();
	}
	public Reclamation(Long id, String titre, String description, User user, int reclam_user, Annonce annonce) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.user = user;
		this.reclam_user = reclam_user;
		this.annonce = annonce;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getReclam_user() {
		return reclam_user;
	}
	public void setReclam_user(int reclam_user) {
		this.reclam_user = reclam_user;
	}
	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	



    

	

}
