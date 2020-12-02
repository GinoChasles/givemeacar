package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Car;
import fr.givemeacar.app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class CarController extends CrudControllerImpl<Car>{

    @Autowired
    CarService service;

    @RequestMapping("cars/count")
    public ResponseEntity count() {
        return tryCount();
    }

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return tryFindAll(_order,_sort,_start,_end);
    }

    @GetMapping("cars/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return tryFindById(id);
    }


    @PostMapping("cars")
    public ResponseEntity create(@Valid @RequestBody Car model) {
        return tryCreate(model);
    }


    @PutMapping("cars/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Car model) {
        return tryUpdate(id,model);
    }


    @DeleteMapping("cars/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return tryDelete(id);
    }

    @Override
    public CarService getService() {
        return service;
    }
}