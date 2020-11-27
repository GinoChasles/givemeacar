package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Country;
import fr.givemeacar.app.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    CountryService service;

    @CrossOrigin
    @RequestMapping("countries/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> findById(@PathVariable int id) {
        Optional<Country> model = service.findById(id);
        if (model.isPresent()) {
            return ResponseEntity.ok().body(model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/countries")
    public ResponseEntity<String> create(@Valid @RequestBody Country model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/countries/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Country model) {
        return service.update(id, model);
    }

    @CrossOrigin
    @DeleteMapping("/countries/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}