package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Model;
import fr.givemeacar.app.service.ModelService;
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
public class ModelController{

    @Autowired
    ModelService service;

    
    @RequestMapping("models/count")
    public BigInteger count() {
        return service.count(TableNames.models);
    }

    @RequestMapping(value = "models", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) Integer offset, @RequestParam int limit) {
        if(offset != null) {
            return service.findAll(TableNames.models,new Model(), offset, limit);
        }else{
            return service.findAll(TableNames.models,new Model(), 0,limit);
        }
    }

    @GetMapping("models/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.models,new Model(),id);

    }



    
    @PostMapping("models")
    public ResponseEntity<String> create(@Valid @RequestBody Model model) {
        return service.create(model);
    }

    
    @PutMapping("models/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Model model) {
        return service.update(model,id);
    }

    
    @DeleteMapping("models/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Model(),id);
    }
}