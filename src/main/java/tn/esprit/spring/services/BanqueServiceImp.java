package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Banque;
import tn.esprit.spring.repository.BanqueRepository;
@Service
public class BanqueServiceImp implements BanqueService {

	@Autowired
	private BanqueRepository banqueDAO;
	//private static final Logger L= LogManager.getLogger(MeubleServiceImpl.class);

	@Override
	public List<Banque> retrieveAllBanque() {
		// TODO Auto-generated method stub
		List<Banque> banque= (List<Banque>) banqueDAO.findAll();
		return banque;
	}

	@Override
	public Banque addBanque(Banque b) {
		// TODO Auto-generated method stub
		return banqueDAO.save(b);
	}

	@Override
	public void deleteBanque(Long id_b) {
		// TODO Auto-generated method stub
		banqueDAO.deleteById((id_b));
	}

	@Override
	public Banque updateBanque(Banque b) {
		// TODO Auto-generated method stub
		return banqueDAO.save(b);
	}

	@Override
	public Banque retrieveBanque(Long id_b) {
		// TODO Auto-generated method stub
		return banqueDAO.findById(id_b).orElse(null);
	}

	
}
