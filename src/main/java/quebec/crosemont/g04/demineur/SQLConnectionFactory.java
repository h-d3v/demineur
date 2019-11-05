package quebec.crosemont.g04.demineur;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Factory permettant d'obtenir une connexion à une BD SQLite
 *
 */
public class SQLConnectionFactory {

  private static Connection cnx;
  
  private SQLConnectionFactory() { }

  public static Connection getConnection() throws SQLException{
    String jbdc="jdbc:sqlite:";
    String url =ClassLoader.getSystemClassLoader().getResource("demineur.db").toString();
    System.out.println(jbdc);
    System.out.println(url);
    System.out.println(jbdc+url);
    if(cnx==null || cnx.isClosed()) cnx=DriverManager.getConnection(jbdc+url);
    return cnx;
  }
}
