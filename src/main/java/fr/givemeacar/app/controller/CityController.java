package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.City;
import fr.givemeacar.app.service.CityService;
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
public class CityController{

    @Autowired
    CityService service;

    
    @RequestMapping("cities/count")
    public BigInteger count() {
        return service.count(TableNames.cities);
    }

    @RequestMapping(value = "cities", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) Integer offset, @RequestParam int limit) {
        if(offset != null) {
            return service.findAll(TableNames.cities,new City(), offset, limit);
        }else{
            return service.findAll(TableNames.cities,new City(), 0,limit);
        }
    }

    @GetMapping("cities/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.cities,new City(),id);

    }



    
    @PostMapping("cities")
    public ResponseEntity<String> create(@Valid @RequestBody City model) {
        return service.create(model);
    }

    
    @PutMapping("cities/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody City model) {
        return service.update(model,id);
    }

    
    @DeleteMapping("cities/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new City(),id);
    }
}