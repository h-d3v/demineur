package quebec.crosemont.g04.demineur;

enum Type {
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
            caractere="\uD83D\uDEA9"; //bombe
        }
        return caractere;
    }
}