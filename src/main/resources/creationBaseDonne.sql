DROP TABLE IF EXISTS Joueur;
DROP TABLE IF EXISTS Partie;
DROP TABLE IF EXISTS PartieJoueur;
CREATE TABLE Joueur (
    pseudo VARCHAR(255) PRIMARY KEY ,
    nom VARCHAR(255),
    niveau TINYINT UNSIGNED NOT NULL

);

CREATE TABLE Partie(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
    dateDebut TIMESTAMP NOT NULL,
    dateFin TIMESTAMP NOT NULL ,
    niveauDifficulte INT UNSIGNED NOT NULL
    CONSTRAINT chk_date CHECK ( DateDebut<DateFin AND DateDebut>'1999-01-01'),
    CONSTRAINT chk_niveau CHECK ( niveauDifficulte<=2 )

);
CREATE TABLE PartieJoueur(
    id INT UNSIGNED,
    pseudo VARCHAR(255),
    CONSTRAINT id_fk FOREIGN KEY (id) REFERENCES Partie(id),
    CONSTRAINT pseudo_fk FOREIGN KEY (pseudo) REFERENCES Joueur(pseudo),
    CONSTRAINT partieJoueur_und UNIQUE (id, pseudo)
);
