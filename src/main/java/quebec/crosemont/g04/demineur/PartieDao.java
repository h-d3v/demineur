package quebec.crosemont.g04.demineur;

import java.sql.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PartieDao implements Dao<Partie>{

    public Partie lire(Object id) throws DAOException {
        Partie partie=null;
        Connection cnx;
        try{
            cnx=SQLConnectionFactory.getConnection();

            PreparedStatement stmt = cnx.prepareStatement("SELECT id,niveauDifficulte, dateDebut, dateFin FROM Partie WHERE id = ?");
            stmt.setObject(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) partie= importerPartie(rs);

            cnx.close();

        } catch(SQLException ex){
            throw new DAOException(ex);
        }

        return partie;
    }

    public Partie ajouter(Partie unePartie) throws DAOException {
        Partie partie=null;
        Connection cnx;
        try{
            cnx=SQLConnectionFactory.getConnection();

            PreparedStatement stmt = cnx.prepareStatement("INSERT INTO Partie (niveauDifficulte, dateDebut, dateFin) VALUES (?,?,?)");
            stmt.setInt(1, unePartie.getNiveauDifficulte().ordinal());
            stmt.setTimestamp(2, Timestamp.valueOf(unePartie.getDateDebut()));
            stmt.setTimestamp(3, Timestamp.valueOf(unePartie.getDateFin()));


            ResultSet rs = stmt.executeQuery();

            if(rs.next()) partie= importerPartie(rs);

            cnx.close();

        } catch(SQLException ex){
            throw new DAOException(ex);
        }
        return lire(partie);
    }

    public Partie modifier(Partie unePartie) throws DAOException {
        Connection cnx;
        Partie partie=null;
        try{
            cnx=SQLConnectionFactory.getConnection();

            PreparedStatement stmt = cnx.prepareStatement("UPDATE Partie SET  niveauDifficulte=?, dateDebut=?, dateFin=? WHERE id=?");
            stmt.setInt(1, unePartie.getNiveauDifficulte().ordinal());
            stmt.setTimestamp(2, Timestamp.valueOf(unePartie.getDateDebut()));
            stmt.setTimestamp(3, Timestamp.valueOf(unePartie.getDateFin()));
            stmt.setInt(4, unePartie.getId());


            ResultSet rs = stmt.executeQuery();

            if(rs.next()) partie= importerPartie(rs);

            cnx.close();

        } catch(SQLException | DAOException ex){
            throw new DAOException(ex);
        }
        return partie;
    }

    public void supprimer(Partie unePartie) throws DAOException {
        Connection cnx;
        try{
            cnx=SQLConnectionFactory.getConnection();

            PreparedStatement stmt = cnx.prepareStatement("DELETE FROM Partie WHERE id=?");
            stmt.setInt(1, unePartie.getId());


            stmt.execute();

            cnx.close();

    } catch(SQLException ex){
            throw new DAOException(ex);
        }
    }
    public ArrayList<Partie> trouverTout()throws DAOException{
        ArrayList<Partie> parties=null;
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
    public ArrayList<Partie> trouverPartieParDifficulte(NiveauDifficulte unNiveau) throws DAOException{
        ArrayList<Partie> parties=null;
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
    public  ArrayList<Partie> trouverPartieParDate(LocalDateTime uneDate) throws DAOException{
        ArrayList<Partie> parties=null;
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
