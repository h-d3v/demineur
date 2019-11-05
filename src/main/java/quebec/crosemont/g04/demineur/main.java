/*Programme principale du jeu démineur en
 * ligne de commande.
 *Fait par Julien Jacquard, Riyad Trii & Hédi Ouahada
 */
package quebec.crosemont.g04.demineur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class main{
	Grille grille;

	ArrayList<Partie> parties;


	public static void main (String[] args) throws DAOException {
		Scanner in = new Scanner(System.in);
		ArrayList<Joueur> joueurs=JoueurDao.trouverTout();
		System.out.println("Entrez votre pseudo: ");
		String pseudoJoueurAChercher=in.next();
		Joueur unJoueur=JoueurDao.lire(pseudoJoueurAChercher);
		boolean nouveau=false,matches;
		while(unJoueur==null){
			System.out.println("Pseudo non existant, voulez devenir un nouveau joueur? o/n");
			String reponse=in.next();
			if(reponse=="o"||reponse=="oui"){
				nouveau=true;
				break;
			}
			System.out.println("Entrez votre pseudo: ");
			pseudoJoueurAChercher=in.next();
			unJoueur=JoueurDao.lire(pseudoJoueurAChercher);
			matches=false;
			String pseudo = null,nom = null;
			if(nouveau){

				while (matches==false){
					System.out.println("Entrez votre nom: ");
					nom=in.next();
					String pattern = "[A-Z][a-z]*";
					matches=Pattern.matches(pattern,nom);
				}
				matches=false;
				while (matches==false){
					System.out.println("Entrez le pseudo que vous desirez: ");
					pseudo=in.next();
					String pattern = "\\w";
					matches=Pattern.matches(pattern,pseudo);
				}
				unJoueur= new Joueur(nom,pseudo);
				JoueurDao.ajouter(unJoueur);
			}
			joueurs=JoueurDao.trouverTout();
			int i=1;
			String meilleursJoueurs="";
			while (i<11) {
				for (Joueur joueur : joueurs) {
					meilleursJoueurs+="\n"+i+ " : " + joueur.toString();
				}
				i++;
			}
			System.out.println(meilleursJoueurs);
		}
		System.out.println("* Facile : 9x9, 10 mines\n" +" * Moyen : 16x16, 40 mines\n" +" * Difficile : 24x24, 99 mines");
		//NiveauDifficulte=
		int largeur=0,hauteur=0;

		Partie partie= new Partie(11, LocalDateTime.of(2019,11,23,21,00,11,2),LocalDateTime.of(2019,11,23,22,00,11,2),NiveauDifficulte.DIFFICILE);

		//tant qu'un numero valide n'est pas entre, le programme n'avance pas, la grille doit etre conforme aux dimensions
		//Entre 5*5 et integer_maxValue** cases

		do{
			System.out.println("Veuillez entrez la largeur  de grille choisie: ");
			while (!in.hasNextInt()) {
				System.out.println("Cela ne peut etre une largeur valide");
				System.out.println("Veuillez entrez la largeur  de grille choisie: ");
				in.next();
			}
			largeur = in.nextInt();
			System.out.println("Veuillez entrez la hauteur  de grille choisie: ");
			while (!in.hasNextInt()) {
				System.out.println("Cela ne peut etre une hauteur valide");
				System.out.println("Veuillez entrez la hauteur  de grille choisie: ");
				in.next();
			}
			hauteur=in.nextInt();
		} while (hauteur<5 || hauteur>=Integer.MAX_VALUE ||largeur<5 || largeur>=Integer.MAX_VALUE);
		int nbCases=largeur*hauteur;


		Grille grilleJeu=new Grille(largeur,hauteur);
		int nbBombe=(largeur*hauteur)/10+1;
		int entreeX=0,entreeY=0;
		
		  //creation d'une grille vierge pour le premier affichage
		Grille grilleVierge= new Grille(largeur,hauteur);
        for(int i=0; i<grilleVierge.cases.length; i++){
            for(int j=0;j<grilleVierge.cases[i].length;j++){
                grilleVierge.cases[i][j]=new Case();
            }
        }
		

		// tant que le joueur ne rentre pas un X et un Y valide, la grille ne sera pas initialiser.

		do{
			//affichage dela grille vierge
			System.out.println(grilleVierge.toString());
			System.out.println("Veuillez entrez le X pour debuter le jeu: ");
			while (!in.hasNextInt()) {
				System.out.println(grilleVierge.toString());
				System.out.println("Cela ne peut etre un X valide");
				System.out.println("Veuillez un X valide pour debuter le jeu: ");
				in.next();
			}
			entreeX = in.nextInt();
			System.out.println("Veuillez entrez un Y valide pour debuter le jeu: ");
			while (!in.hasNextInt()) {
				 System.out.println(grilleVierge.toString());
				System.out.println("Cela ne peut etre un Y valide");
				System.out.println("Veuillez entrez le Y pour debuter le jeu: ");
				in.next();
			}
			entreeY=in.nextInt();
			if  (entreeX<0 || entreeX>largeur-1 || entreeY<0 || entreeY>hauteur-1) System.out.println("Veuillez entrez une coordonnee valide SVP"); ;
		} while (entreeX<0 || entreeX>largeur-1 || entreeY<0 || entreeY>hauteur-1);

		grilleJeu.initialiser(entreeX,entreeY,nbBombe);
		String[] chaineTable;
		String  chaine="",option="";
		int x=0,y=0;

		boolean partieEnCours=true;
	    //création du patron de l'action a entrée
		String pattern = "[md](-)[0-9]*(-)[0-9]*";

		//Tant que la partie n'est pas finie, cette boucle se repete.
		while (partieEnCours){
			System.out.println(grilleJeu.toString());
			do{
				matches=false;
				while(matches==false){
					System.out.println("Veuillez entrez la prochaine action, \n m ou d suivi du x ou y de la case (A-X-Y): ");
					chaine=in.next();
					
					matches = Pattern.matches(pattern, chaine);
					if(matches==true){
						chaineTable=chaine.split("-");
						option=chaineTable[0];
						x = Integer.parseInt(chaineTable[1]);
						y = Integer.parseInt(chaineTable[2]);
						if(x>=largeur||y>=hauteur) System.out.println(grilleJeu.toString()+"\nEntrez une coordonne qui se trouve dans la grille SVP");

					}
					else System.out.println(grilleJeu.toString()+"\nEntrez une commande valide soit m ou d suivi du x ou y de la case (A-X-Y): ");
				}


			}while(x>=largeur||y>=hauteur);

			if(option.equals("m") || option.equals("M")){

				grilleJeu.marquer(x,y);

			}
			else if(option.equals("d") || option.equals("D")){
				Type unType=grilleJeu.decouvrir(x,y);
				if (unType==Type.BOMBE){
					partieEnCours=false;
				}

			}

			else System.out.println("\nEntrez une action valide (m ou d) SVP\n");
			
			
			
			if(grilleJeu.estReussi()){
				partieEnCours=false;
			}


		}
		//Affichage des reultats


		//Si la partie est perdue
		if (!grilleJeu.estReussi()){
			grilleJeu.toutReveler();
			System.out.println(grilleJeu);
			System.out.println("Partie PERDUE \n redemarrer le jeu pour essayer de nouveau");
		}
		//Si le partie est gagnee
		else{
			System.out.println(grilleJeu);
			System.out.println("BRAVO \n VOUS ETES VAINQUEUR");
		}

	}
}



