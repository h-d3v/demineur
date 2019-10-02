/* Classe Grille du TP3 de Julien Jacquard, Riyad Trii & Hedi Ouahada
 * Jeu.java
 *Une case du jeu Démineur.
 *La case est initialement cachée et non marquée. Lorsque la case est mar-
 *quée, la marque passe successivement de «vide» à «bombe» puis à «incon-
 *nue».
 * Copyright 2019 H <h@ubuntu>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 *
 */

package quebec.crosemont.g04.demineur;

import java.util.Random;

class Grille{

    //=======================Proprietes================================
    private int largeur, hauteur;
    protected Case[][] cases;
    //=================Constructeurs====================================

    public Grille(int uneLargeur, int uneHauteur) throws IllegalArgumentException{
        if(uneLargeur<5||uneLargeur>=Integer.MAX_VALUE) throw new IllegalArgumentException("La largeur de la grille doit etre entre 5 et " +Integer.MAX_VALUE);
        if(uneHauteur<5||uneHauteur>=Integer.MAX_VALUE) throw new IllegalArgumentException("La largeur de la grille doit etre entre 5 et " +Integer.MAX_VALUE);
        largeur=uneLargeur;
        hauteur=uneHauteur;
        cases = new Case[uneLargeur][uneHauteur];
    }

    public Grille(){
        largeur=10;
        hauteur=10;
        cases= new Case[10][10];
    }


    //=============Methodes======================

//=======================get()-set()==================================
    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Case getCase(int x, int y){
        Case uneCase;
            uneCase=cases[x][y];
        return uneCase;
    }
//methode qui etourne la représentation en chaine de caractere d’une Case
//sur la Grille.
    public String getFaceCase(int x, int y){

        String faceCase=cases[x][y].toString();
        return faceCase;
    }
//Retourne le nombre de voisins d’une
//case sur lesquels se trouvent une bombe
    public int compterVoisins(int x, int y){
        int compteur=0;
            for(int i=x-1;i<=x+1;i++){
                for(int j=y-1; j<=y+1;j++){
                    try{
                        if (cases[i][j].type==Type.BOMBE) compteur++;}
                    catch (ArrayIndexOutOfBoundsException ignored){}
                }
            }
        return compteur;
    }
//Constitue la grille de Cases aléatoire-
//ment, sachant que la case aux coordonnées (x,y) doit être vide.


    //!!!!!!!Prends pas en compte que la case (x,y ) est vide ni la gestion d'erreur de l'attribut nbBombes !!!!!!!!!!!!!!!!!


    public void  initialiser(int x, int y, int nbBombes){
        Random gen=new Random(1);// Le seed Random est pour les tests seulement, a retirer pour la version finale
        int xx, yy;
        //Remplir les cases de la grille avec les objets Case
        for(int i=0; i<cases.length; i++){
            for(int j=0;j<cases[i].length;j++){
                cases[i][j]=new Case();
            }
        }
        while(nbBombes!=0){
            //initialiation des coordonnees de la case a peupler par une bombe
            xx=gen.nextInt(largeur);
            yy=gen.nextInt(hauteur);
            if(!cases[xx][yy].type.equals(Type.BOMBE) || !(xx==x && yy==y)){
                cases[xx][yy].type=Type.BOMBE;
                nbBombes--;
            }
        }
    }
// A completer, doit decouvrir les cases voisines
    public Type decouvrirVoisines(int x, int y){
        Type unType;
        Case uneCase=cases[x][y];
        unType=uneCase.getType();
        return unType;
    }
    
// Doit decouvrir la case aux cordonnees donnees
    public Type decouvrir(int x, int y){
        Type unType;
        Case uneCase=cases[x][y];
        uneCase.decouvrir();
        unType=uneCase.getType();
        return unType;
    }
    
    //Methode qui marque la case aux coordonnee donnee
	public Marque marquer(int x, int y){
		Marque uneMarque;
		Case uneCase=cases[x][y];
		uneCase.marquer();
		uneMarque=uneCase.getMarque();
		return uneMarque;
	}
	
//Methode qui revele toutes les cases
    public void toutReveler(){
        for(int i=0; i<cases.length; i++){
            for(int j=0;j<cases[i].length;j++){
                cases[i][j].decouvrir();
            }
        }
    }
    

// Methode qui vérifie que le jeu est réussi ou non.
    public boolean estReussi(){
		boolean reussi=false;
		int casesVides=0, casesVidesDecouvertes=0;
		Case uneCase, uneCaseVide;
		for(int i=0; i<cases.length; i++){
            for(int j=0;j<cases[i].length;j++){
                uneCase=cases[i][j];
                if (uneCase.getType()==VIDE){
					uneCaseVide=uneCase;
					casesVides+=1;
					}
            }
            if (uneCaseVide.estDecouverte()==true){
				casesVideDecouvertes+=1;
				}
        }
        if(casesVides==casesVidesDecouvertes){
			reussi=true;
			}
		return reussi;
    }

    public String toString(){
	String res="   ";
	for(int i=0;i<largeur;i++){
	    res+=i+(i<10?"  ":" ");
	}
	res+="\n  ╔";
	for(int i=0;i<largeur-1;i++){
	    res+="══╦";
	}
	res+="══╗\n 0";
	for(int j=0;j<hauteur;j++){
	    for(int i=0;i<largeur;i++){
		res+="║" + getFaceCase(i,j);
	    }
	    res+="║";
	    if(j==hauteur-1) break;

	    res+="\n  ╠";

	    for(int i=0;i<largeur-1;i++){
		res+="══╬";
	    }
	    res+="══╣\n" +(j<9?" "+(j+1):(j+1));

	}
	res+="\n  ╚";
	for(int i=0;i<largeur-1;i++){
	    res+="══╩";
	}
	res+="══╝";

	return res;
    }
}

