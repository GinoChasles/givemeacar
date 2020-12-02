package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Model;
import fr.givemeacar.app.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class ModelController extends CrudControllerImpl<Model>{

    @Autowired
    ModelService service;

    @RequestMapping("models/count")
    public ResponseEntity count() {
        return tryCount();
    }

    @RequestMapping(value = "models", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return tryFindAll(_order,_sort,_start,_end);
    }

    @GetMapping("models/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return tryFindById(id);
    }


    @PostMapping("models")
    public ResponseEntity create(@Valid @RequestBody Model model) {
        return tryCreate(model);
    }


    @PutMapping("models/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Model model) {
        return tryUpdate(id,model);
    }


    @DeleteMapping("models/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return tryDelete(id);
    }

    @Override
    public ModelService getService() {
        return service;
    }
}