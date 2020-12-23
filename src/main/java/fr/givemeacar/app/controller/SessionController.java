package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.UserStatus;
import fr.givemeacar.app.service.AdministratorService;
import fr.givemeacar.app.service.ClientService;
import fr.givemeacar.app.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
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
    public ResponseEntity signin(HttpServletRequest request, @RequestBody Map<String, String> credentials,
                                 HttpServletResponse response) {

        UserStatus status = clientService.getRepository()
                .findUserStatusByMailAndPassword(credentials.get("mail"), credentials.get("password"));

        if(status == null)
            status = managerService.getRepository()
                    .findUserStatusByMailAndPassword(credentials.get("mail"), credentials.get("password"));

        if(status == null)
            status = administratorService.getRepository()
                    .findUserStatusByMailAndPassword(credentials.get("mail"), credentials.get("password"));

        if(status == null){
            ResponseEntity.notFound().build();
        }

        getSession().setAttribute("userStatus",status.getId());
        HttpHeaders userStatus = new HttpHeaders();
        userStatus.set("userStatus",Integer.toString(status.getId()));

        return ResponseEntity.ok().headers(userStatus).build();
    }

    @GetMapping("/signout")
    public RedirectView signout() {
        getSession().removeAttribute("userStatus");
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
