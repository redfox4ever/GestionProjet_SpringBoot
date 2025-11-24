package tn.esprit.gestionprojet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE) /*fixer l'acces priver pour tous les attributs de l'entités et on change les autres public*/
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProjet;
    private String sujet;

    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
            @JsonIgnore
    DetailProjet detailProjet;


    @ManyToMany(mappedBy = "projets")
    @ToString.Exclude
            @JsonIgnore
    Set<Equipe> equipe;


}
