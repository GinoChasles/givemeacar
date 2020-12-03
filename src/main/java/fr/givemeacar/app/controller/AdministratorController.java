package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Administrator;
import fr.givemeacar.app.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class AdministratorController extends CrudControllerImpl<Administrator>{

    @Autowired
    AdministratorService service;

    @RequestMapping("administrators/count")
    public ResponseEntity count() {
        return tryCount();
    }

    @RequestMapping(value = "administrators", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return tryFindAll(_order,_sort,_start,_end);
    }

    @GetMapping("administrators/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return tryFindById(id);
    }


    @PostMapping("administrators")
    public ResponseEntity create(@Valid @RequestBody Administrator model) {
        return tryCreate(model);
    }


    @PutMapping("administrators/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Administrator model) {
        return tryUpdate(id,model);
    }


    @DeleteMapping("administrators/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return tryDelete(id);
    }

    @Override
    public AdministratorService getService() {
        return service;
    }
}