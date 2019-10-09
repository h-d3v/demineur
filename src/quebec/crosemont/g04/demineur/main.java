/*
 * main.java
 * 
 * 
 * 
 */
package quebec.crosemont.g04.demineur;
import java.util.Random;
import java.util.*;
import java.io.*;


public class main{
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in); 
		int largeur=0,hauteur=0;
		boolean erreurEntree=true;
		//tant qu'un numero valide n'est pas entre, le programme n'avance pas
		do{
			try{
				System.out.println("Veuillez entrez la largeur  de grille choisie: ");
				largeur = Integer.parseInt(in.next());
				System.out.println("Veuillez entrez la hauteur de grille choisie: ");
				hauteur = Integer.parseInt(in.next());
				erreurEntree=false;
			}catch(NumberFormatException e){
				System.out.println("\n Veuillez entree un numero entier positif svp \n");
				in.reset();
				}  
			} while(erreurEntree);
		
		int nbCases=largeur*hauteur;
		
		//tant que la grille ne respecte pas les bonnesDimensions(entre 25 et 2 147 483 647),le jeu ne commence pas ;
		while(hauteur<5 || largeur<5 || nbCases<25 || nbCases>2147483647){
			System.out.println("Veuillez faire une grille qui aura entre 25 et 2 147 483 647 cases \n avec une largeur et hauteur minimale de 5 cases");
			
			erreurEntree=true;
			do{
				try{
					System.out.println("Veuillez entrez la largeur  de grille choisie: ");
					largeur = Integer.parseInt(in.next());
					System.out.println("Veuillez entrez la hauteur de grille choisie: ");
					hauteur = Integer.parseInt(in.next());
					erreurEntree=false;
				}catch(NumberFormatException e){
					System.out.println("\n Veuillez entree un numero entier positif svp \n");
					in.reset();
					}  
				} while(erreurEntree);
			nbCases=largeur*hauteur;
			
	}
		Grille grilleJeu=new Grille(largeur,hauteur);
		int nbBombe=(largeur*hauteur)/10+1;
		int entreeX=0,entreeY=0;
		erreurEntree=true;
		// tant que le joueur ne rentre pas un X et un Y valide, la grille ne sera pas initialiser.
		do{
				try{
					System.out.println("Veuillez entrez le X de la case choisie \n(doit etre entre 0 et la largeur de la grille-1): ");
					entreeX= Integer.parseInt(in.next());
					System.out.println("Veuillez entrez le Y de la case choisie \n(doit etre entre 0 et la largeur de la grille-1): ");
					entreeY= Integer.parseInt(in.next());
					erreurEntree=false;
				}catch(NumberFormatException e){
					System.out.println("\n Veuillez entree un numero entier positif svp \n");
					in.reset();
					}  
				} while(erreurEntree);
				
		
		while(entreeX>=largeur || entreeY>=hauteur || entreeX<0 || entreeY<0){
			erreurEntree=true;
			do{
				try{
					System.out.println("Veuillez entrez le X de la case choisie \n(doit etre entre 0 et la largeur de la grille-1): ");
					entreeX = Integer.parseInt(in.next());
					System.out.println("Veuillez entrez le Y de la case choisie \n(doit etre entre 0 et la largeur de la grille-1): ");
					entreeY = Integer.parseInt(in.next());
					erreurEntree=false;
				}catch(NumberFormatException e){
					System.out.println("\n Veuillez entrer un numero entier positif svp \n");
					in.reset();
					}  
				} while(erreurEntree);
		}
		grilleJeu.initialiser(entreeX,entreeY,nbBombe);
		System.out.println(grilleJeu.toString());
		String[] chaineTable;
		String  chaine="",option="";
		int x=0,y=0;
		boolean partieEnCours=true;
		//Tant que la partie n'est pas finie, cette boucle se repete.
		while (partieEnCours){
			erreurEntree=true;
			while(erreurEntree){
				try{
					System.out.println("Veuillez entrez la prochaine action, \n m ou d suivi du x ou y de la case (A-X-Y): ");
					chaine=in.next();
					chaineTable=chaine.split("-");
					System.out.println(chaine);
					option=chaineTable[0];
					x = Integer.parseInt(chaineTable[1]);
					y = Integer.parseInt(chaineTable[2]);
					erreurEntree=false;
					if(x<0||x>largeur||y<0||y>largeur){
						System.out.println("\n Veuillez entrer l'action(m ou d), suivie d'un X et d'un Y valide de la grille SVP \n SEPARER PAR DES TIRETS (-)");
						erreurEntree=true;
					}
				}catch(NumberFormatException e){
					System.out.println("\n Veuillez entrer l'action(m ou d), suivie d'un X et d'un Y valide de la grille SVP \n SEPARER PAR DES TIRETS (-)");
					in.reset();
				}
				//facon alternative de corriger la mauvaise entree des elements de la chaine de caracteres
				catch(ArrayIndexOutOfBoundsException e){
					System.out.println("\n Veuillez entrer l'action(m ou d), suivie d'un X et d'un Y valide SVP \n SEPARER PAR DES TIRETS (-)");
					in.reset();
				}
			
			}
			
			if(option.equals("m") || option.equals("M")){
				
				Marque  uneMarque=grilleJeu.marquer(x,y);
				
			}
			else if(option.equals("d") || option.equals("D")){
				Type unType=grilleJeu.decouvrir(x,y);
				if (unType==Type.BOMBE){
					partieEnCours=false;
					}

			}
			
			else System.out.println("\nEntrez une action valide (m ou d) SVP\n");
			
			System.out.println(grilleJeu.toString());
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


	
		


