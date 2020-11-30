package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Agency;
import fr.givemeacar.app.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AgencyController {

    @Autowired
    AgencyService service;

    @CrossOrigin
    @RequestMapping("agencies/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/agencies/{id}")
    public ResponseEntity<Agency> findById(@PathVariable int id) {
        Optional<Agency> manager = service.findById(id);
        if (manager.isPresent()) {
            return ResponseEntity.ok().body(manager.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/agencies/")
    public ResponseEntity<List<Agency>> findAll() {
        List<Agency> models = service.findAll();
        if (models.size() != 0) {
            return ResponseEntity.ok().body(models);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/agencies")
    public ResponseEntity<String> create(@Valid @RequestBody Agency model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/agencies/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Agency model) {
        return service.update(id, model);
    }

    @CrossOrigin
    @DeleteMapping("/agencies/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}