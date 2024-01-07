package tech.enspd.enspdbiblio.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Memoire")
public class Memoire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String titre;
    @Column(nullable = false)
    private String auteur;
    @Column(nullable = false)
    private String filiere;
    private Integer annee;

    @OneToOne
    private User user;

    @Column(nullable = false)
    private String lien;

}
