package tn.esprit.gestionprojet.entities;
import jakarta.persistence.*;
import lombok.*;




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

}
