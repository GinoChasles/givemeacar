package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.StreetName;
import fr.givemeacar.app.service.StreetNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StreetNameController extends CrudControllerImpl<StreetName>{

    @Autowired
    StreetNameService service;

    @RequestMapping("street_names/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "street_names", method =
            RequestMethod.GET)
    @Override
        public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q) {
            return super.findAll(_order, _sort, _start, _end, id, q);
    }

    @GetMapping("street_names/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("street_names")
    public ResponseEntity create(@Valid @RequestBody StreetName model) {
        return super.create(model);
    }


    @PutMapping("street_names/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody StreetName model) {
        return super.update(model);
    }


    @DeleteMapping("street_names/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public StreetNameService getService() {
        return service;
    }
}