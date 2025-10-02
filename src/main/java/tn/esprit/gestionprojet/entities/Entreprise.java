package tn.esprit.gestionprojet.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEntreprise;
    String nomEntreprise;
    String adresse;

    @OneToMany(mappedBy = "entreprise")
    Set<Equipe>equipes;

}
