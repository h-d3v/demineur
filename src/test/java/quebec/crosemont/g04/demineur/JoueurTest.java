package quebec.crosemont.g04.demineur;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class JoueurTest {
    Partie partieTest = new Partie(NiveauDifficulte.FACILE);
    ArrayList<Partie> desParties= new ArrayList<Partie>();
    Joueur joueurConstructeurComplet= new Joueur("Test2", "test321", 32, desParties);
    Joueur joueurConstructeurPartiel=  new Joueur("Test", "test123");

    @Test
    public void testGetNomConstructeurPartiel(){
        String nomObtenu= joueurConstructeurPartiel.getNom();
        assertEquals("Test",nomObtenu);
    }

    @Test
    public void testGetPseudoConstructeurPartiel(){
        String pseudoObtenu= joueurConstructeurPartiel.getPseudo();
        assertEquals("test123",pseudoObtenu);
    }

    @Test
    public void testGetNiveauConstructeurPartiel(){
        int niveauObtenu=joueurConstructeurPartiel.getNiveau();
        assertEquals(0, niveauObtenu);
    }

    @Test
    public void testGetPartiesJoueurConstructeurPartie(){
        ArrayList<Partie> listeObtenue= joueurConstructeurPartiel.getParties();
        ArrayList<Partie> nouvelleListe= new ArrayList<Partie>();
        assertEquals(nouvelleListe, listeObtenue);
    }

    @Test
    public void testGetNomJoueurConstructeurComplet(){
        String nomObtenu= joueurConstructeurComplet.getNom();
        assertEquals("Test2",nomObtenu);
    }

    @Test
    public void testGetPseudoJoueurConstructeurComplet(){
        String pseudoObtenu=joueurConstructeurComplet.getPseudo();
        assertEquals("test321", pseudoObtenu);
    }

    @Test
    public void testGetNiveauJoueurConstructeurComplet(){
        int niveauObtenu= joueurConstructeurComplet.getNiveau();
        assertEquals(32,niveauObtenu);
    }

    @Test
    public void testGetPartiesConstructeurComplet(){
        ArrayList<Partie> partiesObtenues=joueurConstructeurComplet.getParties();
        assertEquals(desParties, partiesObtenues);
    }
    @Test
    public void testAjouterPartie(){
        joueurConstructeurComplet.ajouterParties(partieTest);
        desParties.add(partieTest);
        ArrayList<Partie> partiesObtenues=joueurConstructeurComplet.getParties();
        assertEquals(desParties,partiesObtenues);
    }

}
