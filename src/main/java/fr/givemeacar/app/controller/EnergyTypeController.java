package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.EnergyType;
import fr.givemeacar.app.service.EnergyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EnergyTypeController extends CrudControllerImpl<EnergyType>{

    @Autowired
    EnergyTypeService service;

    @RequestMapping("energy_types/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "energy_types", method = RequestMethod.GET)
    @Override
    public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
            @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id) {
        return super.findAll(_order, _sort, _start, _end, id);
    }

    @GetMapping("energy_types/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("energy_types")
    public ResponseEntity create(@Valid @RequestBody EnergyType model) {
        return super.create(model);
    }


    @PutMapping("energy_types/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody EnergyType model) {
        return super.update(model);
    }


    @DeleteMapping("energy_types/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public EnergyTypeService getService() {
        return service;
    }
}