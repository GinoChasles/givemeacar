package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.City;
import fr.givemeacar.app.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CityController extends CrudControllerImpl<City>{

    @Autowired
    CityService service;

    @RequestMapping("city/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "city", method = RequestMethod.GET)
    @Override
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return super.findAll(_order, _sort, _start, _end);
    }

    @GetMapping("city/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("city")
    public ResponseEntity create(@Valid @RequestBody City model) {
        return super.create(model);
    }


    @PutMapping("city/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody City model) {
        return super.update(model);
    }


    @DeleteMapping("city/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public CityService getService() {
        return service;
    }
}