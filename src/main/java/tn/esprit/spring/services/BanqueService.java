package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Banque;

public interface BanqueService {
	
	List<Banque> retrieveAllBanque();
	Banque addBanque(Banque b);
	void deleteBanque(Long id);
	Banque updateBanque(Banque b);
	Banque retrieveBanque(Long id_b);
    

}
