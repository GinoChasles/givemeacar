package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity count() {
        return tryCount();
    }

    @RequestMapping(value = "colors", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return tryFindAll(_order,_sort,_start,_end);
    }

    @GetMapping("colors/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return tryFindById(id);
    }


    @PostMapping("colors")
    public ResponseEntity create(@Valid @RequestBody Color model) {
        return tryCreate(model);
    }


    @PutMapping("colors/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Color model) {
        return tryUpdate(id,model);
    }


    @DeleteMapping("colors/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return tryDelete(id);
    }

    @Override
    public ColorService getService() {
        return service;
    }
}