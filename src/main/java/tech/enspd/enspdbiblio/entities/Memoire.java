package tech.enspd.enspdbiblio.entities;


import javax.persistence.*;

@Entity
@Table(name = "Memoire")
public class Memoire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String titre;
    @Column(nullable = false)
    private String auteur;
    @Column(nullable = false)
    private String filiere;
    private Integer annee;

    @Column(nullable = false)
    private String lien;

}
