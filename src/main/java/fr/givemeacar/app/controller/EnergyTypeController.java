package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.EnergyType;
import fr.givemeacar.app.service.EnergyTypeService;
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
public class EnergyTypeController{

    @Autowired
    EnergyTypeService service;

    
    @RequestMapping("energy_types/count")
    public BigInteger count() {
        return service.count(TableNames.energyTypes);
    }

    @RequestMapping(value = "energy_types", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        if(_start != null) {
            return service.findAll(TableNames.energyTypes,new EnergyType(),_start, _end,_order,_sort);
        }else{
            return service.findAll(TableNames.energyTypes,new EnergyType(), 0, _end,_order,_sort);
        }
    }

    @GetMapping("energy_types/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.energyTypes,new EnergyType(),id);

    }



    
    @PostMapping("energy_types")
    public ResponseEntity<String> create(@Valid @RequestBody EnergyType model) {
        return service.create(model);
    }

    
    @PutMapping("energy_types/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody EnergyType model) {
        return service.update(model,id);
    }

    
    @DeleteMapping("energy_types/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new EnergyType(),id);
    }
}