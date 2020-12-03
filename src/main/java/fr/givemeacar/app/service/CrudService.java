package fr.givemeacar.app.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityManager;

public interface CrudService<T> {

    /**
     * Returns the number of rows in the table
     *
     * @return the number of rows in the table
     */
    public Long count();

    /**
     * Returns a collection of entities
     *
     * @param offset    the offset of the research
     * @param limit     the limit of the research
     * @param order     the ordering od the search
     * @param sort      the sorting of the research
     * @return a collection of entities
     */
    public List<T> findAll(int offset, int limit, String order, String sort);

    /**
     * Returns an optional model instance from its id in the database
     *
     * @param id the id of the model
     * @return an optional model instance from its id in the database
     */
    public Optional<T> findById(int id);
    /**
     * Creates a model in the database
     *
     * @param t the model to save
     * @return a 200(ok) or 409(conflict) response with constraint message
     */
    public T create(T t);

    /**
     * Updates a model in the database
     *
     * @param id the id of the object to update
     * @return a 200(ok) or 409(conflict) response with constraint message
     */
    public T update(T t,int id);

    /**
     * Deletes a model in the database
     *
     * @param id the id of the model to delete
     * @return true if deleted, false if failed
     */
    public boolean delete(int id);


    /**
     * Returns the repository of the service
     * @return the repository of the service
     */
    public JpaRepository<T,Integer> getRepository();

}
