package sample.service;

import java.util.List;

/**
 * Basic Spring Service class which contains some business logic
 */

public interface Service<T> {
    /**
     * Gets a T object list.
     *
     * @return T object list
     */
    public List<T> getAll();

    /**
     * Saves a T object.
     *
     * @param t
     */
    public void save(T t);

    /**
     * Gets a T object.
     *
     * @param id
     * @return T object
     */
    public T get(int id);

    /**
     * Deletes a T object by his id.
     *
     * @param id
     */
    public void delete(int id);
}
