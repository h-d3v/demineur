package quebec.crosemont.g04.demineur;



import org.junit.Test;

import static org.junit.Assert.*;

public class GrilleTest {

    Grille testConstruteurSansAttribut= new Grille();

    @Test
    public void getLargeurConstruteurSansAttribut() {
        assertEquals(10, testConstruteurSansAttribut.getLargeur());
    }

    @Test
    public void getHauteurConstruteurSansAttribut() {
        assertEquals(10, testConstruteurSansAttribut.getHauteur());
    }


    @Test
    public void getCase() {
    }

    @Test
    public void getFaceCase() {
    }

    @Test
    public void compterVoisins() {
    }

    @Test
    public void initialiser() {
    }

    @Test
    public void decouvrir() {
    }

    @Test
    public void toutReveler() {
    }

    @Test
    public void testToString() {
    }
}