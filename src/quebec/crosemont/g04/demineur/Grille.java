package quebec.crosemont.g04.demineur;

import java.util.Random;

class Grille{
    
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

