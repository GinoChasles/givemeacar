package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Manager;
import fr.givemeacar.app.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class ManagerController {

    @Autowired
    ManagerService service;

    
    @RequestMapping("managers/count")
    public BigInteger count() {
        return service.count(TableNames.managers);
    }


    @RequestMapping(value = "managers", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        if(_start != null) {
            return service.findAll(TableNames.managers, new Manager(),_start, _end,_order,_sort);
        }else{
<<<<<<< HEAD
            return service.findAll(TableNames.managers, new Manager(),0,limit);

=======
            return service.findAll(TableNames.managers, new Manager(),0, _end,_order,_sort);
>>>>>>> gino
        }
    }

    @GetMapping("managers/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.managers,new Manager(),id);

    }



    
    @PostMapping("managers")
    public ResponseEntity<String> create(@Valid @RequestBody Manager model) {
        return service.create(model);
    }

    
    @PutMapping("managers/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Manager model) {
        return service.update(model,id);
    }

    
    @DeleteMapping("managers/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Manager(),id);
    }
}