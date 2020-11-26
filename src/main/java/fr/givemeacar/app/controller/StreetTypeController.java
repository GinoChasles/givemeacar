package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.StreetType;
import fr.givemeacar.app.service.StreetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class StreetTypeController {

    @Autowired
    StreetTypeService service;

    @CrossOrigin
    @RequestMapping("managers/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/managers/{id}")
    public ResponseEntity<StreetType> findById(@PathVariable int id) {
        Optional<StreetType> model = service.findById(id);
        if (model.isPresent()) {
            return ResponseEntity.ok().body(model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/managers")
    public ResponseEntity<String> create(@Valid @RequestBody StreetType model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/managers/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody StreetType model) {
        return service.update(id, model);
    }

    @CrossOrigin
    @DeleteMapping("/managers/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}