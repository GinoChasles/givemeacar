package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.UserStatus;
import fr.givemeacar.app.service.AdministratorService;
import fr.givemeacar.app.service.ClientService;
import fr.givemeacar.app.service.ManagerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpResponse;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/session")
public class SessionController {
    @Autowired
    ClientService clientService;
    @Autowired
    AdministratorService administratorService;
    @Autowired
    ManagerService managerService;
    @Autowired
    HttpSession session;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody Map<String, String> credentials) {
        UserStatus status = clientService.getRepository()
                .findUserStatusByMailAndPassword(credentials.get("mail"), credentials.get("password"));

        if(status == null)
            status = managerService.getRepository()
                    .findUserStatusByMailAndPassword(credentials.get("mail"), credentials.get("password"));

        if(status == null)
            status = administratorService.getRepository()
                    .findUserStatusByMailAndPassword(credentials.get("mail"), credentials.get("password"));

        if(status == null)
            return ResponseEntity.notFound().build();

        getSession().setAttribute("status",status.getId());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/signout")
    public RedirectView signout() {
        getSession().removeAttribute("status");
        return new RedirectView("/");
    }

    @GetMapping("/status")
    public ResponseEntity count() {
        return ResponseEntity.ok(getSession().getAttribute("status"));
    }

    public HttpSession getSession() {
        return session;
    }
}
