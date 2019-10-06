/* Classe Case du TP3 de Julien Jacquard, Riyad Trii & Hedi Ouahada
        * Jeu.java
        *Une case du jeu Démineur.
La case est initialement cachée et non marquée. Lorsque la case est mar-
quée,
        * Copyright 2019 H <h@ubuntu>
        *
        * This program is free software; you can redistribute it and/or modify
        * it under the terms of the GNU General Public License as published by
        * the Free Software Foundation; either version 2 of the License, or
        * (at your option) any later version.
        *
        *
        */

//package quebec.crosemont.g04.demineur;

public class Case{

    //=================Proprietes=======================
    protected Type type;
    protected Marque marque;
    protected boolean decouverte;
    //=================Constructeurs==================
    public Case(Type unType){
        type=unType;
        decouverte=false;
        marque=Marque.VIDE;
    }

    public Case(){
        type=Type.VIDE;
        decouverte=false;
        marque=Marque.VIDE;
    }
//=====================Methodes=======================


//Mutateur de la propriété découverte. La case ne
//pouvant pas être rechachée, cette méthode est à sens unique.
    public void decouvrir(){
        decouverte=true;
    }


/*
mutateur de la propriété marque. À chaque appel
de cette méthode, la marque passe successivement de «vide» à
«bombe», à «inconnue» puis revient à «vide».
*/

    public void marquer(){
        if(marque.name().equals("VIDE")) marque=Marque.BOMBE;
        else if (marque.name().equals("BOMBE")) marque=Marque.INCONNU;
        else marque=Marque.VIDE;
    }
//==========================get()-set()=======================
    public Type getType() {
        return type;
    }

    public Marque getMarque() {
        return marque;
    }

    public boolean estDecouverte(){
        return decouverte;
    }

    public String toString() {
        String uneCase="";
        if(decouverte) uneCase+=type.toString();
        else uneCase+=marque.toString();
        return uneCase;
    }
}
