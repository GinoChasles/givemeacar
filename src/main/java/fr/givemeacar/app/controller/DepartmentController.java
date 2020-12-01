package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Department;
import fr.givemeacar.app.service.DepartmentService;
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
public class DepartmentController{

    @Autowired
    DepartmentService service;

    
    @RequestMapping("departments/count")
    public BigInteger count() {
        return service.count(TableNames.departments);
    }

    @RequestMapping(value = "departments", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        if(_start != null) {
            return service.findAll(TableNames.departments,new Department(), _start, _end);
        }else{
            return service.findAll(TableNames.departments, new Department(),0,_end);
        }
    }

    @GetMapping("departments/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.departments,new Department(),id);

    }



    
    @PostMapping("departments")
    public ResponseEntity<String> create(@Valid @RequestBody Department model) {
        return service.create(model);
    }

    
    @PutMapping("departments/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Department model) {
        return service.update(model,id);
    }

    
    @DeleteMapping("departments/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Department(),id);
    }
}