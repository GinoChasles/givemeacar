package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Bill;
import fr.givemeacar.app.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class BillController extends CrudControllerImpl<Bill>{

    @Autowired
    BillService service;

    @RequestMapping("bills/count")
    public ResponseEntity count() {
        return tryCount();
    }

    @RequestMapping(value = "bills", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return tryFindAll(_order,_sort,_start,_end);
    }

    @GetMapping("bills/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return tryFindById(id);
    }


    @PostMapping("bills")
    public ResponseEntity create(@Valid @RequestBody Bill model) {
        return tryCreate(model);
    }


    @PutMapping("bills/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Bill model) {
        return tryUpdate(id,model);
    }


    @DeleteMapping("bills/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return tryDelete(id);
    }

    @Override
    public BillService getService() {
        return service;
    }
}