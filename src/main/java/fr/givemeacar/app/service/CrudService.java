package fr.givemeacar.app.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import fr.givemeacar.app.repository.BaseCrudRepository;

import javax.persistence.EntityManager;

public interface CrudService<T> {

    /**
     * Counts the entities in the table
     *
     * @return the number of entities in the table
     */
    public Long count();

    /**
     * Creates a model in the database
     *
     * @param t the model to save
     * @return a 200(ok) or 409(conflict) response with constraint message
     */
    public T create(T t) ;

    /**
     * Updates a model in the database
     *
     * @param t the object to update
     * @return a 200(ok) or 409(conflict) response with constraint message
     */
    public T update(T t);

    /**
     * deletes an entity in the table based on its id
     *
     * @param id the id of the entity in the table
     * @return the delted entity
     */
    public T deleteById(int id);


    /**
     * finds an entity in the table based on its id
     *
     * @param id the id of the entity in the table
     * @return the entity in the table with the given id
     */
    public Optional<T> findById(int id);

    /**
     * Returns the last entity in the table based on its id
     *
     * @return the last entity in the table
     */
    public T findLast();


    /**
     * Returns a collection of entities
     *
     * @param offset the offset of the research
     * @param limit  the limit of the research
     * @param order  the ordering od the search
     * @param sort   the sorting of the research
     * @return a collection of entities
     */
    public List<T> findAll(int offset, int limit, String order, String sort);

    /**
     * Searches for entities who's name starts with given name
     * @param clazz The Entity class
     * @param column The column where to search
     * @param name the name to search
     * @param sort the sort of the result
     * @param order the order of the result
     * @param offset the offset of the search
     * @param limit the limit of the search
     * @return a list of entities starting by the given name
     */
    public List<T> findByNameStartingWith(T clazz, String column,String name,String sort,String order,int offset,
                                          int limit);

    /**
     * Returns the repository of the service
     *
     * @return the repository of the service
     */
    public BaseCrudRepository getRepository();

    /**
     * Returns the entityManager of the service
     *
     * @return the entityManager of the service
     */
    public EntityManager getEntityManager();

}