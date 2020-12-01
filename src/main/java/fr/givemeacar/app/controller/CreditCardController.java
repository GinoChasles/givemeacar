package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.CreditCard;
import fr.givemeacar.app.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CreditCardController{

    @Autowired
    CreditCardService service;

    
    @RequestMapping("credit_cards/count")
    public BigInteger count() {
        return service.count(TableNames.creditCards);
    }

    @RequestMapping(value = "credit_cards", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        if(_start != null) {
            return service.findAll(TableNames.creditCards,new CreditCard(), _start, _end);
        }else{
            return service.findAll(TableNames.creditCards,new CreditCard(), 0,_end);
        }
    }

    @GetMapping("credit_cards/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.creditCards,new CreditCard(),id);

    }



    
    @PostMapping("credit_cards")
    public ResponseEntity<String> create(@Valid @RequestBody CreditCard model) {
        return service.create(model);
    }

    
    @PutMapping("credit_cards/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody CreditCard model) {
        return service.update(model,id);
    }

    
    @DeleteMapping("credit_cards/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new CreditCard(),id);
    }
}