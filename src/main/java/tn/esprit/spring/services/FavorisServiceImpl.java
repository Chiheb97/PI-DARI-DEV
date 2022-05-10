/*package tn.esprit.spring.services;

public class FavorisServiceImpl {

}
*/

package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.Favoris;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.repository.FavorisRepository;
import tn.esprit.spring.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class FavorisServiceImpl implements FavorisService  {
	
	@Autowired
    private FavorisRepository favorisRepository;
	
	@Autowired
	private AnnonceRepository annonceRepository;
	@Autowired
	private UserRepository userRepository;
	
    // save operation

  
    // read operation
    @Override
    public List<Favoris> fetchFavorisList(Long userId) {
		return favorisRepository.findAllByUser_Id(userId);
    }
  
    
    // delete operation
    @Override
    public boolean deleteFavorisById(Long favorisId) {
		Optional<Favoris> optionalFavoris = favorisRepository.findById(favorisId);
		if (optionalFavoris.isPresent()) {
			favorisRepository.deleteById(favorisId);
			return true;
		}
		return false;
    }
    //update operation
	@Override
	public Favoris updateFavoris(Favoris favoris, Long favorisId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Favoris saveFavoris(Favoris favoris, Long id_anno, Long id_user) {
		favoris.setAnnonce(annonceRepository.findById(id_anno).orElse(null));
		favoris.setUser(userRepository.findById(id_user).orElse(null));
	return 	favorisRepository.save(favoris);
	}


	@Override
	public Annonce findbyidd(Long annonce_id) {
		List<Favoris> list = favorisRepository.findAll();
		for (int j = 0; j < list.size(); j++){
			if(list.get(j).getAnnonce()==annonceRepository.getById(annonce_id) ){
				return list.get(j).getAnnonce();
			}
		}
		return null;
	}

	
  
}
	
	