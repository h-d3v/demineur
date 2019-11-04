package quebec.crosemont.g04.demineur;

public interface Dao<T> {


    T lire(final Object id) throws DAOException;

    public T ajouter(final T entite) throws DAOException;

    public void supprimer(final T entite) throws DAOException;

    public T modifier(final T entite) throws DAOException;
}
