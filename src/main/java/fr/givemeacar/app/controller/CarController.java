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

@RestController
@RequestMapping("/api")
public class CarController{

    @Autowired
    CarService service;

    @CrossOrigin
    @RequestMapping("cars/count")
    public BigInteger count() {
        return service.count(TableNames.cars);
    }

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public Collection<Car> findAll(@RequestParam(required = false) Integer offset, @RequestParam int limit) {
        if(offset != null) {
            return service.findAll(TableNames.cars, offset, limit);
        }else{
            return service.findAll(TableNames.cars, 0,limit);
        }
    }

    @GetMapping("cars/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.cars,new Car(),id);

    }



    @CrossOrigin
    @PostMapping("cars")
    public ResponseEntity<String> create(@Valid @RequestBody Car model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("cars/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Car model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("cars/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Car(),id);
    }
}