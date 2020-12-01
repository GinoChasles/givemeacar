package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Region;
import fr.givemeacar.app.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegionController {

    @Autowired
    RegionService service;

    @CrossOrigin
    @RequestMapping("regions/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/regions/{id}")
    public ResponseEntity<Region> findById(@PathVariable int id) {
        Optional<Region> model = service.findById(id);
        if (model.isPresent()) {
            return ResponseEntity.ok().body(model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/regions")
    public ResponseEntity<String> create(@Valid @RequestBody Region model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/regions/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Region model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("/regions/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}