package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.Avis;
import tn.esprit.spring.services.AvisServiceImpl;
import tn.esprit.spring.services.IAvisServ;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/avis")
public class AvisController {
	@Autowired 
	AvisServiceImpl avisServ;
	// Save operation
		@PostMapping("/add-avis/{idannonce}/{idUser}/{note}")
		public Avis saveAvis(@RequestBody Avis avis, @PathVariable("idannonce") Long idannonce,@PathVariable("idUser") Long idUser,@PathVariable("note") int note) {

			return avisServ.ajouterAvisEtAffecterauAnnonce(idannonce, avis,idUser,note);
		}
		// Update operation
		@PutMapping("/update-avis/{id}")
		public Avis updateAvis(@RequestBody Avis avis, @PathVariable("id") Long idavis) {

			return avisServ.updateAvis(avis, idavis);
		}
		@DeleteMapping("/delete-avis/{id}")
		public String deleteAvisById(@PathVariable("id") Long avisId) {

			avisServ.deleteEvis(avisId);
			return "Deleted Successfully";
		}
		@GetMapping("/avisbyid/{id}")
	    public Avis findAviseById(@PathVariable Long id) {
	        return avisServ.affichAvis(id);
	    }
		@GetMapping("/nbravisparannonce/{id}")
	    public int nbravisparannonce(@PathVariable Long id) {
	        return avisServ.nbravispourannonce(id);
	    }
		@GetMapping("/moyennenoteparannonce/{id}")
	    public double moyennenoteparAnnonce(@PathVariable Long id) {
	        return avisServ.moyenneavisparannonce(id);
	    }


}
