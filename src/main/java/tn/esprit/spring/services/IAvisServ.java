package tn.esprit.spring.services;

import tn.esprit.spring.entities.Avis;

public interface IAvisServ {
	public Avis ajouterAvisEtAffecterauAnnonce(Long idAnnonce,Avis avis,Long idUser,int note);
	public Avis updateAvis(Avis avis,Long iddavis);
	public void deleteEvis(Long idAvis);
	public Avis affichAvis(Long idAvis);
	public int nbravispourannonce(Long idAnnonce);
	public float moyenneavisparannonce(Long iddAnnonce);

}
