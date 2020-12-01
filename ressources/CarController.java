package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Car;
import fr.givemeacar.app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    CarService service;

    @CrossOrigin
    @RequestMapping("cars/count")
    public Long count() {
        return service.count(TableNames.cars);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Optional<Car> manager = service.findById(TableNames.cars,id);
        if (manager.isPresent()) {
            return ResponseEntity.ok().body(manager.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/cars")
    public ResponseEntity<String> create(@Valid @RequestBody Car model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/cars/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Car model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}