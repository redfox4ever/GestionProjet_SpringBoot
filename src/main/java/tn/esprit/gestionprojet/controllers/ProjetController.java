package tn.esprit.gestionprojet.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionprojet.entities.Entreprise;
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

@PutMapping("/assignProjetDetailProject/{idProjet}/{idDetailProjet}")
    Projet assignProjetToDetailProjet(@PathVariable long idProjet, @PathVariable long idDetailProjet)
{
    return projetService.assignProjetDtoProjet(idProjet, idDetailProjet);
}
    @PutMapping("/assignProjetToEquipe/{idEquipe}/{idProjet}")
    Equipe assignProjetToEquipe(@PathVariable long idEquipe, @PathVariable long idProjet)
    {
        return projetService.assignProjetToEquipe(idEquipe, idProjet);
    }

    @PutMapping("/assignProjetsToEquipe/{idEquipe}")
    Equipe assignProjetsToEquipe(@PathVariable long idEquipe, @RequestParam List<Long> idProjet)
    {
        return projetService.assignProjetsToEquipe(idEquipe, idProjet);
    }

    @PostMapping ("/AddProjetAndAssignProjetDetail/{idDetailProjet}")
    Projet addProjetAndAssignDetailProjet(@RequestBody Projet projet, @PathVariable long idDetailProjet)
    {
        return projetService.addProjetAndAssignDetailProjet(projet, idDetailProjet);
    }

    @GetMapping("/RepoTest/{s}")
    List<Projet> RepoTest(@PathVariable long s) {
        return projetService.RepoTest(s);
    }

    @GetMapping("/retrieve-by-address")
    public List<Entreprise> retrieveByAddress(@RequestParam String adresse)
    {
        return projetService.retrieveByAddress(adresse);
    }


}
