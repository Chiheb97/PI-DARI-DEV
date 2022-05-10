package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Abonnement;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.AbonnementServiceImpl;
@Controller
@RestController
@CrossOrigin
@RequestMapping(path = "/abonnement")
public class AbonnementController {
	    @Autowired
	    AbonnementServiceImpl service ;

	    @GetMapping("/getall")
	    public List<Abonnement> getAllAbonnement()   
	    {  
	      return service.retrieveAllAbonnement(); 
	    } 
	    
	    @DeleteMapping(path = "/delete/{id}")
		public void deleteAbonnement(@PathVariable Long id) {
	    	service.removeAbonnement(id);
		}
	    
	    @PostMapping("/abonnement_user/{id}")
	    public void Abonnement_user(@PathVariable Long id )   
	    {   
            User user= service.retrieveUser(id);
            Abonnement abon= service.retrieveAbonnement(id);
            user.setAbonnement(abon);
	    	service.Abonnement_user(user);
	    } 
	    
	    @PutMapping("/update")
	    public Abonnement updateAbonnement( @RequestBody Abonnement r)   
	    {  
	    	 return service.updateAbonnement(r) ; 
	    	 
	    } 
	    @PostMapping("/add")
	    public Abonnement addabonnement( @RequestBody Abonnement r)   
	    {  
	    	 return service.addAbonnement(r) ; 
	    	 
	    } 
	    
	    @GetMapping(path = "/getbyid/{id}")
		public Abonnement getAbonnement(@PathVariable Long id) {
	    	return service.retrieveAbonnement(id);	
		}    
	    
}
