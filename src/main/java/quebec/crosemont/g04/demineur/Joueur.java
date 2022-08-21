//Classe Joueur
package quebec.crosemont.g04.demineur;
import java.util.*;
public class Joueur{
	// //=======================Proprietes================================
	protected int niveau;
	protected String pseudo;
	protected ArrayList<Partie> parties;
	// //=================Constructeurs====================================

	/**
	 *Constructeur complet
	 * @param unPseudo String le pseudo d'un joueur
	 * @param desParties ArrayList<Partie>, la liste de parties du joueur
	 * @throws IllegalArgumentException si le pseudo est null ou vide
	 * @throws IllegalArgumentException si la liste des parties est null
	 */
	public  Joueur( String unPseudo,  ArrayList<Partie> desParties) throws IllegalArgumentException{

		if (unPseudo.equals("")||unPseudo==null){
			throw new IllegalArgumentException("Le pseudo ne peut pas etre null ou vide");
		}

		if (desParties==null) throw new IllegalArgumentException("Les parties ne peuvent pas etre null");

		pseudo=unPseudo;
		parties=desParties;
	}

	/**Constructeur avec valeurs par defaut
	 * @param unPseudo
	 * @throws IllegalArgumentException si le pseudo est null ou vide
	 */
	public Joueur(String unPseudo) throws IllegalArgumentException{
		if (unPseudo.equals("") || unPseudo==null){
			throw new IllegalArgumentException("Le pseudo ne peut pas etre null ou vide");
		}

		niveau=0;

		pseudo=unPseudo;
		parties= new ArrayList<Partie>();
	}
	// //=================Accesseurs(get/set)====================================
	/**
	 *Accesseur de de l'attribut pseudo du joueur
	 * @return String le pseudo du joueur
	 */
	public String getPseudo(){
		return pseudo;
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

	public void setParties(ArrayList<Partie> parties) {
		if (parties==null) throw new IllegalArgumentException("Les parties ne peuvent pas etre null");
		this.parties = parties;
	}


	public String toString() {
		String chaine="";
		chaine+=pseudo+" ("+niveau+") ";
		return chaine;
	}

}
