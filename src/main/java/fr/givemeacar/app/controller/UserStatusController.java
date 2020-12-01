package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.TableNames;
import fr.givemeacar.app.model.UserStatus;
import fr.givemeacar.app.service.UserStatusService;
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
public class UserStatusController{

    @Autowired
    UserStatusService service;

    
    @RequestMapping("user_statuses/count")
    public BigInteger count() {
        return service.count(TableNames.userStatuses);
    }

    @RequestMapping(value = "user_statuses", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        if(_start != null) {
            return service.findAll(TableNames.userStatuses,new UserStatus(), _start, _end);
        }else{
            return service.findAll(TableNames.userStatuses, new UserStatus(),0,_end);
        }
    }

    @GetMapping("user_statuses/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.userStatuses,new UserStatus(),id);

    }



    
    @PostMapping("user_statuses")
    public ResponseEntity<String> create(@Valid @RequestBody UserStatus model) {
        return service.create(model);
    }

    
    @PutMapping("user_statuses/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody UserStatus model) {
        return service.update(model,id);
    }

    
    @DeleteMapping("user_statuses/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new UserStatus(),id);
    }
}