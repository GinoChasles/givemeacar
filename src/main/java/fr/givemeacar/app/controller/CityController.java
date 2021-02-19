package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.City;
import fr.givemeacar.app.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CityController extends CrudControllerImpl<City>{

    @Autowired
    CityService service;

    @RequestMapping("cities/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "cities", method = RequestMethod.GET)
    @Override
        public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q) {
            return super.findAll(new City(),"cities",_order, _sort, _start, _end, id, q);
    }

    @GetMapping("cities/{id}")
    @Override
    public ResponseEntity findById(@PathVariable Integer id) {
        return super.findById(id);
    }


    @PostMapping("cities")
    public ResponseEntity create(@Valid @RequestBody City model) {
        return super.create(model);
    }


    @PutMapping("cities/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody City model) {
        return super.update(model);
    }


    @DeleteMapping("cities/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        return super.deleteById(id);
    }

    @Override
    public CityService getService() {
        return service;
    }
}