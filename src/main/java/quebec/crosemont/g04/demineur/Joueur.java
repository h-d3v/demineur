//Classe Joueur
package quebec.crosemont.g04.demineur;
import java.util.*;
public class Joueur{
    // //=======================Proprietes================================
    protected int niveau;
    protected String nom,pseudo;
    protected ArrayList<Partie> parties;
    // //=================Constructeurs====================================
    //Constructeur complet
    public  Joueur(String unNom, String unPseudo, int unNiveau, ArrayList<Partie> desParties) throws IllegalArgumentException{
        if (unNom.equals("")||unNom==null) throw new IllegalArgumentException("Le nom ne peut pas etre null ou vide");

        if (unPseudo.equals("")||unPseudo==null){
            throw new IllegalArgumentException("Le pseudo ne peut pas etre null ou vide");
        }
        if (unNiveau<0){
            throw new IllegalArgumentException("Le niveau ne peut pas etre inferieur a zero ");
        }
        if (desParties==null) throw new IllegalArgumentException("Les parties ne peuvent pas etre null");

        niveau=unNiveau;
        nom=unNom;
        pseudo=unPseudo;
        parties=desParties;
    }

    //Constructeur avec valeurs par defaut
    public Joueur(String unNom, String unPseudo) throws IllegalArgumentException{
        if (unNom.equals("") || unNom==null){
            throw new IllegalArgumentException("Le nom ne peut pas etre null ou vide");
        }
        if (unPseudo.equals("") || unPseudo==null){
            throw new IllegalArgumentException("Le pseudo ne peut pas etre null ou vide");
        }

        niveau=0;
        nom=unNom;
        pseudo=unPseudo;
        parties= new ArrayList<Partie>();
    }
    // //=================Accesseurs(get/set)====================================
    public String getNom(){
        return nom;
    }

    public String getPseudo(){
        return pseudo;
    }

    public int getNiveau(){
        return niveau;
    }

    public ArrayList<Partie> getParties(){
        return parties;
    }

    // //=================Methodes====================================
    public void ajouterParties(Partie unePartie){

        if (unePartie==null){
            throw new IllegalArgumentException("Les parties ne peuvent pas etre null");
        }
        parties.add(unePartie);
    }




}
