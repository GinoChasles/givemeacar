package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Address;
import fr.givemeacar.app.model.CrudModel;
import fr.givemeacar.app.service.CrudService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.validation.Valid;

public interface CrudController<T> {

    /**
     * Counts the entities in the table
     * @return the number of entities in the table
     */
    public ResponseEntity count();

    /**
     * deletes an entity in the table based on its id
     * @param id the id of the entity in the table
     * @return the delted entity
     */
    public ResponseEntity deleteById(@PathVariable int id);


    /**
     * finds an entity in the table based on its id
     * @param id the id of the entity in the table
     * @return the entity in the table with the given id
     */
    public ResponseEntity findById(@PathVariable int id);

    /**
     *
     * @param _order the
     * @param _sort
     * @param _start
     * @param _end
     * @return
     */
    public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
            @RequestParam int _end);

    /**
     * Creates an entity in the table
     * @param model the entity to save
     * @return the saved entity
     */
    public ResponseEntity create(@Valid @RequestBody T model);

    /**
     * Updates an entity in the table
     * @param model the entity to update
     * @return the updated entity
     */
    public ResponseEntity update(@RequestBody T model);

    /**
     * Returns the attached CrudService
     * @return the attached CrudService
     */
    public CrudService<T> getService();
}