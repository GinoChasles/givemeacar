package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Address;
import fr.givemeacar.app.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AddressController extends CrudControllerImpl<Address>{

    @Autowired
    AddressService service;

    @RequestMapping("addresses/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "addresses", method = RequestMethod.GET)
    @Override
        public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q) {
            return super.findAll(_order, _sort, _start, _end, id, q);
    }

    @GetMapping("addresses/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("addresses")
    public ResponseEntity create(@Valid @RequestBody Address model) {
        return super.create(model);
    }


    @PutMapping("addresses/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Address model) {
        return super.update(model);
    }


    @DeleteMapping("addresses/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public AddressService getService() {
        return service;
    }
}