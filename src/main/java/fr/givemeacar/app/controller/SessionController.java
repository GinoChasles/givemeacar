package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.MyUserDetails;
import fr.givemeacar.app.config.WebSecurityConfig;
import fr.givemeacar.app.model.User;
import fr.givemeacar.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.joining;

/**
 * Contrôleur de session : login/logout
 */
@RestController
@RequestMapping("/session")
public class SessionController {

    //Service permettant la recherche dans la bdd via son repository
    @Autowired UserService userService;

    //Configuration de sécurité pour authentification dans le contexte
    @Autowired WebSecurityConfig webSecurityConfig;

    @PostMapping("/signin")
    public ResponseEntity signin(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody Map<String, String> credentials
    ){

        //recherche de l'utilisateur dans la bdd
        User user = userService
                .getRepository()
                .findUserStatusByMailAndPassword(
                        credentials.get("mail"),
                        credentials.get("password")
                );

        //retour 404 si aucun utilisateur trouvé
        if(user == null) return ResponseEntity.notFound().build();

        //sinon authentification dans le contexte de sécurité
        authenticateUser(user);

        //retour 200 avec retour des roles en json dans le corps
        String roles = user.getRoles().stream().map(role->role.getName()).collect((joining(",")));
        return ResponseEntity.ok("{\"roles\":\""+roles+"\"}");
    }



    @GetMapping("/signout")
    public RedirectView signout() {
        return new RedirectView("/");
    }


    /**
     * Méthodes autres
     */



    /**
     * Enregistre les détails de l'utilisateur dans le contexte de sécurité
     * @param user l'utilisateur à enregistrer
     */
    public void authenticateUser(User user){

        UserDetails details = new MyUserDetails(user);

        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

        if(user.getRoles().contains("admin")){
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        webSecurityConfig.authenticationProvider().authenticate(
                new UsernamePasswordAuthenticationToken(
                        details,
                        user.getPassword(),
                        authorities
                )
        );
    }

}
