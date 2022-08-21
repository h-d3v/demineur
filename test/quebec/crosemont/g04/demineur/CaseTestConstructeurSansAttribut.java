package quebec.crosemont.g04.demineur;

import org.junit.Test;

import static org.junit.Assert.*;

public class CaseTestConstructeurSansAttribut {
    Case uneCaseConstructeurSansAttribut=new Case();

    @Test
    public void getTypeInitial() {
        assertEquals(Type.VIDE, uneCaseConstructeurSansAttribut.getType() );
    }
    @Test
    public void estDecouverteInitial() {
        assertEquals(false, uneCaseConstructeurSansAttribut.estDecouverte());
    }

    @Test
    public void getMarqueInitiale() {
        assertEquals(Marque.VIDE, uneCaseConstructeurSansAttribut.getMarque());
    }

    @Test
    public void decouvrir() {
        uneCaseConstructeurSansAttribut.decouvrir();
        assertEquals(true , uneCaseConstructeurSansAttribut.estDecouverte());

    }
    @Test
    public void decouvrirPlusieursFois(){
        uneCaseConstructeurSansAttribut.decouvrir();
        uneCaseConstructeurSansAttribut.decouvrir();
        assertEquals(true , uneCaseConstructeurSansAttribut.estDecouverte());
        uneCaseConstructeurSansAttribut.decouvrir();
        uneCaseConstructeurSansAttribut.decouvrir();
        uneCaseConstructeurSansAttribut.decouvrir();
        assertEquals(true , uneCaseConstructeurSansAttribut.estDecouverte());
    }

    @Test
    public void marquerUneFois() {
        uneCaseConstructeurSansAttribut.marquer();
        assertEquals(Marque.BOMBE, uneCaseConstructeurSansAttribut.getMarque());
    }
    @Test
    public void marquerDeuxFois() {
        uneCaseConstructeurSansAttribut.marquer();
        uneCaseConstructeurSansAttribut.marquer();
        assertEquals(uneCaseConstructeurSansAttribut.getMarque().name(), "INCONNU");
    }
    @Test
    public void marquerTroisFois() {
        uneCaseConstructeurSansAttribut.marquer();
        uneCaseConstructeurSansAttribut.marquer();
        uneCaseConstructeurSansAttribut.marquer();
        assertEquals(uneCaseConstructeurSansAttribut.getMarque(), Marque.VIDE);
    }
    @Test
    public void marquerQuatreFois() {
        uneCaseConstructeurSansAttribut.marquer();
        uneCaseConstructeurSansAttribut.marquer();
        uneCaseConstructeurSansAttribut.marquer();
        uneCaseConstructeurSansAttribut.marquer();
        assertEquals("BOMBE", uneCaseConstructeurSansAttribut.getMarque().name());
    }


    @Test
    public void testToStringMarqueVide() {
        assertEquals(uneCaseConstructeurSansAttribut.toString(), "\u2B1C");
    }
    @Test
    public void testToStringMarqueBombe() {
        uneCaseConstructeurSansAttribut.marquer();
        assertEquals(uneCaseConstructeurSansAttribut.toString(), "\uD83D\uDEA9");

    }
    @Test
    public void testToStringMarqueInconnu() {
        uneCaseConstructeurSansAttribut.marquer();
        uneCaseConstructeurSansAttribut.marquer();
        assertEquals(uneCaseConstructeurSansAttribut.toString(), "\u2753");


    }
    @Test
    public void testToStringTypeVIDE(){
        uneCaseConstructeurSansAttribut.decouvrir();
        assertEquals(uneCaseConstructeurSansAttribut.toString(), "\u2B1C");
    }



}