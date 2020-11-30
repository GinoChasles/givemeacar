package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Administrator;
import fr.givemeacar.app.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AdministratorController {

    @Autowired
    AdministratorService service;

    @CrossOrigin
    @RequestMapping("administrators/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/administrators/{id}")
    public ResponseEntity<Administrator> findById(@PathVariable int id) {
        Optional<Administrator> manager = service.findById(id);
        if (manager.isPresent()) {
            return ResponseEntity.ok().body(manager.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/administrators")
    public ResponseEntity<String> create(@Valid @RequestBody Administrator model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/administrators/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Administrator model) {
        return service.update(id, model);
    }

    @CrossOrigin
    @DeleteMapping("/administrators/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}