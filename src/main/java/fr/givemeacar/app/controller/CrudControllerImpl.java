package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.service.CrudService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public abstract class CrudControllerImpl<T> implements CrudController<T> {
    HttpHeaders responseHeaders;

    public ResponseEntity count() {
        try {
            return ResponseEntity.ok(((CrudService<T>)getService()).count());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
        }
    }

    public ResponseEntity create(@Valid @RequestBody T model) {
            return ResponseEntity.ok(getService().create(model));
    }

    public ResponseEntity update(@RequestBody T model) {
        try {
            return ResponseEntity.ok(((CrudService<T>)getService()).update(model));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
        }
    }

    public ResponseEntity deleteById(int id){ return ResponseEntity.ok(((CrudService<T>)getService()).deleteById(id)); }

    public ResponseEntity findById(int id){
        if(id == 0) return ResponseEntity.ok(((CrudService<T>)getService()).findLast());
        return ResponseEntity.ok(((CrudService<T>)getService()).findById(id));
    }

    public ResponseEntity findAll(@RequestParam(required = false) String _order,
                                     @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                                     @RequestParam int _end) {
        if (_start != null) {
            try {
                responseHeaders = new HttpHeaders();
                responseHeaders.set("X-Total-Count", String.valueOf(((CrudService<T>)getService()).count()));
                responseHeaders.set("Access-Control-Expose-Headers", "X-Total-Count");

                return ResponseEntity.ok()
                        .headers(responseHeaders)
                        .body(((CrudService<T>)getService()).findAll(_start, _end, _order, _sort));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
            }
        } else {
            try {
                return ResponseEntity.ok(((CrudService<T>)getService()).findAll(0, _end, _order, _sort));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
            }
        }
    }
}