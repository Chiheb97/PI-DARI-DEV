package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.ContratService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Contrats")
public class ContratController {
@Autowired
private ContratService myService;

public JavaMailSender emailSender;

@ResponseBody
@RequestMapping("/sendSimpleEmail")
public String sendSimpleEmail(String email) {

    // Create a Simple MailMessage.
    SimpleMailMessage message = new SimpleMailMessage();
    
    message.setTo(email);
    message.setSubject("signature de Contrat ");
    message.setText("");

    // Send Message!
    this.emailSender.send(message);

    return "Email Sent!";
}
@PostMapping("/add-Contrat")
public void saveContrat(@RequestBody Contrat cont) {

	myService.saveContrat(cont);
	
}
@GetMapping("/retreive-Contrats")
public List<Contrat> GetContrats() {

	return myService.fetchContratList();
}

// Update operation
	@PutMapping("/update-Contrat/{id}")
	public void updateDepartment(@RequestBody Contrat cont, @PathVariable("id") Long id) {

		myService.updateContrat(cont, id);
	}
	// Delete operation
	@DeleteMapping("/delete-Contrat/{id}")
	public String deleteContratById(@PathVariable("id") Long id) {

		myService.deleteContratById(id);
		return "Deleted Successfully";
	}


	
}
