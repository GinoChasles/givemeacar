package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.CreditCard;
import fr.givemeacar.app.repository.CreditCardRepository;
import fr.givemeacar.app.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CreditCardController extends CrudControllerImpl<CreditCard>{

    @Autowired
    CreditCardService service;

    @RequestMapping("credit_cards/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "credit_cards", method = RequestMethod.GET)
    @Override
        public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q) {
            return super.findAll(new CreditCard(),"credit_cards",_order, _sort, _start, _end, id, q);
    }

    @GetMapping("credit_cards/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("credit_cards")
    public ResponseEntity create(@Valid @RequestBody CreditCard model) {
        return super.create(model);
    }


    @PutMapping("credit_cards/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody CreditCard model) {
        return super.update(model);
    }


    @DeleteMapping("credit_cards/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public CreditCardService getService() {
        return service;
    }
}