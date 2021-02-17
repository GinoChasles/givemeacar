package fr.givemeacar.app.config;


import java.util.*;

import fr.givemeacar.app.model.Role;
import fr.givemeacar.app.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Produit la classe nécessaire aux informations de sécurité de l'utilisateur enregistré dans le contexte de
 * springboot security
 */
public class MyUserDetails implements UserDetails {
    //l'utilisateur dont on veut lire les données
    private User user;

    /**
     * Constructeur
     * @param user l(utilisateur dont on veut manipuler les données
     */
    public MyUserDetails(User user) {
        this.user = user;
    }

    /**
     * Retourne les autorités de l'utilisateur
     * @return les autorités de l'utilisateur
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return authorities;
    }

    /**
     * Retourne le mot de passe de l'utilisateur
     * @return le mot de passe de l'utilisateur
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Retourne le username de l'utilisateur
     * @return le username de l'utilisateur
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * Retourne si la session de l'utilisateur a expiré
     * @return si la session de l'utilisateur a expiré
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Retourne si l'utilisateur n'est pas bloqué
     * @return si l'utilisateur n'est pas bloqué
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Retourne si les crédits de l'utilisateur ne sont pas expirés
     * @return si les crédits de l'utilisateur ne sont pas expirés
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Retourne si l'utilisateur est activé
     * @return si l'utilisateur est activé
     */
    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }

}