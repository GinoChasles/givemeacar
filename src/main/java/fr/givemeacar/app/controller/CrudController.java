package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Address;
import fr.givemeacar.app.model.CrudModel;
import fr.givemeacar.app.service.CrudService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.validation.Valid;

public interface CrudController<T> {

    public ResponseEntity tryCount();

    public ResponseEntity tryFindAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
            @RequestParam int _end);

    public ResponseEntity tryFindById(@PathVariable int id);

    public ResponseEntity tryCreate(@Valid @RequestBody T model);

    public ResponseEntity tryUpdate(@PathVariable int id, @RequestBody T model);

    public ResponseEntity tryDelete(@PathVariable int id);

    public CrudService getService();

}