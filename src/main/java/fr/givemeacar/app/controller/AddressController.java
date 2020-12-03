package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Address;
import fr.givemeacar.app.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class AddressController extends CrudControllerImpl<Address>{

    @Autowired
    AddressService service;

    @RequestMapping("addresses/count")
    public ResponseEntity count() {
        return count();
    }

    @RequestMapping(value = "addresses", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return findAll(_order, _sort, _start, _end);
    }

    @GetMapping("addresses/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return findById(id);
    }

    
    @PostMapping("addresses")
    public ResponseEntity create(@Valid @RequestBody Address model) {
        return create(model);
    }

    
    @PutMapping("addresses/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Address model) {
        return update(id, model);
    }

    
    @DeleteMapping("addresses/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return delete(id);
    }

    @Override
    public AddressService getService() {
        return service;
    }
}