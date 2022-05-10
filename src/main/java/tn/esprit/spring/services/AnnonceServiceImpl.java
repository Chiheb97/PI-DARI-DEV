package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.Etat;
import tn.esprit.spring.entities.Favoris;
import tn.esprit.spring.entities.FileDB;
import tn.esprit.spring.entities.Transaction;
import tn.esprit.spring.entities.TypeBien;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.repository.FavorisRepository;
import tn.esprit.spring.repository.FileDBRepository;
import tn.esprit.spring.repository.UserRepository;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

@Service
public class AnnonceServiceImpl implements AnnonceService  {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	FileDBRepository filedbrepo;
	
	@Autowired
    private JavaMailSender emailSender;
	
	@Autowired
    private AnnonceRepository annonceRepository;
	@Autowired
    private FavorisRepository fav;
	@Autowired
	private UserRepository userRepo;
  
    // save operation
    @Override
    public Annonce saveAnnonce(Annonce annonce ,Long id) {
    	annonce.setUser(this.userRepo.findById(id).orElse(null));
        return annonceRepository.save(annonce);
    }
  
    // read operation
    @Override
    public List<Annonce> listAllAnnonces () {
        return (List<Annonce>) annonceRepository.findAll();
    }
  
    // update operation
   
    @Override
    public Annonce updateAnnonce(Annonce annonce, Long annonceId) {
      Annonce annonceDB = annonceRepository.findById(annonceId).orElse(null);
		List<Favoris> list = fav.findAll();

      boolean priceChanged = false;
      if (annonce.getPrix() != annonceDB.getPrix()) {
          annonceDB.setPrix(annonce.getPrix());
          for (int i = 0; i < list.size(); i++){
  	         if(list.get(i).getAnnonce()==annonceDB){
              SimpleMailMessage message = new SimpleMailMessage();
              message.setFrom("contact.daria2022@gmail.com");
              message.setTo(list.get(i).getUser().getEmail());
              message.setSubject("Price Changed");
              String text = "le prix de l'annonce " + annonceDB.getTitre() + " est changé à" + annonce.getPrix() ;
              message.setText(text);
              emailSender.send(message);
  	         }}
      }
	    annonceDB.setTitre(annonce.getTitre());
	    annonceDB.setPrix(annonce.getPrix());
	    annonceDB.setDescription(annonce.getDescription());
	    annonceDB.setTransaction(annonce.getTransaction());
	    annonceDB.setEtat(annonce.getEtat());
	    annonceDB.setTypedebien(annonce.getTypedebien());
	    annonceDB.setAge(annonce.getAge());
	    annonceDB.setEtage(annonce.getEtage());
	    annonceDB.setLocalisation(annonce.getLocalisation());
	    annonceDB.setNbrchambre(annonce.getNbrchambre());
	    annonceDB.setSuperficie(annonce.getSuperficie());
	    
	  
	    
	
  
	    
	    
        return annonceRepository.save(annonceDB);
	}
    
    
    
  
    // delete operation
    @Override
    public void deleteAnnonceById(Long annonceId) {
        annonceRepository.deleteById(annonceId);
    }
 
    // affiche selon critére 
    @Override
    public List<Annonce> fetchAnnonceList(String keyword ){
    if (keyword != null) { 
          return annonceRepository.findAllByWord(keyword);
    }
	return this.listAllAnnonces() ;
    }

	

	

	@Override
	public List<Annonce> Range(Double max) {
		return annonceRepository.Range(max);
	}
	
	
	public List<Annonce> suggsetion(int nbrchambre, int age, String localisation, Etat etat,
			TypeBien typedebien, Transaction transaction) 
	{
		List<Annonce> annonces = annonceRepository.findAll();
		
		List<Annonce> annoncessuggsetion = new ArrayList<>();
		
		for(Annonce an : annonces)
		{
			if (an.getNbrchambre() == nbrchambre)
			{
				if (an.getAge() == age)
				{
					if (an.getLocalisation() == localisation)
					{
						if (an.getEtat() == etat)
						{
							if (an.getTypedebien() == typedebien)
							{
								if (an.getTransaction() == transaction)
								{
									annoncessuggsetion.add(an) ;
								}
							}
							
						}
					}
				}
		     }
		}
		return annoncessuggsetion ;
	}

	@Override
	public double Prixmoyenne(List<Annonce> result) {
		return annonceRepository.Prixmoyenne(result);	}

	@Override
	public String Avregeofprice(Annonce an) {
		List<Annonce> result1 = this.suggsetion(
				an.getNbrchambre() ,an.getAge(),
				an.getLocalisation(), an.getEtat(),
				an.getTypedebien(), an.getTransaction());
		
		double result2 = annonceRepository.Prixmoyenne(result1);
		
		if (an.getPrix()> result2 )
		{		return "Prix élevé";
        }
		if (an.getPrix()< result2 )
		{		return "Bonne Affaire";
        }
		if (an.getPrix() == 0 )
		{		return "Hors marché";
        }
		else 
		{
			return " Offre équitable";

		}
    }

	@Override
	public int nombrevue(Long annonceId)
	{
	 Annonce annonce = annonceRepository.findById(annonceId).orElse(null);
	 int nbr = annonce.getNbrvue() + 1 ;
	 annonce.setNbrvue(nbr);
     annonceRepository.save(annonce);

	 return (annonce.getNbrvue());
	 
	}
	
	@Override
	public Annonce estimationprix(Annonce an)
	{   List<Annonce> result1 = this.suggsetion(
			an.getNbrchambre(),an.getAge(),
			an.getLocalisation(), an.getEtat(),
			an.getTypedebien(), an.getTransaction());
	
	    double result2 = annonceRepository.Prixmoyenne(result1);
	    
	    an.setPrix(result2);
	    
		return annonceRepository.save(an);
	 
	}
	
	@Override
	public List<Annonce> findAllByuser(Long id)
    {
	return (List<Annonce>) annonceRepository.findAllByuser(id);

    }
	
	
	@Override
	public void affecterFileToAnnonce(Long idFiles, Long idTrip) {
		Annonce t=annonceRepository.findById(idTrip).orElse(null);
		
			FileDB f=filedbrepo.findById(idFiles).orElse(null);
			t.setFiles(f);
			annonceRepository.save(t);
		
		
	}

	@Override
	public List<Annonce> fetchAnnonceListByTransaction(Transaction transaction) {
		return annonceRepository.findAllByTransaction(transaction);
	}

	@Override
	public List<Annonce> fetchAnnonceListByTransaction1(Transaction transaction) {
		return annonceRepository.findAllByTransaction(transaction);
	}

	@Override
	public Annonce retrieveAnnonce(Long id) {
		return annonceRepository.findById(id).get();
	}
	

	
	
}
	