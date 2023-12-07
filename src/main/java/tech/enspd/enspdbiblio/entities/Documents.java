package tech.enspd.enspdbiblio.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "DOCUMENTS")
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nom_document;
    @Column(nullable = false)
    private String chemin_document;

    public Documents() {
    }

    public Documents(int id, String nom_document, String chemin_document) {
        this.id = id;
        this.nom_document = nom_document;
        this.chemin_document = chemin_document;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_document() {
        return nom_document;
    }

    public void setNom_document(String nom_document) {
        this.nom_document = nom_document;
    }

    public String getChemin_document() {
        return chemin_document;
    }

    public void setChemin_document(String chemin_document) {
        this.chemin_document = chemin_document;
    }
}
