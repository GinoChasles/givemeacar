package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Car;
import fr.givemeacar.app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CarController{

    @Autowired
    CarService service;

    
    @RequestMapping("cars/count")
    public BigInteger count() {
        return service.count(TableNames.cars);
    }

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        if(_start != null) {
            return service.findAll(TableNames.cars,new Car(), _start, _end);
        }else{
            return service.findAll(TableNames.cars,new Car(), 0,_end);
        }
    }

    @GetMapping("cars/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.cars,new Car(),id);

    }



    
    @PostMapping("cars")
    public ResponseEntity<String> create(@Valid @RequestBody Car model) {
        return service.create(model);
    }

    
    @PutMapping("cars/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Car model) {
        return service.update(model,id);
    }

    
    @DeleteMapping("cars/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Car(),id);
    }
}