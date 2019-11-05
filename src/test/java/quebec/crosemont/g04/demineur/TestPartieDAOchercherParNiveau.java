package quebec.crosemont.g04.demineur;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestPartieDAOchercherParNiveau {
    @Test
    public void testTrouverPartieParDifficulte() throws DAOException{
        List<Partie> parties= new ArrayList<Partie>();
        parties=PartieDao.trouverPartieParDifficulte(NiveauDifficulte.DIFFICILE);
        assertEquals(8, parties.get(0).getId());
        assertEquals(1, parties.get(1).getId());
        assertEquals(2, parties.size());
        parties=PartieDao.trouverPartieParDifficulte(NiveauDifficulte.FACILE);
        assertEquals(0, parties.size());
        PartieDao.modifier(new Partie(1, LocalDateTime.of(2019,11,23,21,00,11,2),LocalDateTime.of(2019,11,23,22,00,11,2),NiveauDifficulte.FACILE));

        parties=PartieDao.trouverPartieParDifficulte(NiveauDifficulte.FACILE);
        assertEquals(1, parties.size());
        assertEquals(1, parties.get(0).getId());
    }

}
