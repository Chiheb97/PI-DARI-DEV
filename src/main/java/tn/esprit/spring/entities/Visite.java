package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Visite implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// relation
	@OneToOne
	private Annonce annonce;
	private  Date dateVisite;
	public String title;
	@OneToOne
	private User client;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	public Date getDateVisite() {
		return dateVisite;
	}
	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	public Visite(Long id, Annonce annonce, Date dateVisite, String title, User client) {
		super();
		this.id = id;
		this.annonce = annonce;
		this.dateVisite = dateVisite;
		this.title = title;
		this.client = client;
	}
	public Visite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
