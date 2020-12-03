package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Manager;
import fr.givemeacar.app.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ManagerController extends CrudControllerImpl<Manager>{

    @Autowired
    ManagerService service;

    @RequestMapping("managers/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "managers", method = RequestMethod.GET)
    @Override
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return super.findAll(_order, _sort, _start, _end);
    }

    @GetMapping("managers/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("managers")
    public ResponseEntity create(@Valid @RequestBody Manager model) {
        return super.create(model);
    }


    @PutMapping("managers/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Manager model) {
        return super.update(model);
    }


    @DeleteMapping("managers/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public ManagerService getService() {
        return service;
    }
}