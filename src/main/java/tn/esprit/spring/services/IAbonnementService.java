package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Abonnement;
import tn.esprit.spring.entities.User;

public interface IAbonnementService {
	List<Abonnement> retrieveAllAbonnement();

	Abonnement addAbonnement (Abonnement a);

	Abonnement updateAbonnement (Abonnement  a);

	Abonnement retrieveAbonnement (Long id);

	void removeAbonnement(Long id);
	List<User> retrieveAllUser();
	User retrieveUser (Long id);
}
