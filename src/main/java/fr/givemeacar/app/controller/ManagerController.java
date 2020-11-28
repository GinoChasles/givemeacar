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
@RequestMapping("api")
public class ManagerController{

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
        if  (model.isPresent()) {
            return ResponseEntity.ok().body (model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/managers")
    public ResponseEntity<List<Manager>> findAll() {
        List<Manager> models = service.findAll();

        if  (models.size() != 0) {
            return ResponseEntity.ok().body(models);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/managers")
    public ResponseEntity<String> create(@Valid @RequestBody Manager model) {
        return service.create (model);
    }

    @CrossOrigin
    @PutMapping("/managers/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Manager model) {
        return service.update(id,model);
    }

    @CrossOrigin
    @DeleteMapping("/managers/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}