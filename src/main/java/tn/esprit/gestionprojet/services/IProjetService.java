package tn.esprit.gestionprojet.services;


import tn.esprit.gestionprojet.entities.Projet;

import java.util.List;

public interface IProjetService {

    Projet addOrUpdateProjet(Projet projet);
    void deleteProjet(long id);
    List<Projet> findAllProject();
    Projet findProjectById(long id);

}
