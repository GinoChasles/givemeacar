package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.repository.findByNameStartingWithRepository;
import fr.givemeacar.app.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class CrudControllerImpl<T> implements CrudController<T> {
    HttpHeaders responseHeaders;
    @Autowired
    HttpSession session;

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

    public ResponseEntity listById(int id){
        if(id == 0) return ResponseEntity.ok(((CrudService<T>)getService()).findLast());

        Optional<T> model = ((CrudService<T>)getService()).findById(id);

        List list = new ArrayList<T>();

        if(model.isPresent())
            list.add(model);

        return ResponseEntity.ok(list);
    }

    public ResponseEntity findById(int id){
        if(id == 0) return ResponseEntity.ok(((CrudService<T>)getService()).findLast());

        Optional<T> model = ((CrudService<T>)getService()).findById(id);

        if(model.isPresent())
            return ResponseEntity.ok(model);

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity findByNameStartingBy(String name){
        findByNameStartingWithRepository repo =
                (findByNameStartingWithRepository) getService().getRepository();
        List res = repo.findByNameStartingWith(name);

            responseHeaders = new HttpHeaders();
            responseHeaders.set("X-Total-Count", String.valueOf(res.size()));
            responseHeaders.set("Access-Control-Expose-Headers", "X-Total-Count");

            return ResponseEntity.ok().headers(responseHeaders).body(res);
    }

    public ResponseEntity findAll(@RequestParam(required = false) String _order,
                                     @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                                     @RequestParam(required = false) Integer _end,@RequestParam(required =
            false) Integer id,@RequestParam(required = false) String q) {


        if(q != null){
            return findByNameStartingBy(q);
        }

        if(id != null){
            return listById(id.intValue());
        }

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

    public HttpSession getSession(){
        return session;
    }
}