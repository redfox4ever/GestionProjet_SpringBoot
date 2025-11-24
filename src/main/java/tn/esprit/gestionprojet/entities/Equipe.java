package tn.esprit.gestionprojet.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEquipe;
    String nomEquipe;
    @Enumerated(EnumType.STRING)
    Domaine domaine;

    @ManyToMany()
    //Set<Projet> projets = new HashSet<>();
    Set<Projet> projets ;


    @ManyToOne()
    Entreprise entreprise;
}
