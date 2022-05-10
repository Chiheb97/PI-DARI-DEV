package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Credit;

public interface CreditService  {
	public void ajouterCredit(Credit C);
	public void capaciteClient(int client, Credit C);
	public Credit afficherCredit(Long id);
	public void supprimerCredit(Long id);
	public void modifiercredit(Long id, Long credit);
	public List<Credit> retrieveAllCredit();

}
