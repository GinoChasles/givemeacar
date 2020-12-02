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
    public ResponseEntity count() {
        return tryCount();
    }

    @RequestMapping(value = "regions", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return tryFindAll(_order,_sort,_start,_end);
    }

    @GetMapping("regions/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return tryFindById(id);
    }


    @PostMapping("regions")
    public ResponseEntity create(@Valid @RequestBody Region model) {
        return tryCreate(model);
    }


    @PutMapping("regions/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Region model) {
        return tryUpdate(id,model);
    }


    @DeleteMapping("regions/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return tryDelete(id);
    }

    @Override
    public RegionService getService() {
        return service;
    }
}