package quebec.crosemont.g04.demineur;

import org.junit.Test;


import static org.junit.Assert.*;

public class TestCaseConstructeurAvecAttributs {
    //Type Vide en valeur initiale
    Case uneCaseConstructeurAvecAttributVIDE=new Case(Type.VIDE);

    @Test
    public void getTypeInitial() {
        assertEquals(Type.VIDE, uneCaseConstructeurAvecAttributVIDE.getType() );
    }
    @Test
    public void estDecouverteInitial() {
        assertEquals(false, uneCaseConstructeurAvecAttributVIDE.estDecouverte());
    }

    @Test
    public void getMarqueInitiale() {
        assertEquals(Marque.VIDE, uneCaseConstructeurAvecAttributVIDE.getMarque());
    }

    @Test
    public void decouvrir() {
        uneCaseConstructeurAvecAttributVIDE.decouvrir();
        assertEquals(true , uneCaseConstructeurAvecAttributVIDE.estDecouverte());

    }
    @Test
    public void decouvrirPlusieursFois(){
        uneCaseConstructeurAvecAttributVIDE.decouvrir();
        uneCaseConstructeurAvecAttributVIDE.decouvrir();
        assertEquals(true , uneCaseConstructeurAvecAttributVIDE.estDecouverte());
        uneCaseConstructeurAvecAttributVIDE.decouvrir();
        uneCaseConstructeurAvecAttributVIDE.decouvrir();
        uneCaseConstructeurAvecAttributVIDE.decouvrir();
        assertEquals(true , uneCaseConstructeurAvecAttributVIDE.estDecouverte());
    }

    @Test
    public void marquerUneFois() {
        uneCaseConstructeurAvecAttributVIDE.marquer();
        assertEquals(Marque.BOMBE, uneCaseConstructeurAvecAttributVIDE.getMarque());
    }
    @Test
    public void marquerDeuxFois() {
        uneCaseConstructeurAvecAttributVIDE.marquer();
        uneCaseConstructeurAvecAttributVIDE.marquer();
        assertEquals(uneCaseConstructeurAvecAttributVIDE.getMarque().name(), "INCONNU");
    }
    @Test
    public void marquerTroisFois() {
        uneCaseConstructeurAvecAttributVIDE.marquer();
        uneCaseConstructeurAvecAttributVIDE.marquer();
        uneCaseConstructeurAvecAttributVIDE.marquer();
        assertEquals(uneCaseConstructeurAvecAttributVIDE.getMarque(), Marque.VIDE);
    }
    @Test
    public void marquerQuatreFois() {
        uneCaseConstructeurAvecAttributVIDE.marquer();
        uneCaseConstructeurAvecAttributVIDE.marquer();
        uneCaseConstructeurAvecAttributVIDE.marquer();
        uneCaseConstructeurAvecAttributVIDE.marquer();
        assertEquals("BOMBE", uneCaseConstructeurAvecAttributVIDE.getMarque().name());
    }


    @Test
    public void testToStringMarqueVide() {
        assertEquals(uneCaseConstructeurAvecAttributVIDE.toString(), "\u2B1C");
    }
    @Test
    public void testToStringMarqueBombe() {
        uneCaseConstructeurAvecAttributVIDE.marquer();
        assertEquals(uneCaseConstructeurAvecAttributVIDE.toString(), "\uD83D\uDEA9");

    }
    @Test
    public void testToStringMarqueInconnu() {
        uneCaseConstructeurAvecAttributVIDE.marquer();
        uneCaseConstructeurAvecAttributVIDE.marquer();
        assertEquals(uneCaseConstructeurAvecAttributVIDE.toString(), "\u2753");


    }
    @Test
    public void testToStringTypeVIDE(){
        uneCaseConstructeurAvecAttributVIDE.decouvrir();
        assertEquals(uneCaseConstructeurAvecAttributVIDE.toString(), "\u2B1C");
    }

    //Type BOMBE en valeur initiale
    Case uneCaseConstructeurAvecAttributBOMBE=new Case(Type.BOMBE);

