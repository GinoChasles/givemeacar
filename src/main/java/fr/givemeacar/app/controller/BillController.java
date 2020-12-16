package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Bill;
import fr.givemeacar.app.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BillController extends CrudControllerImpl<Bill>{

    @Autowired
    BillService service;

    @RequestMapping("bills/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "bills", method = RequestMethod.GET)
    @Override
        public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q){
            return super.findAll(new Bill(),"bills",_order, _sort, _start, _end, id, q);
    }

    @GetMapping("bills/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("bills")
    public ResponseEntity create(@Valid @RequestBody Bill model) {
        return super.create(model);
    }


    @PutMapping("bills/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Bill model) {
        return super.update(model);
    }


    @DeleteMapping("bills/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public BillService getService() {
        return service;
    }
}