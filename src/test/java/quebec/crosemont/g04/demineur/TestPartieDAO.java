package quebec.crosemont.g04.demineur;

import org.junit.Test;


import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.Assert.*;


public class TestPartieDAO {
    Partie partie= new Partie(20302,LocalDateTime.of(2019,11,23,21,00,11,2),LocalDateTime.of(2019,11,23,22,00,11,2),NiveauDifficulte.FACILE);
    @Test
    public void testAjouter() throws DAOException{
        PartieDao.ajouter(partie);

    }
    @Test
    public void testLire() throws DAOException{
        Partie partie= new Partie(8,Timestamp.valueOf("2019-11-23 21:00:11.000000002").toLocalDateTime(),Timestamp.valueOf("2020-11-23 21:00:11.000000002").toLocalDateTime(),NiveauDifficulte.DIFFICILE);
        Partie partielue= PartieDao.lire(8);
        assertEquals(partie.getDateDebut(), partielue.getDateDebut());


    }

    @Test
    public void testModifier() throws DAOException{

        Partie partie= new Partie(88,LocalDateTime.of(2019,11,23,21,00,11,2),LocalDateTime.of(2019,11,23,22,00,11,2),NiveauDifficulte.FACILE);
        PartieDao.modifier(partie);
    }

    @Test
    public void testSupprimer() throws DAOException{
        Partie partie= new Partie(88,LocalDateTime.of(2019,11,23,21,00,11,2),LocalDateTime.of(2019,11,23,22,00,11,2),NiveauDifficulte.FACILE);
        PartieDao.supprimer(partie);
    }

}
