package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Geolocation;
import fr.givemeacar.app.service.GeolocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GeolocationController {

    @Autowired
    GeolocationService service;

    @CrossOrigin
    @RequestMapping("geolocations/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/geolocations/{id}")
    public ResponseEntity<Geolocation> findById(@PathVariable int id) {
        Optional<Geolocation> model = service.findById(id);
        if (model.isPresent()) {
            return ResponseEntity.ok().body(model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/geolocations")
    public ResponseEntity<String> create(@Valid @RequestBody Geolocation model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/geolocations/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Geolocation model) {
        return service.update(id, model);
    }

    @CrossOrigin
    @DeleteMapping("/geolocations/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}