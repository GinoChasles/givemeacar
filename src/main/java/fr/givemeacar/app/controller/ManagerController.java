package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.Manager;
import fr.givemeacar.app.model.UserStatus;
import fr.givemeacar.app.service.ManagerService;
import fr.givemeacar.app.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ManagerController extends CrudControllerImpl<Manager>{

    @Autowired
    ManagerService service;

    @Autowired
    UserStatusService userStatusService;

    @RequestMapping("managers/count")
    @Override
    public ResponseEntity count() {
        return super.count();
    }

    @RequestMapping(value = "managers", method = RequestMethod.GET)
    @Override
        public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
                @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                @RequestParam(required = false) String q){
            return super.findAll(_order, _sort, _start, _end, id, q);
    }

    @GetMapping("managers/{id}")
    @Override
    public ResponseEntity findById(@PathVariable int id) {
        return super.listById(id);
    }


    @PostMapping("managers")
    public ResponseEntity create(@Valid @RequestBody Manager model) {
        System.out.println(model.getAgency());
        System.out.println(model.getFirstName());
        System.out.println(model.getLastName());
        System.out.println(model.getMail());
        System.out.println(model.getPassword());

        Optional<UserStatus> managerStatus = userStatusService.getRepository().findById(2);
        if (managerStatus.isPresent()) {
            model.setUserStatus(managerStatus.get());
            System.out.println(model.getUserStatus().getName());
            return super.create(model);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


    @PutMapping("managers/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Manager model) {
        return super.update(model);
    }


    @DeleteMapping("managers/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        return super.deleteById(id);
    }

    @Override
    public ManagerService getService() {
        return service;
    }
}