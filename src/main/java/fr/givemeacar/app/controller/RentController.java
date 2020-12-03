package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Rent;
import fr.givemeacar.app.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RentController extends CrudControllerImpl<Rent>{

    @Autowired
    RentService service;

    @RequestMapping("rents/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "rents", method = RequestMethod.GET)
    @Override
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return super.findAll(_order, _sort, _start, _end);
    }

    @GetMapping("rents/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("rents")
    public ResponseEntity create(@Valid @RequestBody Rent model) {
        return super.create(model);
    }


    @PutMapping("rents/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Rent model) {
        return super.update(model);
    }


    @DeleteMapping("rents/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public RentService getService() {
        return service;
    }
}