package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Manager;
import fr.givemeacar.app.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
<<<<<<< HEAD
public class ManagerController {
=======
public class ManagerController{
>>>>>>> gino

    @Autowired
    ManagerService service;

    @CrossOrigin
    @RequestMapping("managers/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/managers/{id}")
    public ResponseEntity<Manager> findById(@PathVariable int id) {
        Optional<Manager> model = service.findById(id);
        if (model.isPresent()) {
            return ResponseEntity.ok().body(model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/managers")
    public ResponseEntity<String> create(@Valid @RequestBody Manager model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/managers/{id}")
<<<<<<< HEAD
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Manager model) {
        return service.update(id, model);
=======
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Manager model) {
        return service.update(model,id);
>>>>>>> gino
    }

    @CrossOrigin
    @DeleteMapping("/managers/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}