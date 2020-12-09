package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Region;
import fr.givemeacar.app.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RegionController extends CrudControllerImpl<Region>{

    @Autowired
    RegionService service;

    @RequestMapping("regions/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "regions", method = RequestMethod.GET)
    @Override
    public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
            @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id) {
        return super.findAll(_order, _sort, _start, _end, id);
    }

    @GetMapping("regions/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("regions")
    public ResponseEntity create(@Valid @RequestBody Region model) {
        return super.create(model);
    }


    @PutMapping("regions/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Region model) {
        return super.update(model);
    }


    @DeleteMapping("regions/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public RegionService getService() {
        return service;
    }
}