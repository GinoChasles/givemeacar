package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.CrudModel;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class CrudControllerImpl<T> implements CrudController<T> {

    //l'instance de HttpHeaders pour les échanges avec le client
    HttpHeaders responseHeaders;


    public ResponseEntity<?> count() {
        try {
            return ResponseEntity.ok(getService().count());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
        }
    }



    @Override
    public ResponseEntity<?> create(@Valid @RequestBody T model) {
        try{
            return ResponseEntity.ok((CrudModel) getService().create(model));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
        }
    }



    public ResponseEntity<?> update(@RequestBody T model) {
        try {
            return ResponseEntity.ok((getService()).update(model));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
        }
    }



    public ResponseEntity<?> deleteById(Integer id){ return ResponseEntity.ok((getService()).deleteById(id)); }



    public ResponseEntity<?> listById(Integer id){
        if(id == 0) return ResponseEntity.ok((getService()).findLast());

        Optional<T> model = (getService()).findById(id);

        List<Optional<T>> list = new ArrayList<>();

        if(model.isPresent())
            list.add(model);

        return ResponseEntity.ok(list);
    }



    public ResponseEntity<?> findById(Integer id){
        if(id == 0) return ResponseEntity.ok(getService().findLast());
        Optional<T> model = (getService()).findById(id);

        if(model.isPresent())
            return ResponseEntity.ok(model);

        return ResponseEntity.notFound().build();
    }



    public ResponseEntity<?> findByNameStartingBy(T clazz,String column,String name,String sort,String order,
                                                  int offset,
                                               int limit){
        List<T> res = getService().findByNameLike(clazz,column,name,sort,order,offset,limit);
            responseHeaders = new HttpHeaders();
            responseHeaders.set("X-Total-Count", String.valueOf(res.size()));
            responseHeaders.set("Access-Control-Expose-Headers", "X-Total-Count");

            return ResponseEntity.ok().headers(responseHeaders).body(res);
    }

    public ResponseEntity<?> findAll(T clazz, String column,
                                  @RequestParam(required = false) String _order,
                                     @RequestParam(required = false) String _sort,
                                     @RequestParam(required = false) Integer _start,
                                     @RequestParam(required = false) Integer _end,@RequestParam(required =
            false) Integer id,@RequestParam(required = false) String q) {


        if(q != null){
            return findByNameStartingBy(clazz,column,q,_sort,_order,_start, _end);
        }

        if(id != null){
            return listById(id);
        }

        if (_start != null) {
            try {
                responseHeaders = new HttpHeaders();
                responseHeaders.set("X-Total-Count", String.valueOf((getService()).count()));
                responseHeaders.set("Access-Control-Expose-Headers", "X-Total-Count");

                return ResponseEntity.ok()
                        .headers(responseHeaders)
                        .body((getService()).findAll(_start, _end, _order, _sort));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
            }
        } else {
            try {
                return ResponseEntity.ok((getService()).findAll(0, _end, _order, _sort));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
            }
        }
    }
}