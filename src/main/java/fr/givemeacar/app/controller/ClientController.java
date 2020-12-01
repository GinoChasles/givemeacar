package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Client;
import fr.givemeacar.app.service.ClientService;
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
public class ClientController{

    @Autowired
    ClientService service;

    
    @RequestMapping("clients/count")
    public BigInteger count() {
        return service.count(TableNames.clients);
    }

    @RequestMapping(value = "clients", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        if(_start != null) {
            return service.findAll(TableNames.clients,new Client(),_start, _end,_order,_sort);
        }else{
            return service.findAll(TableNames.clients,new Client(), 0, _end,_order,_sort);
        }
    }

    @GetMapping("clients/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.clients,new Client(),id);

    }



    
    @PostMapping("clients")
    public ResponseEntity<String> create(@Valid @RequestBody Client model) {
        return service.create(model);
    }

    
    @PutMapping("clients/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Client model) {
        return service.update(model,id);
    }

    
    @DeleteMapping("clients/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Client(),id);
    }
}