package quebec.crosemont.g04.demineur ;
import java.sql.*;
import java.util.*;


public class JoueurDao implements DAO<Joueur>{

  public Joueur lire(String unPseudonyme )throws DAOException{
    try {
      String url = "jdbc:mysql//localhost/demineur.bd";
      Connection cnx=DriverManager.getConnexion(url);
      String requete = ("SELECT id FROM joueur WHERE nom = ?");
      PreparedStatement stmt = cnx.PreparedStatement(requete);
      stmt.setString(1, unPseudonyme);
      ResultSet resultat= stmt.executeQuery()
      if(resultat.next()) joueur = importerJoueur(rs);
      stmt.close();
      cnx.close();

    }catch (SQLException e) {
      throw new DAOException(ex)

    }
      return joueur;

  }

  public Joueur ajouter(Joueur unJoueur) throws DAOException{
    Joueur joueur=null;
    try{
      String url = "jdbc:mysql//localhost/demineur.bd:";
      Connection cnx=DriverManager.getConnexion(url);
      String requete = ("INSERT INTO joueur(nom,pseudonyme,niveau,partie) VALUES (?,?,?,?)");
      PreparedStatement stmt = cnx.PreparedStatement(requete);
      stmt.setString(1,unJoueur.getNom());
      stmt.setString(2,unJoueur.getPseudonyme());
      stmt.setString(3,unJoueur.getNiveau());
      ResultSet rs = stmt.executeQuery();
      stmt.close();

    }catch (SQLException e){
      throw new DAOException(ex);
    }
    return lire(joueur);

  }

  public Joueur modifier(Joueur unJoueur)throws DAOException{
    try{
      String url = "jdbc:mysql//localhost/demineur.bd:";
      Connection cnx = DriverManager.getConnexion(url);
      String requete = ("UPDATE joueur SET nom=?,niveau=? WHERE pseudo = ?");
      PreparedStatement stmt = cnx.PreparedStatement(requete);
      stmt.setString(1,unJoueur.getNom());
      stmt.setInt(1,unJoueur.getNiveau());
      stmt.setString(3,unJoueur.getPseudonyme());
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) joueur = importerJoueur(rs);
      cnx.close();
    }catch (DAOException ex){
      throw new DAOException(ex);
    }
    return joueur;
  }

  public Joueur supprimer(Joueur unJoueur)throws DAOException{
    try{
      String url = "jdbc:mysql//localhost/demineur.bd:"
      Connection cnx=DriverManager.getConnexion(url);
      String requete = ("DELETE FROM joueur WHERE pseudo=?");
      PreparedStatement stmt = cnx.PreparedStatement(requete);
      stmt.setInt(1,unJoueur.getPseudonyme());
      stmt.execute();
      cnx.close();
    }catch(SQLException ex){
      throw new DAOException(ex);
    }

  }

  public ArrayList<Joueur> trouverTout()throws DAOException{
        ArrayList<Joueur> joueurs=null;
        Connection cnx;
        try{
            cnx=SQLConnectionFactory.getConnection();
            PreparedStatement stmt = cnx.prepareStatement("SELECT pseudo,nom,niveau FROM Joueur");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                joueurs.add(importerPartie(rs));
            }

            cnx.close();

        } catch(SQLException ex){
            throw new DAOException(ex);
        }
        return joueurs ;
    }


  public ArrayList<Joueur> trouverParNiveau(int unNiveau)throws DAOException{
    ArrayList<joueurs> joueurs =null;
    Connextion cnx;
    try{
      cnx= SQLConnectionFactory.getConnection();
      PreparedStatement stmt = cnx.prepareStatement("SELECT pseudo,nom,niveau FROM Joueur WHERE niveau =?");
      stmt.setInt(1,unNiveau);
      ResultSet rs= stmt.executeQuery();
      while(rs.next()){
        joueurs.add(importerJoueur(rs));
      }

    }catch(DAOException e){
      throw new DAOException(e);
    }


  }
}
