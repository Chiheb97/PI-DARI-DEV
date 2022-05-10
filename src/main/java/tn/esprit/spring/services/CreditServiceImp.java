package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Banque;
import tn.esprit.spring.entities.Credit;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.BanqueRepository;
import tn.esprit.spring.repository.CreditRepository;
import tn.esprit.spring.repository.UserRepository;
@Service
public class CreditServiceImp implements CreditService {

	@Autowired
	BanqueRepository brep;
	
	@Autowired
	CreditRepository crep;
	
	
	@Autowired
	UserRepository urep;
	
	

	@Override
	public void ajouterCredit(Credit C) {
		
		
		double interet = 0.35;
		float somme=C.getMontant();	
		float sommefinal=(float) (somme*interet);	
		float monthly=sommefinal;
		C.setMontantfinal(sommefinal);
		C.setMonthly_return(monthly);	
		
		crep.save(C);	
	}
	
	@Override
	public void capaciteClient(int client, Credit C) {
		User cl=(User) urep.findById((long) client).get();
		float somme=C.getSalaire();
		float sommefinal=(float) (somme*0.4);	
		C.setApport_personnel(sommefinal);
		crep.save(C);	
	}
	

	@Override
	public Credit afficherCredit(Long id) {
		// TODO Auto-generated method stub
		return crep.findById(id).orElse(null);
	}

	@Override
	public void supprimerCredit(Long id) {
		// TODO Auto-generated method stub
		crep.deleteById(id);
		
	}



	
	

	@Override
	public List<Credit> retrieveAllCredit() {
		// TODO Auto-generated method stub
		List<Credit> credit= (List<Credit>) crep.findAll();
		return credit;
	}



	@Override
	public void modifiercredit(Long id, Long credit) {
		Credit C=crep.findById(credit).get();
		Banque B=brep.findById(id).get();
		int duree=B.getDuree();
		double interet=B.getInterestRate();
		float somme=C.getMontant();
		float sommefinal=(float) (somme+(somme*interet));	
		float monthly=sommefinal/(duree*12);
		C.setMontantfinal(sommefinal);
		C.setMonthly_return(monthly);	
		C.setBanque(B);
		crep.save(C);
}



	

}
