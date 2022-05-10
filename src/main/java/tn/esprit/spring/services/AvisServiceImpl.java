package tn.esprit.spring.services;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.Avis;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.repository.AvisRepository;
import tn.esprit.spring.repository.UserRepository;
@Service
public class AvisServiceImpl implements IAvisServ {

	@Autowired
	  private AnnonceRepository annonceRepo;
	@Autowired
	  private AvisRepository avisRepo;
	@Autowired
	  private UserRepository userRepo;
	
	////////ajouter avis et affecter au annonce
	@Override
	public Avis ajouterAvisEtAffecterauAnnonce(Long idAnnonce, Avis avis,Long idUser,int note) {
		Annonce a = annonceRepo.findById(idAnnonce).orElse(null);
		User u =userRepo.findById(idUser).orElse(null);
		avis.setAnnonce(a);
		  avis.setUser(u);
		  avis.setNote(note);
		return avisRepo.save(avis);
		
	}

	@Override
	public Avis updateAvis(Avis avis,Long iddavis) {
		Avis a = avisRepo.findById(iddavis).orElse(null);
		a.setNote(avis.getNote());
	
		return avisRepo.save(a);
	}

	@Override
	public void deleteEvis(Long idAvis) {
		avisRepo.deleteById(idAvis);
		
	}

	@Override
	public Avis affichAvis(Long idAvis) {
		// TODO Auto-generated method stub
		return avisRepo.findById(idAvis).orElse(null);
	}

	@Override
	public int nbravispourannonce(Long idAnnonce) {
		// TODO Auto-generated method stub
		return avisRepo.nbravisparannonce(idAnnonce);
	}

	@Override
	public float moyenneavisparannonce(Long iddAnnonce) {
		// TODO Auto-generated method stub
		
		Annonce a = annonceRepo.findById(iddAnnonce).orElse(null);
		float n=a.getAvis().size();
		if(n==0){
			return 0;
		}
		else {
		System.out.println(n);
		float s=0;
		for(Avis av : a.getAvis()) {
			s=s+av.getNote();
			
		}
		float m=s/n;
		BigDecimal bd = new BigDecimal(m);
		bd= bd.setScale(2,BigDecimal.ROUND_DOWN);
		m = (float) bd.doubleValue();
		return m;
	}}

}
