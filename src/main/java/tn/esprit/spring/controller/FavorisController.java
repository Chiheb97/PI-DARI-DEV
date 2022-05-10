package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.Favoris;
import tn.esprit.spring.services.FavorisService;

import java.util.List;

@RestController
@RequestMapping("/favoris")
public class FavorisController {

	@Autowired
	FavorisService favorisService;
	
	@PostMapping("/add/{ann_id}/{user_id}")
	public void saveFavoris(@RequestBody Favoris favoris, @PathVariable Long ann_id,@PathVariable Long user_id ) {
		favorisService.saveFavoris(favoris, ann_id, user_id);
		 
	}
	/*@PostMapping("/ajouter")
	public ResponseEntity<?> ajouterFavoris(@RequestBody Favoris favoris) {

		if (favorisService.ajouterFavoris(favoris)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}*/
	@DeleteMapping("/{favorisId}/delete")
	public ResponseEntity<?> retirerFavoris(@PathVariable Long favorisId) {

		if (favorisService.deleteFavorisById(favorisId)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}

/*	@GetMapping("/all")
	public ResponseEntity<?> fetchAnnonceList(@RequestParam(name ="userId") Long userId) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		userDetails.getId();

		return ResponseEntity.ok(favorisService.fetchFavorisList(1L));
	} */

	@GetMapping("/findAllByuser/{user_id}")
	public List<Favoris> fetchFavorisList(@PathVariable("user_id") Long user_id) {

		return favorisService.fetchFavorisList(user_id);
	}
	

	
	
}
