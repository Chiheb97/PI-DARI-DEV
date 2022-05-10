package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity

public class Avis implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private int note;
	@ManyToOne
	@JsonBackReference
	Annonce annonce;
	@ManyToOne
	
	User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Avis(Long id, int note, Annonce annonce, User user) {
		super();
		this.id = id;
		this.note = note;
		this.annonce = annonce;
		this.user = user;
	}
	public Avis() {
		super();
		// TODO Auto-generated constructor stub
	}


}
