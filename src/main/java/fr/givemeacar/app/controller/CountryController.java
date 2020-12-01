package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Country;
import fr.givemeacar.app.service.CountryService;
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
public class CountryController{

    @Autowired
    CountryService service;

    
    @RequestMapping("countries/count")
    public BigInteger count() {
        return service.count(TableNames.countries);
    }

    @RequestMapping(value = "countries", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        if(_start != null) {
            return service.findAll(TableNames.countries, new Country(),_start, _end,_order,_sort);
        }else{
            return service.findAll(TableNames.countries, new Country(),0, _end,_order,_sort);
        }
    }

    @GetMapping("countries/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.countries,new Country(),id);

    }



    
    @PostMapping("countries")
    public ResponseEntity<String> create(@Valid @RequestBody Country model) {
        return service.create(model);
    }

    
    @PutMapping("countries/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Country model) {
        return service.update(model,id);
    }

    
    @DeleteMapping("countries/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Country(),id);
    }
}