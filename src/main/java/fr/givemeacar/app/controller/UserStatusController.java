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

@RestController
@RequestMapping("/api")
public class UserStatusController{

    @Autowired
    UserStatusService service;

    @CrossOrigin
    @RequestMapping("user_statuses/count")
    public BigInteger count() {
        return service.count(TableNames.userStatuses);
    }

    @RequestMapping(value = "user_statuses", method = RequestMethod.GET)
    public Collection<UserStatus> findAll(@RequestParam(required = false) Integer offset, @RequestParam int limit) {
        if(offset != null) {
            return service.findAll(TableNames.userStatuses,new UserStatus(), offset, limit);
        }else{
            return service.findAll(TableNames.userStatuses, new UserStatus(),0,limit);
        }
    }

    @GetMapping("user_statuses/{id}")
    public Object findById(@PathVariable int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return service.findById(TableNames.userStatuses,new UserStatus(),id);

    }



    @CrossOrigin
    @PostMapping("user_statuses")
    public ResponseEntity<String> create(@Valid @RequestBody UserStatus model) {
        return service.create(model);
    }

    @CrossOrigin
    @PutMapping("user_statuses/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody UserStatus model) {
        return service.update(model,id);
    }

    @CrossOrigin
    @DeleteMapping("user_statuses/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return service.delete(new UserStatus(),id);
    }
}