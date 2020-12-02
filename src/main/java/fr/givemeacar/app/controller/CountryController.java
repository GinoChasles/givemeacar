package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Country;
import fr.givemeacar.app.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class CountryController extends CrudControllerImpl<Country>{

    @Autowired
    CountryService service;

    @RequestMapping("countries/count")
    public ResponseEntity count() {
        return tryCount();
    }

    @RequestMapping(value = "countries", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return tryFindAll(_order,_sort,_start,_end);
    }

    @GetMapping("countries/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return tryFindById(id);
    }


    @PostMapping("countries")
    public ResponseEntity create(@Valid @RequestBody Country model) {
        return tryCreate(model);
    }


    @PutMapping("countries/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Country model) {
        return tryUpdate(id,model);
    }


    @DeleteMapping("countries/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return tryDelete(id);
    }

    @Override
    public CountryService getService() {
        return service;
    }
}