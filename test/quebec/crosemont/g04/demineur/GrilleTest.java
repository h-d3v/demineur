package quebec.crosemont.g04.demineur;

/* Tests de la calsse Grille le generateur random doit etere au seed 1
* Pour un nombre de bombes de 3, les bombes sont situees sur les cases  0-3 2-3 et 4-4
* On utilise une grille simple de 5 par 5 avec 3 bombes
*
* */

import org.junit.Test;

import static org.junit.Assert.*;

public class GrilleTest {

    Grille grilleTest = new Grille(5,5);  //objet test
    @Test
    public  void  testGetLargeur(){
        assertTrue(grilleTest.getLargeur()==5); //S'assurer si la largeur est bel et bien 5.
    }


    @Test
    public void testgetHauteur() {
        assertEquals( grilleTest.getHauteur(), 5);
    }



    @Test
    public void getFaceCaseCaseVideSansBombesVoisines() {
        grilleTest.initialiser(1,1,3);
        assertEquals(grilleTest.getFaceCase(1,1), "  " );
    }
    @Test
    public void getFaceCaseVideAvecUneBombeVoisine() {
        grilleTest.initialiser(0,2,3);
        assertEquals(grilleTest.getFaceCase(0,2), " 1" );
    }
    @Test
    public void getFaceCaseVideAvecDeuxBombesVoisines() {
        grilleTest.initialiser(1,2,3);
        assertEquals(grilleTest.getFaceCase(1,2), " 2" );
    }
    @Test
    public void getFaceCaseUneBombeDecouverte() {
        grilleTest.initialiser(1,2,3);
        grilleTest.toutReveler();
        assertEquals(grilleTest.getFaceCase(0,3), "\uD83D\uDCA3" );
    }

    @Test
    public void compterVoisinsPasDeVoisins() {
        grilleTest.initialiser(0,0,3);
        assertEquals(grilleTest.compterVoisins(0,0), 0);
    }
    @Test
    public void compterVoisinsUnVoisin() {
        grilleTest.initialiser(0,2,3);
        assertEquals(grilleTest.compterVoisins(0,2), 1);
    }

    @Test
    public void initialiser() {

    }
    @Test
    public void TesttoutReveler() {
        grilleTest.initialiser(1,1,3);
        grilleTest.toutReveler();

        int compteurBombes=0;
        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                if (grilleTest.getCase(i,j).getType().equals(Type.BOMBE)){
                    compteurBombes++;
                }
            }
        }
        assertEquals(compteurBombes, 3);
    }


    @Test
    public void decouvrirUneCaseVideSansBombesAdjacente() {
        grilleTest.initialiser(3,1,3);
        //La case 0 0 n'a pas de bombes adjacentes et doit donc decouvrire ses voisines
        grilleTest.decouvrir(0,0);
        assertTrue(grilleTest.getCase(0,0).decouverte);
        assertTrue(grilleTest.getCase(1,0).decouverte);
        assertTrue(grilleTest.getCase(2,0).decouverte);
        assertTrue(grilleTest.getCase(3,0).decouverte);
        assertTrue(grilleTest.getCase(4,0).decouverte);

        assertTrue(grilleTest.getCase(0,1).decouverte);
        assertTrue(grilleTest.getCase(1,1).decouverte);
        assertTrue(grilleTest.getCase(2,1).decouverte);
        assertTrue(grilleTest.getCase(3,1).decouverte);
        assertTrue(grilleTest.getCase(4,1).decouverte);

        assertTrue(grilleTest.getCase(0,2).decouverte);
        assertTrue(grilleTest.getCase(1,2).decouverte);
        assertTrue(grilleTest.getCase(2,2).decouverte);
        assertTrue(grilleTest.getCase(3,2).decouverte);
        assertTrue(grilleTest.getCase(4,2).decouverte);


        assertFalse(grilleTest.getCase(0,3).decouverte);
        assertFalse(grilleTest.getCase(1,3).decouverte);
        assertFalse(grilleTest.getCase(2,3).decouverte);
        assertTrue(grilleTest.getCase(3,3).decouverte);
        assertTrue(grilleTest.getCase(4,3).decouverte);
        assertFalse(grilleTest.getCase(0,4).decouverte);
        assertFalse(grilleTest.getCase(1,4).decouverte);
        assertFalse(grilleTest.getCase(2,4).decouverte);
        assertFalse(grilleTest.getCase(3,4).decouverte);
        assertFalse(grilleTest.getCase(4,4).decouverte);
    }
    @Test
    public void decouvrirUneCaseVideAvecBombesAdjacente() {

        grilleTest.initialiser(1,2,3);
        //La case 1-2 a une bombe adjacente et ne doit decouvrir que celle ci en sachant que la methode initialiser appelle la methode decouvrir()
        grilleTest.decouvrir(2, 2);
        assertFalse(grilleTest.getCase(0,0).decouverte);
        assertFalse(grilleTest.getCase(1,0).decouverte);
        assertFalse(grilleTest.getCase(2,0).decouverte);
        assertFalse(grilleTest.getCase(3,0).decouverte);
        assertFalse(grilleTest.getCase(4,0).decouverte);

        assertFalse(grilleTest.getCase(0,1).decouverte);
        assertFalse(grilleTest.getCase(1,1).decouverte);
        assertFalse(grilleTest.getCase(2,1).decouverte);
        assertFalse(grilleTest.getCase(3,1).decouverte);
        assertFalse(grilleTest.getCase(4,1).decouverte);

        assertFalse(grilleTest.getCase(0,2).decouverte);
        assertTrue(grilleTest.getCase(1,2).decouverte);
        assertTrue(grilleTest.getCase(2,2).decouverte);
        assertFalse(grilleTest.getCase(3,2).decouverte);
        assertFalse(grilleTest.getCase(4,2).decouverte);


        assertFalse(grilleTest.getCase(0,3).decouverte);
        assertFalse(grilleTest.getCase(1,3).decouverte);
        assertFalse(grilleTest.getCase(2,3).decouverte);
        assertFalse(grilleTest.getCase(3,3).decouverte);
        assertFalse(grilleTest.getCase(4,3).decouverte);

        assertFalse(grilleTest.getCase(0,4).decouverte);
        assertFalse(grilleTest.getCase(1,4).decouverte);
        assertFalse(grilleTest.getCase(2,4).decouverte);
        assertFalse(grilleTest.getCase(3,4).decouverte);
        assertFalse(grilleTest.getCase(4,4).decouverte);



    }


}