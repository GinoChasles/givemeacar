package fr.givemeacar.app.interceptor;

import fr.givemeacar.app.config.MyUserDetails;
import fr.givemeacar.app.config.WebSecurityConfig;
import fr.givemeacar.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui intercepte les données utilisateur avant chaque requête
 */
@Component
public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    WebSecurityConfig config;

    /**
     * Interception avant l'appel de la route.
     * Chaque utilisateur devant être authentifié, si un utilisateur passe sur le site, il devient un utilisateur
     * anonyme
     * @param request la requête client
     * @param response la réponse client
     * @param handler no sé
     * @return le succès de l'interception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null){

            //l'autentification en cours
            List<SimpleGrantedAuthority> auths = (List<SimpleGrantedAuthority>)authentication.getAuthorities();

            auths.forEach(auth -> System.out.println(auth.getAuthority()));


            System.out.println("authentificationnnnnnnnnnnnnnnnn : " + authentication);
        }

        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("Après après après");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {

        System.out.println("Completed completed completed");
    }
}