package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.Visite;


@Repository
public interface VisiteRepositroy extends JpaRepository<Visite,Long> {
	@Query("SELECT an FROM Visite an JOIN an.client u WHERE u.id = :id  ")
	public List<Visite> findvisiteByuser(@Param("id")Long id);

	
	@Query("SELECT an FROM Visite an JOIN an.annonce u WHERE u.id = :id  ")
	public List<Visite> findvisiteByannonce(@Param("id")Long id);




}
