package fr.givemeacar.app.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public abstract class CrudControllerImpl<T> implements CrudController<T> {
    HttpHeaders responseHeaders;

    public ResponseEntity tryCount() {
        try {
            return ResponseEntity.ok(getService().count());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
        }
    }

    public ResponseEntity tryFindAll(@RequestParam(required = false) String _order,
                                     @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                                     @RequestParam int _end) {
        if (_start != null) {
            try {
                responseHeaders = new HttpHeaders();
                responseHeaders.set("X-Total-Count", String.valueOf(getService().count()));
                responseHeaders.set("Access-Control-Expose-Headers", "X-Total-Count");

                return ResponseEntity.ok()
                        .headers(responseHeaders)
                        .body(getService().findAll(_start, _end, _order, _sort));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
            }
        } else {
            try {
                return ResponseEntity.ok(getService().findAll(0, _end, _order, _sort));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
            }
        }
    }

    public ResponseEntity tryFindById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(getService().findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity tryCreate(@Valid @RequestBody T model) {
        try {
            return ResponseEntity.ok(getService().create(model));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
        }
    }

    public ResponseEntity tryUpdate(@PathVariable int id, @RequestBody T model) {
        try {
            return ResponseEntity.ok(getService().update(model, id));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
        }
    }

    public ResponseEntity tryDelete(@PathVariable int id) {
        try {
            return ResponseEntity.ok(getService().delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
        }
    }
}