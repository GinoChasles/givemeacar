package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Address;
import fr.givemeacar.app.service.AddressService;
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
public class AddressController{

    @Autowired
    AddressService service;

    @CrossOrigin
    @RequestMapping("addresses/count")
    public BigInteger count() {
        return service.count(TableNames.addresses);
    }

    @RequestMapping(value = "addresses", method = RequestMethod.GET)
    public Collection<Address> findAll(@RequestParam(required = false) Integer offset, @RequestParam int limit) {
        if(offset != null) {
            return service.findAll(TableNames.addresses, offset, limit);
        }else{
            return service.findAll(TableNames.addresses, 0,limit);
        }
    }

    @GetMapping("addresses/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.addresses,new Address(),id);

    }

    @CrossOrigin
    @PostMapping("addresses")
    public ResponseEntity<String> create(@Valid @RequestBody Address model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("addresses/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Address model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("addresses/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Address(),id);
    }
}