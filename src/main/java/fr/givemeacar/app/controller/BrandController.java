package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Brand;
import fr.givemeacar.app.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

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
        public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q) {
            return super.findAll(new Brand(),"brands",_order, _sort, _start, _end, id, q);
    }

    @GetMapping("brands/{id}")
    @Override
    public ResponseEntity findById(@PathVariable Integer id) {
        return super.findById(id);
    }


    @PostMapping("brands")
    public ResponseEntity create(@Valid @RequestBody Brand model) {
        return super.create(model);
    }


    @PutMapping("brands/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody Brand model) {
        return super.update(model);
    }


    @DeleteMapping("brands/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        return super.deleteById(id);
    }

    @Override
    public BrandService getService() {
        return service;
    }
}