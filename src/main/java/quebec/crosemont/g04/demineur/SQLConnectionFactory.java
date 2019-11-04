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
    String url =ClassLoader.getSystemClassLoader().getResource("demineur.db").toString();
    if(cnx==null || cnx.isClosed()) cnx=DriverManager.getConnection(url);
    return cnx;
  }
}
