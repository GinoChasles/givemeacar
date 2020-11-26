package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Address;
import fr.givemeacar.app.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class AddressController {

    @Autowired
    AddressService service;

    @CrossOrigin
    @RequestMapping("addresses/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Address> findById(@PathVariable int id) {
        Optional<Address> address = service.findById(id);
        if (address.isPresent()) {
            return ResponseEntity.ok().body(address.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/addresses")
    public ResponseEntity<String> create(@Valid @RequestBody Address address) {
        return service.create(address);
    }

    @CrossOrigin
    @PutMapping("/addresses/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Address address) {
        return service.update(id, address);
    }

    @CrossOrigin
    @DeleteMapping("/addresses/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}