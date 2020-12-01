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

@RestController
@RequestMapping("/api")
public class RentController{

    @Autowired
    RentService service;

    @CrossOrigin
    @RequestMapping("rents/count")
    public BigInteger count() {
        return service.count(TableNames.rents);
    }

    @RequestMapping(value = "rents", method = RequestMethod.GET)
    public Collection<Rent> findAll(@RequestParam(required = false) Integer offset, @RequestParam int limit) {
        if(offset != null) {
            return service.findAll(TableNames.rents,new Rent(), offset, limit);
        }else{
            return service.findAll(TableNames.rents,new Rent(), 0,limit);
        }
    }

    @GetMapping("rents/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.rents,new Rent(),id);

    }



    @CrossOrigin
    @PostMapping("rents")
    public ResponseEntity<String> create(@Valid @RequestBody Rent model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("rents/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Rent model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("rents/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Rent(),id);
    }
}