package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Brand;
import fr.givemeacar.app.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class BrandController extends CrudControllerImpl<Brand>{

    @Autowired
    BrandService service;

    @RequestMapping("brands/count")
    public ResponseEntity count() {
        return count();
    }

    @RequestMapping(value = "brands", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return findAll(_order, _sort, _start, _end);
    }

    @GetMapping("brands/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return findById(id);
    }


    @PostMapping("brands")
    public ResponseEntity create(@Valid @RequestBody Brand model) {
        return create(model);
    }


    @PutMapping("brands/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Brand model) {
        return update(id, model);
    }


    @DeleteMapping("brands/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return delete(id);
    }

    @Override
    public BrandService getService() {
        return service;
    }
}