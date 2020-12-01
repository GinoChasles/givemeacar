package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.Bill;
import fr.givemeacar.app.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BillController{

    @Autowired
    BillService service;

    @CrossOrigin
    @RequestMapping("bills/count")
    public BigInteger count() {
        return service.count(TableNames.bills);
    }

    @RequestMapping(value = "bills", method = RequestMethod.GET)
    public Collection<Bill> findAll(@RequestParam(required = false) Integer offset, @RequestParam int limit) {
        if(offset != null) {
            return service.findAll(TableNames.bills, offset, limit);
        }else{
            return service.findAll(TableNames.bills, 0,limit);
        }
    }

    @GetMapping("bills/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.bills,new Bill(),id);

    }



    @CrossOrigin
    @PostMapping("bills")
    public ResponseEntity<String> create(@Valid @RequestBody Bill model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("bills/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Bill model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("bills/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new Bill(),id);
    }
}