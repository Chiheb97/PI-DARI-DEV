package tn.esprit.spring.services;

import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.Etat;
import tn.esprit.spring.entities.Transaction;
import tn.esprit.spring.entities.TypeBien;

import java.util.List;

import org.springframework.stereotype.Service;

public interface AnnonceService {

	// save operation ok
	 Annonce saveAnnonce(Annonce annonce , Long id );

	// read operation ok
	List<Annonce> listAllAnnonces();

	// update operation ok
	Annonce updateAnnonce(Annonce annonce, Long annonceId);

	// delete operation ok
	void deleteAnnonceById(Long annonceId);
	
    // recherche operation ok
	List<Annonce> fetchAnnonceList(String keyword);

	//range prix
	List<Annonce> Range(Double max);

	//annonce similaire
	List<Annonce> suggsetion(int nbrchambre, int age, String localisation, Etat etat, TypeBien typedebien, Transaction transaction);
	
    //prix moyenne
	double Prixmoyenne(List<Annonce> result1);
	
    //prix moyenne
	String Avregeofprice(Annonce an);
	
    //nbr de vue ok
	int nombrevue(Long annonceId);

	//estimation de prix 
	Annonce estimationprix(Annonce an);

     //ok
	List<Annonce> findAllByuser(Long id);

	Annonce retrieveAnnonce(Long id);
      //getpremium (amine)
	

// file to annonce
	
	public void affecterFileToAnnonce(Long idFiles, Long idAnnonce);
	
	//affiche par type vente
	List<Annonce> fetchAnnonceListByTransaction(Transaction transaction);
	//affiche par type location
		List<Annonce> fetchAnnonceListByTransaction1(Transaction transaction);
	
	

}
