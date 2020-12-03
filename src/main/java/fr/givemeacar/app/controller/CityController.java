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

    @RequestMapping("cities/count")
    public ResponseEntity count() {
        return tryCount();
    }

    @RequestMapping(value = "cities", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return tryFindAll(_order,_sort,_start,_end);
    }

    @GetMapping("cities/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return tryFindById(id);
    }


    @PostMapping("cities")
    public ResponseEntity create(@Valid @RequestBody City model) {
        return tryCreate(model);
    }


    @PutMapping("cities/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody City model) {
        return tryUpdate(id,model);
    }


    @DeleteMapping("cities/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return tryDelete(id);
    }

    @Override
    public CityService getService() {
        return service;
    }
}