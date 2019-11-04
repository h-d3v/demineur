package quebec.crosemont.g04.demineur;

public interface Dao<T> {

    T lire(final Object id) throws DAOException;

    T ajouter(final T entite) throws DAOException;

    void supprimer(final T entite) throws DAOException;

    T modifier(final T entite) throws DAOException;
}
