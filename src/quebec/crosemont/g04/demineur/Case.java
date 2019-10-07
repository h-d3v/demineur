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

package quebec.crosemont.g04.demineur;

public class Case{

    //=================Proprietes=======================
    protected Type type;
    protected Marque marque;
    protected boolean decouverte;
    //=================Constructeurs==================
    /*Consttructeur d'un Objet Case avec un Type passe en parametre
    * @param Type unType Enum représentant les différents types possibles de Case :
    *0. VIDE
    *1. BOMBE
    */
    public Case(Type unType){
        type=unType;
        decouverte=false;
        marque=Marque.VIDE;
    }
    /*Constructeur d'un Objet Case sana parametre
     * la marque est vide par degaut
     */
    public Case(){
        type=Type.VIDE;
        decouverte=false;
        marque=Marque.VIDE;
    }
//=====================Methodes=======================


/*
*Mutateur de la propriété découverte. La case ne
*pouvant pas être rechachée, cette méthode est à sens unique.
*/
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
    /*
    *Metgode qui retourne le Type de l'objet Case
    * @return: Type unType
     */

    public Type getType() {
        return type;
    }
    /*
     *Methode qui retourne la marque de l'objet Case
     * @return: Marque uneMarque
     */

    public Marque getMarque() {
        return marque;
    }

    /*
     *Methode qui retourne le booleun decouvert de l'objet Case
     * @return: boolean decouverte
     */
    public boolean estDecouverte(){
        return decouverte;
    }

    /*
    *La représentation de la case en chaîne de caractères :
    *son type si elle est découverte, sa marque sinon.
     */
    public String toString() {
        String uneCase="";
        if(decouverte) uneCase+=type.toString();
        else uneCase+=marque.toString();
        return uneCase;
    }
}