package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Favoris;

import java.util.List;

@Repository
public interface FavorisRepository extends JpaRepository<Favoris, Long> {


    List<Favoris> findAllByUser_Id(Long userId);
    //Favoris findByUser_IdAndAnnonce_Id(Long user, Long annonce);

}