package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Brand;
import fr.givemeacar.app.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BrandController {

    @Autowired
    BrandService service;

    @CrossOrigin
    @RequestMapping("brands/count")
    public Long count() {
        return service.count(TableNames.brands);
    }

    @GetMapping("/brands/{id}")
    public ResponseEntity<Brand> findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Optional<Brand> manager = service.findById(TableNames.brands,id);
        if (manager.isPresent()) {
            return ResponseEntity.ok().body(manager.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/brands")
    public ResponseEntity<String> create(@Valid @RequestBody Brand model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/brands/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Brand model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("/brands/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}