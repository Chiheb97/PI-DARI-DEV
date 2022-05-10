package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.Avis;


@Repository
public interface AvisRepository extends JpaRepository<Avis, Long>{
	@Query("Select count(*) FROM Avis a where a.annonce.id =:id ")
	public int nbravisparannonce(@Param("id") Long id);

}
