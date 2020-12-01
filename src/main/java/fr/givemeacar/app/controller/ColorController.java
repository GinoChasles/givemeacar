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

@RestController
@RequestMapping("/api")
public class ColorController{

    @Autowired
    ColorService service;

    @CrossOrigin
    @RequestMapping("colors/count")
    public BigInteger count() {
        return service.count(TableNames.colors);
    }

    @RequestMapping(value = "colors", method = RequestMethod.GET)
    public Collection<Color> findAll(@RequestParam(required = false) Integer offset, @RequestParam int limit) {
        if(offset != null) {
            return service.findAll(TableNames.colors, offset, limit);
        }else{
            return service.findAll(TableNames.colors, 0,limit);
        }
    }

    @GetMapping("colors/{id}")
    public ResponseEntity<Color> findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

       Color color = (Color) service.findById(TableNames.colors,new Color(),id);
        if (color != null) {
            return ResponseEntity.ok().body(color);
        }
        return ResponseEntity.notFound().build();
    }



    @CrossOrigin
    @PostMapping("colors")
    public ResponseEntity<String> create(@Valid @RequestBody Color color) {
        return service.create(color);
    }

    @CrossOrigin
    @PutMapping("colors/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Color color) {
        return service.update(color,id);
    }

    @CrossOrigin
    @DeleteMapping("colors/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(id);
    }
}