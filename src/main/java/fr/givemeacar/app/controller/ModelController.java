package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Model;
import fr.givemeacar.app.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ModelController extends CrudControllerImpl<Model>{

    @Autowired
    ModelService service;

    @RequestMapping("models/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "models", method = RequestMethod.GET)
    @Override
        public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q) {
            return super.findAll(new Model(),"models",_order, _sort, _start, _end, id, q);
    }

    @GetMapping("models/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("models")
    public ResponseEntity create(@Valid @RequestBody Model model) {
        return super.create(model);
    }


    @PutMapping("models/{id}")
    public ResponseEntity update(@PathVariable int id,@Valid @RequestBody Model model) {
        return super.update(model);
    }


    @DeleteMapping("models/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public ModelService getService() {
        return service;
    }
}