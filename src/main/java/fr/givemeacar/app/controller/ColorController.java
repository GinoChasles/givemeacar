package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ColorController {

    @Autowired
    ColorService service;

    @CrossOrigin
    @RequestMapping("colors/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/colors/{id}")
    public ResponseEntity<Color> findById(@PathVariable int id) {
        Optional<Color> color = service.findById(id);
        if (color.isPresent()) {
            return ResponseEntity.ok().body(color.get());
        }
        return ResponseEntity.notFound().build();
    }



    @CrossOrigin
    @PostMapping("colors")
    public ResponseEntity<String> create(@Valid @RequestBody Color color) {
        return service.create(color);
    }

    @CrossOrigin
    @PutMapping("colors/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Color color) {
        return service.update(id, color);
    }

    @CrossOrigin
    @DeleteMapping("colors/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}