package quebec.crosemont.g04.demineur;

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

    public void decouvrir(){
        decouverte=true;
    }
    public void marquer(){
        if(marque.name().equals("VIDE")) marque=Marque.BOMBE;
        else if (marque.name().equals("BOMBE")) marque=Marque.INCONNU;
        else marque=Marque.VIDE;
    }

    public Type getType() {
        return type;
    }

    public Marque getMarque() {
        return marque;
    }

    public String toString() {
        String uneCase="";
        if(decouverte) uneCase+=type.toString();
        else uneCase+=marque.toString();
        return uneCase;
    }
}