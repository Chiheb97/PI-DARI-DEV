package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Banque implements Serializable{
	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
   
	private long id_banque;
	private String nombanque;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "banque")
	private Set<Credit> credit;
	
	private int duree;
	private double InterestRate;
	public double getInterestRate() {
		return InterestRate;
	}
	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public long getId_banque() {
		return id_banque;
	}
	public void setId_banque(long id_banque) {
		this.id_banque = id_banque;
	}
	public String getNombanque() {
		return nombanque;
	}
	public void setNombanque(String nombanque) {
		this.nombanque = nombanque;
	}
	
	

	public Banque() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<Credit> getCredit() {
		return credit;
	}
	public void setCredit(Set<Credit> credit) {
		this.credit = credit;
	}
	public Banque(long id_banque, String nombanque, Set<Credit> credit, int duree, double interestRate) {
		super();
		this.id_banque = id_banque;
		this.nombanque = nombanque;
		this.credit = credit;
		this.duree = duree;
		InterestRate = interestRate;
	}

	
}
