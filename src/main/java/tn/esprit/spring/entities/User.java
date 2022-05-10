package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.spring.entities.Role;
import lombok.*;
@Entity

@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails , Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	@Enumerated(EnumType.STRING)
    private Role role;
	
	private String email;
	private String password;
	private String num;
	private Boolean locked = false;
	private Boolean enabled = false;


	
	     
	@OneToMany(mappedBy="user")
	private Set<Annonce> annonce;

		@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
		private Set<Favoris> Favoris;

		// relation

		@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
		private Set<Reclamation> Reclamation;
		@ManyToMany(cascade = CascadeType.ALL)
		private Set<Contrat> Contrat;
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
		private Set<Credit> Credit;
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
		private Set<SouscriptionAssurance> SouscriptionAssurance;
		@OneToOne(cascade = CascadeType.ALL)
		private Visite visite ;
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
		private Set<Assurance> Assurance;
		@ManyToOne
		private Abonnement abonnement;
		
        @JsonIgnore
		@Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        SimpleGrantedAuthority authority =
	                new SimpleGrantedAuthority(role.name());
	        return Collections.singletonList(authority);
	    }
	    @Override
	    public String getPassword() {
	        return password;
	    }
		@Override
		public boolean isAccountNonExpired() {
			return true;
		}
		  @Override
		    public String getUsername() {
		        return email;
		    }
		  
		@Override
		public boolean isAccountNonLocked() {
			 return false;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}
		@Override
		public boolean isEnabled() {
			 return enabled;
		}
		
		  
		    public String getEmail() {
		        return email;
		    }
			public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
			public Role getRole() {
				return role;
			}
			public void setRole(Role role) {
				this.role = role;
			}
			public String getNum() {
				return num;
			}
			public void setNum(String num) {
				this.num = num;
			}
			public Boolean getLocked() {
				return locked;
			}
			public void setLocked(Boolean locked) {
				this.locked = locked;
			}
			public Boolean getEnabled() {
				return enabled;
			}
			public void setEnabled(Boolean enabled) {
				this.enabled = enabled;
			}
			
			public void setUsername(String username) {
				this.username = username;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			public User(Long id, String username, Role role, String email, String password, String num, Boolean locked,
					Boolean enabled) {
				super();
				this.id = id;
				this.username = username;
				this.role = role;
				this.email = email;
				this.password = password;
				this.num = num;
				this.locked = locked;
				this.enabled = enabled;
			}
			@JsonIgnore
			public Set<Annonce> getAnnonce() {
				return annonce;
			}
			public void setAnnonce(Set<Annonce> annonce) {
				this.annonce = annonce;
			}
            @JsonIgnore
			public Set<Favoris> getFavoris() {
				return Favoris;
			}
			public void setFavoris(Set<Favoris> favoris) {
				Favoris = favoris;
			}
			@JsonIgnore
			public Set<Reclamation> getReclamation() {
				return Reclamation;
			}
			public void setReclamation(Set<Reclamation> reclamation) {
				Reclamation = reclamation;
			}
			public Set<Contrat> getContrat() {
				return Contrat;
			}
			public void setContrat(Set<Contrat> contrat) {
				Contrat = contrat;
			}
			public Set<Credit> getCredit() {
				return Credit;
			}
			public void setCredit(Set<Credit> credit) {
				Credit = credit;
			}
			public Set<SouscriptionAssurance> getSouscriptionAssurance() {
				return SouscriptionAssurance;
			}
			public void setSouscriptionAssurance(Set<SouscriptionAssurance> souscriptionAssurance) {
				SouscriptionAssurance = souscriptionAssurance;
			}
			@JsonIgnore 
			public Visite getVisite() {
				return visite;
			}
			public void setVisite(Visite visite) {
				this.visite = visite;
			}
			public Set<Assurance> getAssurance() {
				return Assurance;
			}
			public void setAssurance(Set<Assurance> assurance) {
				Assurance = assurance;
			}

			public Abonnement getAbonnement() {
				return abonnement;
			}
			public void setAbonnement(Abonnement abonnement) {
				this.abonnement = abonnement;
			}
			
		
	
		
	
		
		
}
