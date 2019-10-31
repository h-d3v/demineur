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

public class Grille{

    //=======================Proprietes================================
    protected int largeur, hauteur;
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

    public Case getCase(int x, int y) throws IllegalArgumentException{
        if(x>largeur || x<0 || y>hauteur || y<0) {
            throw new IllegalArgumentException("Les coordonees doivent etre comprises entre 0 et " + largeur + "pour la largeur 0 et" +
                    hauteur + "pour la hauteur");
        }
        Case uneCase;
            uneCase=cases[x][y];
        return uneCase;
    }
//methode qui etourne la représentation en chaine de caractere d’une Case
//sur la Grille.
    protected String getFaceCase(int x, int y) throws IllegalArgumentException{
        if(x>largeur || x<0 || y>hauteur || y<0){
            throw new IllegalArgumentException("Les coordonees doivent etre comprises entre 0 et "+largeur+ "pour la largeur 0 et"+
                    hauteur+"pour la hauteur"
            );
        }
        String faceCase=cases[x][y].toString();
        if (cases[x][y].decouverte && cases[x][y].getType()!=Type.BOMBE){
            faceCase=" ";
            if(compterVoisins(x,y)>0){
                faceCase+=compterVoisins(x,y);
            }else faceCase+=" ";
        }

            return faceCase;
    }


/*
Retourne le nombre de voisins d’une
case de coordonnees(x,y), sur lesquels se trouvent une bombe
@param: int x : la coordonee x representant la largeur
@param y : la coordonee y representant la largeur
@return  int nbBombes le nombres de bombes sur les cases entourant la case de coordonnee x,y
*/
protected int compterVoisins(int x, int y){
        assert x>=0;
        assert  y>=0;
        assert x<largeur;
        assert y<hauteur;
        int compteur=0;
        int ecartXMin=1;
        int ecartXMax=1;
        int ecartYMin=1;
        int ecartYMax=1;

        if(x==0) ecartXMin=0;
        if(x==largeur-1) ecartXMax=0;
        if(y==0) ecartYMin=0;
        if(y==hauteur-1) ecartYMax=0;

        for(int i=x-ecartXMin; i<=x+ecartXMax;i++){
            for (int j=y-ecartYMin; j<=y+ecartYMax; j++){
                if (cases[i][j].type==Type.BOMBE) compteur++;
            }
        }


        return compteur;
    }



    public void  initialiser(int x, int y, int nbBombes) throws IllegalArgumentException{
        if(x>largeur || x<0 || y>hauteur || y<0) {
            throw new IllegalArgumentException("Les coordonees doivent etre comprises entre 0 et " + largeur + "pour la largeur 0 et" +
                    hauteur + "pour la hauteur");
        }
        if(nbBombes>=largeur*hauteur) throw new IllegalArgumentException("Le nombre de bombes doit etre inferieur au nommbre de cases de la grille");
        assert nbBombes>=0;
        assert x>=0;
        assert  y>=0;
        assert x<largeur;
        assert y<hauteur;
        Random gen=new Random();
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
            if( !(xx==x && yy==y)) {
                if (!cases[xx][yy].type.equals(Type.BOMBE)) {
                    cases[xx][yy].type = Type.BOMBE;
                    nbBombes--;
                }
            }

        }
        this.decouvrir(x, y);
    }
/* Fonction qui decouvre(passe l'attribut decouverte a true) une case de coordonee x,y et decouvre toutes les cases vides liees entre elles et decouvrent les cases adjacentes a une bombe
* @param int x : la coordonee x representant la largeur
*@param int y : la coordonee y representant la largeur
* @return Type : le Type de case
*
* */
    public Type decouvrir(int x, int y){
        assert x>=0;
        assert  y>=0;
        assert x<largeur;
        assert y<hauteur;
		Case uneCase=cases[x][y];
		if(uneCase.getType()==Type.VIDE) {
            uneCase.decouvrir();
        }
        Type unType=uneCase.getType();
        
        if(cases[x][y].type==Type.VIDE&&compterVoisins(x,y)==0 ) {


            int ecartXMin = 1;
            int ecartXMax = 1;
            int ecartYMin = 1;
            int ecartYMax = 1;

            if (x == 0) ecartXMin = 0;
            if (x == largeur - 1) ecartXMax = 0;
            if (y == 0) ecartYMin = 0;
            if (y == hauteur - 1) ecartYMax = 0;

            for (int i = x - ecartXMin; i <= x + ecartXMax; i++) {
                for (int j = y - ecartYMin; j <= y + ecartYMax; j++) {
                    if (cases[i][j].type == Type.VIDE && !cases[i][j].decouverte&& compterVoisins(i, j)==0) {
                        decouvrir(i, j);
                    }
                    else if (cases[i][j].type == Type.VIDE && !cases[i][j].decouverte&& compterVoisins(i, j)>0){
                        cases[i][j].decouvrir();
                    }
                }
            }
        }
        
        return unType;
    }
    
    
/*
    Methode qui marque la case aux coordonnee donnee
    * @param int x : la coordonee x representant la largeur
    *@param int y : la coordonee y representant la largeur
    *@return Marque unMarque : la marque de la case correspondante

    */
public Marque marquer(int x, int y) {
        assert x>=0;
        assert  y>=0;
        assert x<largeur;
        assert y<hauteur;
		Marque uneMarque;
		Case uneCase=cases[x][y];
		uneCase.marquer();
		uneMarque=uneCase.getMarque();
		return uneMarque;
	}
	

//Methode qui revele toutes les cases Bombes
    public void toutReveler(){
        for(int i=0; i<cases.length; i++){
            for(int j=0;j<cases[i].length;j++){
                if (cases[i][j].getType() == Type.BOMBE) {
                    cases[i][j].decouverte=true;
                }

            }
        }
    }


/* Doit decouvrir la case aux cordonnees donnees, mit en commentaire,
 * voir decouvrir en haut pour la version complete.
    public Type decouvrir(int x, int y){
        Type unType;
        Case uneCase=cases[x][y];
        uneCase.decouvrir();
        unType=uneCase.getType();
        return unType;
    }*/

/* Methode qui erifie si toutes les cases du jeux sont decouvertes
* @return  boolean reussi : le booleen reussi retourne true si la partie est gagnee
*
* */
public boolean estReussi(){
		boolean reussi=false;
		int casesBombes=0, casesDecouvertes=0;


		for(int i=0; i<cases.length; i++){
            for(int j=0;j<cases[i].length;j++){
                if (cases[i][j].getType()==Type.BOMBE){
					casesBombes+=1;
					}
                if (cases[i][j].estDecouverte()){
                    casesDecouvertes++;
                }
            }
        }
        if(casesDecouvertes==largeur*hauteur-casesBombes){
			reussi=true;
			}
    //System.out.println("casesBombes "+casesBombes+ "casesVidesDecouvertes "+casesDecouvertes+"reussi : "+reussi);//Pour tests
		return reussi;
    }

//methode toString de la grille

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

