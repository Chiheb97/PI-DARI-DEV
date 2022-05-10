package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.Commentaire;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.repository.AvisRepository;
import tn.esprit.spring.repository.CommentaireRepository;
import tn.esprit.spring.repository.UserRepository;



@Service
public class CommentaireSErviceImpl implements ICommentaireServ {

	@Autowired
	  private AnnonceRepository annonceRepo;
	@Autowired
	  private CommentaireRepository cmtRepo;
	@Autowired
	  private UserRepository userRepo;
	@Override
	public Commentaire ajouterCommentaireEtAffecterauAnnonce(Long idAnnonce, Commentaire cmt,Long idUser) {
		Annonce a = annonceRepo.findById(idAnnonce).orElse(null); 
		User u =userRepo.findById(idUser).orElse(null);
		cmt.setAnnonce(a);
		cmt.setUser(u);
		return cmtRepo.save(cmt);
	}

	@Override
	public Commentaire updateCommantaire(Commentaire cmt, Long idcmt) {
		Commentaire c =cmtRepo.findById(idcmt).orElse(null);
		c.setCommentaire(cmt.getCommentaire());
		return cmtRepo.save(c);
	}

	@Override
	public void deleteCommantaire(Long idcmt) {
		// TODO Auto-generated method stub
		cmtRepo.deleteById(idcmt);
	}

	@Override
	public Commentaire affichCommantaire(Long idcmt) {
		// TODO Auto-generated method stub
		return cmtRepo.findById(idcmt).orElse(null);
	}

	@Override
	public List<Commentaire> affichCommentaireByannoce(Long idannoce) {
		// TODO Auto-generated method stub
		Annonce a =annonceRepo.findById(idannoce).orElse(null);
		return a.getCommaentaire();
	}

	

}
