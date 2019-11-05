package quebec.crosemont.g04.demineur;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartieTestConsctructeurPartiel {
    Partie partieConstructeurPartiel0 = new Partie(NiveauDifficulte.FACILE);
    Partie partieConstructeurPartiel1 = new Partie(NiveauDifficulte.FACILE);
    @Test
    public void testIdPartieConstructeurPartiel() {
        assertEquals(Integer.MAX_VALUE, partieConstructeurPartiel0.getId());
        assertEquals(Integer.MAX_VALUE-1, partieConstructeurPartiel1.getId());
    }

}
