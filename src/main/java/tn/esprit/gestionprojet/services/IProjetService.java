package tn.esprit.gestionprojet.services;


import tn.esprit.gestionprojet.entities.Equipe;
import tn.esprit.gestionprojet.entities.Projet;

import java.util.List;

public interface IProjetService {

    Projet addOrUpdateProjet(Projet projet);
    void deleteProjet(long id);
    List<Projet> findAllProject();
    Projet findProjectById(long id);
    Projet assignProjetDtoProjet(long idProjet, long idDetailProjet);
    Equipe assignProjetToEquipe(long idEquipe, long idProjet);
    Equipe assignProjetsToEquipe(long idEquipe, List<Long> idProjets);

    Projet addProjetAndAssignDetailProjet(Projet projet, long idDetailProjet);

    List<Projet> RepoTest(long s);

}
