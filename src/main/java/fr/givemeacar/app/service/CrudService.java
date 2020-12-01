package fr.givemeacar.app.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Optional;

import fr.givemeacar.app.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityManager;

public interface CrudService<T> {

    /**
     * Returns the number of rows in the table
     *
     * @return the number of rows in the table
     */
    public BigInteger count(String tableName);

    /**
     * Returns a collection of entities
     *
     * @param tableName the table to count the rows
     * @param offset    the offset of the research
     * @param limit     the limit of the research
     * @return a collection of entities
     */
    public Collection<T> findAll(String tableName, int offset, int limit);

    /**
     * Returns an optional model instance from its id in the database
     *
     * @param tableName the table to search by id
     * @param id the id of the model
     * @return an optional model instance from its id in the database
     */
    public Object findById(String tableName,T t, int id) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;

    /**
     * Creates a model in the database
     *
     * @param repo the repo for the transaction
     * @param model the model to save
     * @return a 200(ok) or 409(conflict) response with constraint message
     */
    public ResponseEntity<String> create(JpaRepository<T, Integer> repo,T model);
    /**
     * Updates a model in the database
     *
     * @param model the model to update
     * @return a 200(ok) or 409(conflict) response with constraint message
     */
    public ResponseEntity<String> update(JpaRepository<T, Integer> repo, T model, int id);

    /**
     * Deletes a model in the database
     *
     * @param id the id of the model to delete
     * @return a 200(ok) or 409(conflict) response with constraint message
     */
    public ResponseEntity<String> delete(int id);

    /**
     * Transforms an Exception into a ResponseEntity
     *
     * @param e The ExceptionMessage
     * @return The ResponseEntity
     */
    public ResponseEntity<String> exceptionToResponseEntity(Exception e);

    /**
     * Returns the entityManager
     *
     * @return the entityManager
     */
    public EntityManager getEntityManager();

    /**
     * Sets the entityManager
     *
     * @param em the entityManager to define
     */
    public void setEntityManager(EntityManager em);

    /**
     * Tries to save a model and returns the corresponding ResponseEntity
     * @param repo the repo to save the model
     * @param model the model to save
     * @return the ResponseEntity
     */
    public ResponseEntity<String> trySaveOrConflict(JpaRepository<T,Integer> repo,T model);
}
