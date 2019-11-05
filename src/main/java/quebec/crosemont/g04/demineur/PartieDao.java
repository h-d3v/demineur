package quebec.crosemont.g04.demineur;

import java.sql.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PartieDao extends Dao<Partie> {

    public static Partie lire(Object id) throws DAOException {
        Partie partie=null;
        Connection cnx;
        int idint= (int) id;
        try{
            cnx=SQLConnectionFactory.getConnection();

            PreparedStatement stmt = cnx.prepareStatement("SELECT id,niveauDifficulte, dateDebut, dateFin FROM Partie WHERE id = ?");
            stmt.setInt(1, idint);

            ResultSet rs = stmt.executeQuery();
            partie=importerPartie(rs);

            cnx.close();

        } catch(SQLException ex){
            throw new DAOException(ex);
        }

        return partie;
    }

    public static Partie ajouter(Partie unePartie) throws DAOException {
        Partie partie=null;
        Connection cnx;
        try{
            cnx=SQLConnectionFactory.getConnection();

            PreparedStatement stmt = cnx.prepareStatement("INSERT INTO Partie (niveauDifficulte, dateDebut, dateFin, id) VALUES (?,?,?,?)");
            int diff = unePartie.getNiveauDifficulte().ordinal();
            Timestamp dateDebut = Timestamp.valueOf(unePartie.getDateDebut());
            Timestamp dateFin = Timestamp.valueOf(unePartie.getDateFin());
            int id =unePartie.getId();
            stmt.setInt(1,diff);
            stmt.setTimestamp(2, dateDebut);
            stmt.setTimestamp(3, dateFin);
            stmt.setInt(4, id);

            stmt.execute();

            cnx.close();
            partie=lire(unePartie.getId());
            return partie;


        } catch(SQLException ex){
            throw new DAOException(ex);
        }

    }

    public static Partie modifier(Partie unePartie) throws DAOException {
        Connection cnx;
        Partie partie=null;
        try{
            cnx=SQLConnectionFactory.getConnection();

            int diff = unePartie.getNiveauDifficulte().ordinal();
            Timestamp dateDebut = Timestamp.valueOf(unePartie.getDateDebut());
            Timestamp dateFin = Timestamp.valueOf(unePartie.getDateFin());
            int id =unePartie.getId();
            PreparedStatement stmt = cnx.prepareStatement("UPDATE Partie SET  niveauDifficulte=?, dateDebut=?, dateFin=? WHERE id=?");

            stmt.setInt(1,diff);
            stmt.setTimestamp(2, dateDebut);
            stmt.setTimestamp(3, dateFin);
            stmt.setInt(4, id);

            stmt.execute();


            cnx.close();
            return lire(id);

        } catch(SQLException  ex){
            throw new DAOException(ex);
        }
    }

    public static void supprimer(Partie unePartie) throws DAOException {
        Connection cnx;
        try{
            cnx=SQLConnectionFactory.getConnection();
            int id = unePartie.getId();
            PreparedStatement stmt = cnx.prepareStatement("DELETE FROM Partie WHERE id=?");
            stmt.setInt(1,id);


            stmt.execute();

            cnx.close();

    } catch(SQLException ex){
            throw new DAOException(ex);
        }
    }
    public static ArrayList<Partie> trouverTout()throws DAOException{
        ArrayList<Partie> parties=new ArrayList<Partie>();
        Connection cnx;
        try{
            cnx=SQLConnectionFactory.getConnection();

            PreparedStatement stmt = cnx.prepareStatement("SELECT id,niveauDifficulte, dateDebut, dateFin FROM Partie");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                parties.add(importerPartie(rs));
            }

            cnx.close();

        } catch(SQLException ex){
            throw new DAOException(ex);
        }


        return parties;
    }
    public static ArrayList<Partie> trouverPartieParDifficulte(NiveauDifficulte unNiveau) throws DAOException{
        ArrayList<Partie> parties=new ArrayList<Partie>();
        Connection cnx;
        try{
            cnx=SQLConnectionFactory.getConnection();

            PreparedStatement stmt = cnx.prepareStatement("SELECT id,niveauDifficulte, dateDebut, dateFin FROM Partie WHERE niveauDifficulte=?");
            stmt.setInt(1, unNiveau.ordinal());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                parties.add(importerPartie(rs));
            }

            cnx.close();

        } catch(SQLException ex){
            throw new DAOException(ex);
        }


        return parties;
    }
    public static   ArrayList<Partie> trouverPartieParDate(LocalDateTime uneDate) throws DAOException{
        ArrayList<Partie> parties=new ArrayList<Partie>();
        Connection cnx;
        try{
            cnx=SQLConnectionFactory.getConnection();

            PreparedStatement stmt = cnx.prepareStatement("SELECT id,niveauDifficulte, dateDebut, dateFin FROM Partie WHERE dateDebut=?");
            stmt.setTimestamp(1, Timestamp.valueOf(uneDate));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                parties.add(importerPartie(rs));
            }

            cnx.close();

        } catch(SQLException ex){
            throw new DAOException(ex);
        }


        return parties;
    }
    private static  Partie importerPartie(ResultSet rs) throws DAOException {

        try{
            return new Partie(rs.getInt("id"),  rs.getTimestamp("dateDebut").toLocalDateTime(), rs.getTimestamp("dateFin").toLocalDateTime(), NiveauDifficulte.values()[rs.getInt("niveauDifficulte")]);
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }
}
