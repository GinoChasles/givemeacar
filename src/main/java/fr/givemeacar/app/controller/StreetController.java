package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Street;
import fr.givemeacar.app.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StreetController extends CrudControllerImpl<Street>{

    @Autowired
    StreetService service;

    @RequestMapping("streets/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "streets", method = RequestMethod.GET)
    @Override
        public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q) {
            return super.findAll(new Street(),"streets",_order, _sort, _start, _end, id, q);
    }

    @GetMapping("streets/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("streets")
    public ResponseEntity create(@Valid @RequestBody Street model) {
        return super.create(model);
    }


    @PutMapping("streets/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Street model) {
        return super.update(model);
    }


    @DeleteMapping("streets/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public StreetService getService() {
        return service;
    }
}