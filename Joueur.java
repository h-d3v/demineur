package quebec.crosemont.g04.demineur;


public class Joueur(){

  //Attributs
  private String nom;
  private String pseudonyme ;
  private int niveau;
  private ArrayList<Partie> parties;

  //Constructeur

  public joueur(String unNom,String unpseudonyme,int unNiveau,ArrayList<Partie> desParties){
    nom = unNom;
    pseudonyme = unpseudonyme;
    niveau = unNiveau;
    partie=desParties;
  }

  //Methodes

  public String getNom(){
    return nom ;

  }

  public String getPseudonyme(){
    return pseudonyme ;

  }

  public int getNiveau(){
    return niveau ;


  }

  public ArrayList<Partie> getParties(){
    return parties ;

  }

  public Partie ajouterPartie(Partie unePartie){
    desParties.add(unePartie);


  }


  }



}
