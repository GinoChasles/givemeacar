package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Rent;
import fr.givemeacar.app.service.RentService;
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
public class RentController{

    @Autowired
    RentService service;

    
    @RequestMapping("rents/count")
    public BigInteger count() {
        return service.count(TableNames.rents);
    }

    @RequestMapping(value = "rents", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        if(_start != null) {
            return service.findAll(TableNames.rents,new Rent(), _start, _end);
        }else{
            return service.findAll(TableNames.rents,new Rent(), 0,_end);
        }
    }

    @GetMapping("rents/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.rents,new Rent(),id);

    }



    
    @PostMapping("rents")
    public ResponseEntity<String> create(@Valid @RequestBody Rent model) {
        return service.create(model);
    }

    
    @PutMapping("rents/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Rent model) {
        return service.update(model,id);
    }

    
    @DeleteMapping("rents/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Rent(),id);
    }
}