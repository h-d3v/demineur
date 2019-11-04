package quebec.crosemont.g04.demineur;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PartieTest {
    Partie partieConstructeurPartiel = new Partie(NiveauDifficulte.FACILE);
    Partie partieConstructeurTotal = new Partie(11, LocalDateTime.of(2019,11,23,21,00,11,2),LocalDateTime.of(2019,11,23,22,00,11,2),NiveauDifficulte.FACILE);//objet test


    @Test
    public void testIdPartieConstructeurTotal(){
        assertEquals(11, partieConstructeurTotal.getId());
    }


    @Test
    public void testIdPartieConstructeurTotalFalse(){
        assertNotEquals(21, partieConstructeurTotal.getId());
    }
    @Test
    public  void testGetDateDebut(){
        LocalDateTime dateTime=LocalDateTime.of(2019,11,23,21,00,11,2);
        assertTrue(dateTime.equals(partieConstructeurTotal.getDateDebut()));
    }
    @Test
    public  void testGetFin(){
        LocalDateTime dateTime=LocalDateTime.of(2019,11,23,22,00,11,2);
        assertTrue(dateTime.equals(partieConstructeurTotal.getDateFin()));
    }
    @Test
    public  void testGetTemps(){
        int temps=3600;
        assertEquals(temps, partieConstructeurTotal.getTemps());
    }
    @Test
    public  void testGetNiveauDifficulteFacile(){
        assertEquals(NiveauDifficulte.FACILE, partieConstructeurTotal.getNiveauDifficulte());
        assertEquals(NiveauDifficulte.FACILE, partieConstructeurPartiel.getNiveauDifficulte());
    }
    @Test
    public  void testGetNiveauDifficulteMoyen(){
        Partie partieConstructeurPartiel = new Partie(NiveauDifficulte.MOYEN);
        Partie partieConstructeurTotal = new Partie(11, LocalDateTime.of(2019,11,23,21,00,11,2),LocalDateTime.of(2019,11,23,22,00,11,2),NiveauDifficulte.MOYEN);//objet test

        assertEquals(NiveauDifficulte.MOYEN, partieConstructeurTotal.getNiveauDifficulte());
        assertEquals(NiveauDifficulte.MOYEN, partieConstructeurPartiel.getNiveauDifficulte());
    }
    @Test
    public  void testGetNiveauDifficulteDifficile(){
        Partie partieConstructeurPartiel = new Partie(NiveauDifficulte.DIFFICILE);
        Partie partieConstructeurTotal = new Partie(11, LocalDateTime.of(2019,11,23,21,00,11,2),LocalDateTime.of(2019,11,23,22,00,11,2),NiveauDifficulte.DIFFICILE);//objet test

        assertEquals(NiveauDifficulte.DIFFICILE, partieConstructeurTotal.getNiveauDifficulte());
        assertEquals(NiveauDifficulte.DIFFICILE, partieConstructeurPartiel.getNiveauDifficulte());
    }
    @Test
    public  void testSetTempsAjoutTemps(){
        partieConstructeurTotal.setTemps(7200);
        assertEquals(7200, partieConstructeurTotal.getTemps() );
        assertTrue(LocalDateTime.of(2019,11,23,23,00,11,2).equals(partieConstructeurTotal.getDateFin()));
    }
    @Test
    public  void testSetTempsSupprimerTemps(){

        partieConstructeurTotal.setTemps(1);
        assertEquals(1, partieConstructeurTotal.getTemps() );
        assertTrue(LocalDateTime.of(2019,11,23,21,00,12,2).equals(partieConstructeurTotal.getDateFin()));
    }


}

