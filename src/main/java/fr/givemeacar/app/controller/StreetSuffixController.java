package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.StreetSuffix;
import fr.givemeacar.app.service.StreetSuffixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StreetSuffixController extends CrudControllerImpl<StreetSuffix>{

    @Autowired
    StreetSuffixService service;

    @RequestMapping("street_suffices/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "street_suffices", method = RequestMethod.GET)
    @Override
    public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
            @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id) {
        return super.findAll(_order, _sort, _start, _end, id);
    }

    @GetMapping("street_suffices/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("street_suffices")
    public ResponseEntity create(@Valid @RequestBody StreetSuffix model) {
        return super.create(model);
    }


    @PutMapping("street_suffices/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody StreetSuffix model) {
        return super.update(model);
    }


    @DeleteMapping("street_suffices/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public StreetSuffixService getService() {
        return service;
    }
}