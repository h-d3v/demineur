DROP TABLE IF EXISTS partie;
CREATE TABLE partie (
    'id' INT UNSIGNED PRIMARY KEY NOT NULL,
    'dateDebut' TIMESTAMP NOT NULL,
    'dateFin' TIMESTAMP DATETIME,
    'niveauDifficulte' VARCHAR(10),
    check(dateDebut<=CURRENT_TIMESTAMP),
    check(dateFin>dateDebut OR dateFin IS NULL)
);


DROP TABLE IF EXISTS joueur;
CREATE TABLE joueur (
    'pseudo' VARCHAR(50) PRIMARY KEY NOT NULL,
    'nom' VARCHAR(50) NOT NULL,
    'niveau' INT UNSIGNED NOT NULL,
    'partieId' INT UNSIGNED,
    constraint partieId_parties_fk foreign key (partieId) references partie(no_employe)
);

DROP TABLE IF EXISTS ListePartie;

CREATE TABLE ListePartie(
    'id' INT UNSIGNED,
    'pseudo' VARCHAR(255),
    CONSTRAINT id_fk FOREIGN KEY (id) REFERENCES Partie(id),
    CONSTRAINT pseudo_fk FOREIGN KEY (pseudo) REFERENCES Joueur(pseudo),
    CONSTRAINT partieJoueur_und UNIQUE (id, pseudo)
);
