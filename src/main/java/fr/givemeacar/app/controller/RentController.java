package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Rent;
import fr.givemeacar.app.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class RentController extends CrudControllerImpl<Rent>{

    @Autowired
    RentService service;

    @RequestMapping("rents/count")
    public ResponseEntity count() {
        return tryCount();
    }

    @RequestMapping(value = "rents", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return tryFindAll(_order,_sort,_start,_end);
    }

    @GetMapping("rents/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return tryFindById(id);
    }


    @PostMapping("rents")
    public ResponseEntity create(@Valid @RequestBody Rent model) {
        return tryCreate(model);
    }


    @PutMapping("rents/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Rent model) {
        return tryUpdate(id,model);
    }


    @DeleteMapping("rents/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return tryDelete(id);
    }

    @Override
    public RentService getService() {
        return service;
    }
}