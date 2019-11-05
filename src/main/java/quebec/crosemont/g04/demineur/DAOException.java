package quebec.crosemont.g04.demineur;

import java.sql.SQLException;

/**
 * Une exception pouvant survenir lors de l'accès à une source de
 * données quelconque
 *
 */
public class DAOException extends Exception{

  public Exception exceptionOriginale;

  public DAOException(SQLException ex){
    exceptionOriginale=ex;
  }

}

