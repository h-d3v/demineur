package quebec.crosemont.g04.demineur;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestJoueurDAO {
    Joueur cobaye=new Joueur("Roberto", "blob", 3, new ArrayList<Partie>());
    @Test
    public void testLire() throws DAOException{

        Joueur joueurlu=JoueurDao.lire("blob");
        System.out.println(joueurlu.getNiveau());
        assertEquals(joueurlu.getPseudo(),cobaye.getPseudo());
    }
    @Test
    public void testLirePartieParJoueur() throws DAOException{
        ArrayList<Partie> parties=new ArrayList<Partie>();
        parties.add(PartieDao.lire(1));
        parties.add(PartieDao.lire(8));

        Joueur cobaye=new Joueur("Robert", "bob", 3, parties);
        System.out.println(JoueurDao.trouverPartiesParJoueur(cobaye));
        assertEquals(parties.size(),JoueurDao.trouverPartiesParJoueur(cobaye).size());
        for(int i=0; i<parties.size();i++)
        { assertEquals(parties.get(i).getId(),JoueurDao.trouverPartiesParJoueur(cobaye).get(i).getId());
        System.out.println(JoueurDao.trouverPartiesParJoueur(cobaye).get(i).getId());
        }
    }@Test
    public void testAjouterPartieJoueur() throws DAOException{
        Partie partie= new Partie(202, LocalDateTime.of(2019,11,23,21,00,11,2),LocalDateTime.of(2019,11,23,22,00,11),NiveauDifficulte.FACILE);
        ArrayList<Partie> partieJoueur=JoueurDao.trouverPartiesParJoueur(cobaye);



    }
}
