package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class ColorController{

    @Autowired
    ColorService service;


    @RequestMapping("colors/count")
    public BigInteger count() {
        return service.count(TableNames.colors);
    }

    @RequestMapping(value = "colors", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        if(_start != null) {
            return service.findAll(TableNames.colors, new Color(),_start, _end);
        }else{
            return service.findAll(TableNames.colors, new Color(),0,_end);
        }
    }

    @GetMapping("colors/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
       return service.findById(TableNames.colors,new Color(),id);

    }



    
    @PostMapping("colors")
    public ResponseEntity<String> create(@Valid @RequestBody Color color) {
        return service.create(color);
    }

    
    @PutMapping("colors/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Color color) {
        return service.update(color,id);
    }

    
    @DeleteMapping("colors/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Color(),id);
    }
}