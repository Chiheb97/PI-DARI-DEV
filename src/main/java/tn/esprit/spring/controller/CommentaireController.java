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

import tn.esprit.spring.entities.Avis;
import tn.esprit.spring.entities.Commentaire;
import tn.esprit.spring.services.AvisServiceImpl;
import tn.esprit.spring.services.CommentaireSErviceImpl;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/commentaire")
public class CommentaireController {
	@Autowired 
	CommentaireSErviceImpl cmtserv;
	
	@PostMapping("/add-commentaire/{idannonce}/{idUser}")
	public Commentaire savecommentaire(@RequestBody Commentaire cmt, @PathVariable("idannonce") Long idannonce,@PathVariable("idUser") Long idUser) {

		return cmtserv.ajouterCommentaireEtAffecterauAnnonce(idannonce, cmt,idUser);
	}
	// Update operation
			@PutMapping("/update-commentaire/{id}")
			public Commentaire updateAvis(@RequestBody Commentaire cmt, @PathVariable("id") Long idcmt) {

				return cmtserv.updateCommantaire(cmt, idcmt);
			}
			@DeleteMapping("/delete-commentaire/{id}")
			public String deletecommentaireById(@PathVariable("id") Long cmtId) {

				cmtserv.deleteCommantaire(cmtId);
				return "Deleted Successfully";
			}
			@GetMapping("/commentairebyid/{id}")
		    public Commentaire findcommentaireById(@PathVariable Long id) {
		        return cmtserv.affichCommantaire(id);
		    }
			@GetMapping("/listcommentairebyannoce/{id}")
		    public List<Commentaire> commentairebyannoce(@PathVariable Long id) {
		        return cmtserv.affichCommentaireByannoce(id);
		    }

}
