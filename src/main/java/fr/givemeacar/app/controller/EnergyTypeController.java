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

@RestController
@RequestMapping("/api")
public class EnergyTypeController{

    @Autowired
    EnergyTypeService service;

    @CrossOrigin
    @RequestMapping("energy_types/count")
    public BigInteger count() {
        return service.count(TableNames.energyTypes);
    }

    @RequestMapping(value = "energy_types", method = RequestMethod.GET)
    public Collection<EnergyType> findAll(@RequestParam(required = false) Integer offset, @RequestParam int limit) {
        if(offset != null) {
            return service.findAll(TableNames.energyTypes, offset, limit);
        }else{
            return service.findAll(TableNames.energyTypes, 0,limit);
        }
    }

    @GetMapping("energy_types/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.energyTypes,new EnergyType(),id);

    }



    @CrossOrigin
    @PostMapping("energy_types")
    public ResponseEntity<String> create(@Valid @RequestBody EnergyType model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("energy_types/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody EnergyType model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("energy_types/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new EnergyType(),id);
    }
}