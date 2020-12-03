package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Agency;
import fr.givemeacar.app.repository.AgencyRepository;
import fr.givemeacar.app.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AgencyController extends CrudControllerImpl<Agency>{

    @Autowired
    AgencyService service;

    @RequestMapping("agencies/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "agencies", method = RequestMethod.GET)
    @Override
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return super.findAll(_order, _sort, _start, _end);
    }

    @GetMapping("agencies/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("agencies")
    public ResponseEntity create(@Valid @RequestBody Agency model) {
        return super.create(model);
    }


    @PutMapping("agencies/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Agency model) {
        return super.update(model);
    }


    @DeleteMapping("agencies/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public AgencyService getService() {
        return service;
    }
}