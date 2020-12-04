package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Client;
import fr.givemeacar.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class ClientController extends CrudControllerImpl<Client>{

    @Autowired
    ClientService service;

    @RequestMapping("clients/count")
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "clients", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return super.findAll(_order, _sort, _start, _end);
    }

    @GetMapping("clients/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("clients")
    public ResponseEntity create(@Valid @RequestBody Client model) {
        return super.create(model);
    }


    @PutMapping("clients/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Client model) {
        return super.update(model);
    }


    @DeleteMapping("clients/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public ClientService getService() {
        return service;
    }
}