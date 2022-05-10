package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entities.Commentaire;

public interface ICommentaireServ {
	public Commentaire ajouterCommentaireEtAffecterauAnnonce(Long idAnnonce,Commentaire cmt,Long idUser);
	public Commentaire updateCommantaire(Commentaire cmt,Long idcmt);
	public void deleteCommantaire(Long idcmt);
	public Commentaire affichCommantaire(Long idcmt);
	public List<Commentaire> affichCommentaireByannoce(Long idannoce);

}
