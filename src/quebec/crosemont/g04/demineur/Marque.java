package quebec.crosemont.g04.demineur;

enum Marque{
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