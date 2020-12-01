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

@RestController
@RequestMapping("/api")
public class ManagerController{

    @Autowired
    ManagerService service;

    @CrossOrigin
    @RequestMapping("managers/count")
    public BigInteger count() {
        return service.count(TableNames.managers);
    }

    @RequestMapping(value = "managers", method = RequestMethod.GET)
    public Collection<Manager> findAll(@RequestParam(required = false) Integer offset, @RequestParam int limit) {
        if(offset != null) {
            return service.findAll(TableNames.managers, offset, limit);
        }else{
            return service.findAll(TableNames.managers, 0,limit);
        }
    }

    @GetMapping("managers/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.managers,new Manager(),id);

    }



    @CrossOrigin
    @PostMapping("managers")
    public ResponseEntity<String> create(@Valid @RequestBody Manager model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("managers/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Manager model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("managers/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Manager(),id);
    }
}