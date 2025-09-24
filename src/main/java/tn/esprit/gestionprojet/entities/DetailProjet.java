package tn.esprit.gestionprojet.entities;

import jakarta.persistence.*;
import lombok.*;
import java.sql.*;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idDetailProjet;
    String description;
    String technologied ;
    long cout ;
    Date dateDebut;
}
