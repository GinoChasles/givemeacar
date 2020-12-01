package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Department;
import fr.givemeacar.app.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @CrossOrigin
    @RequestMapping("departments/count")
    public Long count() {
        return service.count(TableNames.departments);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Optional<Department> model = service.findById(TableNames.departments,id);
        if (model.isPresent()) {
            return ResponseEntity.ok().body(model.get());
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PostMapping("/departments")
    public ResponseEntity<String> create(@Valid @RequestBody Department model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("/departments/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Department model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("/departments/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}