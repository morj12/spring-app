package sample.dao;

import java.util.List;

/**
 * Basic Data Access Object interface
 *
 * @param <T> data type to work with
 */
public interface DAO<T> {
    /**
     * Gets all the objects (SELECT * FROM T)
     *
     * @return a list with all the found objects
     */
    List<T> getAll();

    /**
     * Saves one object (INSERT INTO T ...)
     *
     * @param t
     */
    void save(T t);

    /**
     * Returns an object found by his id (SELECT * FROM T WHERE id = @id)
     *
     * @param id
     * @return the found object
     */
    T get(int id);

    /**
     * Removes an object by his id
     *
     * @param id
     */
    void delete(int id);
}

