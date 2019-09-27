package quebec.crosemont.g04.demineur;

import java.util.Random;

class Grille{
    private int largeur, hauteur;
    protected Case[][] cases;

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
//Retourne la représentation d’une Case
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


    //!!!!!!!Prends pas en compte que la case (x,y ) est vide !!!!!!!!!!!!!!!!!


    public void  initialiser(int x, int y, int nbBombes){
        Random gen=new Random(1);// Le seed Random est pour les tests seulement, a retirer pour la version finale
        int xx, yy;

        for(int i=0; i<cases.length; i++){
            for(int j=0;j<cases[i].length;j++){
                cases[i][j]=new Case();
            }
        }
        while(nbBombes!=0){
            xx=gen.nextInt(largeur);
            yy=gen.nextInt(hauteur);
            if(!cases[xx][yy].type.equals(Type.BOMBE)){
                cases[xx][yy].type=Type.BOMBE;
                nbBombes--;
            }
        }
    }

    public Type decouvrir(int x, int y){
        Type unType;
        unType=cases[x][y].getType();
        return unType;
    }

    public void toutReveler(){
        for(int i=0; i<cases.length; i++){
            for(int j=0;j<cases[i].length;j++){
                cases[i][j].decouverte=true;
            }
        }
    }
    public boolean estReussi(){
        boolean reussi= false;
        int compteurBombes=0;
        int compteurBombesDecouvertes=0;
        for(int i=0; i<cases.length; i++){
            for(int j=0;j<cases[i].length;j++){
                if(cases[i][j].type.equals(Type.BOMBE)) compteurBombes++;
                if(cases[i][j].marque.equals(Marque.BOMBE)) compteurBombesDecouvertes++;
            }
            if(compteurBombes==compteurBombesDecouvertes) reussi=true;
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

