package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Street;
import fr.givemeacar.app.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StreetController {

    @Autowired
    StreetService service;

    @CrossOrigin
    @RequestMapping("streets/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/streets/{id}")
    public ResponseEntity<Street> findById(@PathVariable int id) {
        Optional<Street> model = service.findById(id);
        if (model.isPresent()) {
            return ResponseEntity.ok().body(model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/streets")
    public ResponseEntity<String> create(@Valid @RequestBody Street model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/streets/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Street model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("/streets/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}