/*
 * main.java
 * 
 * 
 * 
 */
//package quebec.crosemont.g04.demineur;
import java.util.Random;
import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class main{
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in); 
		int largeur=0,hauteur=0;
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
		
		// tant que le joueur ne rentre pas un X et un Y valide, la grille ne sera pas initialiser.
		
		do{ 
			System.out.println("Veuillez entrez le X pour debuter le jeu: ");
			while (!in.hasNextInt()) {
				System.out.println("Cela ne peut etre un X valide");
				System.out.println("Veuillez un X valide pour debuter le jeu: ");
				in.next();
			}
			entreeX = in.nextInt();
			System.out.println("Veuillez entrez un Y valide pour debuter le jeu: ");
			while (!in.hasNextInt()) {
				System.out.println("Cela ne peut etre un Y valide");
				System.out.println("Veuillez entrez le Y pour debuter le jeu: ");
				in.next();
			}
			entreeY=in.nextInt();
		} while (entreeX<0 || entreeX>largeur-1 || entreeY<0 || entreeY>hauteur-1);
		
		grilleJeu.initialiser(entreeX,entreeY,nbBombe);
		System.out.println(grilleJeu.toString());
		String[] chaineTable;
		String  chaine="",option="";
		int x=0,y=0;
		boolean partieReussie=false,partiePerdue=false,partieEnCours=true,bonneChaine=false,matches=false;;
		//new Pattern chainePattern = Pattern.compile("[md](-)[0-9]*(-)[0-9]*");
		String pattern = "[md](-)[0-9]*(-)[0-9]*";
  
		//Tant que la partie n'est pas finie, cette boucle se repete.
		while (partieEnCours){
			do{
				while(matches==false){
				System.out.println("Veuillez entrez la prochaine action, \n m ou d suivi du x ou y de la case (A-X-Y): ");
				chaine=in.next();
				//Matcher matcherChaine=chainePattern.matcher(chaine);
				matches = Pattern.matches(pattern, chaine);
				if(matches==true){
					bonneChaine=true;
					chaineTable=chaine.split("-");
					option=chaineTable[0];
					x = Integer.parseInt(chaineTable[1]);
					y = Integer.parseInt(chaineTable[2]);
				}
				else System.out.println("Entrez une commande valide");
			}
			
		
		}while(x>=largeur||y>hauteur);
			
		
				
			
			if(option.equals("m") || option.equals("M")){
				
				Marque  uneMarque=grilleJeu.marquer(x,y);
				
			}
			else if(option.equals("d") || option.equals("D")){
				Type unType=grilleJeu.decouvrir(x,y);
				if (unType==Type.BOMBE){
					partieEnCours=false;
					grilleJeu.toutReveler();
					}
				else{
					
					partieReussie=grilleJeu.estReussi();
					if(partieReussie){
						partieEnCours=false;
						grilleJeu.toutReveler();
						} 
					}
				}
			
			else System.out.println("\nEntrez une action valide (m ou d) SVP\n");
			
			System.out.println(grilleJeu.toString());
			
		
	}
		//Si la partie est perdue
		if (partieReussie==false){
			System.out.println("Partie PERDUE \n redemarrer le jeu pour essayer de nouveau");
		}
		//Si le partie est gagnee
		else if(partieReussie){
			System.out.println("BRAVO \n VOUS ETES VAINQUEUR");
		}
		
	}
}


	
		


