package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Agency;
import fr.givemeacar.app.service.AgencyService;
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
public class AgencyController{

    @Autowired
    AgencyService service;

    
    @RequestMapping("agencies/count")
    public BigInteger count() {
        return service.count(TableNames.agencies);
    }

    @RequestMapping(value = "agencies", method = RequestMethod.GET)
    public Collection<Agency> findAll(@RequestParam(required = false) Integer offset, @RequestParam int limit) {
        if(offset != null) {
            return service.findAll(TableNames.agencies,new Agency(), offset, limit);
        }else{
            return service.findAll(TableNames.agencies,new Agency(), 0,limit);
        }
    }

    @GetMapping("agencies/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.agencies,new Agency(),id);

    }



    
    @PostMapping("agencies")
    public ResponseEntity<String> create(@Valid @RequestBody Agency model) {
        return service.create(model);
    }

    
    @PutMapping("agencies/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Agency model) {
        return service.update(model,id);
    }

    
    @DeleteMapping("agencies/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Agency(),id);
    }
}