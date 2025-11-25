package tn.esprit.gestionprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionprojet.entities.Entreprise;

import java.util.List;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {


    List<Entreprise> findBy();

    @Query("select e from Entreprise e where e.adresse=:adresse")
    List<Entreprise> retrieveByAddress(@Param("adresse") String adresse);
}
