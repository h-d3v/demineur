package quebec.crosemont.g04.demineur;

/**
 * Une exception pouvant survenir lors de l'accès à une source de
 * données quelconque
 *
 */
public class DAOException extends Exception{

  public Exception exceptionOriginale;

  public DAOException(Exception ex){
    exceptionOriginale=ex;
  }

}

