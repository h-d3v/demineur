package quebec.crosemont.g04.demineur;

import java.util.concurrent.ThreadPoolExecutor;


public abstract class Dao<T> {

    static <T> T lire() throws DAOException {
        return null;
    }

    static <T> T ajouter(final T entite) throws DAOException{
        return null;
    }

    static <T> void supprimer(final T entite) throws DAOException{

    }

    static <T> T modifier(final T entite) throws DAOException{
        return null;
    }

}
