package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Department;
import fr.givemeacar.app.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class DepartmentController extends CrudControllerImpl<Department>{

    @Autowired
    DepartmentService service;

    @RequestMapping("departments/count")
    public ResponseEntity count() {
        return tryCount();
    }

    @RequestMapping(value = "departments", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return tryFindAll(_order,_sort,_start,_end);
    }

    @GetMapping("departments/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return tryFindById(id);
    }


    @PostMapping("departments")
    public ResponseEntity create(@Valid @RequestBody Department model) {
        return tryCreate(model);
    }


    @PutMapping("departments/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Department model) {
        return tryUpdate(id,model);
    }


    @DeleteMapping("departments/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return tryDelete(id);
    }

    @Override
    public DepartmentService getService() {
        return service;
    }
}