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
		int largeur=0,hauteur=0;
		boolean etatGrille=false;
		largeur=ES.lireEntier("Veuillez entrez la largeur  de grille choisie: ");
		hauteur=ES.lireEntier("Veuillez entrez la hauteur de grille choisie: ");
		int nbCases=largeur*hauteur;
		
		//tant que la grille ne respecte pas les bonnesDimensions(entre 5 et 2 147 483 647),le jeu ne commence pas ;
		while(nbCases<5 || nbCases>2147483647){
			System.out.println("Veuillez faire une grille qui aura entre 5 et 2 147 483 647 cases");
			largeur=ES.lireEntier("Veuillez entrez la largeur  de grille choisie: ");
			hauteur=ES.lireEntier("Veuillez entrez la hauteur de grille choisie: ");
			nbCases=largeur*hauteur;
			
	}
		Grille GrilleJeu=new Grille(largeur,hauteur);
		Case[][] casesJeu=GrilleJeu.cases;
		int nbBombe=(largeur*hauteur)/10;
		
		
		
		
	}
}

