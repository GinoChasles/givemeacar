package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Administrator;
import fr.givemeacar.app.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AdministratorController extends CrudControllerImpl<Administrator>{

    @Autowired
    AdministratorService service;

    @RequestMapping("administrators/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "administrators", method = RequestMethod.GET)
    @Override
        public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q) {
            return super.findAll(new Administrator(),"administrators",_order, _sort, _start, _end, id, q);
    }

    @GetMapping("administrators/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("administrators")
    public ResponseEntity create(@Valid @RequestBody Administrator model) {
        return super.create(model);
    }


    @PutMapping("administrators/{id}")
    public ResponseEntity update(@PathVariable int id,@Valid @RequestBody Administrator model) {
        return super.update(model);
    }


    @DeleteMapping("administrators/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public AdministratorService getService() {
        return service;
    }
}