package tn.esprit.spring.services;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.Favoris;

import java.util.List;

@Service
public interface FavorisService {

	// save operation
	Favoris saveFavoris(Favoris favoris ,Long id_anno , Long id_user);

	// read operation
	List<Favoris> fetchFavorisList(Long userId);

	// update operation
	Favoris updateFavoris(Favoris favoris, Long favorisId);

	// delete operation
	boolean deleteFavorisById(Long favorisId);
	
	Annonce findbyidd(Long annonce) ;
		
	
	
}