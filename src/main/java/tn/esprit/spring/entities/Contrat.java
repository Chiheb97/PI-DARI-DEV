package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Contrat implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id; 
	private String titre ;
	private String description;
	
	public String getTitre() {
		return titre;
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

	//relation
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="Contrat")
	private Set<User> User;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<User> getUser() {
		return User;
	}

	public void setUser(Set<User> user) {
		User = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Contrat(Long id, Set<tn.esprit.spring.entities.User> user) {
		super();
		this.id = id;
		User = user;
	}

	public Contrat() {
		super();
	}

}
