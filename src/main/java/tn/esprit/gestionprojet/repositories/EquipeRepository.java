package tn.esprit.gestionprojet.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionprojet.entities.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}
