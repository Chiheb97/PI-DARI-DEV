package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Credit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_credit;
	
	private float montant;
	
	private float salaire;
	
	private float montantfinal;
    private float TMM;
	
	private float apport_personnel;
	
	private String D_remboursement;
	private float monthly_return;
	
    @ManyToOne
	private Banque banque;
	

	@ManyToOne
	private User user;
   


	public float getMonthly_return() {
		return monthly_return;
	}


	public void setMonthly_return(float monthly_return) {
		this.monthly_return = monthly_return;
	}


	
	public float getMontantfinal() {
		return montantfinal;
	}


	public void setMontantfinal(float montantfinal) {
		this.montantfinal = montantfinal;
	}


	
	

	
	
	  public Long getId_credit() {
			return id_credit;
		}


		public void setId_credit(Long id_credit) {
			this.id_credit = id_credit;
		}


		public float getMontant() {
			return montant;
		}


		public void setMontant(float montant) {
			this.montant = montant;
		}


		public float getSalaire() {
			return salaire;
		}


		public void setSalaire(float salaire) {
			this.salaire = salaire;
		}


		public float getTMM() {
			return TMM;
		}


		public void setTMM(float tMM) {
			TMM = tMM;
		}


		public float getApport_personnel() {
			return apport_personnel;
		}


		public void setApport_personnel(float apport_personnel) {
			this.apport_personnel = apport_personnel;
		}


		public String getD_remboursement() {
			return D_remboursement;
		}


		public void setD_remboursement(String d_remboursement) {
			D_remboursement = d_remboursement;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}

		public Credit(Long id_credit, float montant, float salaire, float montantfinal, float tMM,
				float apport_personnel, String d_remboursement, float monthly_return, Banque banque, User user) {
			super();
			this.id_credit = id_credit;
			this.montant = montant;
			this.salaire = salaire;
			this.montantfinal = montantfinal;
			TMM = tMM;
			this.apport_personnel = apport_personnel;
			D_remboursement = d_remboursement;
			this.monthly_return = monthly_return;
			this.banque = banque;
			this.user = user;
		}


		public Banque getBanque() {
			return banque;
		}


		public void setBanque(Banque banque) {
			this.banque = banque;
		}


		public Credit() {
			super();
			// TODO Auto-generated constructor stub
		}


}
