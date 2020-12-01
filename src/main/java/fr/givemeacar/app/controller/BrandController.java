package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Brand;
import fr.givemeacar.app.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BrandController{

    @Autowired
    BrandService service;

    @CrossOrigin
    @RequestMapping("brands/count")
    public BigInteger count() {
        return service.count(TableNames.brands);
    }

    @RequestMapping(value = "brands", method = RequestMethod.GET)
    public Collection<Brand> findAll(@RequestParam(required = false) Integer offset, @RequestParam int limit) {
        if(offset != null) {
            return service.findAll(TableNames.brands, offset, limit);
        }else{
            return service.findAll(TableNames.brands, 0,limit);
        }
    }

    @GetMapping("brands/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.brands,new Brand(),id);

    }



    @CrossOrigin
    @PostMapping("brands")
    public ResponseEntity<String> create(@Valid @RequestBody Brand model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("brands/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Brand model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("brands/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Brand(),id);
    }
}