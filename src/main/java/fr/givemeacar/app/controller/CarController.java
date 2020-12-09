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
        return super.count();
    }

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    @Override
    public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
            @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id) {
        return super.findAll(_order, _sort, _start, _end, id);
    }

    @GetMapping("cars/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("cars")
    public ResponseEntity create(@Valid @RequestBody Car model) {
        return super.create(model);
    }


    @PutMapping("cars/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Car model) {
        return super.update(model);
    }


    @DeleteMapping("cars/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public CarService getService() {
        return service;
    }
}