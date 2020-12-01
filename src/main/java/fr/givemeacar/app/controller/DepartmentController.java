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

@RestController
@RequestMapping("/api")
public class DepartmentController{

    @Autowired
    DepartmentService service;

    @CrossOrigin
    @RequestMapping("departments/count")
    public BigInteger count() {
        return service.count(TableNames.departments);
    }

    @RequestMapping(value = "departments", method = RequestMethod.GET)
    public Collection<Department> findAll(@RequestParam(required = false) Integer offset, @RequestParam int limit) {
        if(offset != null) {
            return service.findAll(TableNames.departments,new Department(), offset, limit);
        }else{
            return service.findAll(TableNames.departments, new Department(),0,limit);
        }
    }

    @GetMapping("departments/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.departments,new Department(),id);

    }



    @CrossOrigin
    @PostMapping("departments")
    public ResponseEntity<String> create(@Valid @RequestBody Department model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("departments/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Department model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("departments/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Department(),id);
    }
}