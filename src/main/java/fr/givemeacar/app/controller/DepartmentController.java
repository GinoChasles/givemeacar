package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Department;
import fr.givemeacar.app.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DepartmentController extends CrudControllerImpl<Department>{

    @Autowired
    DepartmentService service;

    @RequestMapping("departments/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "departments", method = RequestMethod.GET)
    @Override
        public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q) {
            return super.findAll(new Department(),"departments",_order, _sort, _start, _end, id, q);
    }

    @GetMapping("departments/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("departments")
    public ResponseEntity create(@Valid @RequestBody Department model) {
        return super.create(model);
    }


    @PutMapping("departments/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Department model) {
        return super.update(model);
    }


    @DeleteMapping("departments/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public DepartmentService getService() {
        return service;
    }
}