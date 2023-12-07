package tech.enspd.enspdbiblio.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Memoires")
public class Memoires {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String titre;
    @Column(nullable = false)
    private String auteur;
    private Integer annee_publication;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private String lien;
    @ManyToOne
    @JoinColumn(name = "proprietaire_id", referencedColumnName = "id")
    private Utilisateurs proprietaire; // Référence à l'utilisateur propriétaire du mémoire

    public Memoires() {
    }

    public Memoires(int id, String titre, String auteur, Integer annee_publication, String description, String lien, Utilisateurs proprietaire) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.annee_publication = annee_publication;
        this.description = description;
        this.lien = lien;
        this.proprietaire = proprietaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Integer getAnnee_publication() {
        return annee_publication;
    }

    public void setAnnee_publication(Integer annee_publication) {
        this.annee_publication = annee_publication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Utilisateurs getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateurs proprietaire) {
        this.proprietaire = proprietaire;
    }
}
