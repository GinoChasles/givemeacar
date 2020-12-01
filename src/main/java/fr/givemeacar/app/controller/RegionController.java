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

@RestController
@RequestMapping("/api")
public class RegionController{

    @Autowired
    RegionService service;

    @CrossOrigin
    @RequestMapping("regions/count")
    public BigInteger count() {
        return service.count(TableNames.regions);
    }

    @RequestMapping(value = "regions", method = RequestMethod.GET)
    public Collection<Region> findAll(@RequestParam(required = false) Integer offset, @RequestParam int limit) {
        if(offset != null) {
            return service.findAll(TableNames.regions,new Region(), offset, limit);
        }else{
            return service.findAll(TableNames.regions,new Region(), 0,limit);
        }
    }

    @GetMapping("regions/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.regions,new Region(),id);

    }



    @CrossOrigin
    @PostMapping("regions")
    public ResponseEntity<String> create(@Valid @RequestBody Region model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("regions/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Region model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("regions/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Region(),id);
    }
}