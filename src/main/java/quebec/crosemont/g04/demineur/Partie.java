package quebec.crosemont.g04.demineur;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Partie {
    private static final AtomicInteger compteurId=  new AtomicInteger(Integer.MAX_VALUE);
    private int id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin=null;
    private NiveauDifficulte niveauDifficulte;

    public Partie(int unID, LocalDateTime uneDateDebut, LocalDateTime uneDateFin, NiveauDifficulte unNiveauDifficulte){
        id=unID;
        dateDebut=uneDateDebut;
        dateFin=uneDateFin;
        niveauDifficulte=unNiveauDifficulte;
    }
    public Partie(NiveauDifficulte unNiveauDifficulte){
        id=compteurId.getAndDecrement();
        niveauDifficulte=unNiveauDifficulte;
        dateDebut= LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public NiveauDifficulte getNiveauDifficulte() {
        return niveauDifficulte;
    }

    public int getTemps() {
        Duration duree = Duration.between(dateDebut, dateFin);
        long tempsLong= duree.toSeconds();
        return (int) tempsLong;
    }
    public void terminer(){
        dateFin=LocalDateTime.now();
    }


    public void setTemps(int unTemps){
        int tempsDifference = unTemps- getTemps();
        if (tempsDifference>0) {
            dateFin = dateFin.plusSeconds(tempsDifference);
        }
        else if (tempsDifference<0) {
            dateFin = dateFin.minusSeconds(Math.abs(tempsDifference));
        }
    }
}
