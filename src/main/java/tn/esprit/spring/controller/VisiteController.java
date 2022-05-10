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
import tn.esprit.spring.entities.Visite;
import tn.esprit.spring.services.VisiteService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/visite")
public class VisiteController {

@Autowired
VisiteService myVisiteService;

//Save operation
	@PostMapping("/addVisiste/{user_id}/{ann_id}")
	public Visite saveVisite(@RequestBody Visite visite ,@PathVariable("user_id") Long user_id ,@PathVariable("ann_id") Long ann_id) {

		return myVisiteService.addVisite(visite,user_id,ann_id );
	}

	// Read operation
	@GetMapping("/retreive-visites")
	public List<Visite> fetchVisiteList() {

		return myVisiteService.retrieveAllVisites() ;
	}

	// Update operation
	@PutMapping("/update-visite/{id}")
	public Visite updateVisite(@RequestBody Visite visite, @PathVariable("id") Long id) {

		return myVisiteService.updateVisite(visite, id);
	}

	// Delete operation
	@DeleteMapping("/delete-visites/{id}")
	public String deleteVisiteById(@PathVariable("id") Long id) {

		myVisiteService.deleteVisiteById(id);
		return "Deleted Successfully";
	}
	
	// Read operation
			@GetMapping("/findvisiteByuser/{id}")
			public List<Visite> findvisiteByuser(@PathVariable("id") Long id) {

				return myVisiteService.findvisiteByuser(id);
			}
			
			// Read operation
						@GetMapping("/findvisiteByannonce/{id}")
						public List<Visite> findvisiteByannonce(@PathVariable("id") Long id) {

							return myVisiteService.findvisiteByuser(id);
						}

}
