package fr.givemeacar.app.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface CrudService<T> {

    /**
     * Returns the number of rows in the table
     * 
     * @return the number of rows in the table
     */
    public Long count(JpaRepository<T, Integer> repo);

    /**
     * Returns an optional model instance from its id in the database
     * 
     * @param id the id of the model
     * @return an optional model instance from its id in the database
     */
    public Optional<T> findById(JpaRepository<T, Integer> repo,int id);

    /**
     * Creates a model in the database
     * 
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
    public ResponseEntity<String> update(JpaRepository<T, Integer> repo, T model,int id);

    /**
     * Deletes a model in the database
     * 
     * @param id the id of the model to delete
     * @return a 200(ok) or 409(conflict) response with constraint message
     */
    public ResponseEntity<String> delete(JpaRepository<T, Integer> repo,int id);

    /**
     * Transforms an Exception into a ResponseEntity
     * 
     * @param e The ExceptionMessage
     * @return The ResponseEntity
     */
    public ResponseEntity<String> exceptionToResponseEntity(Exception e);

    /**
     * Tries to save the model and returns a 200 response or returns a 409 response
     * with constraint message
     * 
     * @param model the model to save
     * @return a 200(ok) or 409(conflict) response with constraint message
     */
    public ResponseEntity<String> trySaveOrConflict(JpaRepository<T, Integer> repo,T model);

}
