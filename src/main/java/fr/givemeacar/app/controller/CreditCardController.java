package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.CreditCard;
import fr.givemeacar.app.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class CreditCardController {

    @Autowired
    CreditCardService service;

    @CrossOrigin
    @RequestMapping("creditcads/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/creditcads/{id}")
    public ResponseEntity<CreditCard> findById(@PathVariable int id) {
        Optional<CreditCard> model = service.findById(id);
        if (model.isPresent()) {
            return ResponseEntity.ok().body(model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/creditcads")
    public ResponseEntity<String> create(@Valid @RequestBody CreditCard model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/creditcads/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody CreditCard model) {
        return service.update(id, model);
    }

    @CrossOrigin
    @DeleteMapping("/creditcads/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}