package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.User;
import fr.givemeacar.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController extends CrudControllerImpl<User>{

    @Autowired
    UserService service;

    @RequestMapping("users/count")
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    @Override
        public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q) {
            return super.findAll(new User(),"users",_order, _sort, _start, _end, id, q);
    }

    @GetMapping("users/{id}")
    public ResponseEntity findById(@PathVariable int id) { return super.findById(id);}


    @PostMapping("users")
    public ResponseEntity create(@Valid @RequestBody User model) {
        return super.create(model);
    }


    @PutMapping("users/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody User model) {
        return super.update(model);
    }


    @DeleteMapping("users/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public UserService getService() {
        return service;
    }
}