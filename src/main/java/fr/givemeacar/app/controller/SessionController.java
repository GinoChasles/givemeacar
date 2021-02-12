package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.User;
import fr.givemeacar.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@RequestMapping("/session")
public class SessionController {
    @Autowired
    UserService userService;

    @PostMapping("/signin")
    public ResponseEntity signin(HttpServletRequest request, @RequestBody Map<String, String> credentials,
                                 HttpServletResponse response) {

        User user = userService.getRepository()
                .findUserStatusByMailAndPassword(credentials.get("mail"), credentials.get("password"));


        if(user == null){
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user.getRoles());
    }

    @GetMapping("/signout")
    public RedirectView signout() {
        return new RedirectView("/");
    }

}
