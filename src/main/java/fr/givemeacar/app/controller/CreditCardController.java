package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.CreditCard;
import fr.givemeacar.app.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class CreditCardController extends CrudControllerImpl<CreditCard>{

    @Autowired
    CreditCardService service;

    @RequestMapping("credit_cards/count")
    public ResponseEntity count() {
        return count();
    }

    @RequestMapping(value = "credit_cards", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return findAll(_order, _sort, _start, _end);
    }

    @GetMapping("credit_cards/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return findById(id);
    }


    @PostMapping("credit_cards")
    public ResponseEntity create(@Valid @RequestBody CreditCard model) {
        return create(model);
    }


    @PutMapping("credit_cards/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody CreditCard model) {
        return update(id, model);
    }


    @DeleteMapping("credit_cards/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return delete(id);
    }

    @Override
    public CreditCardService getService() {
        return service;
    }
}