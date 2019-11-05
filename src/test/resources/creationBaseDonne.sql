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
    CONSTRAINT chk_date CHECK ( DateDebut<DateFin),
    CONSTRAINT chk_niveau CHECK ( niveauDifficulte<=2 )

);
CREATE TABLE PartieListe(
                            ids TEXT,
                            pseudo VARCHAR(255),
                            CONSTRAINT id_fk FOREIGN KEY (ids) REFERENCES Partie(id)
);
Insert into Partie values(8, 1606183511, 1606183811,2);
Insert into Partie values(1, 1606189511, 1606283811,2);
INSERT into Joueur values("bob","Robert",3);
INSERT into Joueur values("blob","Roberto",3);
delete * from Pa
INSERT INTO PartieListe values("1-8","bob");

