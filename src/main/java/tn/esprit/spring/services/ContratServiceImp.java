package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
@Service
public class ContratServiceImp implements ContratService {

	@Autowired 
	private ContratRepository  repo;

	@Override
	public Contrat saveContrat(Contrat cont) {
		this.repo.save(cont);
		
		
		return null;
	}

	@Override
	public List<Contrat> fetchContratList() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public Contrat updateContrat(Contrat cont, Long Id) {
		
		return null;
	}

	@Override
	public void deleteContratById(Long Id) {
		this.repo.deleteById(Id);
		
	}
	

}
