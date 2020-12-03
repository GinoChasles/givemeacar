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
    public ResponseEntity count() {
        return count();
    }

    @RequestMapping(value = "managers", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return findAll(_order, _sort, _start, _end);
    }

    @GetMapping("managers/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return findById(id);
    }


    @PostMapping("managers")
    public ResponseEntity create(@Valid @RequestBody Manager model) {
        return create(model);
    }


    @PutMapping("managers/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Manager model) {
        return update(id, model);
    }


    @DeleteMapping("managers/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return delete(id);
    }

    @Override
    public ManagerService getService() {
        return service;
    }
}