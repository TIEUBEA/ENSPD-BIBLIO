CREATE DATABASE BIBLIO;
CREATE TABLE UTILISATEURS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    matricule VARCHAR(50) NOT NULL UNIQUE,
    mot_de_passe VARCHAR(100) NOT NULL,
    est_admin BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE MEMOIRES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    auteur VARCHAR(100) NOT NULL,
    titre VARCHAR(255) NOT NULL,
    departement VARCHAR(255) NOT NULL,
    annee_publication INT,
    description TEXT,
    lien VARCHAR(255) NOT NULL
    proprietaire_id VARCHAR(50), -- Utilisation du matricule comme clé étrangère
    FOREIGN KEY (proprietaire_id) REFERENCES Utilisateurs(id)
);

CREATE TABLE DOCUMENTS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom_document VARCHAR(255) NOT NULL,
    chemin_document VARCHAR(255) NOT NULL
);