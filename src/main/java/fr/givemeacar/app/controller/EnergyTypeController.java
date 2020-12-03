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
    public ResponseEntity count() {
        return count();
    }

    @RequestMapping(value = "energy_types", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return findAll(_order, _sort, _start, _end);
    }

    @GetMapping("energy_types/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return findById(id);
    }


    @PostMapping("energy_types")
    public ResponseEntity create(@Valid @RequestBody EnergyType model) {
        return create(model);
    }


    @PutMapping("energy_types/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody EnergyType model) {
        return update(id, model);
    }


    @DeleteMapping("energy_types/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return delete(id);
    }

    @Override
    public EnergyTypeService getService() {
        return service;
    }
}