package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Region;
import fr.givemeacar.app.service.RegionService;
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
public class RegionController{

    @Autowired
    RegionService service;

    
    @RequestMapping("regions/count")
    public BigInteger count() {
        return service.count(TableNames.regions);
    }

    @RequestMapping(value = "regions", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        if(_start != null) {
            return service.findAll(TableNames.regions,new Region(), _start, _end);
        }else{
            return service.findAll(TableNames.regions,new Region(), 0,_end);
        }
    }

    @GetMapping("regions/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.regions,new Region(),id);

    }



    
    @PostMapping("regions")
    public ResponseEntity<String> create(@Valid @RequestBody Region model) {
        return service.create(model);
    }

    
    @PutMapping("regions/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Region model) {
        return service.update(model,id);
    }

    
    @DeleteMapping("regions/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Region(),id);
    }
}