package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Energy;
import fr.givemeacar.app.service.EnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EnergyController {

    @Autowired
    EnergyService service;

    @CrossOrigin
    @RequestMapping("energies/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/energies/{id}")
    public ResponseEntity<Energy> findById(@PathVariable int id) {
        Optional<Energy> model = service.findById(id);
        if (model.isPresent()) {
            return ResponseEntity.ok().body(model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/energies")
    public ResponseEntity<String> create(@Valid @RequestBody Energy model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/energies/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Energy model) {
        return service.update(id, model);
    }

    @CrossOrigin
    @DeleteMapping("/energies/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}