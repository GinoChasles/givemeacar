package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Administrator;
import fr.givemeacar.app.service.AdministratorService;
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
public class AdministratorController{

    @Autowired
    AdministratorService service;

    
    @RequestMapping("administrators/count")
    public BigInteger count() {
        return service.count(TableNames.administrators);
    }

    @RequestMapping(value = "administrators", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        if(_start != null) {
            return service.findAll(TableNames.administrators, new Administrator(),_start, _end);
        }else{
            return service.findAll(TableNames.administrators, new Administrator(),0,_end);
        }
    }

    @GetMapping("administrators/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.administrators,new Administrator(),id);

    }



    
    @PostMapping("administrators")
    public ResponseEntity<String> create(@Valid @RequestBody Administrator model) {
        return service.create(model);
    }

    
    @PutMapping("administrators/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Administrator model) {
        return service.update(model,id);
    }

    
    @DeleteMapping("administrators/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Administrator(),id);
    }
}