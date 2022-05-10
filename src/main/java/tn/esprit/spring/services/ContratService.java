package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;

public interface ContratService {
	// save operation
		Contrat saveContrat(Contrat cont);

		// read operation
		List<Contrat> fetchContratList();

		// update operation
		Contrat updateContrat(Contrat cont, Long Id);

		// delete operation
		void deleteContratById(Long Id);

}
