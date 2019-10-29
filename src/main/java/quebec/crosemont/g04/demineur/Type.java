/* enum Type du TP3 de Julien Jacquard, Riyad Trii & Hedi Ouahada
 * Jeu.java
 *Enum représentant les différents types possibles de Case :
0. VIDE
1. BOMBE
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

public enum Type {
    VIDE,
    BOMBE;
    /* toString pour enum Type,
     * retourne le caractere a afficher selon le Type*/
    public String toString(){
        String caractere="";
        if((this.name()).equals("VIDE")){
            caractere="\u2B1C"; //carrer blanc
        }
        else if((this.name()).equals("BOMBE")){
            caractere="\uD83D\uDCA3"; //bombe
        }
        return caractere;
    }
}