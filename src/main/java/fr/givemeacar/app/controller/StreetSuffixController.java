package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.StreetSuffix;
import fr.givemeacar.app.service.StreetSuffixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StreetSuffixController {

    @Autowired
    StreetSuffixService service;

    @CrossOrigin
    @RequestMapping("streetsuffices/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/streetsuffices/{id}")
    public ResponseEntity<StreetSuffix> findById(@PathVariable int id) {
        Optional<StreetSuffix> model = service.findById(id);
        if (model.isPresent()) {
            return ResponseEntity.ok().body(model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/streetsuffices")
    public ResponseEntity<String> create(@Valid @RequestBody StreetSuffix model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/streetsuffices/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody StreetSuffix model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("/streetsuffices/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}