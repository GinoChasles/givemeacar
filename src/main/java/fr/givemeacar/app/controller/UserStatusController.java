package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.UserStatus;
import fr.givemeacar.app.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserStatusController extends CrudControllerImpl<UserStatus>{

    @Autowired
    UserStatusService service;

    @RequestMapping("user_statuses/count")
    public ResponseEntity count() {
        return tryCount();
    }

    @RequestMapping(value = "user_statuses", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam(required = false) String _order, @RequestParam(required = false) String _sort,@RequestParam(required = false) Integer _start, @RequestParam int _end) {
        return tryFindAll(_order,_sort,_start,_end);
    }

    @GetMapping("user_statuses/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return tryFindById(id);
    }


    @PostMapping("user_statuses")
    public ResponseEntity create(@Valid @RequestBody UserStatus model) {
        return tryCreate(model);
    }


    @PutMapping("user_statuses/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody UserStatus model) {
        return tryUpdate(id,model);
    }


    @DeleteMapping("user_statuses/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return tryDelete(id);
    }

    @Override
    public UserStatusService getService() {
        return service;
    }
}