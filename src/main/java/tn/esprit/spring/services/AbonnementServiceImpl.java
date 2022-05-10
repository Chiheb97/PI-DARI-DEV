package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Abonnement;
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.AbonnementRepository;
import tn.esprit.spring.repository.UserRepository;
@Service
public class AbonnementServiceImpl implements IAbonnementService  {
	 @Autowired
	 AbonnementRepository ab;
	    @Autowired
		UserRepository user_repo;
	 
	@Override
	public List<Abonnement> retrieveAllAbonnement() {
		return ab.findAll();
	}

	@Override
	public Abonnement addAbonnement(Abonnement a) {
		   ab.save(a);
		   return a;
	}

	@Override
	public Abonnement updateAbonnement(Abonnement a) {
		ab.save(a);
		 return a;
	}

	@Override
	public Abonnement retrieveAbonnement(Long id) {
		return ab.findById(id).orElse(null);

	}

	@Override
	public void removeAbonnement(Long id) {
		Abonnement abo = ab.findById(id).orElse(null);
		ab.delete(abo);
		
	}

	@Override
	public List<User> retrieveAllUser() {
     return user_repo.findAll()	;
	}

	@Override
	public User retrieveUser(Long id) {
		return user_repo.findById(id).orElse(null);
	}
	
	public void Abonnement_user(User a) {
		user_repo.save(a);
		  
	}


}
