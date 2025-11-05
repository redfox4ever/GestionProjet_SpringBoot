package tn.esprit.gestionprojet.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionprojet.entities.DetailProjet;
import tn.esprit.gestionprojet.entities.Equipe;
import tn.esprit.gestionprojet.entities.Projet;
import tn.esprit.gestionprojet.repositories.DetailProjetRepository;
import tn.esprit.gestionprojet.repositories.EquipeRepository;
import tn.esprit.gestionprojet.repositories.ProjetRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetServiceImpl implements IProjetService {

  final ProjetRepository projetRepository;
  final DetailProjetRepository detailProjetRepository;
  final EquipeRepository equipeRepository;


    @Override
    public Projet addOrUpdateProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public void deleteProjet(long id) {
        projetRepository.deleteById(id);
    }

    @Override
    public List<Projet> findAllProject() {
        return projetRepository.findAll();
    }

    @Override
    public Projet findProjectById(long id) {
        return
                projetRepository.findById(id).get();
    }

    @Override
    public Projet assignProjetDtoProjet(long idProjet, long idDetailProjet) {
        Projet projet = findProjectById(idProjet);
        DetailProjet detailProjet1 = detailProjetRepository.findById(idDetailProjet).get();
        projet.setDetailProjet(detailProjet1);

        return projetRepository.save(projet);
    }

    //ManyToMany
    @Override
    public Equipe assignProjetToEquipe(long idEquipe, long idProjet)
    {
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        Projet projet = projetRepository.findById(idProjet).get();
        equipe.getProjets().add(projet);
        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe assignProjetsToEquipe(long idEquipe, List<Long> idProjets)
    {
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        List<Projet> projets = projetRepository.findAllById(idProjets);
        equipe.getProjets().addAll(projets);
        return equipeRepository.save(equipe);
    }




}
