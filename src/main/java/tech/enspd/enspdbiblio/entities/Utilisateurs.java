package tech.enspd.enspdbiblio.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "UTILISATEURS")
public class Utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false, unique = true)
    private String matricule;
    @Column(nullable = false)
    private String mot_de_passe;
    @Column(nullable = false)
    private boolean est_admin;

    public Utilisateurs() {
    }

    public Utilisateurs(int id, String nom, String matricule, String mot_de_passe, boolean est_admin) {
        this.id = id;
        this.nom = nom;
        this.matricule = matricule;
        this.mot_de_passe = mot_de_passe;
        this.est_admin = est_admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public boolean isEst_admin() {
        return est_admin;
    }

    public void setEst_admin(boolean est_admin) {
        this.est_admin = est_admin;
    }
}
