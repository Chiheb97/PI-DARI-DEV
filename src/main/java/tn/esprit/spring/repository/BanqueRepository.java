package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Banque;
@Repository
public interface BanqueRepository extends JpaRepository<Banque,Long> {

}
