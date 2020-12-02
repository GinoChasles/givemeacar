package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Street;
import fr.givemeacar.app.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class StreetController extends CrudControllerImpl<Street>{

    @Autowired
    StreetService service;

    @RequestMapping("streets/count")
    public ResponseEntity count() {
        return tryCount();
    }

    @RequestMapping(value = "streets", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return tryFindAll(_order,_sort,_start,_end);
    }

    @GetMapping("streets/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return tryFindById(id);
    }


    @PostMapping("streets")
    public ResponseEntity create(@Valid @RequestBody Street model) {
        return tryCreate(model);
    }


    @PutMapping("streets/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Street model) {
        return tryUpdate(id,model);
    }


    @DeleteMapping("streets/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return tryDelete(id);
    }

    @Override
    public StreetService getService() {
        return service;
    }
}