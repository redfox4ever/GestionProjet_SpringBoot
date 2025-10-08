package tn.esprit.gestionprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionprojet.entities.DetailProjet;

@Repository
public interface DetailProjetRepository extends JpaRepository<DetailProjet, Long> {
}
