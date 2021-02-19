package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Car;
import fr.givemeacar.app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;



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
                @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q) {
            return super.findAll(new Car(),"cars",_order, _sort, _start, _end, id, q);
    }

    @GetMapping("cars/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        return super.findById(id);
    }


    @PostMapping("cars")
    public ResponseEntity create(@Valid @RequestBody Car model) {
        System.out.println(model);
        return super.create(model);
    }


    @PutMapping("cars/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody Car model) {
        return super.update(model);
    }


    @DeleteMapping("cars/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        return super.deleteById(id);
    }

    @Override
    public CarService getService() {
        return service;
    }
}