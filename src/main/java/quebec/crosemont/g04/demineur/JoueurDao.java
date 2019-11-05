package quebec.crosemont.g04.demineur ;
import java.sql.*;
import java.util.*;


public class JoueurDao extends Dao<Joueur>{

    public Joueur lire(String unPseudonyme )throws DAOException{
        Joueur joueur=null;
        try {
            Connection cnx=SQLConnectionFactory.getConnection();
            String requete = ("SELECT id FROM joueur WHERE pseudo = ?");
            PreparedStatement stmt = cnx.prepareStatement(requete);
            stmt.setString(1, unPseudonyme);
            ResultSet resultat= stmt.executeQuery();

            if(resultat.next()) joueur = importerJoueur(resultat);
            stmt.close();
            cnx.close();

        }catch (SQLException ex) {
            throw new DAOException(ex);

        }
        return joueur;

    }

    public Joueur ajouter(Joueur unJoueur) throws DAOException{
        Connection cnx;
        try{
            cnx=SQLConnectionFactory.getConnection();
            String requete = ("INSERT INTO joueur(nom,pseudo,niveau) VALUES (?,?,?)");
            PreparedStatement stmt = cnx.prepareStatement(requete);
            stmt.setString(1,unJoueur.getNom());
            stmt.setString(2,unJoueur.getPseudo());
            stmt.setInt(3,unJoueur.getNiveau());
            stmt.execute();
            stmt.close();

        }catch (SQLException ex){
            throw new DAOException(ex);
        }
        return unJoueur;

    }

    public Joueur modifier(Joueur unJoueur)throws DAOException{
        Joueur joueur=null;
        Connection cnx;
        try{
            cnx=SQLConnectionFactory.getConnection();
            String requete = ("UPDATE joueur SET nom=?,niveau=? WHERE pseudo = ?");
            PreparedStatement stmt = cnx.prepareStatement(requete);
            stmt.setString(1,unJoueur.getNom());
            stmt.setInt(1,unJoueur.getNiveau());
            stmt.setString(3,unJoueur.getPseudo());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) joueur = importerJoueur(rs);
            cnx.close();
        }catch (SQLException e){
            throw new DAOException(e);
        }
        return joueur;
    }

    public static void supprimer(Joueur unJoueur)throws DAOException{
        Connection cnx;
        try{

            cnx=SQLConnectionFactory.getConnection();
            String requete = ("DELETE FROM joueur WHERE pseudo=?");
            PreparedStatement stmt = cnx.prepareStatement(requete);
            stmt.setString(1,unJoueur.getPseudo());
            stmt.execute();
            cnx.close();
        }catch(SQLException ex){
            throw new DAOException(ex);
        }

    }

    public static ArrayList<Joueur> trouverTout()throws DAOException{
        ArrayList<Joueur> joueurs=null;
        Connection cnx;
        try{
            cnx=SQLConnectionFactory.getConnection();
            PreparedStatement stmt = cnx.prepareStatement("SELECT pseudo,nom,niveau FROM Joueur");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                joueurs.add(importerJoueur(rs));
            }

            cnx.close();

        } catch(SQLException ex){
            throw new DAOException(ex);
        }
        return joueurs ;
    }


    public static ArrayList<Joueur> trouverParNiveau(int unNiveau)throws DAOException {
        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        Connection cnx;
        try {
            cnx = SQLConnectionFactory.getConnection();
            PreparedStatement stmt = cnx.prepareStatement("SELECT pseudo,nom,niveau FROM Joueur WHERE niveau =?");
            stmt.setInt(1, unNiveau);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                joueurs.add(importerJoueur(rs));
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return joueurs;
    }
    private static Joueur importerJoueur (ResultSet rs) throws DAOException {
        ArrayList<Partie> desParties=PartieDao.trouverTout();//TODO
        try{
            JoueurDao.lire();
            return new Joueur(rs.getString("pseudo"), rs.getString("nom"), rs.getInt("niveau"), desParties);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}

