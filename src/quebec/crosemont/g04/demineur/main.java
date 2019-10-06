/*
 * main.java
 * 
 * 
 * 
 */
 
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
		Grille GrilleJeu=new Grille(largeur,hauteur);
		Case[][] casesJeu=GrilleJeu.cases;
		int nbBombe=(largeur*hauteur)/10;
		
	}
}
	
		


