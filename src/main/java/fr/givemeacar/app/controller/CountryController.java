package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Country;
import fr.givemeacar.app.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CountryController extends CrudControllerImpl<Country>{

    @Autowired
    CountryService service;

    @RequestMapping("countries/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "countries", method = RequestMethod.GET)
    @Override
        public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q) {
            return super.findAll(new Country(),"countries",_order, _sort, _start, _end, id, q);
    }

    @GetMapping("countries/{id}")
    @Override
    public ResponseEntity findById(@PathVariable Integer id) {
        return super.findById(id);
    }


    @PostMapping("countries")
    public ResponseEntity create(@Valid @RequestBody Country model) {
        return super.create(model);
    }


    @PutMapping("countries/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody Country model) {
        return super.update(model);
    }


    @DeleteMapping("countries/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        return super.deleteById(id);
    }

    @Override
    public CountryService getService() {
        return service;
    }
}