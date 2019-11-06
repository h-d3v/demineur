package quebec.crosemont.g04.demineur ;
import java.sql.*;
import java.util.*;


public class JoueurDao extends Dao<Joueur>{

    public static Joueur lire(String unPseudonyme )throws DAOException{
        Joueur joueur=null;
        Connection cnx;
        try {
            cnx=SQLConnectionFactory.getConnection();
            String requete = ("SELECT pseudo, nom,niveau FROM joueur WHERE pseudo = ?");
            PreparedStatement stmt = cnx.prepareStatement(requete);
            stmt.setString(1, unPseudonyme);
            ResultSet resultat= stmt.executeQuery();

            if(resultat.next()){
                joueur = importerJoueur(resultat);
            }
            stmt.close();
            cnx.close();
            return joueur;
        }catch (SQLException ex) {
            throw new DAOException(ex);
        }

    }

    public static Joueur ajouter(Joueur unJoueur) throws DAOException{
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
            cnx.close();

        }catch (SQLException ex){
            throw new DAOException(ex);
        }
        return lire(unJoueur.getPseudo());

    }

    public static Joueur modifier(Joueur unJoueur)throws DAOException{
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
            stmt.close();
            cnx.close();
        }catch (SQLException e){
            throw new DAOException(e);
        }
        return lire(joueur.getPseudo());
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
        ArrayList<Joueur> joueurs= new ArrayList<Joueur>();
        Connection cnx;
        try{
            cnx=SQLConnectionFactory.getConnection();
            PreparedStatement stmt = cnx.prepareStatement("SELECT pseudo,nom,niveau FROM Joueur ORDER BY niveau DESC");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Joueur  j=new Joueur(rs.getString(1), rs.getString(2));
                Joueur nouveauJoueur=new Joueur(rs.getString(1), rs.getString(2), rs.getInt(3),JoueurDao.trouverPartiesParJoueur(j));
                joueurs.add(nouveauJoueur);
            }
            stmt.close();
            return joueurs ;
        } catch(SQLException ex){
            throw new DAOException(ex);
        }

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

            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return joueurs;

    }
    public static ArrayList<Partie> trouverPartiesParJoueur(Joueur unJoueur) throws DAOException {
        ArrayList<Partie> parties = new ArrayList<Partie>();
        Connection cnx;
        String pseudo = unJoueur.getPseudo();
        try {

            cnx = SQLConnectionFactory.getConnection();
            PreparedStatement stmt = cnx.prepareStatement("SELECT ids FROM PartieListe WHERE pseudo =?");
            stmt.setString(1, pseudo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String[] tab=rs.getString("ids").split("-");
                for(String uneId :tab){
                    parties.add(PartieDao.lire(Integer.valueOf(uneId)));
                }
            }
            stmt.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return parties;
    }

    public static void ajouterPartieAJoueur(Joueur unJoueur, Partie unePartie) throws DAOException{
        Connection cnx;
        String pseudo = unJoueur.getPseudo();
        ArrayList<Partie> desParties=trouverPartiesParJoueur(unJoueur);
        try {
            cnx = SQLConnectionFactory.getConnection();
            PreparedStatement stmt = cnx.prepareStatement("SELECT ids FROM PartieListe WHERE pseudo =?");
            stmt.setString(1, pseudo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String ids="-"+rs.getString("ids")+unePartie.getId();
                stmt=cnx.prepareStatement("UPDATE PartieListe Set ids=? WHERE pseudo=?");
                stmt.setString(1, ids);
                stmt.setString(2, pseudo);
                stmt.execute();

            }else{

                String ids =String.valueOf(unePartie.getId());
                stmt=cnx.prepareStatement("INSERT INTO PartieListe VALUES(?, ?)");
                stmt.setString(1, ids);
                stmt.setString(2, pseudo);
                stmt.execute();

            }

            stmt.close();
            cnx.close();


        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }


    private static Joueur importerJoueur (ResultSet rs) throws DAOException {
        ArrayList<Partie> desParties=new ArrayList<Partie>();
        try{
            Joueur unJoueur =new Joueur(rs.getString("nom"), rs.getString("pseudo"),rs.getInt("niveau"), desParties);
            desParties.addAll(trouverPartiesParJoueur(unJoueur));
            Joueur leJoueur =new Joueur(unJoueur.getNom(),unJoueur.getPseudo(), unJoueur.getNiveau(), desParties);
            return leJoueur;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
