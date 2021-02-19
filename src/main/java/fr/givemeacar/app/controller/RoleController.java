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
public class RoleController extends CrudControllerImpl<Role>{

    @Autowired
    UserStatusService service;

    @RequestMapping("roles/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "roles", method = RequestMethod.GET)
    @Override
        public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort,
                                      @RequestParam(required = false) Integer _start,
                @RequestParam(required = false) Integer _end,
                                      @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q) {
            return super.findAll(new Role(),"roles",_order, _sort, _start, _end, id, q);
    }

    @GetMapping("roles/{id}")
    @Override
    public ResponseEntity findById(@PathVariable Integer id) {
        return super.findById(id);
    }


    @PostMapping("roles")
    public ResponseEntity create(@Valid @RequestBody Role model) {
        return super.create(model);
    }


    @PutMapping("roles/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody Role model) {
        return super.update(model);
    }


    @DeleteMapping("roles/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        return super.deleteById(id);
    }

    @Override
    public UserStatusService getService() {
        return service;
    }
}