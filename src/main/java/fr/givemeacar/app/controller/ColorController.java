package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ColorController extends CrudControllerImpl<Color>{

    @Autowired
    ColorService service;

    @RequestMapping("colors/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @GetMapping("colors")
    @Override
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return super.findAll(_order, _sort, _start, _end);
    }

    @GetMapping("colors/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("colors")
    public ResponseEntity create(@Valid @RequestBody Color model) {
            return super.create(model);
    }


    @PutMapping("colors/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Color model) {
        return super.update(model);
    }


    @DeleteMapping("colors/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public ColorService getService() {
        return service;
    }
}