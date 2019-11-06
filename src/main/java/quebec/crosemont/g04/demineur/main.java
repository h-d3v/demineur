/*Programme principale du jeu démineur en
 * ligne de commande.
 *Fait par Julien Jacquard, Riyad Trii & Hédi Ouahada
 */
package quebec.crosemont.g04.demineur;
import java.util.*;
import java.util.regex.Pattern;

public class main{
	Grille grille;

	ArrayList<Partie> parties;


	public static void main (String[] args) throws DAOException {
		//Le programme demande au joueur son pseudo, si il n'est pas trouvé, il devra entrer son nom et un nouveau pseudo.
		Scanner in = new Scanner(System.in);
		ArrayList<Joueur> joueurs=JoueurDao.trouverTout();
		System.out.println("Entrez votre pseudo: ");
		String pseudoJoueurAChercher=in.next();
		Joueur unJoueur=JoueurDao.lire(pseudoJoueurAChercher);
		boolean nouveau=false,matches;
		//le pseudo n'es pas trouvé du premier coup;

		while(unJoueur==null) {
			System.out.println("Pseudo non existant, voulez devenir un nouveau joueur? o/n");
			String reponse = in.next();
			if (reponse.equals("o") || reponse.equals("oui")) {
				nouveau = true;
			}
			//Si c'est un nouveau joueur
			matches = false;
			if (nouveau==true) {
				String pseudoNouveauJoueur = null, nom = null;
				while (matches == false) {
					System.out.println("Entrez votre nom: ");
					nom = in.next();
					String pattern = "[A-Z][a-z]*";
					matches = Pattern.matches(pattern, nom);
				}
				matches = false;
				while (matches == false) {
					System.out.println("Entrez le pseudo que vous desirez: ");
					pseudoNouveauJoueur = in.next();
					String pattern = "[a-zA-Z]*[0-9]*";
					matches = Pattern.matches(pattern, pseudoNouveauJoueur);
				}
				unJoueur = new Joueur(nom, pseudoNouveauJoueur);
				JoueurDao.ajouter(unJoueur);
				unJoueur=JoueurDao.lire(pseudoNouveauJoueur);
			}
			else{
				System.out.println("Entrez votre pseudo: ");
				pseudoJoueurAChercher = in.next();
				unJoueur=JoueurDao.lire(pseudoJoueurAChercher);
			}
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
			int position=meilleursJoueurs.indexOf(unJoueur.toString());
			if(position==-1){
				meilleursJoueurs+="\n"+joueurs.indexOf(unJoueur)+ " : " + unJoueur.toString();
			}
			System.out.println(meilleursJoueurs);
		//}
		//Choix du niveau de diffucultée
		System.out.println("* Facile : 9x9, 10 mines\n" +" * Moyen : 16x16, 40 mines\n" +" * Difficile : 24x24, 99 mines");
		String entreeNiveauDiff=in.next();

		//Validation du niveau de difficultée
		while (!entreeNiveauDiff.matches("(?i)(facile)")&&!entreeNiveauDiff.matches("(?i)(moyen)")&&!entreeNiveauDiff.matches("(?i)(difficile)")){
			System.out.println("* Facile : 9x9, 10 mines\n" +" * Moyen : 16x16, 40 mines\n" +" * Difficile : 24x24, 99 mines");
			entreeNiveauDiff=in.next();
		}

		int largeur=0,hauteur=0;
		NiveauDifficulte niveauDiffPartie=null;
		switch(entreeNiveauDiff.toLowerCase()){
			case "facile": niveauDiffPartie=NiveauDifficulte.FACILE; largeur=9;hauteur=9;break;

			case "moyen": niveauDiffPartie=NiveauDifficulte.MOYEN; largeur=16;hauteur=16;break;

			case "difficile\\i": niveauDiffPartie=NiveauDifficulte.DIFFICILE; largeur=24;hauteur=24;break;
		}

		ArrayList<Partie> partiesNiveauDiff=PartieDao.trouverPartieParDifficulte(niveauDiffPartie);

		//Début de la nouvelle partie
		Partie partieCourrante= new Partie(niveauDiffPartie);

		/*Partie du tp1 mise en commentaire pour le tp2:
		tant qu'un numero valide n'est pas entre, le programme n'avance pas, la grille doit etre conforme aux dimensions
		Entre 5*5 et integer_maxValue** cases
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
		int nbCases=largeur*hauteur;*/

		Grille grilleJeu=new Grille(largeur,hauteur);
		int nbBombe=(largeur*hauteur)/10+1;
		int entreeX=0,entreeY=0;
		
		  //creation d'une grille vierge pour le premier affichage
		Grille grilleVierge= new Grille(largeur,hauteur);
        for(i=0; i<grilleVierge.cases.length; i++){
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

		//Si la partie est perdue
		if (!grilleJeu.estReussi()){
			grilleJeu.toutReveler();
			System.out.println(grilleJeu);
			System.out.println("Partie PERDUE \n redemarrer le jeu pour essayer de nouveau");
			//On termine la partie et on l'enregistre dans la db
			partieCourrante.terminer();
			PartieDao.ajouter(partieCourrante);
			JoueurDao.ajouterPartieAJoueur(unJoueur, partieCourrante);
		}
		//Si la partie est gagnee
		else{
			System.out.println(grilleJeu);
			System.out.println("BRAVO \n VOUS ETES VAINQUEUR");
			//On termine la partie et on l'enregistre dans la db
			partieCourrante.terminer();
			PartieDao.ajouter(partieCourrante);
			JoueurDao.ajouterPartieAJoueur(unJoueur, partieCourrante);
		}

	}
}



