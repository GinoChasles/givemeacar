package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Agency;
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
    public ResponseEntity count() {
        return count();
    }

    @RequestMapping(value = "agencies", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return findAll(_order, _sort, _start, _end);
    }

    @GetMapping("agencies/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return findById(id);
    }


    @PostMapping("agencies")
    public ResponseEntity create(@Valid @RequestBody Agency model) {
        return create(model);
    }


    @PutMapping("agencies/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Agency model) {
        return update(id, model);
    }


    @DeleteMapping("agencies/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return delete(id);
    }

    @Override
    public AgencyService getService() {
        return service;
    }
}