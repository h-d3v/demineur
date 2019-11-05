package quebec.crosemont.g04.demineur;


import java.net.URL;
import java.net.URLClassLoader;
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
    String jdbc="jdbc:sqlite:";
    URL url =ClassLoader.getSystemClassLoader().getResource("demineur.db");
    //System.out.println(jdbc+url);
    //System.out.println(jdbc+url.toString().replace("file:",""));
    //if(cnx==null || cnx.isClosed()) cnx=DriverManager.getConnection("jdbc:sqlite:/home/ju/Dropbox/Ecole/Session en cours/Applications natives/demineur (autre copie)/src/main/resources/demineur.db");
    if(cnx==null || cnx.isClosed()) cnx=DriverManager.getConnection(jdbc+url);
    return cnx;
  }
}
