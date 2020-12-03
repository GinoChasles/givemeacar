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
    public ResponseEntity count() {
        return count();
    }

    @RequestMapping(value = "street_suffices", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return findAll(_order, _sort, _start, _end);
    }

    @GetMapping("street_suffices/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return findById(id);
    }


    @PostMapping("street_suffices")
    public ResponseEntity create(@Valid @RequestBody StreetSuffix model) {
        return create(model);
    }


    @PutMapping("street_suffices/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody StreetSuffix model) {
        return update(id, model);
    }


    @DeleteMapping("street_suffices/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return delete(id);
    }

    @Override
    public StreetSuffixService getService() {
        return service;
    }
}