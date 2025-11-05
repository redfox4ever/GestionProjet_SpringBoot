package tn.esprit.gestionprojet.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionprojet.entities.Equipe;
import tn.esprit.gestionprojet.entities.Projet;
import tn.esprit.gestionprojet.services.IProjetService;
import tn.esprit.gestionprojet.services.ProjetServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/ProjetController")
@AllArgsConstructor

public class ProjetController {

     final IProjetService projetService;

  @PostMapping("/AddProject")
    Projet addProjet(@RequestBody Projet projet) {
      return projetService.addOrUpdateProjet(projet);
  }

  @PutMapping("/UpdateProject")
    Projet updateProjet(@RequestBody Projet projet) {
      return projetService.addOrUpdateProjet(projet);
}

@DeleteMapping("/DeleteProject/{id}")
    void deleteProjet(@PathVariable ("id")long idProject) {
      projetService.deleteProjet(idProject);
}

@GetMapping("/GetAllProject")
List<Projet> getAllProjet() {
      return projetService.findAllProject();
}

@GetMapping("/GetProject{idProjet}")
    Projet getProjet(@PathVariable ("idProjet")long id) {
      return projetService.findProjectById(id);
}
@PutMapping("/assignProjetDtoProject/{idProjet}/{idDetailProjet}")
    Projet assignProjetToDetailProjet(@PathVariable long idProjet, @PathVariable long idDetailProjet)
{
    return projetService.assignProjetDtoProjet(idProjet, idDetailProjet);
}
    @PutMapping("/assignProjetToEquipe/{idEquipe}/{idProjet}")
    Equipe assignProjetToEquipe(@PathVariable long idEquipe, @PathVariable long idProjet)
    {
        return projetService.assignProjetToEquipe(idEquipe, idProjet);
    }

    @PutMapping("/assignProjetsToEquipe/{idEquipe}/{idProjet}")
    Equipe assignProjetsToEquipe(@PathVariable long idEquipe, @PathVariable List<Long> idProjet)
    {
        return projetService.assignProjetsToEquipe(idEquipe, idProjet);
    }
}
