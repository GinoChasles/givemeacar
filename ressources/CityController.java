package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.City;
import fr.givemeacar.app.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    CityService service;

    @CrossOrigin
    @RequestMapping("cities/count")
    public Long count() {
        return service.count(TableNames.cities);
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Optional<City> model = service.findById(TableNames.cities,id);
        if (model.isPresent()) {
            return ResponseEntity.ok().body(model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/cities")
    public ResponseEntity<String> create(@Valid @RequestBody City model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/cities/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody City model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("/cities/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}