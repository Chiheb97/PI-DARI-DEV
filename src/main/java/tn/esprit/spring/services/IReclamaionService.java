package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.User;

public interface IReclamaionService {
	List<Reclamation> retrieveAllReclamation();

	Reclamation addReclamation (Reclamation r);

	Reclamation updateReclamation (Reclamation  r);

	Reclamation retrieveReclamation (Long id);
	void removeReclamation(Long id);
	List<User> retrieveAllUser();
	User retrieveUser (Long id);
	List<Annonce> retrieveAllAnnonce();
	Annonce retrieveAnnonce(Long id);
	public Long number_reclams();
}
