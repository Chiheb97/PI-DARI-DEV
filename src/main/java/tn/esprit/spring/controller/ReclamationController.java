package tn.esprit.spring.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IReclamaionService;
import tn.esprit.spring.services.ReclamationServiceImpl;


@Controller
@RestController
@CrossOrigin
@RequestMapping(path = "/reclamation")
public class ReclamationController {
    @Autowired
	ReclamationServiceImpl service;
   
    @GetMapping("/getall")
    public List<Reclamation> getAllReclamation()   
    {  
      	return  service.retrieveAllReclamation(); 
    } 
    
    @DeleteMapping(path = "/delete/{id}")
	public void deletereclamation(@PathVariable Long id) {
    	service.removeReclamation(id);
	}
    
    @PostMapping("/add/{id}/{iduser}")
    public Reclamation AddReclamationAnnonce(@RequestBody Reclamation r, @PathVariable Long id,@PathVariable Long iduser)   
    {   ;
    	Annonce a = service.retrieveAnnonce(id);
    	r.setAnnonce(a);
        User user= service.retrieveUser(iduser);
        r.setUser(user);
        return service.addReclamation(r); 
    	
    } 
    @PostMapping("/add/{id}")
    public Reclamation AddReclamationuser(@RequestBody Reclamation r, @PathVariable Long id)   
    {   
        User user= service.retrieveUser(id);
        r.setUser(user);
        return service.addReclamation(r); 
    	
    } 
    
    @PostMapping("/update")
    public Reclamation updateReclamation( @RequestBody Reclamation r)   
    {  
    	 return service.updateReclamation(r) ; 
    	 
    } 
    
    @GetMapping(path = "/getbyid/{id}")
	public Reclamation getReclamation(@PathVariable Long id) {
    	return service.retrieveReclamation(id);
    	
	}  
    
    //user 
    @GetMapping("/getallusername")
    public List<User> getAllUser()   
    {  
      return service.retrieveAllUser(); 
    } 
    
    @GetMapping(path = "/getuserbyid/{id}")
   	public User getReservation(@PathVariable Long id) {
       	return service.retrieveUser(id);
       	
   	}  
    //Annonce 
    @GetMapping("/getallannonce")
    public List<Annonce> getAllannonce()   
    {  
      return service.retrieveAllAnnonce(); 
    } 
    @GetMapping("/number_reclam")
    public Long getNumberReclamation()   
    {  
      	return  service.number_reclams(); 
    } 
  
}
