package quebec.crosemont.g04.demineur ;
import java.sql.*;
import java.util.*;


public class JoueurDao extends Dao<Joueur>{

  public static Joueur lire(String unPseudonyme )throws DAOException{
    Joueur joueur=null;
    try {
      Connection cnx=SQLConnectionFactory.getConnection();
      String requete = ("SELECT * FROM joueur WHERE pseudo = ? ORDER BY id DESC");
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

  public static Joueur ajouter(Joueur unJoueur) throws DAOException{
    Connection cnx;
    try{
      cnx=SQLConnectionFactory.getConnection();
      String requete = ("INSERT INTO joueur(nom,pseudonyme,niveau,partieId) VALUES (?,?,?,?)");
      PreparedStatement stmt = cnx.prepareStatement(requete);
      stmt.setString(1,unJoueur.getNom());
      stmt.setString(2,unJoueur.getPseudo());
      stmt.setInt(3,unJoueur.getNiveau());
      //stmt.setInt(4,);
      ResultSet rs = stmt.executeQuery();
      stmt.close();

    }catch (SQLException ex){
      throw new DAOException(ex);
    }
    return unJoueur;

  }

  public static Joueur modifier(Joueur unJoueur)throws DAOException{
    Joueur joueur=null;
    try{
      String url = "jdbc:mysql//localhost/demineur.bd:";
      Connection cnx = DriverManager.getConnection(url);
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
      ArrayList<Partie> desParties=PartieDao.trouverTout();
  try{
        PartieDao.lire();
        return new Joueur(rs.getString("pseudo"), rs.getString("nom"), rs.getInt("niveau"), desParties);
      } catch (SQLException e) {
        throw new DAOException(e);
      }
    }
  }


