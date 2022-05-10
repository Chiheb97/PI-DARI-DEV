package tn.esprit.spring.services;
import java.util.List;
import tn.esprit.spring.entities.Visite;

public interface VisiteService {
	
	Visite addVisite(Visite visite, Long id , Long annonce_id); 
	
	List<Visite> retrieveAllVisites();
	
	Visite updateVisite(Visite visite, Long id);

	// delete operation
	void deleteVisiteById(Long id);

	List<Visite> findvisiteByuser(Long id);

	List<Visite> findvisiteByannonce(Long id);

	

}
