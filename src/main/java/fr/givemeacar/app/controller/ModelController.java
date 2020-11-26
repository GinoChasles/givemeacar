package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Model;
import fr.givemeacar.app.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ModelController {

    @Autowired
    ModelService service;

    @CrossOrigin
    @RequestMapping("models/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/models/{id}")
    public ResponseEntity<Model> findById(@PathVariable int id) {
        Optional<Model> model = service.findById(id);
        if (model.isPresent()) {
            return ResponseEntity.ok().body(model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/models")
    public ResponseEntity<String> create(@Valid @RequestBody Model model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/models/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Model model) {
        return service.update(id, model);
    }

    @CrossOrigin
    @DeleteMapping("/models/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}