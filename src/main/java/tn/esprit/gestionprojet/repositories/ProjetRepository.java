package tn.esprit.gestionprojet.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionprojet.entities.Projet;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {

    List<Projet> findByEquipeIdEquipe(long id);
    //List<Projet> findByEquipeIdEquipeAndEquipeEntrepriseIdEntreprise(long id, long id2);

    //Like is optional
    // don't conflate Like or nothing with Contains
   // List<Projet> findByEquipeDomaineLikeAndEquipeEntrepriseAdresse(String domaine);





}
