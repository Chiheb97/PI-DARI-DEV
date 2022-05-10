package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.Etat;
import tn.esprit.spring.entities.Transaction;
import tn.esprit.spring.entities.TypeBien;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
	
//	public List<Annonce> suggsetion(int nbrchambre, int age, String localisation, Etat etat, TypeBien typedebien,Transaction transaction);


	@Query("SELECT an FROM Annonce an WHERE an.titre like %?1 OR an.description like %?1 ")
	public List<Annonce>findAllByWord(String keyword);

	@Query("SELECT an FROM Annonce an JOIN an.user u WHERE u.id = :id  ")
	public List<Annonce>findAllByuser(@Param("id")Long id);
	
	@Query("SELECT an FROM Annonce an where an.prix BETWEEN 0.0 AND :max")
	public List<Annonce>Range(@Param("max") Double max);

	
	@Query("select avg(an.prix) FROM Annonce an ")
 	public double Prixmoyenne(List<Annonce> listAnnonces);

	//mohamed
	List<Annonce> findAllByTransaction(Transaction transaction);


}