    @Test
    public void getTypeInitialInitBOMBE() {
        assertEquals(Type.BOMBE, uneCaseConstructeurAvecAttributBOMBE.getType() );
    }
    @Test
    public void estDecouverteInitialInitBOMBE() {
        assertEquals(false, uneCaseConstructeurAvecAttributBOMBE.estDecouverte());
    }

    @Test
    public void getMarqueInitialeInitBOMBE() {
        assertEquals(Marque.VIDE, uneCaseConstructeurAvecAttributBOMBE.getMarque());
    }

    @Test
    public void decouvrirInitBOMBE() {
        uneCaseConstructeurAvecAttributBOMBE.decouvrir();
        assertEquals(true , uneCaseConstructeurAvecAttributBOMBE.estDecouverte());

    }
    @Test
    public void decouvrirPlusieursFoisInitBOMBE(){
        uneCaseConstructeurAvecAttributBOMBE.decouvrir();
        uneCaseConstructeurAvecAttributBOMBE.decouvrir();
        assertEquals(true , uneCaseConstructeurAvecAttributBOMBE.estDecouverte());
        uneCaseConstructeurAvecAttributBOMBE.decouvrir();
        uneCaseConstructeurAvecAttributBOMBE.decouvrir();
        uneCaseConstructeurAvecAttributBOMBE.decouvrir();
        assertEquals(true , uneCaseConstructeurAvecAttributBOMBE.estDecouverte());
    }

    @Test
    public void marquerUneFoisInitBOMBE() {
        uneCaseConstructeurAvecAttributBOMBE.marquer();
        assertEquals(Marque.BOMBE, uneCaseConstructeurAvecAttributBOMBE.getMarque());
    }
    @Test
    public void marquerDeuxFoisInitBOMBE() {
        uneCaseConstructeurAvecAttributBOMBE.marquer();
        uneCaseConstructeurAvecAttributBOMBE.marquer();
        assertEquals(uneCaseConstructeurAvecAttributBOMBE.getMarque().name(), "INCONNU");
    }
    @Test
    public void marquerTroisFoisInitBOMBE() {
        uneCaseConstructeurAvecAttributBOMBE.marquer();
        uneCaseConstructeurAvecAttributBOMBE.marquer();
        uneCaseConstructeurAvecAttributBOMBE.marquer();
        assertEquals(uneCaseConstructeurAvecAttributBOMBE.getMarque(), Marque.VIDE);
    }
    @Test
    public void marquerQuatreFoisInitBOMBE() {
        uneCaseConstructeurAvecAttributBOMBE.marquer();
        uneCaseConstructeurAvecAttributBOMBE.marquer();
        uneCaseConstructeurAvecAttributBOMBE.marquer();
        uneCaseConstructeurAvecAttributBOMBE.marquer();
        assertEquals("BOMBE", uneCaseConstructeurAvecAttributBOMBE.getMarque().name());
    }


    @Test
    public void testToStringMarqueVideInitBOMBE() {
        assertEquals(uneCaseConstructeurAvecAttributBOMBE.toString(), "\u2B1C");
    }
    @Test
    public void testToStringMarqueBombeInitBOMBE() {
        uneCaseConstructeurAvecAttributBOMBE.marquer();
        assertEquals(uneCaseConstructeurAvecAttributBOMBE.toString(), "\uD83D\uDEA9");

    }
    @Test
    public void testToStringMarqueInconnuInitBOMBE() {
        uneCaseConstructeurAvecAttributBOMBE.marquer();
        uneCaseConstructeurAvecAttributBOMBE.marquer();
        assertEquals(uneCaseConstructeurAvecAttributBOMBE.toString(), "\u2753");


    }
    @Test
    public void testToStringTypeBOMBEInitBOMBE(){
        uneCaseConstructeurAvecAttributBOMBE.decouvrir();
        assertEquals(uneCaseConstructeurAvecAttributBOMBE.toString(), "\uD83D\uDCA3");
    }


}
