package tn.esprit.gestionprojet.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionprojet.entities.DetailProjet;
import tn.esprit.gestionprojet.entities.Equipe;
import tn.esprit.gestionprojet.entities.Projet;
import tn.esprit.gestionprojet.repositories.DetailProjetRepository;
import tn.esprit.gestionprojet.repositories.EquipeRepository;
import tn.esprit.gestionprojet.repositories.ProjetRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
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
    //@Scheduled(fixedRate = 1000, timeUnit = TimeUnit.MILLISECONDS, initialDelay = 1000)
    //@Scheduled(fixedDelay = 1000, timeUnit = TimeUnit.MILLISECONDS) //value is in ms
    //@Scheduled(cron = "*/10 * * * * *")
//fixed delay waits for the previous execution to finish before the new execution
    // so if a single execution will take 5s with a delay of 10s the function will run
    // once every 15s
    // while fixedRate will execute separately every fixedRate (parallel)
    @Scheduled(cron = "*/15 * 8-11 * * MON-FRI")
    @Scheduled(cron = "0 0/10 9-17 * * MON-FRI")
    @Scheduled(cron = "0 15 8 * * MON")
    // scheduled method must return void
    // @EnableScheduling on the application method
    public List<Projet> findAllProject() {
        System.out.println("hello");
        for(Projet p : projetRepository.findAll() )
        {
            System.out.println("hello");
            ProjetServiceImpl.log.info("le projet"+p);
        }
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

    @Override
    public Projet addProjetAndAssignDetailProjet(Projet projet, long idDetailProjet)
    {
        DetailProjet detailProjet = detailProjetRepository.findById(idDetailProjet).get();
        projet.setDetailProjet(detailProjet);
        return  projetRepository.save(projet);

    }

    public List<Projet> RepoTest(long s)
    {
        return projetRepository.findByEquipeIdEquipe(s);
    }


}
