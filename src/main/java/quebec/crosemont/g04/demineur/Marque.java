/*enum Marque du TP3 de Julien Jacquard, Riyad Trii & Hedi Ouahada
 * Jeu.java
 *Enum représentant les différentes marques possibles sur une Case :
0. VIDE
1. BOMBE
2. INCONNUE
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

public enum Marque{
    VIDE,
    BOMBE,
    INCONNU;
    /* toString pour enum Marque,
     * retourne la représentation d’une marque de Case,
     * c’est-à-dire le caractère à afficher pour cette marque.*/
    public String toString(){

        String caractere="";
        if((this.name()).equals("VIDE")){
            caractere="\u2B1C"; // carre blanc
        }
        else if((this.name()).equals("BOMBE")){
            caractere="\uD83D\uDEA9"; // Drapeau rouge
        }
        else if((this.name()).equals("INCONNU")){
            caractere="\u2753"; // Point d'interrogation
        }
        return caractere;
    }
}