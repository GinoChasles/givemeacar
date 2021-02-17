package fr.givemeacar.app.controller;

import fr.givemeacar.app.config.MyUserDetails;
import fr.givemeacar.app.config.WebSecurityConfig;
import fr.givemeacar.app.model.Role;
import fr.givemeacar.app.model.User;
import fr.givemeacar.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.joining;

/**
 * Contrôleur de session : login/logout
 */
@RestController
@RequestMapping("/session")
public class SessionController {

    //Rôles utilisateurs pour enregistrement dans le contexte

    static String ROLE_ADMIN = "ROLE_ADMIN";
    static String ROLE_MANAGER = "ROLE_MANAGER";
    static String ROLE_CLIENT = "ROLE_CLIENT";

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

        //recherche de l'utilisateur dans la bdd via son mail
        User user = userService
                .getRepository()
                .getUserByMail(credentials.get("mail"));

        //retour 404 si aucun utilisateur trouvé
        //#TODO écrire un UserNotFoundException
        if(user == null) return ResponseEntity.notFound().build();

        //test du mot de passe
        boolean passwordMatches = webSecurityConfig.passwordEncoder()
                .matches(credentials.get("password"),user.getPassword());

        //retour 404 si password ne matche pas
        //#TODO écrire un BadCredentialsException
        if(!passwordMatches) return ResponseEntity.notFound().build();

        //sinon authentification dans le contexte de sécurité
        List<String> authorities = authenticateUser(user,credentials.get("password"));


        return ResponseEntity.ok("{\"authorities\":\""+String.join(",",authorities)+"\"}");
    }



    /**
     * Méthodes autres
     */



    /**
     * Authentifie l'utilisateur dans le contexte et définit ses autorités selon ses rôles
     * @param user l'utilisateur à enregistrer
     */
    public List<String> authenticateUser(User user,String password){

        //la liste des autorités rajoutées dans le contexte
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

        //la liste des noms d'autorités renvoyées dans le corps de la réponse
        ArrayList<String> auths = new ArrayList<String>();

        user.getRoles().stream().forEach(role->{
            String name = role.getName();
            if(name.equals(SessionController.ROLE_ADMIN)){
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                auths.add(name);
            }
            if(role.getName().equals(SessionController.ROLE_MANAGER)){
                authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
                auths.add(name);
            }
            if(role.getName().equals(SessionController.ROLE_CLIENT)){
                authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
                auths.add(name);
            }
        });

        Authentication auth = new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                password,
                authorities
        );

        Authentication authentication = webSecurityConfig.authenticationProvider().authenticate(auth);

        SecurityContextHolder.getContext().setAuthentication(authentication);


        return auths;
    }
}