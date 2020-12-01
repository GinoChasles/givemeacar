package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Street;
import fr.givemeacar.app.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StreetController{

    @Autowired
    StreetService service;

    
    @RequestMapping("streets/count")
    public BigInteger count() {
        return service.count(TableNames.streets);
    }

    @RequestMapping(value = "streets", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        if(_start != null) {
            return service.findAll(TableNames.streets,new Street(),_start, _end,_order,_sort);
        }else{
            return service.findAll(TableNames.streets,new Street(), 0, _end,_order,_sort);
        }
    }

    @GetMapping("streets/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.streets,new Street(),id);

    }



    
    @PostMapping("streets")
    public ResponseEntity<String> create(@Valid @RequestBody Street model) {
        return service.create(model);
    }

    
    @PutMapping("streets/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Street model) {
        return service.update(model,id);
    }

    
    @DeleteMapping("streets/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Street(),id);
    }
}