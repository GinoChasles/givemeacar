package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Client;
import fr.givemeacar.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService service;

    @CrossOrigin
    @RequestMapping("clients/count")
    public Long count() {
        return service.count(TableNames.clients);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Optional<Client> model = service.findById(TableNames.clients,id);
        if (model.isPresent()) {
            return ResponseEntity.ok().body(model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/clients")
    public ResponseEntity<String> create(@Valid @RequestBody Client model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/clients/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Client model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}