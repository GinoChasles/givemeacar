package fr.givemeacar.app.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

/**
 * Configuration de la sécurité du serveur
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    /**
     * Configuration de la sécurité
     * @param http l'instance responsable de la sécurité du protocol http
     * @throws Exception l'exception levée en cas d'erreur
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/session/signin").hasAuthority("ROLE_ANONYMOUS")
                .antMatchers("/session/signout").hasAnyRole("admin","client","manager")
                .antMatchers("/new").hasAnyAuthority("ADMIN", "CREATOR")
                .antMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
                .antMatchers("/delete/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedPage("/403");


        http.cors().and().csrf()/*.disable()*/;


        //Gestion du logout
        http.logout()
                .logoutUrl("/session/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/");
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {

        //les origines en cross origin autorisées par le serveur
        List<String> origins = Arrays.asList(
                //le serveur react
                "http://localhost:3000",
                //YARC
                // pour le connaitre l'ID de votre YARC, il suffit d'essayer une requête
                // et de voir dans le terminal quelle url a été refusée xD
                "chrome-extension://ehafadccdcdedbhcbddihehiodgcddpl"
        );

        //les méthodes http autorisées par le serveur
        List<String> methods = Arrays.asList("*");

        //les headers autorisés par le serveur
        List<String> headers = Arrays.asList("*");

        //la durée de mise en cache de la config en secondes
        Long configCacheDuration = Integer.toUnsignedLong(60*60*7*24);

        //instance de configuration du crossOrigin
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(origins);
        configuration.setAllowedMethods(methods);
        configuration.setAllowedHeaders(headers);

        configuration.setAllowCredentials(true);

        configuration.setMaxAge(configCacheDuration);

        //L'URL sur laquelle s'applique la configuration
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }


    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    /**
     * Le protocole d'encryptage des mots de passe de l'application
     * @return l'instance de cryptage de l'application
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Le fournisseur d'authentification permettant de récupérer le UserDetails dans le contexte de sécurité
     * @return
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}