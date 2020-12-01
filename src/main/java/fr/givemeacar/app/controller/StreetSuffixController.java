package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.StreetSuffix;
import fr.givemeacar.app.service.StreetSuffixService;
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
public class StreetSuffixController{

    @Autowired
    StreetSuffixService service;

    @CrossOrigin
    @RequestMapping("street_suffices/count")
    public BigInteger count() {
        return service.count(TableNames.streetSuffices);
    }

    @RequestMapping(value = "street_suffices", method = RequestMethod.GET)
    public Collection<StreetSuffix> findAll(@RequestParam(required = false) Integer offset, @RequestParam int limit) {
        if(offset != null) {
            return service.findAll(TableNames.streetSuffices, offset, limit);
        }else{
            return service.findAll(TableNames.streetSuffices, 0,limit);
        }
    }

    @GetMapping("street_suffices/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.streetSuffices,new StreetSuffix(),id);

    }



    @CrossOrigin
    @PostMapping("street_suffices")
    public ResponseEntity<String> create(@Valid @RequestBody StreetSuffix model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("street_suffices/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody StreetSuffix model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("street_suffices/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new StreetSuffix(),id);
    }
}