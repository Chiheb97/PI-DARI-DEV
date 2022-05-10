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

import tn.esprit.spring.entities.Credit;
import tn.esprit.spring.services.CreditService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/credits")
public class CreditController {
	
	@Autowired 
	private CreditService credService;
	
	@PostMapping("/add-credit")
	public void saveCredit(@RequestBody Credit cred) {

		credService.ajouterCredit(cred);
	}
	@GetMapping("/retreive-credits")
	public List<Credit> GetCredits() {

		return credService.retrieveAllCredit();
	}
	
	// Update operation
		@PutMapping("/update-credit/{id}")
		public void updateDepartment(@RequestBody Long credit, @PathVariable("id") Long id) {

			credService.modifiercredit(id, credit);
		}
		// Delete operation
		@DeleteMapping("/delete-credit/{id}")
		public String deleteCreditById(@PathVariable("id") Long id) {

			credService.supprimerCredit(id);
			return "Deleted Successfully";
		}
  
	

}
