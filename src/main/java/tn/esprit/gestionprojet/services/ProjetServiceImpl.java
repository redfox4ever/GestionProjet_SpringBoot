package tn.esprit.gestionprojet.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionprojet.entities.Projet;
import tn.esprit.gestionprojet.repositories.ProjetRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetServiceImpl implements IProjetService {

  final ProjetRepository projetRepository;


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
}
