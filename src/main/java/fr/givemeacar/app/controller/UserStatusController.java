package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Role;
import fr.givemeacar.app.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserStatusController extends CrudControllerImpl<Role>{

    @Autowired
    UserStatusService service;

    @RequestMapping("user_statuses/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "user_statuses", method = RequestMethod.GET)
    @Override
        public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q) {
            return super.findAll(new Role(),"user_statuses",_order, _sort, _start, _end, id, q);
    }

    @GetMapping("user_statuses/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.findById(id);
    }


    @PostMapping("user_statuses")
    public ResponseEntity create(@Valid @RequestBody Role model) {
        return super.create(model);
    }


    @PutMapping("user_statuses/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Role model) {
        return super.update(model);
    }


    @DeleteMapping("user_statuses/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public UserStatusService getService() {
        return service;
    }
}