//classe Partie 
//package quebec.crosemont.g04.demineur;
import java.time.LocalDateTime;
public class Partie{
	// //=======================Proprietes================================
    protected int id;
    protected NiveauDifficulte niveauDifficulte;
    protected LocalDateTime dateDebut,dateFin;
    // //=================Constructeurs====================================
    //Constructeur complet
    public Partie(int unId, LocalDateTime uneDateDebut, LocalDateTime uneDateFin, NiveauDifficulte unNiveauDiff)throws IllegalArgumentException{
		if(uneDateFin!=null && uneDateFin.isBefore(uneDateDebut) || uneDateFin.isEqual(uneDateDebut)){
			throw new IllegalArgumentException("La date de fin doit etre null ou apres la date de debut.");
		}
		dateDebut=uneDateDebut;
		dateFin=uneDateFin;
		id=unId;
		niveauDifficulte=unNiveauDiff;
	}
	//constructeur valeurs par defaut
	Partie(NiveauDifficulte unNiveauDiff) throws IllegalArgumentException{
		if(unNiveauDiff==null){
			throw new IllegalArgumentException("Le niveau de la partie ne peut pas etre null");
		}
		id=-1;
		dateDebut=LocalDateTime.now();		
	}
	 // //=================Accesseurs(get/set)====================================
	public int getId(){
		 return id;
	}
	public LocalDateTime getDateDebut(){
		 return dateDebut;
	}
	public LocalDateTime getDateFin(){
		 return dateFin;
	}
	public NiveauDifficulte getNiveauDifficulte(){
		 return niveauDifficulte;
	}
	
	
		 
	
}
