package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.repository.ReclamationRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.utils.BadWordFilter;
@Service
public class ReclamationServiceImpl implements IReclamaionService {
    @Autowired
	ReclamationRepository reclam;
    @Autowired
	UserRepository user_repo;
    @Autowired
	AnnonceRepository annonce_repo;
    @Autowired
    public JavaMailSender emailSender;
	
	@Override
	public List<Reclamation> retrieveAllReclamation() {
	
		return reclam.findAll();
		}

	@Override
	public Reclamation addReclamation(Reclamation r) {
		reclam.save(r);
	   return r;
		}

	@Override
	public Reclamation updateReclamation(Reclamation r) {
		 reclam.save(r);
		 return r;
	}

	@Override
	public Reclamation retrieveReclamation(Long id) {
		return reclam.findById(id).orElse(null);
	}

	@Override
	public void removeReclamation(Long id) {
		Reclamation r = reclam.findById(id).orElse(null);
		reclam.delete(r);
	}


	@Override
	public List<User> retrieveAllUser() {
     return user_repo.findAll()	;
	}

	@Override
	public User retrieveUser(Long id) {
		return user_repo.findById(id).orElse(null);
	}

	@Override
	public List<Annonce> retrieveAllAnnonce() {
		  return annonce_repo.findAll()	;
	}

	@Override
	public Annonce retrieveAnnonce(Long id) {
		 return annonce_repo.findById(id).orElse(null);
	}
	
	//@Scheduled(cron = "*/10 * * * * *")
	public void scanbadword( ){
		List<Annonce> list = annonce_repo.findAll();
		List<User> userlist = this.retrieveAllUser();
		 List<Long> annonce_id = new ArrayList<Long>() ;
	        SimpleMailMessage message = new SimpleMailMessage(); 
		for (int i = 0; i < list.size(); i++) {
		String output = BadWordFilter.getCensoredText(list.get(i).getDescription());
		if(output.length()>2){

             annonce_id.add(list.get(i).getId());
			}
	}
		if (!annonce_id.isEmpty()){
		for (int j = 0; j < userlist.size(); j++){
			if (userlist.get(j).getRole()==Role.valueOf("Admin")){
		           message.setTo(userlist.get(j).getEmail());
		           message.setSubject("Annonce supprimeé");
			       message.setText("Les Annonce qui ont/a pour id "+annonce_id +" ont ete supprimés , ils contiennent des gros mots " );
			       this.emailSender.send(message);
			       }
		}
		for (int y = 0; y < annonce_id.size(); y++){
			annonce_repo.deleteById(annonce_id.get(y));
		}
	}}

	@Override
	public Long number_reclams() {
		
		return reclam.number_reclam();
	}


	}
