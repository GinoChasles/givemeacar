package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Agency;
import fr.givemeacar.app.repository.AgencyRepository;
import fr.givemeacar.app.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

/**
 * Contrôleur responsable des opérations CRUD sur les agences
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class AgencyController extends CrudControllerImpl<Agency>{

    @Autowired
    AgencyService service;

    @RequestMapping("agencies/count")
    @RolesAllowed({"ROLE_ADMIN","ROLE_MANAGER","ROLE_CLIENT"})
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "agencies", method = RequestMethod.GET)
    @RolesAllowed({"ROLE_ADMIN","ROLE_MANAGER","ROLE_CLIENT"})
    @Override
    public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
            @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                                  @RequestParam(required = false) String q){
        return super.findAll(new Agency(),"agencies",_order, _sort, _start, _end, id,q);
    }

    @GetMapping("agencies/{id}")
    @RolesAllowed({"ROLE_ADMIN","ROLE_MANAGER","ROLE_CLIENT"})
    @Override
    public ResponseEntity findById(@PathVariable Integer id) {
        return super.findById(id);
    }


    @PostMapping("agencies")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity create(@Valid @RequestBody Agency model) {
        return super.create(model);
    }


    @PutMapping("agencies/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody Agency model) {
        return super.update(model);
    }

    @DeleteMapping("agencies/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        return super.deleteById(id);
    }

    @Override
    public AgencyService getService() {
        return service;
    }
}