package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Bill;
import fr.givemeacar.app.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class BillController {

    @Autowired
    BillService service;

    @CrossOrigin
    @RequestMapping("bills/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/bills/{id}")
    public ResponseEntity<Bill> findById(@PathVariable int id) {
        Optional<Bill> manager = service.findById(id);
        if (manager.isPresent()) {
            return ResponseEntity.ok().body(manager.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/bills")
    public ResponseEntity<String> create(@Valid @RequestBody Bill model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/bills/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Bill model) {
        return service.update(id, model);
    }

    @CrossOrigin
    @DeleteMapping("/bills/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}