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
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "brands", method = RequestMethod.GET)
    @Override
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return super.findAll(_order, _sort, _start, _end);
    }

    @GetMapping("brands/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("brands")
    public ResponseEntity create(@Valid @RequestBody Brand model) {
        return super.create(model);
    }


    @PutMapping("brands/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Brand model) {
        return super.update(model);
    }


    @DeleteMapping("brands/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public BrandService getService() {
        return service;
    }
}