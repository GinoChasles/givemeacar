package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.UserStatus;
import fr.givemeacar.app.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class UserStatusController {

    @Autowired
    UserStatusService service;

    @CrossOrigin
    @RequestMapping("userstatuses/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/userstatuses/{id}")
    public ResponseEntity<UserStatus> findById(@PathVariable int id) {
        Optional<UserStatus> model = service.findById(id);
        if (model.isPresent()) {
            return ResponseEntity.ok().body(model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/userstatuses")
    public ResponseEntity<String> create(@Valid @RequestBody UserStatus model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/userstatuses/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody UserStatus model) {
        return service.update(id, model);
    }

    @CrossOrigin
    @DeleteMapping("/userstatuses/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}